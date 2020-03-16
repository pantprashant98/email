package com.springboot.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "conformation")
public class ConformationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name = "conformation_token")
    private  String conformationToken;

    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne( targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    public ConformationToken() {
    }
    public ConformationToken(User user) {
        this.user = user;
        createdDate = new Date();
       conformationToken = UUID.randomUUID().toString();
    }

    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return conformationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.conformationToken = confirmationToken;
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

    public String getConformationToken() {
        return conformationToken;
    }

    public void setConformationToken(String conformationToken) {
        this.conformationToken = conformationToken;
    }
}
