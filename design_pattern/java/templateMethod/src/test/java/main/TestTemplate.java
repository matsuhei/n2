package main;

public abstract class TestTemplate {
    public void startTest() {
        init(); // テスト初期化
        preAction(); // テストの前準備(データ追加など)
        mainAction();  // テストの実行
        result();
    }

    protected abstract void mainAction();

    protected abstract void preAction();

    protected abstract void result();

    private void init(){
        System.out.println("初期化");
    }
}
