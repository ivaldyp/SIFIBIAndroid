package bankindonesia.coba.other.Activity.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.JadwalDetailKehadiranActivity;
import bankindonesia.coba.activity.TabelDetailLaporanActivity;
import bankindonesia.coba.activity.TabelDetailLaporanVerifikasiActivity;

public class CallerVerifikasiLaporan extends Thread
{
    public CallSoapVerifikasiLaporan cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapVerifikasiLaporan();
            String resp=cs.Call(a);
            TabelDetailLaporanVerifikasiActivity.rslt=resp;
        }catch(Exception ex) {
            TabelDetailLaporanVerifikasiActivity.rslt=ex.toString();}
    }
}
