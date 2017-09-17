package bankindonesia.coba.other.fragment.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.kehadiran.ViewKehadiranFragment;

public class CallerView2Kehadiran extends Thread
{
    public CallSoapView2Kehadiran cs;
    public String a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapView2Kehadiran();
            String resp=cs.Call(a);
            ViewKehadiranFragment.rslt=resp;
        }catch(Exception ex)
        {ViewKehadiranFragment.rslt=ex.toString();}
    }
}
