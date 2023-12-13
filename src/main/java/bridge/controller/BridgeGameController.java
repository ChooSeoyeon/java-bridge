package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.dto.GameResult;
import bridge.model.enums.GameCommand;
import bridge.model.enums.MoveDirection;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        readyGame();
        startGame();
        endGame();
    }

    private void readyGame() {
        outputView.printGameStartAnnounce();
        List<String> bridge = repeatUntilSuccessWithReturn(this::settingBridge);
        bridgeGame = new BridgeGame(bridge);
    }

    private List<String> settingBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {
        while (bridgeGame.canTryMove()) {
            playGame();
            if (bridgeGame.isFailToMove()) {
                restartGame();
                break;
            }
        }
    }

    private void playGame() {
        MoveDirection moveDirection = repeatUntilSuccessWithReturn(inputView::readMoving);
        List<String> moveResult = bridgeGame.move(moveDirection);
        outputView.printMap(moveResult);
    }

    private void restartGame() {
        GameCommand gameCommand = repeatUntilSuccessWithReturn(inputView::readGameCommand);
        if (gameCommand.isRestart()) {
            bridgeGame.retry();
            startGame();
        }
    }

    private void endGame() {
        GameResult gameResult = bridgeGame.captureGameResult();
        outputView.printGameResult(gameResult);
    }

    private <T> T repeatUntilSuccessWithReturn(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
