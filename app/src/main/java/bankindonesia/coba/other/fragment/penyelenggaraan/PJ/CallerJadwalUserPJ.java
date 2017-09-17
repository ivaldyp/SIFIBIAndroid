package bankindonesia.coba.other.fragment.penyelenggaraan.PJ;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.penyelenggaraan.JadwalPenyelenggaraanFragment;


public class CallerJadwalUserPJ extends Thread
{
    public CallSoapJadwalUserPJ cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalUserPJ();
            String resp=cs.Call(a);
            JadwalPenyelenggaraanFragment.rslt=resp;
        }catch(Exception ex)
        {
            JadwalPenyelenggaraanFragment.rslt=ex.toString();}
    }
}
