package bankindonesia.coba.other.fragment.laporan.Admin;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.laporan.TabelLaporanFragment;

public class CallerTabelUserAdmin extends Thread
{
    public CallSoapTabelUserAdmin cs;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapTabelUserAdmin();
            String resp=cs.Call();
            TabelLaporanFragment.rslt=resp;
        }catch(Exception ex)
        {TabelLaporanFragment.rslt=ex.toString();}
    }
}
