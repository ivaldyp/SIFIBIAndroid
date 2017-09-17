package bankindonesia.coba.other.fragment.kehadiran.PJ;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.kehadiran.JadwalKehadiranFragment;

public class CallerJadwalUserPJ extends Thread
{
    public CallSoapJadwalUserPJ cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalUserPJ();
            String resp=cs.Call(a);
            JadwalKehadiranFragment.rslt=resp;
        }catch(Exception ex)
        {JadwalKehadiranFragment.rslt=ex.toString();}
    }
}
