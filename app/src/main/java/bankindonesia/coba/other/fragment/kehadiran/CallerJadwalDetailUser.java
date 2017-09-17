package bankindonesia.coba.other.fragment.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.activity.JadwalDetailKehadiran2Activity;
import bankindonesia.coba.activity.JadwalDetailKehadiranActivity;
import bankindonesia.coba.activity.SearchKehadiranActivity;
import bankindonesia.coba.activity.UpdateKehadiranActivity;
import bankindonesia.coba.fragment.kehadiran.JadwalKehadiranFragment;

public class CallerJadwalDetailUser extends Thread
{
    public CallSoapJadwalDetailUser cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapJadwalDetailUser();
            String resp=cs.Call(a);
            UpdateKehadiranActivity.rslt=resp;
            JadwalDetailKehadiranActivity.rslt=resp;
            JadwalDetailKehadiran2Activity.rslt=resp;
            JadwalKehadiranFragment.rslt2=resp;
            SearchKehadiranActivity.rslt2=resp;
        }catch(Exception ex) {
            UpdateKehadiranActivity.rslt=ex.toString();
            JadwalDetailKehadiranActivity.rslt=ex.toString();
            JadwalDetailKehadiran2Activity.rslt=toString();
            JadwalKehadiranFragment.rslt2=ex.toString();
            SearchKehadiranActivity.rslt2=ex.toString();
        }
    }
}
