package main.strategy;

import java.util.List;

// ストラテジーのインターフェイス
public interface Strategy {
    public abstract Long getNumber(List<Long> numbers);
}
