package bankindonesia.coba.other.fragment.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.JadwalDetailPenyelenggaraan2Activity;
import bankindonesia.coba.activity.JadwalDetailPenyelenggaraanActivity;
import bankindonesia.coba.activity.SearchPenyelenggaraanActivity;
import bankindonesia.coba.activity.UpdatePenyelenggaraanActivity;
import bankindonesia.coba.fragment.penyelenggaraan.JadwalPenyelenggaraanFragment;

public class CallerJadwalDetailUser extends Thread
{
    public CallSoapJadwalDetailUser cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalDetailUser();
            String resp=cs.Call(a);
            UpdatePenyelenggaraanActivity.rslt=resp;
            JadwalPenyelenggaraanFragment.rslt2=resp;
            JadwalDetailPenyelenggaraanActivity.rslt=resp;
            JadwalDetailPenyelenggaraan2Activity.rslt=resp;
            SearchPenyelenggaraanActivity.rslt2=resp;
        }catch(Exception ex) {
            UpdatePenyelenggaraanActivity.rslt=ex.toString();
            JadwalDetailPenyelenggaraanActivity.rslt=ex.toString();
            JadwalDetailPenyelenggaraan2Activity.rslt=ex.toString();
            JadwalPenyelenggaraanFragment.rslt2=ex.toString();
            SearchPenyelenggaraanActivity.rslt2=ex.toString();
        }
    }
}
