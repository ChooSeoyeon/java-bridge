package bridge.model.enums;

import java.util.Arrays;

public enum MoveDirection {
    UP("U"),
    DOWN("D");

    private final String name;

    MoveDirection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MoveDirection findByName(String name) {
        return Arrays.stream(MoveDirection.values())
                .filter(direction -> direction.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이동 방향은 U 또는 D만 가능합니다."));
    }
}
