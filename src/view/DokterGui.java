package view;

import controller.AllObjMod;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DokterGui extends JFrame {
    private String dokterPenanganan, penanganan, diagnosa, keluhan;

    private int status;

    public DokterGui(int id) {
        initWindow();
        initComponent(id);
    }

    private void initWindow(){
        setTitle("DOKTER PAGE");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(int id){
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setBounds(460, 20,150, 30);
        add(title);

        scrollPasien.setBounds(45, 50, 900, 300);
        dataTable07338();
        add(scrollPasien);

        dokterLbl.setFont(new Font("Arial", Font.BOLD, 14));
        dokterLbl.setBounds(45, 360,150, 30);
        add(dokterLbl);


        keluhanLbl.setFont(new Font("Arial", Font.BOLD, 14));
        keluhanLbl.setBounds(45, 400,150, 30);
        add(keluhanLbl);


        diagnosaLbl.setFont(new Font("Arial", Font.BOLD, 14));
        diagnosaLbl.setBounds(380, 360,150, 30);
        add(diagnosaLbl);


        penangananLbl.setFont(new Font("Arial", Font.BOLD, 14));
        penangananLbl.setBounds(380, 400,150, 30);
        add(penangananLbl);

        Border border = BorderFactory.createLineBorder(Color.GRAY);
        keluhanField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        keluhanField.setBounds(165, 410, 190,130);
        add(keluhanField);


        penangananField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        penangananField.setBounds(490, 410, 190,130);
        add(penangananField);

        diagnosaField.setBounds(490, 360, 190,35);
        add(diagnosaField);

        dokterField.setBounds(165, 360, 190,35);
        add(dokterField);

        deleteBtn.setBounds(700,360,100,28);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setBorderPainted(false);
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.WHITE);
        add(deleteBtn);

        verifBtn.setBounds(830,360,100,28);
        verifBtn.setFocusPainted(false);
        verifBtn.setBorderPainted(false);
        verifBtn.setBackground(Color.BLACK);
        verifBtn.setForeground(Color.WHITE);
        add(verifBtn);

        refreshBtn.setBounds(700,410,100,28);
        refreshBtn.setFocusPainted(false);
        refreshBtn.setBorderPainted(false);
        refreshBtn.setBackground(Color.BLACK);
        refreshBtn.setForeground(Color.WHITE);
        add(refreshBtn);

        updateBtn.setBounds(830,410,100,28);
        updateBtn.setFocusPainted(false);
        updateBtn.setBorderPainted(false);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        add(updateBtn);

        logoutBtn.setBounds(845,15,100,28);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setBackground(Color.BLACK);
        logoutBtn.setForeground(Color.WHITE);
        add(logoutBtn);


        tableEvent07338();
        verifEvent(id);
        logoutEvent();
        refreshEvent();
        updateEvent();
        deleteEvent();


    }

    private void updateEvent(){
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedField.getText().length() > 0){
                    if (penangananField.getText().length() > 0 && diagnosaField.getText().length() > 0){
                        penanganan = penangananField.getText();
                        diagnosa = diagnosaField.getText();
                        AllObjCtr.pasienController.updateDiagnosaa(Integer.parseInt(selectedField.getText()), diagnosa);
                        AllObjCtr.pasienController.updatePenanganan(Integer.parseInt(selectedField.getText()), penanganan);
                        dataTable07338();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "DIAGNOSIS DAN PENANGANAN TIDAK BOLEH KOSONG");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "PILIH DATA TERLEBIH DAHULU");
                }
            }
        });
    }

    private void deleteEvent(){
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedField.getText().length() > 0){
                    try {
                        //String konf = JOptionPane.showInputDialog("Yakin Ingin Hapus Data dengan ID " + id + " (y/n)");
                        int konf = JOptionPane.showConfirmDialog(null, "Yakin ingin hapus data ID yang dipilih ");

                        if (konf == JOptionPane.YES_OPTION) {
                            int hapus = AllObjCtr.dokterController.deletePasien(Integer.parseInt(selectedField.getText()));

                            String msg = (hapus > 0) ? "Berhasil Hapus Data" : "Gagal Hapus Data";

                            JOptionPane.showMessageDialog(null, msg);

                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cancelled");

                        }
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null, "Cancelled " + err);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "PILIH DATA TERLEBIH DAHULU");
                }
                dataTable07338();
            }
        });
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

    private void refreshEvent(){
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTable07338();
                selectedField.setText(null);
            }
        });
    }

    private void dataTable07338(){
        tablePasien.setModel(AllObjCtr.dokterController.daftarPasien());
        tablePasien.setDefaultEditor(Object.class, null);
        dokterField.setText(null);
        diagnosaField.setText(null);
        penangananField.setText(null);
        keluhanField.setText(null);
    }

    private void tableEvent07338(){

        tablePasien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablePasien.getSelectedRow();
                selectedField.setText(AllObjCtr.dokterController.daftarPasien().getValueAt(i, 0).toString());
                dokterPenanganan = AllObjCtr.dokterController.getNamaDokter(Integer.parseInt(selectedField.getText()));
                keluhan = AllObjCtr.pasienController.getKeluhanPasien(Integer.parseInt(selectedField.getText()));
                diagnosa = AllObjCtr.pasienController.getDiagnosa(Integer.parseInt(selectedField.getText()));
                penanganan = AllObjCtr.pasienController.getPenanganan(Integer.parseInt(selectedField.getText()));
                status = AllObjCtr.pasienController.getStatusPasien(Integer.parseInt(selectedField.getText()));

                dokterField.setText(dokterPenanganan);
                diagnosaField.setText(diagnosa);
                keluhanField.setText(keluhan);
                penangananField.setText(penanganan);

                if (status == 1){
                    dokterField.setEditable(false);
                    diagnosaField.setEditable(true);
                    keluhanField.setEditable(true);
                    penangananField.setEditable(true);
                }
                else {
                    dokterField.setEditable(false);
                    diagnosaField.setEditable(false);
                    keluhanField.setEditable(false);
                    penangananField.setEditable(false);
                }
            }
        });

    }

    private void verifEvent(int id){
        verifBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedField.getText().length() > 0){
                        String dokterPenangan = AllObjCtr.dokterController.getNamaDokter(id);
                        int statusUpdate = AllObjCtr.pasienController.updateDokterPenangan(Integer.parseInt(selectedField.getText()), dokterPenangan);
                        int statusUpdate2 = AllObjCtr.dokterController.verifDataPasien(Integer.parseInt(selectedField.getText()));
                        if (statusUpdate == 1 && statusUpdate2 == 1){
                            JOptionPane.showMessageDialog(null,"Berhasil Di Verif");
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Gagal Di Verif");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "PILIH DATA TERLEBIH DAHULU");
                    }

                    dataTable07338();
                }catch (Exception pp){
                    pp.printStackTrace();
                }
            }
        });
    }

    private final JLabel title, dokterLbl, diagnosaLbl, keluhanLbl, penangananLbl;
    private final JButton updateBtn, deleteBtn, refreshBtn, verifBtn, logoutBtn;
    private final JTextField selectedField, dokterField, diagnosaField;
    private final JTextArea keluhanField,penangananField;
    private final JScrollPane scrollPasien;
    private final JTable tablePasien;

    {
        title = new JLabel("DAFTAR PASIEN");
        dokterLbl = new JLabel("NAMA DOKTER");
        diagnosaLbl = new JLabel("DIAGNOSA");
        keluhanLbl = new JLabel("KELUHAN");
        penangananLbl = new JLabel("PENANGANAN");
        updateBtn = new JButton("UPDATE");
        deleteBtn = new JButton("DELETE");
        refreshBtn = new JButton("REFRESH");
        verifBtn = new JButton("VERIFIKASI");
        logoutBtn = new JButton("LOG OUT");
        selectedField = new JTextField();
        penangananField = new JTextArea();
        keluhanField = new JTextArea();
        diagnosaField = new JTextField();
        dokterField = new JTextField();
        tablePasien = new JTable();
        scrollPasien = new JScrollPane(tablePasien);
    }
}
