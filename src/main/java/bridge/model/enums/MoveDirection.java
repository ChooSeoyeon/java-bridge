package bridge.model.enums;

import java.util.Arrays;

public enum MoveDirection {
    UP("U", 1),
    DOWN("D", 0);

    private final String name;
    private final int number;

    MoveDirection(String name, int number) {
        this.name = name;
        this.number = number;
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

    public static String findNameByNumber(int number) {
        return Arrays.stream(MoveDirection.values())
                .filter(direction -> direction.number == number)
                .findFirst()
                .map(MoveDirection::getName)
                .orElseThrow(() -> new IllegalArgumentException("이동 방향은 0 또는 1만 가능합니다."));
    }
}
