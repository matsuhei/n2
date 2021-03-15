package main;

import main.Exception.TestException;
import main.helper.StringHelper;

public class Main {
    /**
     * 全体をキャッチ
     * @return {String}
     */
    public static String name() {
        try {
            return StringHelper.getName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * 絶対ダメなやつ(コメントありでも基本的に非推奨)
     * Exceptionを握りつぶしているだけでほかは何もしていない
     * @return {String}
     */

    public static String deprecatedName() {
        try {
            return StringHelper.getName();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 料金の支払い これはプログラム上のエラーではなく、リクエストによるエラーのためException
     * 
     * @param price
     * @param balance
     * @throws TestException
     */
    public static void validateBalance(Integer price, Integer balance) throws TestException {
        if (price - balance < 0) {
            throw new TestException("金額が足りません", balance - price);
        }
    }

    /**
     * 配列を生成するもの(RunTimeExceptionのケース プログラム上で異常系の処理が起こったときのものを確認するため)
     * @param size
     * @return
     */
    public static String[] gen(Integer size) {
        String[] result = new String[256];
        for (Integer i = 0; i < size ; i++ ){
            result[i] = i.toString();
        }
        return result;
    }
}
