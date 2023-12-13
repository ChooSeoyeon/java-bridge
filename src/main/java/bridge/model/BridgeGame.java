package bridge.model;

import bridge.model.enums.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private int tryNumber;
    private int successNumber;
    private List<String> bridge; // TODO: Bridge 클래스로 변경
    private List<String> moveResult;

    public BridgeGame(List<String> bridge) {
        this.tryNumber = 0;
        this.successNumber = 0;
        this.bridge = bridge;
        this.moveResult = new ArrayList<>();
    }

    public boolean canTryMove() {
        return tryNumber < bridge.size();
    }

    public void move(MoveDirection moveDirection) {
        if (isSuccessToMove()) {
            countSuccessNumber();
        }
        countTryNumber();
        moveResult.add(moveDirection.getName());
    }

    private boolean isSuccessToMove() {
        return moveResult.get(tryNumber).equals(bridge.get(tryNumber));
    }

    private void countSuccessNumber() {
        successNumber++;
    }

    private void countTryNumber() {
        tryNumber++;
    }

    public void retry() {
        tryNumber = 0;
        successNumber = 0;
        moveResult.clear();
    }
}
