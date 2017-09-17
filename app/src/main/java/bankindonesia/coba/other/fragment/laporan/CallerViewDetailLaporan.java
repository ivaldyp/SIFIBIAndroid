package bankindonesia.coba.other.fragment.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchLaporanActivity;
import bankindonesia.coba.activity.ViewDetailLaporanActivity;
import bankindonesia.coba.fragment.laporan.ViewLaporanFragment;


public class CallerViewDetailLaporan extends Thread
{
    public CallSoapViewDetailLaporan cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapViewDetailLaporan();
            String resp=cs.Call(a);
            ViewDetailLaporanActivity.rslt=resp;
            ViewLaporanFragment.rslt2=resp;
        }catch(Exception ex) {
            ViewDetailLaporanActivity.rslt=ex.toString();
            ViewLaporanFragment.rslt2=ex.toString();
        }
    }
}
