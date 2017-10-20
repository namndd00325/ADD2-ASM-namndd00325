/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.view;

import com.fpt.add2.entity.Account;
import com.fpt.add2.model.AccountModel;
import com.fpt.add2.util.Utility;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class FormLogin extends JFrame {

    private JPanel pnLogin;
    private JLabel account;
    private JLabel password;
    private JTextField txtAcc;
    private JPasswordField txtPass;
    private JButton login;
    private JButton register;
    private JLabel accountMessage;
    private JLabel passwordMessage;
    private JLabel lblIcon;

    public FormLogin() {
        setTitle("Login Account");
        setSize(800, 532);
        setLayout(null);
        setLocationRelativeTo(null);

        pnLogin = new JPanel();
        pnLogin.setLayout(null);
        pnLogin = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\bgLogin.jpg").getImage());

        lblIcon = new JLabel();
        account = new JLabel("Account");
        password = new JLabel("Password");
        txtAcc = new JTextField();
        txtPass = new JPasswordField();
        login = new JButton("Login");
        register = new JButton("Register account");
        accountMessage = new JLabel();
        passwordMessage = new JLabel();

        pnLogin.setBounds(0, 0, 800, 532);
        lblIcon.setBounds(330, 40, 130, 130);
        ImageIcon icon = new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\if_login_173049.png");
        lblIcon.setIcon(icon);
        account.setBounds(160, 200, 100, 40);
        password.setBounds(160, 260, 100, 40);
        txtAcc.setBounds(280, 200, 250, 40);
        txtPass.setBounds(280, 260, 250, 40);
        login.setBounds(280, 320, 250, 40);
        register.setBounds(280, 380, 250, 40);
        accountMessage.setBounds(540, 200, 300, 40);
        passwordMessage.setBounds(540, 260, 300, 40);

        account.setFont(new Font("Arial", 4, 20));
        password.setFont(new Font("arial", 4, 20));
        txtAcc.setFont(new Font("Arial", 4, 20));
        txtPass.setFont(new Font("Arial", 4, 20));
        login.setFont(new Font("Arial", 4, 20));
        register.setFont(new Font("Arial", 4, 20));
        accountMessage.setFont(new Font("Arial", 4, 20));
        passwordMessage.setFont(new Font("Arial", 4, 20));
        login.setBackground(Color.decode("#76ee00"));
        register.setBackground(Color.decode("#5cacee"));

        add(pnLogin);
        pnLogin.add(account);
        pnLogin.add(password);
        pnLogin.add(txtAcc);
        pnLogin.add(txtPass);
        pnLogin.add(login);
        pnLogin.add(register);
        pnLogin.add(accountMessage);
        pnLogin.add(passwordMessage);
        pnLogin.add(lblIcon);

        login.addActionListener(new LoginHandle());
        register.addActionListener(new RegisterHandle());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    class RegisterHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            FormRegisterAccount registerAccount = new FormRegisterAccount();
            setVisible(false);
        }

    }

    class LoginHandle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
             Account account = new Account();
            AccountModel model = new AccountModel();

            String acc = txtAcc.getText();
            account.setAccount(acc);
            String strPass = String.copyValueOf(txtPass.getPassword());
            account.setPassword(strPass);

            HashMap<String, String> errors = new ValidateLogin().ValidateLoginAcc(account);
            if (errors.size() == 0) {
                Account accountLogin = model.checkAuthentication(acc, Utility.digestPassword(strPass));
                if (accountLogin == null) {
                    JOptionPane.showMessageDialog(null, "Accout doesn't exist!");
                } else {
                    ResetMessage();
                    BankingMenu bankingMenu = new BankingMenu(txtAcc.getText());
                    setVisible(false);
                }

            } else {
                ShowError(errors);
            }
        }
    }

    public void ShowError(HashMap<String, String> errors) {
        if (errors.containsKey("txtAcc")) {

            accountMessage.setForeground(Color.red);
            accountMessage.setText(errors.get("txtAcc"));
        } else {
            accountMessage.setForeground(Color.green);
            accountMessage.setText("Correct!");
        }
        if (errors.containsKey("txtPass")) {
            passwordMessage.setForeground(Color.red);
            passwordMessage.setText(errors.get("txtPass"));
        } else {
            passwordMessage.setForeground(Color.green);
            passwordMessage.setText("Correct!");
        }
    }

    public void ResetMessage() {
        accountMessage.setText("");
        passwordMessage.setText("");
    }

    public static void main(String[] args) {
        FormLogin formLogin = new FormLogin();
    }
}
