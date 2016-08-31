package org.kehao.netctoss.model;

public class ModuleInfo {
    private Short moduleId;

    private String name;

    public Short getModuleId() {
        return moduleId;
    }

    public void setModuleId(Short moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}