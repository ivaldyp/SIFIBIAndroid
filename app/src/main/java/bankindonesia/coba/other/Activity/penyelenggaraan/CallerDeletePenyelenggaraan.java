package bankindonesia.coba.other.Activity.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.JadwalDetailPenyelenggaraanActivity;

public class CallerDeletePenyelenggaraan extends Thread
{
    public CallSoapDeletePenyelenggaraan cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapDeletePenyelenggaraan();
            String resp=cs.Call(a);
            JadwalDetailPenyelenggaraanActivity.rslt=resp;
        }catch(Exception ex) {JadwalDetailPenyelenggaraanActivity.rslt=ex.toString();}
    }
}
