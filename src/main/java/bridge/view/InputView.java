package bridge.view;

import bridge.model.enums.GameCommand;
import bridge.model.enums.MoveDirection;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
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
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputMoving = Console.readLine();
        return MoveDirection.findByName(inputMoving);
    }

    public GameCommand readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputGameCommand = Console.readLine();
        return GameCommand.findByName(inputGameCommand);
    }
}
