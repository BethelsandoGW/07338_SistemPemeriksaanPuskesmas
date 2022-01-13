package entity;


public abstract class DataAbstract07338 {
    protected String nama;
    protected String notelp;
    protected String password;
    protected String umur;
    protected int id;

    //constructor
    public DataAbstract07338() {}

    public DataAbstract07338(String nama, String notelp, String password, String umur, int id) {
        this.nama = nama;
        this.notelp = notelp;
        this.password = password;
        this.umur = umur;
        this.id = id;
    }

    public DataAbstract07338(String nama, String notelp, String password, String umur) {
        this.nama = nama;
        this.notelp = notelp;
        this.password = password;
        this.umur = umur;
    }

    //method getter
    public String getNama() {
        return nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public String getPassword() {
        return password;
    }

    public String getUmur() {
        return umur;
    }

    public int getId() {
        return id;
    }

    //method setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setId(int id) {
        this.id = id;
    }
}
