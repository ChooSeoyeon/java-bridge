package bridge.model.enums;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String name;

    GameCommand(String name) {
        this.name = name;
    }

    public static GameCommand findByName(String inputGameCommand) {
        return Arrays.stream(GameCommand.values())
                .filter(command -> command.getName().equals(inputGameCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("게임 명령은 R 또는 Q만 가능합니다."));
    }

    public String getName() {
        return name;
    }
}
