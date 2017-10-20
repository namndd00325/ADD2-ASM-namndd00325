/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.util;

import java.security.MessageDigest;

/**
 *
 * @author daolinh
 */
public class Utility {

    public static String digestPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] afterDigest = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < afterDigest.length; i++) {
                sb.append(Integer.toHexString(0xff & afterDigest[i]));
            }
            return sb.toString();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
