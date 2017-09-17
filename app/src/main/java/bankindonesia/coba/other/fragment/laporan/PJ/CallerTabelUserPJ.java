package bankindonesia.coba.other.fragment.laporan.PJ;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.laporan.TabelLaporanFragment;

public class CallerTabelUserPJ extends Thread
{
    public CallSoapTabelUserPJ cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapTabelUserPJ();
            String resp=cs.Call(a);
            TabelLaporanFragment.rslt=resp;
        }catch(Exception ex)
        {TabelLaporanFragment.rslt=ex.toString();}
    }
}
