/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.entity;

/**
 *
 * @author daolinh
 */
public enum TransactionType {
    
    DEPOSIT(1), WITHDRAWS(2), TRANSFER(3);

    private final int value;

    private TransactionType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
