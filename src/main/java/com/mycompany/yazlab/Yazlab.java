/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.yazlab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author efeyi
 */
public class Yazlab {

   public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Uygulaması");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Öğrenci, Hoca ve Yönetici Kullanıcı Adları ve Şifreleri
        String studentUsername = "ogrenci";
        String studentPassword = "1234";
        String teacherUsername = "hoca";
        String teacherPassword = "5678";
        String adminUsername = "yonetici";
        String adminPassword = "abcd";

        // Kullanıcı Adı ve Şifre Alanları
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        // Giriş Butonu
        JButton loginButton = new JButton("Giriş Yap");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String passwordStr = new String(password);

                if (username.equals(studentUsername) && passwordStr.equals(studentPassword)) {
                    JOptionPane.showMessageDialog(null, "Öğrenci Paneline Hoş Geldiniz!");
                } else if (username.equals(teacherUsername) && passwordStr.equals(teacherPassword)) {
                    JOptionPane.showMessageDialog(null, "Hoca Paneline Hoş Geldiniz!");
                } else if (username.equals(adminUsername) && passwordStr.equals(adminPassword)) {
                    JOptionPane.showMessageDialog(null, "Yönetici Paneline Hoş Geldiniz!");
                } else {
                    JOptionPane.showMessageDialog(null, "Geçersiz Kullanıcı Adı veya Şifre!");
                }
                
                // Kullanıcı adı ve şifreyi temizle
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        frame.add(new JLabel("Kullanıcı Adı: "));
        frame.add(usernameField);
        frame.add(new JLabel("Şifre: "));
        frame.add(passwordField);
        frame.add(loginButton);

        frame.setVisible(true);
    }
}
