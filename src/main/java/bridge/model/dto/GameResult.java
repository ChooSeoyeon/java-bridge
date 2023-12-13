package bridge.model.dto;

import java.util.List;

public class GameResult {
    List<String> bridge; // TODO: MoveResult로 변경
    boolean isSuccess;
    int tryCount;

    public GameResult(List<String> bridge, boolean isSuccess, int tryCount) {
        this.bridge = bridge;
        this.isSuccess = isSuccess;
        this.tryCount = tryCount;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }
}
