/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.view;

import com.fpt.add2.entity.Account;
import com.fpt.add2.entity.User;
import com.fpt.add2.model.AccountModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Nam Nguyen
 */
public class BankingMenu extends JFrame {

    private JPanel pnContentLeft;
    private JPanel pnContentRight;
    private JPanel pnWithDraw;
    private JPanel pnTransfer;
    private JLabel iconAccount;
    private JButton btnAccountInfor;
    private JButton btnDeposit;
    private JButton btnWithDraw;
    private JButton btnTransfer;
    private JButton btnLogout;
    private JLabel accountName;
    private JLabel iconHello;
    private JLabel iconHelloText;

    //show thông tin account
    private JPanel pnShowInfor;
    private JLabel lblTitle;
    private JLabel lblShowName;
    private JLabel lblIdentifyCard;
    private JLabel lblShowBirthDay;
    private JLabel lblShowGender;
    private JLabel lblShowEmail;
    private JLabel lblShowPhone;
    private JLabel lblShowAddress;
    private JTextField ShowName;
    private JTextField ShowBirthday;
    private JComboBox ShowGender;
    private JTextField ShowEmail;
    private JTextField ShowIdentifyCard;
    private JTextField ShowPhone;
    private JTextField ShowAddress;
    private JButton btnEdit;
    private JButton btnCancel;

    // gửi tiền vào tài khoản 
    private JPanel pnDeposit;
    private JLabel depositNumber;
    private JLabel depositName;
    private JLabel depositAmount;
    private JTextField txtDepositAmount;
    private JLabel showDepositNumber;
    private JLabel showDepositName;
    private JLabel lblVND;
    private JButton deposit;
    private JButton depositCancel;

    //rút tiền từ tài khoản
    private JLabel withDrawName;
    private JLabel showWithDrawName;
    private JLabel withDrawBalance;
    private JLabel showWithDrawBalance;
    private JLabel withDrawAmount;
    private JTextField txtWithDraw;
    private JLabel withDrawVND;
    private JButton withDraw;
    private JButton withDrawCancel;
    private JLabel showWithDrawNumber;
    private JLabel withDrawNumber;

    // chuyển tiền giữa các tài khoản
    private JLabel lblTitleSend;
    private JLabel lblTitleReceiver;
    private JLabel lblNameSender;
    private JLabel showNameSender;
    private JLabel lblNumberSender;
    private JLabel showNumberSender;
    private JLabel lblNameReceiver;
    private JTextField txtNameReceiver;
    private JLabel lblNumberReceiver;
    private JTextField txtNumberReceiver;
    private JLabel lblTransferAmount;
    private JTextField txtTransferAmount;
    private JButton transfer;
    private JButton transferCancel;

    Account account;
    User oldUser;

    String a;
    AccountModel accountModel = new AccountModel();

