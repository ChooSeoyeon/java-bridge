package bridge.view;

public class OutputView {
    public void printGameStartAnnounce() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap() { // 이름 변경 불가
    }

    public void printResult() {
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }
}
