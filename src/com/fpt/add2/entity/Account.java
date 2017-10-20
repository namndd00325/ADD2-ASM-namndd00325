/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Nam Nguyen
 */
public class Account {

    private String number;
    private String account;
    private String password;
    private long balance;
    private String userIdentifyCard;
    private long createdTimeMLS;
    private long updatedTimeMLS;
    private int status; //trang thai tai khoan(0: bi block, 1: dang hoat dong)

    public Account() {
        this.number = UUID.randomUUID().toString();
        this.createdTimeMLS = System.currentTimeMillis();
        this.updatedTimeMLS = this.createdTimeMLS;
        this.status = 1;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getUserIdentifyCard() {
        return userIdentifyCard;
    }

    public void setUserIdentifyCard(String userIdentifyCard) {
        this.userIdentifyCard = userIdentifyCard;
    }

    public long getCreatedTimeMLS() {
        return createdTimeMLS;
    }

    public void setCreatedTimeMLS(long createdTimeMLS) {
        this.createdTimeMLS = createdTimeMLS;
    }

    public long getUpdatedTimeMLS() {
        return updatedTimeMLS;
    }

    public void setUpdatedTimeMLS(long updatedTimeMLS) {
        this.updatedTimeMLS = updatedTimeMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

}
