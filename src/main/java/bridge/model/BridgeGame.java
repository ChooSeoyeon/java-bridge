package bridge.model;

import bridge.model.enums.MoveDirection;
import java.util.List;

public class BridgeGame {
    private int tryNumber;
    private List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.tryNumber = 0;
        this.bridge = bridge;
    }

    public void move(MoveDirection moveDirection) {
        bridge.add(moveDirection.getName());
    }

    public void retry() {
        tryNumber = 0;
        bridge.clear();
    }

    public void countTryNumber() {
        tryNumber++;
    }
}
