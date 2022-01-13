package model;

import Helper.KoneksiDb;

import java.sql.Connection;

public interface ModelInterface07338 {
    public int cekLogin(String nama, String password);
    public static Connection conn = KoneksiDb.getConnection();
}
