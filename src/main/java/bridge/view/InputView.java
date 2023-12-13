package bridge.view;

import bridge.model.enums.GameCommand;
import bridge.model.enums.MoveDirection;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        String inputBridgeSize = Console.readLine();
        return parseInputBridgeSizeToInt(inputBridgeSize);
    }

    private int parseInputBridgeSizeToInt(String inputBridgeSize) {
        try {
            return Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리의 길이는 숫자만 가능합니다.");
        }
    }

    public MoveDirection readMoving() {
        String inputMoving = Console.readLine();
        return MoveDirection.findByName(inputMoving);
    }

    public GameCommand readGameCommand() {
        String inputGameCommand = Console.readLine();
        return GameCommand.findByName(inputGameCommand);
    }
}
