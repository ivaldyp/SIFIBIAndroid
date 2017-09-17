package bankindonesia.coba.other.fragment.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.laporan.ViewLaporanFragment;

public class CallerViewLaporan extends Thread
{
    public CallSoapViewLaporan cs;
//    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapViewLaporan();
            String resp=cs.Call();
            ViewLaporanFragment.rslt=resp;
        }catch(Exception ex)
        {ViewLaporanFragment.rslt=ex.toString();}
    }
}
