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
        System.out.println("tryNumber = " + tryNumber);
        System.out.println("bridge.size() = " + bridge.size());
        return tryNumber < bridge.size();
    }

    public List<String> move(MoveDirection moveDirection) {
        countTryNumber();
        moveResult.add(moveDirection.getName());
        return moveResult;
    }

    public boolean isFailToMove() {
        return !(moveResult.get(tryNumber - 1)
                .equals(bridge.get(tryNumber - 1)));
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
