package bridge.model;

import bridge.model.dto.GameResult;
import bridge.model.enums.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private int moveNumber;
    private int tryNumber;
    private List<String> bridge; // TODO: Bridge 클래스로 변경
    private List<String> moveResult;

    public BridgeGame(List<String> bridge) {
        this.moveNumber = 0;
        this.tryNumber = 1;
        this.bridge = bridge;
        this.moveResult = new ArrayList<>();
    }

    public boolean canTryMove() {
        return moveNumber < bridge.size();
    }

    public List<String> move(MoveDirection moveDirection) {
        countMoveNumber();
        moveResult.add(moveDirection.getName());
        return moveResult;
    }

    public boolean isFailToMove() {
        return !(moveResult.get(moveNumber - 1)
                .equals(bridge.get(moveNumber - 1)));
    }

    private void countMoveNumber() {
        moveNumber++;
    }

    private void countTryNumber() {
        tryNumber++;
    }

    public void retry() {
        countTryNumber();
        moveNumber = 0;
        moveResult.clear();
    }

    public GameResult captureGameResult() {
        return new GameResult(moveResult, isSuccessToComplete(), tryNumber);
    }

    private boolean isSuccessToComplete() {
        return moveNumber == bridge.size();
    }
}
