package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame {
    public LoginGui() {
        initWindow();
        initComponent();
    }
    private void initWindow(){
        setTitle("PUSKESMAS");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    private void initComponent(){
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setBounds(140, 21,154, 30);
        add(title);

        userLbl.setFont(new Font("Arial", Font.BOLD, 14));
        userLbl.setBounds(40,95, 160, 35);
        add(userLbl);

        passLbl.setFont(new Font("Arial", Font.BOLD, 14));
        passLbl.setBounds(40,160, 160, 35);
        add(passLbl);

        loginBtn.setBounds(143,270,100,28);
        loginBtn.setFocusPainted(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        add(loginBtn);

        regisBtn.setBounds(100,348,200,28);
        regisBtn.setFocusPainted(false);
        regisBtn.setBorderPainted(false);
        regisBtn.setBackground(Color.BLACK);
        regisBtn.setForeground(Color.WHITE);
        add(regisBtn);

        usernameField.setBounds(150, 95, 190,35);
        add(usernameField);

        passwordField.setBounds(150, 160, 190,35);
        add(passwordField);

        loginEvent();
        RegistrasiEvent();
    }

    private void loginEvent(){
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                int loginDokter = AllObjCtr.dokterController.cekLogin(username, password);
                int loginPasien = AllObjCtr.pasienController.cekLogin(username, password);

                if(username.length() != 0 && password.length() != 0){
                    if(loginDokter > 0){
                        JOptionPane.showMessageDialog(null,"Login Sebagai Dokter");
                        new DokterGui(loginDokter).setVisible(true);
                        dispose();
                    }else if(loginPasien > 0){
                        JOptionPane.showMessageDialog(null,"Login sebagai Pasien");
                        new PasienGui(loginPasien).setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null,"Username atau password salah");
                    };
                }else {
                    JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }

            }
        });
    }
    private void RegistrasiEvent(){
        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPasienGui().setVisible(true);
            }
        });
    }

    private final JLabel title, userLbl, passLbl;
    private final JButton loginBtn, regisBtn;
    private final JTextField usernameField;
    private final JPasswordField passwordField;


    {
        title = new JLabel("PUSKESMAS");
        userLbl = new JLabel("USERNAME");
        passLbl = new JLabel("PASSWORD");
        loginBtn = new JButton("LOGIN");
        regisBtn = new JButton("REGISTRASI PASIEN");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
    }
}
