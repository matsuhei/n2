package main;

public class ImmutableObject {
    public final String configA = "configA";
    public final String configB = "configB";
    public final String configC = "configC";
    public final String configD = "configD";

    public ImmutableObject() {
    }

    public String getConfigA() {
        return configA;
    }

    public String getConfigB() {
        return configB;
    }

    public String getConfigC() {
        return configC;
    }

    public String getConfigD() {
        return configD;
    }
}