    public BankingMenu(String accountN) {

        account = accountModel.getAccount(accountN);
        String iden = account.getUserIdentifyCard();
        oldUser = accountModel.getUser(iden);
        a = account.getAccount();

        setTitle("Banking Menu");
        setSize(900, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        pnContentLeft = new JPanel();
        pnContentLeft.setLayout(null);
        pnContentLeft.setBackground(new Color(0, 0, 0, 0));

        pnContentRight = new JPanel();
        pnContentRight.setLayout(null);

        pnShowInfor = new JPanel();
        pnShowInfor.setLayout(null);

        pnDeposit = new JPanel();
        pnDeposit.setLayout(null);

        pnWithDraw = new JPanel();
        pnWithDraw.setLayout(null);

        pnTransfer = new JPanel();
        pnTransfer.setLayout(null);

        pnDeposit = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\background-hd - Copy.jpg").getImage());
        pnTransfer = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\background-hd - Copy.jpg").getImage());
        pnWithDraw = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\background-hd - Copy.jpg").getImage());
        pnShowInfor = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\background-hd - Copy.jpg").getImage());
        pnContentLeft = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\background-hd.jpg").getImage());
        pnContentRight = new ImagePanel(new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\background-hd - Copy.jpg").getImage());
//       pnContentRight.setOpaque(true);
//       pnContentRight.setBackground(new Color(0, 0, 0, 0));
              
        pnContentRight.setBorder(BorderFactory.createTitledBorder("bar"));
      
        iconHello = new JLabel();
        iconHelloText = new JLabel("Hi, " + oldUser.getFullName() + "! You can use bank's service. Have a nice day!");
        accountName = new JLabel(oldUser.getFullName());
        accountName.setFont(new Font("Arial", 4, 16));
        btnLogout = new JButton("Logout");
        iconAccount = new JLabel();
        btnAccountInfor = new JButton();
        btnDeposit = new JButton("Deposit");
        btnDeposit.setFont(new Font("Arial", 4, 25));
        btnDeposit.setBackground(Color.decode("#76ee00"));
        btnTransfer = new JButton("Transfer");
        btnTransfer.setFont(new Font("Arial", 4, 25));
        btnTransfer.setBackground(Color.decode("#5cacee"));
        btnWithDraw = new JButton("Withdraw");
        btnWithDraw.setFont(new Font("Arial", 4, 25));
        btnWithDraw.setBackground(Color.decode("#f08080"));
        pnContentLeft.setBounds(0, 0, 250, 700);
        pnContentRight.setBounds(250, 0, 650, 700);
        pnShowInfor.setBounds(250, 0, 650, 700);
        pnDeposit.setBounds(250, 0, 650, 700);
        pnTransfer.setBounds(250, 0, 650, 700);
        pnWithDraw.setBounds(250, 0, 650, 700);
        iconAccount.setBounds(30, 50, 130, 130);
        ImageIcon iconAcc = new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\iconAccount.png");
        iconAccount.setIcon(iconAcc);
        accountName.setBounds(40, 180, 150, 40);
        btnDeposit.setBounds(30, 300, 150, 40);
        btnWithDraw.setBounds(30, 370, 150, 40);
        btnTransfer.setBounds(30, 440, 150, 40);
        btnLogout.setBounds(30, 510, 150, 40);
        iconHello.setBounds(20, 200, 130, 130);
        iconHelloText.setBounds(120, 240, 500, 100);
        iconHelloText.setFont(new Font("Arial", 1, 15));
        ImageIcon hello = new ImageIcon("C:\\Users\\Nam Nguyen\\Documents\\NetBeansProjects\\ADD2-ASM\\src\\com\\fpt\\add2\\image\\if_Chat_32666.png");
        iconHello.setIcon(hello);
        // Form show thông tin account
        lblTitle = new JLabel("Account Information");
        lblIdentifyCard = new JLabel("Identify Card");
        lblShowAddress = new JLabel("Address");
        lblShowBirthDay = new JLabel("Date of birth");
        lblShowEmail = new JLabel("Email");
        lblShowGender = new JLabel("Gender");
        lblShowPhone = new JLabel("Phone");
        lblShowName = new JLabel("Full Name");
        ShowName = new JTextField(oldUser.getFullName());
        ShowAddress = new JTextField(oldUser.getAddress());
        ShowBirthday = new JTextField(oldUser.getBirthDay());
        ShowEmail = new JTextField(oldUser.getEmail());
        String[] strGender = {"Male", "Female"};
        ShowGender = new JComboBox(strGender);
        ShowGender.setEnabled(false);
        if (oldUser.getGender().equals("Female")) {
            ShowGender.setSelectedIndex(1);
        } else if (oldUser.getGender().equals("Male")) {
            ShowGender.setSelectedIndex(0);
        }

        ShowIdentifyCard = new JTextField(oldUser.getIdentifyCard());
        ShowPhone = new JTextField(oldUser.getPhone());
        btnCancel = new JButton("Cancel");
        btnEdit = new JButton("Edit");

        lblTitle.setBounds(250, 50, 250, 40);
        lblTitle.setFont(new Font("Arial", 4, 25));
        lblShowName.setBounds(100, 100, 150, 40);
        lblShowName.setFont(new Font("Arial", 4, 20));
        ShowName.setBounds(250, 100, 250, 40);
        ShowName.setFont(new Font("Arial", 4, 20));
        ShowName.setEditable(false);
        ShowName.setBackground(Color.white);

        lblShowBirthDay.setBounds(100, 150, 150, 40);
        lblShowBirthDay.setFont(new Font("Arial", 4, 20));
        ShowBirthday.setBounds(250, 150, 250, 40);
        ShowBirthday.setFont(new Font("Arial", 4, 20));
        ShowBirthday.setEditable(false);
        ShowBirthday.setBackground(Color.white);

        lblShowGender.setBounds(100, 200, 150, 40);
        lblShowGender.setFont(new Font("Arial", 4, 20));
        ShowGender.setBounds(250, 200, 250, 40);
        ShowGender.setFont(new Font("Arial", 4, 20));
        ShowGender.setEditable(false);
        ShowGender.setBackground(Color.white);

        lblShowEmail.setBounds(100, 250, 150, 40);
        lblShowEmail.setFont(new Font("Arial", 4, 20));
        ShowEmail.setBounds(250, 250, 250, 40);
        ShowEmail.setFont(new Font("Arial", 4, 20));
        ShowEmail.setEditable(false);
        ShowEmail.setBackground(Color.white);

        lblShowPhone.setBounds(100, 300, 150, 40);
        lblShowPhone.setFont(new Font("Arial", 4, 20));
        ShowPhone.setBounds(250, 300, 250, 40);
        ShowPhone.setFont(new Font("Arial", 4, 20));
        ShowPhone.setEditable(false);
        ShowPhone.setBackground(Color.white);

        lblShowAddress.setBounds(100, 350, 150, 40);
        lblShowAddress.setFont(new Font("Arial", 4, 20));
        ShowAddress.setBounds(250, 350, 250, 40);
        ShowAddress.setFont(new Font("Arial", 4, 20));
        ShowAddress.setEditable(false);
        ShowAddress.setBackground(Color.white);

        lblIdentifyCard.setBounds(100, 400, 150, 40);
        lblIdentifyCard.setFont(new Font("Arial", 4, 20));
        ShowIdentifyCard.setBounds(250, 400, 250, 40);
        ShowIdentifyCard.setFont(new Font("Arial", 4, 20));
        ShowIdentifyCard.setEditable(false);
        ShowIdentifyCard.setBackground(Color.white);

        btnEdit.setBounds(250, 450, 115, 40);
        btnCancel.setBounds(385, 450, 115, 40);

        pnShowInfor.add(lblTitle);
        pnShowInfor.add(lblIdentifyCard);
        pnShowInfor.add(lblShowAddress);
        pnShowInfor.add(lblShowBirthDay);
        pnShowInfor.add(lblShowEmail);
        pnShowInfor.add(lblShowGender);
        pnShowInfor.add(lblShowName);
        pnShowInfor.add(lblShowPhone);
        pnShowInfor.add(ShowAddress);
        pnShowInfor.add(ShowPhone);
        pnShowInfor.add(ShowName);
        pnShowInfor.add(ShowIdentifyCard);
        pnShowInfor.add(ShowGender);
        pnShowInfor.add(ShowEmail);
        pnShowInfor.add(ShowBirthday);
        pnShowInfor.add(btnEdit);
        pnShowInfor.add(btnCancel);

        // form gửi tiền vào tài khoản 
        lblVND = new JLabel("VND");
        depositAmount = new JLabel("Amount");
        txtDepositAmount = new JTextField();
        depositName = new JLabel("Account Name");
        showDepositName = new JLabel(oldUser.getFullName());
        depositNumber = new JLabel("Account Number");
        showDepositNumber = new JLabel(account.getNumber());
        deposit = new JButton("Deposit");
        depositCancel = new JButton("Cancel");

        depositName.setBounds(100, 150, 150, 40);
        showDepositName.setBounds(260, 150, 250, 40);
        depositNumber.setBounds(100, 200, 150, 40);
        showDepositNumber.setBounds(260, 200, 250, 40);
        depositAmount.setBounds(100, 250, 150, 40);
        txtDepositAmount.setBounds(260, 250, 250, 40);
        lblVND.setBounds(220, 0, 30, 40);
        deposit.setBounds(260, 300, 115, 40);
        depositCancel.setBounds(395, 300, 115, 40);

        pnDeposit.add(depositAmount);
        pnDeposit.add(depositName);
        pnDeposit.add(depositNumber);
        pnDeposit.add(txtDepositAmount);
        pnDeposit.add(showDepositName);
        pnDeposit.add(showDepositNumber);
        pnDeposit.add(deposit);
        pnDeposit.add(depositCancel);
        txtDepositAmount.add(lblVND);

        // form rút tiền từ tài khoản
        withDrawName = new JLabel("Account Name");
        withDrawBalance = new JLabel("Account Bolane");
        withDrawAmount = new JLabel("Amount");
        withDrawNumber = new JLabel("Account Number");
        showWithDrawName = new JLabel(oldUser.getFullName());
        showWithDrawBalance = new JLabel(String.valueOf(account.getBalance()));
        txtWithDraw = new JTextField();
        withDrawVND = new JLabel("VND");
        withDraw = new JButton("Withdraw");
        withDrawCancel = new JButton("Cancel");
        showWithDrawNumber = new JLabel(account.getNumber());

        withDrawNumber.setBounds(100, 100, 150, 40);
        showWithDrawNumber.setBounds(260, 100, 250, 40);
        withDrawName.setBounds(100, 150, 150, 40);
        showWithDrawName.setBounds(260, 150, 250, 40);
        withDrawBalance.setBounds(100, 200, 150, 40);
        showWithDrawBalance.setBounds(260, 200, 250, 40);
        withDrawAmount.setBounds(100, 250, 150, 40);
        txtWithDraw.setBounds(260, 250, 250, 40);
        withDrawVND.setBounds(220, 0, 30, 40);
        withDraw.setBounds(260, 300, 115, 40);
        withDrawCancel.setBounds(395, 300, 115, 40);

        pnWithDraw.add(withDrawAmount);
        pnWithDraw.add(withDrawBalance);
        pnWithDraw.add(withDrawName);
        pnWithDraw.add(showWithDrawBalance);
        pnWithDraw.add(showWithDrawName);
        pnWithDraw.add(txtWithDraw);
        pnWithDraw.add(withDraw);
        pnWithDraw.add(withDrawCancel);
        txtWithDraw.add(withDrawVND);
        pnWithDraw.add(withDrawNumber);
        pnWithDraw.add(showWithDrawNumber);

        // chuyển tiền vào tài khoản khác
        transfer = new JButton("Transfer");
        transferCancel = new JButton("Cancel");
        lblTitleSend = new JLabel("Account Send");
        lblTitleReceiver = new JLabel("Account Receive");
        lblNameSender = new JLabel("Account Name");
        showNameSender = new JLabel(oldUser.getFullName());
        lblNumberSender = new JLabel("Account Number");
        showNumberSender = new JLabel(account.getNumber());
        lblNameReceiver = new JLabel("Account Name");
        txtNameReceiver = new JTextField();
        lblNumberReceiver = new JLabel("Account Number");
        txtNumberReceiver = new JTextField();
        lblTransferAmount = new JLabel("Transfer Amount");
        txtTransferAmount = new JTextField();

        lblTitleSend.setBounds(100, 50, 250, 40);
        lblNameSender.setBounds(50, 150, 150, 40);
        showNameSender.setBounds(220, 150, 250, 40);
        lblNumberSender.setBounds(50, 200, 150, 40);
        showNumberSender.setBounds(220, 200, 250, 40);
        lblTitleReceiver.setBounds(100, 250, 250, 40);
        lblNameReceiver.setBounds(50, 300, 150, 40);
        txtNameReceiver.setBounds(220, 300, 250, 40);
        lblNumberReceiver.setBounds(50, 350, 150, 40);
        txtNumberReceiver.setBounds(220, 350, 250, 40);
        lblTransferAmount.setBounds(50, 400, 150, 40);
        txtTransferAmount.setBounds(220, 400, 250, 40);
        transfer.setBounds(220, 450, 115, 40);
        transferCancel.setBounds(355, 450, 115, 40);

        pnTransfer.add(lblTitleSend);
        pnTransfer.add(lblTitleReceiver);
        pnTransfer.add(lblNameSender);
        pnTransfer.add(showNameSender);
        pnTransfer.add(lblNumberSender);
        pnTransfer.add(showNumberSender);
        pnTransfer.add(lblNameReceiver);
        pnTransfer.add(txtNameReceiver);
        pnTransfer.add(lblNumberReceiver);
        pnTransfer.add(txtNumberReceiver);
        pnTransfer.add(lblTransferAmount);
        pnTransfer.add(txtTransferAmount);
        pnTransfer.add(transfer);
        pnTransfer.add(transferCancel);

        //bat su kien
        iconAccount.addMouseListener(new AccountInforHandle());
        btnDeposit.addActionListener(new DepositHandle());
        btnTransfer.addActionListener(new TransferHandle());
        btnWithDraw.addActionListener(new WithDrawHandle());
        btnEdit.addActionListener(new EditHandle());
        btnCancel.addActionListener(new CancelHandle());
        deposit.addActionListener(new Deposit());
        depositCancel.addActionListener(new DepositCancel());
        withDraw.addActionListener(new WithDraw());
        withDrawCancel.addActionListener(new WithDrawCancel());
        btnLogout.addActionListener(new LogoutHandle());
        transfer.addActionListener(new Transfer());
        transferCancel.addActionListener(new TransferCancel());

        // add component
        add(pnContentLeft);
        add(pnContentRight);
        add(pnShowInfor);
        add(pnDeposit);
        add(pnWithDraw);
        add(pnTransfer);
        pnContentLeft.add(iconAccount);
        pnContentLeft.add(accountName);
        pnContentLeft.add(btnAccountInfor);
        pnContentLeft.add(btnDeposit);
        pnContentLeft.add(btnTransfer);
        pnContentLeft.add(btnWithDraw);
        pnContentLeft.add(btnLogout);
        pnContentRight.add(iconHello);
        pnContentRight.add(iconHelloText);
        pnShowInfor.setVisible(false);
        pnDeposit.setVisible(false);
        pnWithDraw.setVisible(false);
        pnTransfer.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    class TransferCancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnTransfer.setVisible(false);
            pnContentRight.setVisible(true);
        }

    }

    class Transfer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int opt = JOptionPane.showConfirmDialog(null, "Do you want to handle transaction?");
            if (opt == 0) {
                String numberSender = showNumberSender.getText();
                long amount = Long.valueOf(txtTransferAmount.getText());
                String numberReceiver = txtNumberReceiver.getText();
                accountModel.transfer(numberSender, amount, numberReceiver);
            }
        }
    }

    class LogoutHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            FormLogin login = new FormLogin();
            setVisible(false);
        }
    }

    class WithDraw implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            accountModel.withdraw(showWithDrawNumber.getText(), Long.valueOf(txtWithDraw.getText()));
            Account newBalance = accountModel.getAccount(a);
            showWithDrawBalance.setText(String.valueOf(newBalance.getBalance()));
            txtWithDraw.setText("");
        }
    }

    class WithDrawCancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnWithDraw.setVisible(false);
            pnContentRight.setVisible(true);
        }

    }

    class Deposit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            accountModel.deposit(showDepositNumber.getText(), Long.valueOf(txtDepositAmount.getText()));
            Account newBalance = accountModel.getAccount(a);
            JOptionPane.showMessageDialog(null, "Deposit Success! Your balance: " + newBalance.getBalance());
            txtDepositAmount.setText("");
        }
    }

    class DepositCancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnDeposit.setVisible(false);
            pnContentRight.setVisible(true);
            txtDepositAmount.setText("");
        }

    }

    class EditHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (btnEdit.getText().equals("Edit")) {
                btnEdit.setText("Save");
                ShowName.setEditable(true);
                ShowBirthday.setEditable(true);
                ShowGender.setEnabled(true);
                ShowEmail.setEditable(true);
                ShowPhone.setEditable(true);
                ShowAddress.setEditable(true);
                ShowIdentifyCard.setEditable(false);
                lblTitle.setText("Edit information");
            } else if (btnEdit.getText().equals("Save")) {
                btnEdit.setText("Edit");
                ShowName.setEditable(false);
                ShowBirthday.setEditable(false);
                ShowGender.setEnabled(false);
                ShowEmail.setEditable(false);
                ShowPhone.setEditable(false);
                ShowAddress.setEditable(false);
                ShowIdentifyCard.setEditable(false);
                lblTitle.setText("Account information");
                AccountModel model = new AccountModel();
                account.setUpdatedTimeMLS(System.currentTimeMillis());

                oldUser.setFullName(ShowName.getText());
                oldUser.setBirthDay(ShowBirthday.getText());
                oldUser.setGender(ShowGender.getSelectedItem().toString());
                oldUser.setEmail(ShowEmail.getText());
                oldUser.setPhone(ShowPhone.getText());
                oldUser.setAddress(ShowAddress.getText());

                //JOptionPane.showMessageDialog(null, user.toString());
                model.update(account, oldUser);
            }
        }

    }

    class CancelHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnShowInfor.setVisible(false);
            pnContentRight.setVisible(true);
        }

    }

    class DepositHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnDeposit.setVisible(true);
            pnContentRight.setVisible(false);
            pnTransfer.setVisible(false);
            pnWithDraw.setVisible(false);
            pnShowInfor.setVisible(false);
            pnDeposit.setBackground(Color.green);

        }
    }

    class TransferHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnTransfer.setVisible(true);
            pnDeposit.setVisible(false);
            pnWithDraw.setVisible(false);
            pnContentRight.setVisible(false);
            pnShowInfor.setVisible(false);
            pnTransfer.setBackground(Color.yellow);
        }
    }

    class WithDrawHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pnWithDraw.setVisible(true);
            pnTransfer.setVisible(false);
            pnDeposit.setVisible(false);
            pnContentRight.setVisible(false);
            pnShowInfor.setVisible(false);
            Account newBalance = accountModel.getAccount(a);
            showWithDrawBalance.setText(String.valueOf(newBalance.getBalance()));
        }

    }

    class AccountInforHandle implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

            pnShowInfor.setVisible(true);

            pnTransfer.setVisible(false);
            pnDeposit.setVisible(false);
            pnWithDraw.setVisible(false);
            pnContentRight.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {
            iconAccount.setBounds(32, 52, 130, 130);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            iconAccount.setBounds(30, 50, 130, 130);
        }
    }

}
