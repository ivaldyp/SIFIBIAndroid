package bankindonesia.coba.other.fragment.kehadiran.Admin;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.kehadiran.JadwalKehadiranFragment;

public class CallerJadwalUserAdmin extends Thread
{
    public CallSoapJadwalUserAdmin cs;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalUserAdmin();
            String resp=cs.Call();
            JadwalKehadiranFragment.rslt=resp;
        }catch(Exception ex)
        {JadwalKehadiranFragment.rslt=ex.toString();}
    }
}
