package bridge.model;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        validateBridgeSize(size);
        for (int i = 0; i < size; i++) {
            bridge.add(makeBridgeUnit());
        }
        return bridge;
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 10 이하만 가능합니다.");
        }
    }

    private String makeBridgeUnit() {
        int number = bridgeNumberGenerator.generate();
        if (number == 0) { // TODO: enum 사용
            return "D";
        }
        return "U";
    }
}
