package controller;

import entity.PasienEntity07338;

import java.util.ArrayList;

public class PasienController {
    public PasienController(){

    }
    public int addPasien(String nama, String noTelp, String password, String umur, String keluhan){
        return AllObjMod.pasMod.addPasien(new PasienEntity07338(nama,noTelp,password,umur,keluhan));
    }
    public int cekLogin(String nama , String password){
        return AllObjMod.pasMod.cekLogin(nama, password);
    }
    public int updatePassword(int id, String password){
        return AllObjMod.pasMod.updatePassword(id, password);
    }
    public int updateDiagnosaa(int id, String diagnosis){
        return AllObjMod.pasMod.updateDiagnosis(id,diagnosis);
    }
    public int updatePenanganan(int id, String penanganan){
        return AllObjMod.pasMod.updatePenanganan(id, penanganan);
    }
    public int updateDokterPenangan(int id, String namaDokter){
        return AllObjMod.pasMod.updateDokterPenangan(id, namaDokter);
    }
    public String getNamaPasien(int id){
        return AllObjMod.pasMod.getNamaPasien(id);
    }
    public int getStatusPasien(int id){
        return AllObjMod.pasMod.getStatus(id);
    }
    public String getKeluhanPasien(int id){
        return AllObjMod.pasMod.getKeluhan(id);
    }
    public String getDiagnosa(int id){
        return AllObjMod.pasMod.getDiagnosis(id);
    }
    public int cekPassword(int id, String input){
        return AllObjMod.pasMod.cekPassword(id,input);
    }
    public String getPenanganan(int id){
        return AllObjMod.pasMod.getPenanganan(id);
    }
    public ArrayList<PasienEntity07338> getDataPasien(int id){
        return AllObjMod.pasMod.getDataPasien(id);
    }

}
