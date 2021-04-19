package main;

import main.strategy.Strategy;

import java.util.List;

public class ListStrategyUtil {

    private Strategy strategy;

    public ListStrategyUtil(Strategy strategy) {
        this.strategy = strategy;
    }

    // ストラテジーによってメソッドのアルゴリズムを切り替えられる
    public Long getNumber(List<Long> numbers) {
        return strategy.getNumber(numbers);
    }
}
