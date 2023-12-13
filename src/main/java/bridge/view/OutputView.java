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
        StringBuilder firstLine = new StringBuilder("[ ");
        StringBuilder secondLine = new StringBuilder("[ ");

        for (String s : bridge) {
            if ("U".equals(s)) {
                firstLine.append("O | ");
                secondLine.append("  | ");
            } else if ("D".equals(s)) {
                firstLine.append("  | ");
                secondLine.append("O | ");
            } else {
                firstLine.append("  | ");
                secondLine.append("  | ");
            }
        }

        if (firstLine.length() > 2) {
            firstLine.setLength(firstLine.length() - 2);
        }
        if (secondLine.length() > 2) {
            secondLine.setLength(secondLine.length() - 2);
        }
        firstLine.append("]");
        secondLine.append("]");

        return firstLine + "\n" + secondLine;
    }

    private String formatIsSuccessToSuccess(boolean isSuccess) {
        return isSuccess ? "성공" : "실패";
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }
}
