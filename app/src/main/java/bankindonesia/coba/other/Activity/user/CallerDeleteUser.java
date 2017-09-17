package bankindonesia.coba.other.Activity.user;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UserDetailActivity;
import bankindonesia.coba.activity.UserDetailActivity2;

public class CallerDeleteUser extends Thread
{
    public CallSoapDeleteUser cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapDeleteUser();
            String resp=cs.Call(a);
            UserDetailActivity.rslt=resp;
            UserDetailActivity2.rslt=resp;
        }catch(Exception ex) {
            UserDetailActivity.rslt=ex.toString();
            UserDetailActivity2.rslt=ex.toString();
        }
    }
}
