package bankindonesia.coba.other.Activity.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.TabelDetailLaporanActivity;

public class CallerDeleteLaporan extends Thread
{
    public CallSoapDeleteLaporan cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapDeleteLaporan();
            String resp=cs.Call(a);
            TabelDetailLaporanActivity.rslt=resp;
        }catch(Exception ex) {TabelDetailLaporanActivity.rslt=ex.toString();}
    }
}
