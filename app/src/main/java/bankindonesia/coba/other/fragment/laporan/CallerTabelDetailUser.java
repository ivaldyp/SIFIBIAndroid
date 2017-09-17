package bankindonesia.coba.other.fragment.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchLaporanActivity;
import bankindonesia.coba.activity.TabelDetailLaporanActivity;
import bankindonesia.coba.activity.TabelDetailLaporanVerifikasiActivity;
import bankindonesia.coba.activity.UpdateLaporanActivity;
import bankindonesia.coba.fragment.laporan.TabelLaporanFragment;

public class CallerTabelDetailUser extends Thread
{
    public CallSoapTabelDetailUser cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapTabelDetailUser();
            String resp=cs.Call(a);
            UpdateLaporanActivity.rslt=resp;
            TabelDetailLaporanActivity.rslt=resp;
            TabelLaporanFragment.rslt2=resp;
            TabelDetailLaporanVerifikasiActivity.rslt=resp;
            SearchLaporanActivity.rslt2=resp;
        }catch(Exception ex) {
            UpdateLaporanActivity.rslt=ex.toString();
            TabelDetailLaporanActivity.rslt=ex.toString();
            TabelLaporanFragment.rslt2=ex.toString();
            TabelDetailLaporanVerifikasiActivity.rslt=ex.toString();
            SearchLaporanActivity.rslt2=ex.toString();
        }
    }
}
