/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.view;

import com.fpt.add2.entity.Account;
import com.fpt.add2.entity.User;
import com.fpt.add2.validate.Validate;
import java.util.HashMap;

/**
 *
 * @author Nam Nguyen
 */
public class ValidateRegister {
     public HashMap<String, String> ValidateRegisterAcc(Account account, User user ){
         HashMap<String, String> errorsRegister = new HashMap<>();
         if (account.getAccount().length() < 6) {
            errorsRegister.put("txtAccount", "*Please enter Account!Accout have to six characters ");
        }
           if (account.getPassword().length() < 6) {
            errorsRegister.put("txtPassword", "*Please enter Password! Password have to six characters ");
        }
         if(user.getFullName().isEmpty()){
             errorsRegister.put("txtName", "*Please enter full name! ");
         }
         if (user.getEmail().isEmpty()) {
            errorsRegister.put("txtEmail", "*Please enter Email!");
        } else if (Validate.valiEmail(user.getEmail()) == false) {
            errorsRegister.put("txtEmail", "*Incorrect format email. Exp:abc@xyz.com");
        }
        if (user.getPhone().isEmpty()) {
            errorsRegister.put("txtPhone", "*Vui long nhap phone");
        } else if (Validate.valiPhoneNumber(user.getPhone()) == false) {
            errorsRegister.put("txtPhone", "*Incorrect format phone. Exp: +841.. or +8491.. ");
        }
         if (user.getBirthDay().isEmpty()) {
            errorsRegister.put("txtBirthday", "*Please enter birthday");
        } else if (Validate.valiBirthday(user.getBirthDay()) == false) {
            errorsRegister.put("txtBirthday", "*Incorrect format date. Exp: 13/12/1995 ");
        }
         if(user.getAddress().isEmpty()){
             errorsRegister.put("txtAddress", "Please enter address!");
         }
         if(user.getIdentifyCard().isEmpty()){
             errorsRegister.put("txtIdentifyCard", "Please enter identify card");
         }
      return errorsRegister;
     }
}
