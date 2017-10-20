/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.add2.model;

import com.fpt.add2.entity.Account;
import com.fpt.add2.entity.Transaction;
import com.fpt.add2.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daolinh
 */
/**
 *
 */
public class AccountModel {

    private TransactionModel transactionModel = new TransactionModel();

    // Thêm mới dữ liệu.
    public boolean insertAccount(Account account) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into");
        sqlBuilder.append(" ");
        sqlBuilder.append("account");
        sqlBuilder.append(" ");
        sqlBuilder.append("(number, account, password, balance, userIdentifyCard, createdTimeMLS, updatedTimeMLS, status)");
        sqlBuilder.append(" ");
        sqlBuilder.append("values");
        sqlBuilder.append(" ");
        sqlBuilder.append("(?, ?, ?, ?, ?, ?, ?, ?);");

        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sqlBuilder.toString());
            preStt.setString(1, account.getNumber());
            preStt.setString(2, account.getAccount());
            preStt.setString(3, account.getPassword());
            preStt.setLong(4, account.getBalance());
            preStt.setString(5, account.getUserIdentifyCard());
            preStt.setLong(6, account.getCreatedTimeMLS());
            preStt.setLong(7, account.getUpdatedTimeMLS());
            preStt.setInt(8, account.getStatus());
            preStt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean insertUser(User user) {
        String sql = "INSERT INTO user (identifyCard, fullName, birthday, gender, email, phone, address, createdTimeMLS, updatedTimeMLS, status) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sql);
            preStt.setString(1, user.getIdentifyCard());
            preStt.setString(2, user.getFullName());
            preStt.setString(3, user.getBirthDay());
            preStt.setString(4, user.getGender());
            preStt.setString(5, user.getEmail());
            preStt.setString(6, user.getPhone());
            preStt.setLong(8, user.getCreatedTimeMLS());
            preStt.setLong(9, user.getUpdatedTimeMLS());
            preStt.setString(7, user.getAddress());
            preStt.setInt(10, user.getStatus());
            preStt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Account getAccount(String account) {
        Account acc = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            String sql = "SELECT * FROM account WHERE account = ? AND status=1;";
            PreparedStatement preStt = con.prepareStatement(sql);
            preStt.setString(1, account);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                String number = rs.getString("number");
                String strAccount = rs.getString("account");
                long balance = rs.getLong("balance");
                String identifyCard = rs.getString("userIdentifyCard");

                acc = new Account();
                acc.setAccount(strAccount);
                acc.setNumber(number);
                acc.setBalance(balance);
                acc.setUserIdentifyCard(identifyCard);
            }
        } catch (Exception e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return acc;
    }

    public User getUser(String identifyCard) {
        User user = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            String sql = "SELECT * FROM user WHERE identifyCard = ? AND status=1;";
            PreparedStatement preStt = con.prepareStatement(sql);
            preStt.setString(1, identifyCard);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                String strIdentifyCard = rs.getString("identifyCard");
                String name = rs.getString("fullName");
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                user = new User();
                user.setIdentifyCard(strIdentifyCard);
                user.setFullName(name);
                user.setBirthDay(birthday);
                user.setGender(gender);
                user.setEmail(email);
                user.setPhone(phone);
                user.setAddress(address);
            }
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return user;
    }

    public boolean update(Account account, User user) {
        try {
            Connection con = DAO.getConnection();
            String sqlAcc = "UPDATE account SET updatedTimeMLS = ? WHERE number = ?;";
            String sqlUser = "UPDATE user SET  fullName = ?, birthday= ?, gender = ?, email = ?, phone = ?, address = ?  WHERE identifyCard = ? ;";
            PreparedStatement preSttAcc = con.prepareStatement(sqlAcc);
            preSttAcc.setLong(1, account.getUpdatedTimeMLS());
            preSttAcc.setString(2, account.getNumber());

            PreparedStatement preSttUser = con.prepareStatement(sqlUser);

            preSttUser.setString(1, user.getFullName());
            preSttUser.setString(2, user.getBirthDay());
            preSttUser.setString(3, user.getGender());
            preSttUser.setString(4, user.getEmail());
            preSttUser.setString(5, user.getPhone());
            preSttUser.setString(6, user.getAddress());
            preSttUser.setString(7, user.getIdentifyCard());
            preSttAcc.executeUpdate();
            preSttUser.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(String id) {
        
        return false;
    }

    public Account getById(String id) {
        Account obj = new Account();
        return obj;
    }

    public ArrayList<Account> getList() {
        ArrayList<Account> list = new ArrayList<>();
        return list;
    }

    // Thực hiện cộng tiền vào tài khoản, trả về là số dư mới.
    public long deposit(String targetAccountNumber, long amount) {
        Connection con = null;
        try {
            con = DAO.getConnection();
            con.setAutoCommit(false);

            // 1. Thực hiện truy vấn số dư của tài khoản.
            StringBuilder sqlSelectBuilder = new StringBuilder();
            sqlSelectBuilder.append("select balance from account where number = ?;");
            PreparedStatement queryBalance = con.prepareStatement(sqlSelectBuilder.toString());
            queryBalance.setString(1, targetAccountNumber);
            ResultSet resultBalance = queryBalance.executeQuery();
            // Số dư mặc định bằng 0.
            long balance = 0;
            if (resultBalance.next()) {
                balance = resultBalance.getLong("balance");
            }

            // 2. Tiến hành cộng tiền vào tài khoản.
            balance += amount;

            StringBuilder sqlUpdate = new StringBuilder();
            sqlUpdate.append("update account");
            sqlUpdate.append(" ");
            sqlUpdate.append("set balance = ?");
            sqlUpdate.append(" ");
            sqlUpdate.append("where");
            sqlUpdate.append(" ");
            sqlUpdate.append("number = ?;");
            PreparedStatement updateBalance = con.prepareStatement(sqlUpdate.toString());
            updateBalance.setLong(1, balance); // số dư mới của tài khoản.
            updateBalance.setString(2, targetAccountNumber); // tài khoản cộng tiền.
            updateBalance.executeUpdate();

            // Lưu lịch sử giao dịch.
            Transaction tx = new Transaction();
            tx.setSenderAccountNumber(targetAccountNumber);
            tx.setReceiverAccountNumber(targetAccountNumber);
            tx.setAmount(amount);
            tx.setType(1);
            tx.setStatus(1);
            tx.setMessage("Deposit money.");
            if (transactionModel.insert(tx)) {
                con.commit(); // Lưu tất cả các thay đổi của các lệnh vừa thực thi vào db.
                return balance;
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    // Thực hiện rút tiền từ tài khoản, trả về số dư mới.
    public long withdraw(String targetAccountNumber, long amount) {
        Connection con = null;
        // Lưu lịch sử giao dịch.
        Transaction tx = new Transaction();
        tx.setSenderAccountNumber(targetAccountNumber);
        tx.setReceiverAccountNumber(targetAccountNumber);
        tx.setAmount(amount);
        tx.setMessage("Withdraw money.");
        tx.setType(2);
        try {
            con = DAO.getConnection();
            con.setAutoCommit(false);

            // 1. Thực hiện truy vấn số dư của tài khoản.
            StringBuilder sqlSelectBuilder = new StringBuilder();
            sqlSelectBuilder.append("select balance from account where number = ?;");
            PreparedStatement queryBalance = con.prepareStatement(sqlSelectBuilder.toString());
            queryBalance.setString(1, targetAccountNumber);
            ResultSet resultBalance = queryBalance.executeQuery();
            // Số dư mặc định bằng 0.
            long balance = 0;
            if (resultBalance.next()) {
                balance = resultBalance.getLong("balance");
            }

            // 2. Tiến hành trừ tiền trong tài khoản.
            if (balance >= amount) {
                balance -= amount;

                StringBuilder sqlUpdate = new StringBuilder();
                sqlUpdate.append("update account");
                sqlUpdate.append(" ");
                sqlUpdate.append("set balance = ?");
                sqlUpdate.append(" ");
                sqlUpdate.append("where");
                sqlUpdate.append(" ");
                sqlUpdate.append("number = ?;");
                PreparedStatement updateBalance = con.prepareStatement(sqlUpdate.toString());
                updateBalance.setLong(1, balance); // số dư mới của tài khoản.
                updateBalance.setString(2, targetAccountNumber); // tài khoản cộng tiền.
                updateBalance.executeUpdate();
                tx.setStatus(1);
                transactionModel.insert(tx);
                 con.commit(); // Lưu tất cả các thay đổi của các lệnh vừa thực thi vào db.
                return balance;
            } else {
                JOptionPane.showMessageDialog(null, "Balance not enough!");
                tx.setStatus(0);
                transactionModel.insert(tx);
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    // Thực hiện chuyển tiền đến tài khoản đích, tham số thứ nhất là số lượng tiền
    // cần chuyển, tham số thứ hai là số tài khoản nhận tiền. Trả về số dư hiện tại
    // của tài khoản thực hiện.
    public long transfer(String targetSenderAccountNumber, long amount, String targetReceiverAccountNumber) {
        Connection con = null;
        // Lưu lịch sử giao dịch.
        Transaction tx = new Transaction();
        tx.setSenderAccountNumber(targetSenderAccountNumber);
        tx.setReceiverAccountNumber(targetReceiverAccountNumber);
        tx.setAmount(amount);
        tx.setMessage("Transfer money.");
        tx.setType(3);
        try {
            con = DAO.getConnection();
            con.setAutoCommit(false);
            // truy vấn tài khoản gửi
            String sqlSender = "SELECT balance FROM account WHERE number = ?;";
            PreparedStatement preSttSender = con.prepareStatement(sqlSender);
            preSttSender.setString(1, targetSenderAccountNumber);
            ResultSet rsSender = preSttSender.executeQuery();
            long balanceSender = 0;
            if (rsSender.next()) {
                balanceSender = rsSender.getLong("balance");
            }

            // truy vấn tài khoản nhận
            String sqlReceiver = "SELECT balance FROM account WHERE number = ?;";
            PreparedStatement preSttReceiver = con.prepareStatement(sqlReceiver);
            preSttReceiver.setString(1, targetReceiverAccountNumber);
            ResultSet rsReceiver = preSttReceiver.executeQuery();
            long balanceReceiver = 0;
            if (rsSender.next()) {
                balanceReceiver = rsReceiver.getLong("balance");
            }

            if (balanceSender >= amount) {
                balanceSender -= amount;
                String sqlUpdateSender = "UPDATE account SET balance= ? WHERE number=?;";
                PreparedStatement preSttUpdateSender = con.prepareStatement(sqlUpdateSender);
                preSttUpdateSender.setLong(1, balanceSender);
                preSttUpdateSender.setString(2, targetSenderAccountNumber);
                preSttUpdateSender.executeUpdate();

                balanceReceiver += amount;
                String sqlUpdateReceiverd = "UPDATE account SET balance= ? WHERE number=?;";
                PreparedStatement preSttUpdateReceiverd = con.prepareStatement(sqlUpdateReceiverd);
                preSttUpdateReceiverd.setLong(1, balanceReceiver);
                preSttUpdateReceiverd.setString(2, targetReceiverAccountNumber);
                preSttUpdateReceiverd.executeUpdate();

                JOptionPane.showMessageDialog(null, "Handling transaction...");
                tx.setStatus(1);
                transactionModel.insert(tx);
                con.commit(); // Lưu tất cả các thay đổi của các lệnh vừa thực thi vào db.
                return balanceSender;
            } else {
                JOptionPane.showMessageDialog(null, "Balance not enough!");
                tx.setStatus(0);
                transactionModel.insert(tx);
                con.rollback();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return 0;
    }

    // Kiểm tra thông tin tài khoản với account và password. Trả về null trong 
    // trường hợp không tồn tại account và password hợp lệ.
    public Account checkAuthentication(String account, String password) {
        Account acc = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            StringBuilder strSQL = new StringBuilder();
            strSQL.append("SELECT number, account, balance FROM account WHERE account = ? AND password = ? AND status = 1;");
            PreparedStatement preStt = con.prepareStatement(strSQL.toString());
            preStt.setString(1, account);
            preStt.setString(2, password);
            System.out.println(preStt);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                String number = rs.getString("number");
                String accountString = rs.getString("account");
                long balance = rs.getLong("balance");
                acc = new Account();
                acc.setAccount(accountString);
                acc.setNumber(number);
                acc.setBalance(balance);
            }
        } catch (Exception e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return acc;
    }
}
