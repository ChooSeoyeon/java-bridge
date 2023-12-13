package bridge.view;

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

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}
