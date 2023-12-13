package bridge.model;

import java.util.List;

public class BridgeGame {
    private int tryNumber;
    private List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.tryNumber = 0;
        this.bridge = bridge;
    }

    public void move() {
    }

    public void retry() {
        tryNumber = 0;
    }

    public void countTryNumber() {
        tryNumber++;
    }
}
