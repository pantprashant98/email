package com.springboot.dtos;

import com.springboot.models.User;

import java.util.Date;

public class ConformationTokenDto {

    private long tokenid;
    private  String conformationToken;
    private Date createdDate;
    private User user;
    public ConformationTokenDto() {
    }

    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConformationToken() {
        return conformationToken;
    }

    public void setConformationToken(String conformationToken) {
        this.conformationToken = conformationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
