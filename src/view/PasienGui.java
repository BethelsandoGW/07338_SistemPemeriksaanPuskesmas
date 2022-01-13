package view;

import entity.PasienEntity07338;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasienGui extends JFrame {

    private String nama, noTelp, dokterPenangan, diagnosa, penanganan, umur;
    private int status;

    public PasienGui(int id) {
        initWindow();
        initComponent(id);
    }
    private void initWindow(){
        setTitle("BIODATA PASIEN");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    private void initComponent(int id){
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setBounds(230, 15,154, 30);
        add(title);

        logoutBtn.setBounds(460,15,100,28);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setBackground(Color.BLACK);
        logoutBtn.setForeground(Color.WHITE);
        add(logoutBtn);

        biodataField.setFont(new Font("Arial", Font.ITALIC, 17));
        biodataField.setBounds(30, 60,530, 170);
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        biodataField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        biodataField.setText(getPasien(id));
        biodataField.setEditable(false);
        add(biodataField);

        logoutEvent();

    }

    private void logoutEvent(){
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGui().setVisible(true);
                dispose();
            }
        });
    }

    private String getPasien(int id){
        for (PasienEntity07338 pasien : AllObjCtr.pasienController.getDataPasien(id)) {
            this.nama = pasien.getNama();
            this.umur = pasien.getUmur();
            this.noTelp = pasien.getNotelp();
            this.dokterPenangan = pasien.getDokterPenanganan();
            this.diagnosa = pasien.getDiagnosa();
            this.penanganan = pasien.getPenanganan();
        }
        return "  NAMA : " + nama + "\n  UMUR : " + umur + "\n  NO.TELP : " + noTelp + "\n  DOKTER : " + dokterPenangan + "\n  DIAGNOSA : " + diagnosa + "\n  PENANGANAN : " + penanganan;
    }
    private JLabel title;
    private JTextArea biodataField;
    private JButton logoutBtn;
    {
        title = new JLabel("BIODATA PASIEN");
        biodataField = new JTextArea();
        logoutBtn = new JButton("LOG OUT");
    }
}
