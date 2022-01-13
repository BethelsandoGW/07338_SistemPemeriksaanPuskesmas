package model;

import entity.PasienEntity07338;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasienModel07338 implements ModelInterface07338{
    public ArrayList<PasienEntity07338> pasienEntityArrayList;
    String sql;

    public PasienModel07338() {

    }

    public int addPasien(PasienEntity07338 pasien) {
        try {
            sql = "INSERT INTO pasien(nama,notelp,password,umur,keluhan)" +
                    "VAlUES(?,?,?,?,?)";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, pasien.getNama());
            stat.setString(2, pasien.getNotelp());
            stat.setString(3, pasien.getPassword());
            stat.setString(4, pasien.getUmur());
            stat.setString(5, pasien.getKeluhan());
            int cek = cekData(pasien.getNama());

            if(cek == 0){
                return stat.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int cekData(String nama) {
        int cek = 0;
        try {
            sql = "SELECT nama FROM pasien WHERE nama = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                if (nama.equals(rs.getString("nama"))) {
                    cek = 1;
                } else {
                    cek = 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }


    public int cekLogin(String nama, String password) {
        int cek = 0;
        try {
            sql = "SELECT * FROM pasien WHERE nama = ? AND password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                if (nama.equals(rs.getString("nama"))
                        && password.equals(rs.getString("password"))) {
                    cek = rs.getInt("id");
                } else {
                    cek = 0;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }

    public int updatePassword(int id, String password){
        try{
            sql = "UPDATE pasien SET password  = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,password);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateDiagnosis(int id, String diagnosis){
        try{
            sql = "UPDATE pasien SET diagnosa = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,diagnosis);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updatePenanganan(int id, String penanganan){
        try{
            sql = "UPDATE pasien SET penanganan = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,penanganan);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateDokterPenangan(int id, String namaDokter){
        try{
            sql = "UPDATE pasien SET dokterpenanganan = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,namaDokter);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public String getDiagnosis(int id){
        String diagnosa = null;
        try{
            sql = "SELECT * FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                diagnosa = rs.getString("diagnosa");
            }else {
                diagnosa = null;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return diagnosa;
    }

    public String getNamaPasien(int id){
        String nama = null;
        try{
            sql = "SELECT * FROM pasien WHERE id = ?";
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

    public int cekPassword(int id, String input){
        try{
            sql = "SELECT password FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                if(input.equals(rs.getString("password"))){
                    return 1;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public String getKeluhan(int id){
        String keluhan = null;
        try{
            sql = "SELECT * FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                keluhan = rs.getString("keluhan");
            }else {
                keluhan = null;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return keluhan;
    }

    public int getStatus(int id){
        int cek = 0;
        try{
            sql = "SELECT * FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                cek = rs.getInt("status");
            }else {
                cek = 0;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cek;
    }

    public String getPenanganan(int id){
        String penanganan = null;
        try{
            sql = "SELECT * FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                penanganan = rs.getString("penanganan");
            }else {
                penanganan = null;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return penanganan;
    }

    public ArrayList<PasienEntity07338>getDataPasien(int id){
        ArrayList<PasienEntity07338>pasien = new ArrayList<>();
        try{
            sql = "SELECT * FROM pasien WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
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
                    rs.getInt("status"));
                pasien.add(pasienEntity);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pasien;
    }
}
