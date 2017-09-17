package bankindonesia.coba.other;

import android.app.Application;

public class Config extends Application{
    //URL to our login.php file
    public static final String LOGIN_URL = "http://192.168.43.135/sifibi/login.php";
    public static final String LOGIN_ASP = "http://10.161.168.18/webservice/WebService.asmx";
    public static final String INSERT_USER_URL = "http://192.168.43.135/sifibi/signup.php";
    public static final String LOGIN_BI = "http://10.161.168.18/webservice/WebService.asmx";

    public static final String KEY_NAME = "name";
    public static final String KEY_SATKER = "satker";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_JABATAN = "jabatan";

    private int ID_USER;
    public int getID_USER() {return ID_USER;}
    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    private String NAMA_SATKER;
    public String getNAMA_SATKER() {return NAMA_SATKER;}
    public void setNAMA_SATKER(String NAMA_SATKER) { this.NAMA_SATKER = NAMA_SATKER; }

    private int ID_USERPILIHAN;
    public int getID_USERPILIHAN() {
        return ID_USERPILIHAN;
    }
    public void setID_USERPILIHAN(int ID_USERPILIHAN) {
        this.ID_USERPILIHAN = ID_USERPILIHAN;
    }

    private int ID_JABATAN;
    public int getID_JABATAN() {
        return ID_JABATAN;
    }
    public void setID_JABATAN(int ID_JABATAN) {
        this.ID_JABATAN = ID_JABATAN;
    }

    private int ID_KEHADIRAN;
    public int getID_KEHADIRAN() {
        return ID_KEHADIRAN;
    }
    public void setID_KEHADIRAN(int ID_KEHADIRAN) {
        this.ID_KEHADIRAN = ID_KEHADIRAN;
    }

    private int ID_PENYELENGGARAAN;
    public int getID_PENYELENGGARAAN() {
        return ID_PENYELENGGARAAN;
    }
    public void setID_PENYELENGGARAAN(int ID_PENYELENGGARAAN) {this.ID_PENYELENGGARAAN = ID_PENYELENGGARAAN;}

    private int ID_LAPORAN;
    public int getID_LAPORAN() {
        return ID_LAPORAN;
    }
    public void setID_LAPORAN(int ID_LAPORAN) {this.ID_LAPORAN = ID_LAPORAN;}
}
