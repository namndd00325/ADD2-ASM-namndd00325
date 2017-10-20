/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.view;

import com.fpt.add2.entity.Account;
import com.fpt.add2.entity.User;
import com.fpt.add2.model.AccountModel;
import com.fpt.add2.util.Utility;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Nam Nguyen
 */
public class FormRegisterAccount extends JFrame {

    private JPanel pnForm;
    private JLabel lblTitle;
    private JLabel lblAccount;
    private JLabel lblPassword;
    private JLabel lblFullName;
    private JLabel lblBirthday;
    private JLabel lblGender;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblAddress;
    private JLabel lblIdentifyCard;

    private JTextField txtAccount;
    private JPasswordField txtPassword;
    private JTextField txtName;
    private JTextField txtBirthday;
    private JTextField txtEmail;
    private JComboBox cbGender;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JTextField txtIdentifyCard;
    private JButton registerAccount;
    private JButton cancel;

    String[] strGender = {"Male", "Female"};

    public FormRegisterAccount() {
        setSize(800, 700);
        setTitle("Register Account");
        setLayout(null);
        setLocationRelativeTo(null);

        pnForm = new JPanel();
        pnForm = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\light-design.jpg").getImage());
        pnForm.setLayout(null);

        lblAccount = new JLabel("Account");
        lblPassword = new JLabel("Password");
        lblFullName = new JLabel("Full Name");
        lblBirthday = new JLabel("Date of birthday");
        lblGender = new JLabel("Gender");
        lblEmail = new JLabel("Email");
        lblAddress = new JLabel("Adderes");
        lblPhone = new JLabel("Phone");
        lblIdentifyCard = new JLabel("IdentifyCard");
        txtAccount = new JTextField();
        txtPassword = new JPasswordField();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtBirthday = new JTextField();
        txtPhone = new JTextField();
        txtAddress = new JTextField();
        txtIdentifyCard = new JTextField();
        cbGender = new JComboBox(strGender);
        registerAccount = new JButton("Register");
        cancel = new JButton("Cancel");
        lblTitle = new JLabel("Register Account");

        pnForm.setBounds(0, 0, 800, 700);
        lblTitle.setBounds(320, 30, 250, 50);
        lblTitle.setFont(new Font("Arial", 4, 30));

        lblAccount.setBounds(100, 110, 150, 35);
        lblAccount.setFont(new Font("Arial", 4, 20));
        txtAccount.setBounds(280, 110, 300, 35);
        txtAccount.setFont(new Font("Arial", 4, 20));

        lblPassword.setBounds(100, 155, 150, 35);
        lblPassword.setFont(new Font("Arial", 4, 20));
        txtPassword.setBounds(280, 155, 300, 35);
        txtPassword.setFont(new Font("Arial", 4, 20));

        lblFullName.setBounds(100, 200, 150, 35);
        lblFullName.setFont(new Font("Arial", 4, 20));
        txtName.setBounds(280, 200, 300, 35);
        txtName.setFont(new Font("Arial", 4, 20));

        lblBirthday.setBounds(100, 245, 150, 35);
        lblBirthday.setFont(new Font("Arial", 4, 20));
        txtBirthday.setBounds(280, 245, 300, 35);
        txtBirthday.setFont(new Font("Arial", 4, 20));

        lblGender.setBounds(100, 290, 150, 35);
        lblGender.setFont(new Font("Arial", 4, 20));
        cbGender.setBounds(280, 290, 300, 35);
        cbGender.setFont(new Font("Arial", 4, 20));

        lblEmail.setBounds(100, 335, 150, 35);
        lblEmail.setFont(new Font("Arial", 4, 20));
        txtEmail.setBounds(280, 335, 300, 35);
        txtEmail.setFont(new Font("Arial", 4, 20));

        lblPhone.setBounds(100, 380, 150, 35);
        lblPhone.setFont(new Font("Arial", 4, 20));
        txtPhone.setBounds(280, 380, 300, 35);
        txtPhone.setFont(new Font("Arial", 4, 20));

        lblAddress.setBounds(100, 425, 150, 35);
        lblAddress.setFont(new Font("Arial", 4, 20));
        txtAddress.setBounds(280, 425, 300, 35);
        txtAddress.setFont(new Font("Arial", 4, 20));

        lblIdentifyCard.setBounds(100, 470, 150, 35);
        lblIdentifyCard.setFont(new Font("Arial", 4, 20));
        txtIdentifyCard.setBounds(280, 470, 300, 35);
        txtIdentifyCard.setFont(new Font("Arial", 4, 20));

        registerAccount.setBounds(280, 510, 140, 35);
        registerAccount.setFont(new Font("Arial", 4, 20));
        registerAccount.setBackground(Color.decode("#76ee00"));
        cancel.setBounds(440, 510, 140, 35);
        cancel.setFont(new Font("Arial", 4, 20));
        cancel.setBackground(Color.decode("#5cacee"));

        cancel.addActionListener(new ResetHandle());
        registerAccount.addActionListener(new RegisterHandle());
        add(pnForm);
        pnForm.add(lblTitle);
        pnForm.add(lblAccount);
        pnForm.add(lblPassword);
        pnForm.add(lblFullName);
        pnForm.add(lblBirthday);
        pnForm.add(lblGender);
        pnForm.add(lblEmail);
        pnForm.add(lblAddress);
        pnForm.add(lblPhone);
        pnForm.add(lblIdentifyCard);
        pnForm.add(txtAccount);
        pnForm.add(txtAddress);
        pnForm.add(txtPhone);
        pnForm.add(txtIdentifyCard);
        pnForm.add(txtPassword);
        pnForm.add(txtName);
        pnForm.add(txtEmail);
        pnForm.add(txtBirthday);
        pnForm.add(cbGender);
        pnForm.add(registerAccount);
        pnForm.add(cancel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    class RegisterHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ResetMessageRegister();
            Account account = new Account();
            AccountModel accountModel = new AccountModel();
            User user = new User();
            account.setAccount(txtAccount.getText());
            String strPass = String.copyValueOf(txtPassword.getPassword());
            account.setPassword(Utility.digestPassword(strPass));
            account.setUserIdentifyCard(txtIdentifyCard.getText());

            user.setFullName(txtName.getText());
            user.setBirthDay(txtBirthday.getText());
            user.setEmail(txtEmail.getText());
            user.setPhone(txtPhone.getText());
            user.setAddress(txtAddress.getText());
            user.setIdentifyCard(txtIdentifyCard.getText());
            user.setGender(cbGender.getSelectedItem().toString());
            HashMap<String, String> errorsRegister = new ValidateRegister().ValidateRegisterAcc(account, user);
            if (errorsRegister.size() == 0) {
                accountModel.insertAccount(account);
                accountModel.insertUser(user);
                JOptionPane.showMessageDialog(null, "Register Success!");
                txtAccount.setText("");
                txtPassword.setText("");
                txtName.setText("");
                txtBirthday.setText("");
                txtEmail.setText("");
                txtPhone.setText("");
                txtAddress.setText("");
                txtIdentifyCard.setText("");
            } else {
                ShowErrorsRegister(errorsRegister);
                JOptionPane.showMessageDialog(null, "Please enter enough information: "
                        + "\n"+ "Account, password have to enough six characters"
                        + "\n"+ "Birth's format: dd/mm/yyyy"
                        + "\n"+ "Email's format: abc@xyz.com"
                        + "\n"+ "Phone's format: +841234567890 or +84912345678" );
            }
        }

    }

