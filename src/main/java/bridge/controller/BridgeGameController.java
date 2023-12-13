package bridge.controller;

import bridge.model.enums.GameCommand;
import bridge.model.enums.MoveDirection;
import bridge.view.InputView;
import bridge.view.OutputView;
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
    }

    private void readyGame() {
        outputView.printGameStartAnnounce();
    }

    private void startGame() {
        int bridgeSize = repeatUntilSuccessWithReturn(inputView::readBridgeSize);
        MoveDirection moveDirection = repeatUntilSuccessWithReturn(inputView::readMoving);
        GameCommand gameCommand = repeatUntilSuccessWithReturn(inputView::readGameCommand);
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
