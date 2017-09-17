package bankindonesia.coba.other.fragment.home;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.home.HomeAdminFragment;

public class CallerHomeAdmin extends Thread
{
    public CallSoapHomeAdmin cs;
    public AlertDialog ad;
    public int a;

    public void run(){
        try{
            cs=new CallSoapHomeAdmin();
            String resp=cs.Call(a);
            HomeAdminFragment.rslt=resp;
        }catch(Exception ex)
        {HomeAdminFragment.rslt=ex.toString();}
    }
}

