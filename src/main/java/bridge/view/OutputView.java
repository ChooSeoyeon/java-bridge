package bridge.view;

import bridge.model.dto.GameResult;
import java.util.List;

public class OutputView {
    public void printGameStartAnnounce() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<String> bridge) {
        System.out.println(formatBridgeToMap(bridge));
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println("\n최종 게임 결과");
        System.out.println(formatBridgeToMap(gameResult.getBridge()));
        System.out.print("\n게임 성공 여부: ");
        System.out.println(formatIsSuccessToSuccess(gameResult.isSuccess()));
        System.out.print("총 시도한 횟수: ");
        System.out.println(gameResult.getTryCount());
    }

    private String formatBridgeToMap(List<String> bridge) {
        return buildLine(bridge, "U") + "\n" + buildLine(bridge, "D");
    }

    private String buildLine(List<String> bridge, String symbol) {
        StringBuilder line = new StringBuilder("[ ");

        for (String s : bridge) {
            line.append(symbol.equals(s) ? "O | " : "  | ");
        }
        if (line.length() > 2) {
            line.setLength(line.length() - 2);
        }

        line.append("]");
        return line.toString();
    }

    private String formatIsSuccessToSuccess(boolean isSuccess) {
        return isSuccess ? "성공" : "실패";
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }
}
