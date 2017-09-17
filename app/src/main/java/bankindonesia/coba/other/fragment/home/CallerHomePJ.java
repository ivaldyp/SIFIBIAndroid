package bankindonesia.coba.other.fragment.home;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.home.HomePJFragment;

public class CallerHomePJ extends Thread
{
    public CallSoapHomePJ cs;
    public AlertDialog ad;
    public int a;

    public void run(){
        try{
            cs=new CallSoapHomePJ();
            String resp=cs.Call(a);
            HomePJFragment.rslt=resp;
        }catch(Exception ex)
        {HomePJFragment.rslt=ex.toString();}
    }
}

