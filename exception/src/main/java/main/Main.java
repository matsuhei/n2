package main;

import main.exception.OuterException;
import main.exception.TestException;
import main.helper.StringHelper;

import java.util.Objects;

public class Main {

    /**
     * 1. 例外状態にだけ例外を使用すべし、以下のようなforを抜け出すためのthrowなどはダメ
     *
     * @return
     * @throws Exception
     */
    public static String badExceptionEx() throws Exception {
        int i;
        for (i = 0; i < 100; i++) {
            if (i > 50) {
                throw new Exception("iが50を超えました");
            }
        }
        return "テスト";
    }

    /**
     * 2. 回復可能な状態にはチェックされる例外をプログラミングには実行時例外を使用
     * 例外の種類の確認
     * チェックされる例外、実行時例外、Errorクラス(OutOfMemory)
     *
     * @param size
     * @return
     */
    public static String[] gen(Integer size) throws Exception {
        // sizeは入力が必要
        if (Objects.isNull(size)) {
            throw new Exception("sizeが入力されていません。");
        }

        // 256以上のsizeの時、ArrayIndexOutOfBoundsExceptionになる (RunTimeException)
        String[] result = new String[256];
        for (Integer i = 0; i < size; i++) {
            result[i] = i.toString();
        }
        return result;
    }

    /**
     * 3. チェックされる例外を不必要に使用するのを避ける
     * 購入処理時、不要な例外は使わないようにすべきなので、以下のExceptionが発生する前に、validation系メソッドで対応すると良い
     *
     * @param price
     * @param balance
     * @return
     * @throws TestException
     */
    public static Integer badPurchase(Integer price, Integer balance) throws TestException {
        try {
            if (balance - price < 0) {
                throw new TestException("金額が足りません", balance - price);
            }

            // 購入処理系

            // お釣りの返金
            return balance - price;
        } catch (TestException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 3. 避けたversion
     *
     * @param price
     * @param balance
     * @return
     */
    public static Integer purchase(Integer price, Integer balance) {
        if (!validateBalance(price, balance)) {
            return null;
        }
        // 購入処理系
        return balance - price;
    }

    /**
     * 料金と支払額の確認 true ok
     *
     * @param price
     * @param balance
     * @throws TestException
     */
    public static boolean validateBalance(Integer price, Integer balance) {
        return balance - price > 0;
    }

    /**
     * 4. 標準例外を使用する JDKで提供されてる例外を利用する
     * 基本は独自で作らない
     * らしいけれど、
     *
     * @param name
     * @return
     */
    public static Integer getNameLength(String name) {
        try {
            return StringHelper.length(name);
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 5. 抽象概念に適した例外をスローする
     *
     * @param size
     * @return
     * @throws OuterException
     */
    public static String[] getIntStringList(Integer size) throws OuterException {
        try {
            // 256以上のsizeの時、ArrayIndexOutOfBoundsExceptionになる (RunTimeException)
            String[] result = new String[256];
            for (Integer i = 0; i < size; i++) {
                result[i] = i.toString();
            }
            return result;
        } catch (ArrayIndexOutOfBoundsException e) { // low
            e.printStackTrace();
            throw new OuterException(e.getMessage()); // high
        }
    }

    /**
     * 8-1 不変なオブジェクトを使う
     * 変わらないものを使えば処理失敗時も問題ない
     *
     * @return
     */
    public static ImmutableObject ImmutableObject() {
        return new ImmutableObject();
    }

    /**
     * 全体をキャッチ
     *
     * @return {String}
     */
    public static String name() {
        try {
            return StringHelper.getName();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 9. 例外を無視しない
     * 絶対ダメなやつ(コメントありでも基本的に非推奨)
     * Exceptionを握りつぶしているだけでほかは何もしていない
     *
     * @return {String}
     */

    public static String deprecatedName() {
        try {
            return StringHelper.getName();
        } catch (Exception e) {
        }
        return null;
    }

}
