package model;

import entity.DokterEntity07338;
import entity.PasienEntity07338;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DokterModel implements ModelInterface07338{
    public ArrayList<DokterEntity07338> dokterEntityArrayList;
    String sql;

    public DokterModel() {
    }


    public int addDokter(DokterEntity07338 dokter){
        try{
            sql = "INSERT INTO dokter(nama,noTelp,password,umur,nip)" +
                    "VALUES(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,dokter.getNama());
            stat.setString(2, dokter.getNotelp());
            stat.setString(3,dokter.getPassword());
            stat.setString(4,dokter.getUmur());
            stat.setString(5,dokter.getNip());
            JOptionPane.showMessageDialog(null,"Berhasil Ditambah");
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int verifDataPasien(int id){
        try{
            sql = "UPDATE pasien SET status = 1 WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int cekLogin(String nama, String password){
        int cek = 0;
        try {
            sql = "SELECT * FROM dokter WHERE nama = ? AND password = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                cek = rs.getInt("id");
            }else {
                cek = 0;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cek;
    }

    public int deletePasien(int id){
        try{
            sql = "DELETE FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<PasienEntity07338> getDataPasien(){
        ArrayList<PasienEntity07338>pasien = new ArrayList<>();
        try{
            sql = "SELECT * FROM pasien";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                PasienEntity07338 pasienEntity = new PasienEntity07338(
                        rs.getString("nama"),
                        rs.getString("notelp"),
                        rs.getString("password"),
                        rs.getString("umur"),
                        rs.getInt("id"),
                        rs.getString("keluhan"),
                        rs.getString("diagnosa"),
                        rs.getString("dokterpenanganan"),
                        rs.getString("penanganan"),
                        rs.getInt("status")
                    );

                pasien.add(pasienEntity);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pasien;
    }

    public String getNamaDokter(int id){
        String nama = null;
        try{
            sql = "SELECT * FROM dokter WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                nama = rs.getString("nama");
            }else {
                nama = null;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return nama;
    }
}
