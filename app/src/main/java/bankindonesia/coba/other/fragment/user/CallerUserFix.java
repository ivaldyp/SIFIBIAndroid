package bankindonesia.coba.other.fragment.user;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.user.UserVerifFragment;

public class CallerUserFix extends Thread
{
    public CallSoapUserFix cs;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUserFix();
            String resp=cs.Call();
            UserVerifFragment.rslt=resp;
        }catch(Exception ex)
        {
            UserVerifFragment.rslt=ex.toString();}
    }
}
