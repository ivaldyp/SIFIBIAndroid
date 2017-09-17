package bankindonesia.coba.other.Activity.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.activity.JadwalDetailKehadiranActivity;

public class CallerDeleteKehadiran extends Thread
{
    public CallSoapDeleteKehadiran cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapDeleteKehadiran();
            String resp=cs.Call(a);
            JadwalDetailKehadiranActivity.rslt=resp;
        }catch(Exception ex) {JadwalDetailKehadiranActivity.rslt=ex.toString();}
    }
}
