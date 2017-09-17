package bankindonesia.coba.other.fragment.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.penyelenggaraan.ViewPenyelenggaraanFragment;
import bankindonesia.coba.other.fragment.kehadiran.CallSoapViewKehadiran;

public class CallerViewPenyelenggaraan extends Thread
{
    public CallSoapViewPenyelenggaraan cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapViewPenyelenggaraan();
            String resp=cs.Call(a);
            ViewPenyelenggaraanFragment.rslt=resp;
        }catch(Exception ex)
        {ViewPenyelenggaraanFragment.rslt=ex.toString();}
    }
}
