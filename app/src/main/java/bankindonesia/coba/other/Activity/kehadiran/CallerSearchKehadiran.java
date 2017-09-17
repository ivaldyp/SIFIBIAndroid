package bankindonesia.coba.other.Activity.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchKehadiranActivity;

public class CallerSearchKehadiran extends Thread
{
    public CallSoapSearchKehadiran cs;
    public String varchar,tanggal;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapSearchKehadiran();
            String resp=cs.Call(varchar,tanggal);
            SearchKehadiranActivity.rslt=resp;
        }catch(Exception ex) {
            SearchKehadiranActivity.rslt=ex.toString();
        }
    }
}
