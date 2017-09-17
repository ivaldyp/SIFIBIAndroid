package bankindonesia.coba.other.Activity.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchLaporanActivity;

public class CallerSearchLaporan extends Thread
{
    public CallSoapSearchLaporan cs;
    public String varchar,tanggal;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapSearchLaporan();
            String resp=cs.Call(varchar,tanggal);
            SearchLaporanActivity.rslt=resp;
        }catch(Exception ex) {
            SearchLaporanActivity.rslt=ex.toString();
        }
    }
}
