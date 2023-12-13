package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
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

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        readyGame();
        startGame();
        endGame(new GameResult(List.of("U", "D", "D"), true, 1));
    }

    private List<String> readyGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        outputView.printGameStartAnnounce();
        int bridgeSize = repeatUntilSuccessWithReturn(inputView::readBridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {

        playGame(); // TODO: 다 돌 거나 실패할 때까지 반복
        restartGame(); // TODO: 실패했을 때만
    }

    private void playGame() {
        MoveDirection moveDirection = repeatUntilSuccessWithReturn(inputView::readMoving);
        outputView.printMap(List.of("D", "D", "D"));
    }

    private void restartGame() {
        GameCommand gameCommand = repeatUntilSuccessWithReturn(inputView::readGameCommand);
        if (gameCommand.isRestart()) {
            startGame();
        }
    }

    private void endGame(GameResult gameResult) {
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

    private void repeatUntilSuccess(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
