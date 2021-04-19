package main.service;

import main.ListStrategyUtil;
import main.strategy.HalfStrategy;
import main.strategy.RandomStrategy;

import java.util.List;

// ストラテジーパターンのものを利用するクラス
public class IdsService {

    // Randomのストラテジー利用
    public Long getIdRandom(List<Long> numbers) {
        return new ListStrategyUtil(new RandomStrategy()).getNumber(numbers);
    }

    // Halfのストラテジー利用
    public Long getIdHalf(List<Long> numbers) {
        return new ListStrategyUtil(new HalfStrategy()).getNumber(numbers);
    }
}
