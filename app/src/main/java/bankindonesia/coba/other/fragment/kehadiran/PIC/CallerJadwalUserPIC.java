package bankindonesia.coba.other.fragment.kehadiran.PIC;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.kehadiran.JadwalKehadiranFragment;

public class CallerJadwalUserPIC extends Thread
{
    public CallSoapJadwalUserPIC cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalUserPIC();
            String resp=cs.Call(a);
            JadwalKehadiranFragment.rslt=resp;
        }catch(Exception ex)
        {JadwalKehadiranFragment.rslt=ex.toString();}
    }
}
