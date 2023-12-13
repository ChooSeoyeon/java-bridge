package bridge.model.enums;

public enum MoveDirection {
    UP("U"),
    DOWN("D");

    private final String direction;

    MoveDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
