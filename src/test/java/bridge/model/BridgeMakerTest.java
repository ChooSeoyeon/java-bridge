package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {
    @Test
    public void 다리_생성_시_0이면_아래칸으로_D가_되고_1이면_위칸으로_U가_된다() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21})
    public void 다리길이가_3이상_10이하가_아니면_예외가_발생한다(int size) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리의 길이는 3 이상 10 이하만 가능합니다.");
        assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리의 길이는 3 이상 10 이하만 가능합니다.");
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