    public void ShowErrorsRegister(HashMap<String, String> errorsRegister) {
        if (errorsRegister.containsKey("txtAccount")) {
            lblAccount.setForeground(Color.red);
        }
        if (errorsRegister.containsKey("txtPassword")) {
            lblPassword.setForeground(Color.red);
        }
        if (errorsRegister.containsKey("txtName")) {
            lblFullName.setForeground(Color.red);
        }
         if (errorsRegister.containsKey("txtBirthday")) {
           lblBirthday.setForeground(Color.red);
        }
          if (errorsRegister.containsKey("txtEmail")) {
            lblEmail.setForeground(Color.red);
        }
           if (errorsRegister.containsKey("txtPhone")) {
            lblPhone.setForeground(Color.red);
        }
            if (errorsRegister.containsKey("txtAddress")) {
            lblAddress.setForeground(Color.red);
        }
             if (errorsRegister.containsKey("txtIdentifyCard")) {
            lblIdentifyCard.setForeground(Color.red);
        }

    }

    public void ResetMessageRegister() {
        lblAccount.setForeground(Color.black);
        lblPassword.setForeground(Color.black);
        lblFullName.setForeground(Color.black);
        lblBirthday.setForeground(Color.black);
        lblEmail.setForeground(Color.black);
        lblPhone.setForeground(Color.black);
        lblIdentifyCard.setForeground(Color.black);
        lblAddress.setForeground(Color.black);
    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            FormLogin login = new FormLogin();
             setVisible(false);
        }

    }

    public static void main(String[] args) {
        FormRegisterAccount register = new FormRegisterAccount();
    }

}
