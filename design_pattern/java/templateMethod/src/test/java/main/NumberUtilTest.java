package main;

import org.junit.jupiter.api.Assertions;

// テストのパターンごとにこのクラスを作成してテストできる
public class NumberUtilTest extends TestTemplate{
    boolean result = false;

    @Override
    public void mainAction() {
        System.out.println("test実行系");
        System.out.println(NumberUtil.sum(10, 11));
        Assertions.assertEquals(NumberUtil.sum(10, 11), 21);
        result = true;
    }

    @Override
    public void preAction() {
        System.out.println("test準備系");
    }

    @Override
    public void result() {
        if (result) {
            System.out.println("成功");
        } else {
            System.out.println("失敗");
        }
    }

}
