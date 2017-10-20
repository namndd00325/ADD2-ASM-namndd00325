/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.view;

import com.fpt.add2.entity.Account;
import java.util.HashMap;

/**
 *
 * @author Nam Nguyen
 */
public class ValidateLogin {
     public HashMap<String, String> ValidateLoginAcc(Account acc){
         HashMap<String, String> errors = new HashMap<>();
          if (acc.getAccount().isEmpty()) {
            errors.put("txtAcc", "*Please enter Account! ");
        }
           if (acc.getPassword().isEmpty()) {
            errors.put("txtPass", "*Please enter Password! ");
        }
         return errors;
     }
}
