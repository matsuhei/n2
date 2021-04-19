package main.strategy;

import java.util.List;

// ストラテジーパターンを継承したクラス
public class HalfStrategy implements Strategy {

    public Long getNumber(List<Long> numbers) {
        return numbers.get(numbers.size() / 2);
    }
}