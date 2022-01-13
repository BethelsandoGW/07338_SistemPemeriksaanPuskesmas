package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPasienGui extends JFrame {
    public RegisterPasienGui() {
        initWindow();
        initComponent();
    }

    private void initWindow(){
        setTitle("REGISTER PASIEN");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setBounds(150, 15,154, 30);
        add(title);

        backBtn.setBounds(10,15,120,28);
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        add(backBtn);

        namaLbl.setFont(new Font("Arial", Font.BOLD, 14));
        namaLbl.setBounds(40,80, 160, 35);
        add(namaLbl);

        passwordLbl.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLbl.setBounds(40,125, 160, 35);
        add(passwordLbl);

        notelpLbl.setFont(new Font("Arial", Font.BOLD, 14));
        notelpLbl.setBounds(40,170, 160, 35);
        add(notelpLbl);

        umurLbl.setFont(new Font("Arial", Font.BOLD, 14));
        umurLbl.setBounds(40,215, 160, 35);
        add(umurLbl);

        keluhanLbl.setFont(new Font("Arial", Font.BOLD, 14));
        keluhanLbl.setBounds(40,260, 160, 35);
        add(keluhanLbl);

        namaField.setBounds(150, 80, 190,35);
        add(namaField);

        passwordField.setBounds(150, 125, 190,35);
        add(passwordField);

        notelpField.setBounds(150, 170, 190,35);
        add(notelpField);

        umurField.setBounds(150, 215, 190,35);
        add(umurField);

        Border border = BorderFactory.createLineBorder(Color.GRAY);
        keluhanField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        keluhanField.setBounds(150, 260, 190,130);
        add(keluhanField);

        addBtn.setBounds(150,415,120,28);
        addBtn.setFocusPainted(false);
        addBtn.setBorderPainted(false);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        add(addBtn);

        registerEvent();
        backEvent();
    }

    private void backEvent(){
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGui().setVisible(true);
                dispose();
            }
        });
    }

    private void registerEvent(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String noTelp = notelpField.getText();
                String password = passwordField.getText();
                String umur = umurField.getText();
                String keluhan = keluhanField.getText();


                if(nama.length() != 0 && noTelp.length() != 0 && password.length()!=0 && umur.length()!=0 && keluhan.length()!=0){
                    int cek = AllObjCtr.pasienController.addPasien(nama,noTelp,password,umur,keluhan);
                    if(cek > 0){
                        JOptionPane.showMessageDialog(null,"Berhasil ditambah");
                        new LoginGui().setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null,"Nama sudah terdaftar");
                        namaField.setText(null);
                        notelpField.setText(null);
                        passwordField.setText(null);
                        umurField.setText(null);
                        keluhanField.setText(null);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Tidak Boleh ada yang kosong");
                }

            }
        });
    }

    private JLabel namaLbl, notelpLbl, passwordLbl, umurLbl, keluhanLbl, title;
    private JTextField namaField, notelpField, passwordField, umurField;
    private JTextArea keluhanField;
    private JButton addBtn, backBtn;
    {
        title = new JLabel("ISI BIODATA");
        namaLbl = new JLabel("NAMA");
        notelpLbl = new JLabel("NO.TELEPON");
        passwordLbl = new JLabel("PASSWORD");
        umurLbl = new JLabel("UMUR");
        keluhanLbl = new JLabel("KELUHAN");
        namaField = new JTextField();
        notelpField = new JTextField();
        passwordField = new JTextField();
        umurField = new JTextField();
        keluhanField = new JTextArea();
        addBtn = new JButton("REGISTRASI");
        backBtn = new JButton("BACK");
    }

}
