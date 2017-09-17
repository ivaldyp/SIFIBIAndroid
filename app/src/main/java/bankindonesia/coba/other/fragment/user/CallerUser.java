package bankindonesia.coba.other.fragment.user;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.user.UserNotVerifFragment;

public class CallerUser extends Thread
{
    public CallSoapUser cs;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUser();
            String resp=cs.Call();
            UserNotVerifFragment.rslt=resp;
        }catch(Exception ex)
        {
            UserNotVerifFragment.rslt=ex.toString();}
    }
}
