package org.kehao.netctoss.model;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceDetall {
    private Long detailId;

    private Long serviceId;

    private String clientHost;

    private String osUsername;

    private Long pid;

    private Date loginTime;

    private Date logoutTime;

    private BigDecimal duration;

    private BigDecimal cost;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getClientHost() {
        return clientHost;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost == null ? null : clientHost.trim();
    }

    public String getOsUsername() {
        return osUsername;
    }

    public void setOsUsername(String osUsername) {
        this.osUsername = osUsername == null ? null : osUsername.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}