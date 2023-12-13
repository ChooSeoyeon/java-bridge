package bridge.model;

import bridge.model.enums.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private int tryNumber;
    private List<String> bridge;
    private int bridgeSize;

    public BridgeGame(int bridgeSize) {
        this.tryNumber = 0;
        this.bridge = new ArrayList<>();
        this.bridgeSize = bridgeSize;
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

    public boolean isSuccess() {
        return bridge.size() == bridgeSize;
    }
}
