/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.yazlab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author efeyi
 */
public class SelectionScreen {
    
 private static final String DB_URL = "jdbc:postgresql://localhost:5432/Yazlab";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Murat131efe67.";
    
     public static void baglanti() {
        String url = "jdbc:postgresql://localhost:5432/Yazlab?user=postgres&password=Murat131efe67.";
        String username = "postgres";
        String password = "Murat131efe67.";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Bağlantı başarılı.");
            connection.close(); // Bağlantıyı kapat
        } catch (SQLException e) {
            System.err.println("Bağlantı hatası: " + e.getMessage());
        }
    }

    public static void mali() {
        JFrame frame = new JFrame("Login Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();

        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (checkCredentials(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Giriş başarılı.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Kullanıcı adı veya şifre yanlış.");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static boolean checkCredentials(String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT username, password FROM ogrenciler WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    



}
