package controller;

import entity.PasienEntity07338;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class DokterController {

    public DokterController() {

    }
    public int cekLogin(String nama , String password){
        return AllObjMod.dokMod.cekLogin(nama, password);
    }

    public int verifDataPasien(int id){
        return AllObjMod.dokMod.verifDataPasien(id);
    }

    public int deletePasien(int id){
        return AllObjMod.dokMod.deletePasien(id);
    }

    public ArrayList<PasienEntity07338> getAllDataPasien(){
        return AllObjMod.dokMod.getDataPasien();
    }
    public String getNamaDokter(int id){
        return AllObjMod.dokMod.getNamaDokter(id);
    }

    public DefaultTableModel daftarPasien(){
        DefaultTableModel daftarPasien = new DefaultTableModel();
        Object [] kolom = {"ID", "NAMA", "NOTELP","PASSWORD","UMUR","KELUHAN","DOKTER","STATUS","DIAGNOSA","PENANGANAN"};
        daftarPasien.setColumnIdentifiers(kolom);
        List<PasienEntity07338> list = AllObjMod.pasMod.pasienEntityArrayList;

        for (PasienEntity07338 data : getAllDataPasien()) {
            Object[] row = new Object[kolom.length];
            row[0] = data.getId();
            row[1] = data.getNama();
            row[2] = data.getNotelp();
            row[3] = data.getPassword();
            row[4] = data.getUmur();
            row[5] = data.getKeluhan();
            row[6] = data.getDokterPenanganan();
            row[7] = data.getStatus();
            row[8] = data.getDiagnosa();
            row[9] = data.getPenanganan();
            daftarPasien.addRow(row);
        }
        return daftarPasien;
    }

}
