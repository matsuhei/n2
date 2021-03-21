package src.Singleton;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.getClassA().getClassName() == "ClassA");
        System.out.println(context.getClassB().getClassName() == "ClassB");
    }
}
