package bankindonesia.coba.other.Activity.user;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UserDetailActivity;

public class CallerVerifikasiUser extends Thread
{
    public CallSoapVerifikasiUser cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapVerifikasiUser();
            String resp=cs.Call(a);
            UserDetailActivity.rslt=resp;
        }catch(Exception ex) {UserDetailActivity.rslt=ex.toString();}
    }
}
