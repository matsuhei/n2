package main;

public class Log implements Cloneable {
    public String name;
    public String detail;
    public Boolean rewriteFlag;
    public String recoveryCode;

    public Log() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getRewriteFlag() {
        return rewriteFlag;
    }

    public void setRewriteFlag(Boolean rewriteFlag) {
        this.rewriteFlag = rewriteFlag;
    }

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    @Override
    public Log clone() throws CloneNotSupportedException {
        return (Log) super.clone();
    }
}
