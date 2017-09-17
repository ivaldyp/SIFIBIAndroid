package bankindonesia.coba.other.fragment.home;

import android.app.AlertDialog;

import bankindonesia.coba.activity.ProfilePICActivity;
import bankindonesia.coba.fragment.home.HomePICFragment;

public class CallerHomePIC extends Thread
{
    public CallSoapHomePIC cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapHomePIC();
            String resp=cs.Call(a);
            HomePICFragment.rslt=resp;
            ProfilePICActivity.rslt=resp;
        }catch(Exception ex) {
            HomePICFragment.rslt=ex.toString();
            ProfilePICActivity.rslt=ex.toString();
        }
    }
}

