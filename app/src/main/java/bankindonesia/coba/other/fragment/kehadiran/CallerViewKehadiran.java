package bankindonesia.coba.other.fragment.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.kehadiran.ViewKehadiranFragment;

public class CallerViewKehadiran extends Thread
{
    public CallSoapViewKehadiran cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapViewKehadiran();
            String resp=cs.Call(a);
            ViewKehadiranFragment.rslt=resp;
        }catch(Exception ex)
        {ViewKehadiranFragment.rslt=ex.toString();}
    }
}
