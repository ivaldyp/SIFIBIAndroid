package bankindonesia.coba.other.fragment.penyelenggaraan.Admin;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.penyelenggaraan.JadwalPenyelenggaraanFragment;


public class CallerJadwalUserAdmin extends Thread
{
    public CallSoapJadwalUserAdmin cs;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalUserAdmin();
            String resp=cs.Call();
            JadwalPenyelenggaraanFragment.rslt=resp;
        }catch(Exception ex)
        {
            JadwalPenyelenggaraanFragment.rslt=ex.toString();}
    }
}
