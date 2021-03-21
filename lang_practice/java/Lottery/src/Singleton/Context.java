package src.Singleton;

public class Context {
    public ClassA classA;
    public ClassB classB;

    public Context() {
        this.classA = new ClassA();
        this.classB = new ClassB();
    }

    public ClassA getClassA() {
        return this.classA;
    }

    public ClassB getClassB() {
        return this.classB;
    }
}
