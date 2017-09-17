package bankindonesia.coba.other.fragment.penyelenggaraan.PIC;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.penyelenggaraan.JadwalPenyelenggaraanFragment;


public class CallerJadwalUserPIC extends Thread
{
    public CallSoapJadwalUserPIC cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalUserPIC();
            String resp=cs.Call(a);
            JadwalPenyelenggaraanFragment.rslt=resp;
        }catch(Exception ex)
        {
            JadwalPenyelenggaraanFragment.rslt=ex.toString();}
    }
}
