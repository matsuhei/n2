package main.strategy;

import java.util.List;
import java.util.Random;

// ストラテジーパターンを継承したクラス
public class RandomStrategy implements Strategy {

    public Long getNumber(List<Long> numbers) {
        Random random = new Random();
        return numbers.get(random.nextInt(numbers.size()) - 1);
    }
}