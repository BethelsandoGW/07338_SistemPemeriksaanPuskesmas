package entity;

public class PasienEntity07338 extends DataAbstract07338{
    private String keluhan;
    private String diagnosa;
    private String dokterPenanganan;
    private String penanganan;
    private int status;


    public PasienEntity07338(String nama, String notelp, String password, String umur, String keluhan) {
        super(nama, notelp, password, umur);
        this.keluhan = keluhan;
    }

    public PasienEntity07338(String keluhan, String diagnosa, String dokterPenanganan, String penanganan, int status) {
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.dokterPenanganan = dokterPenanganan;
        this.penanganan = penanganan;
        this.status = status;
    }

    public PasienEntity07338(String nama, String notelp, String password, String umur, int id, String keluhan, String diagnosa, String dokterPenanganan, String penanganan, int status) {
        super(nama, notelp, password, umur, id);
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.dokterPenanganan = dokterPenanganan;
        this.penanganan = penanganan;
        this.status = status;
    }


    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getDokterPenanganan() {
        return dokterPenanganan;
    }

    public void setDokterPenanganan(String dokterPenanganan) {
        this.dokterPenanganan = dokterPenanganan;
    }

    public String getPenanganan() {
        return penanganan;
    }

    public void setPenanganan(String penanganan) {
        this.penanganan = penanganan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
