package bankindonesia.coba.other.fragment.laporan.PIC;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.laporan.TabelLaporanFragment;

public class CallerTabelUserPIC extends Thread
{
    public CallSoapTabelUserPIC cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapTabelUserPIC();
            String resp=cs.Call(a);
            TabelLaporanFragment.rslt=resp;
        }catch(Exception ex)
        {TabelLaporanFragment.rslt=ex.toString();}
    }
}
