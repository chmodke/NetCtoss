package org.kehao.netctoss.model;

public class FunctionInfo {
    private Integer functionId;

    private String functionCode;

    private Short moudleId;

    private String name;

    private String url;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public Short getMoudleId() {
        return moudleId;
    }

    public void setMoudleId(Short moudleId) {
        this.moudleId = moudleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}