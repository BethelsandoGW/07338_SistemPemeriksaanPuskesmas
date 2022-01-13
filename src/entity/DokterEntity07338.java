package entity;

import java.util.Date;

public class DokterEntity07338 extends DataAbstract07338{
    private String nip;

    public DokterEntity07338(String nip) {
        this.nip = nip;
    }

    public DokterEntity07338(String nama, String notelp, String password, String umur, int id, String nip) {
        super(nama, notelp, password, umur, id);
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
