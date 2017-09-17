package bankindonesia.coba.other.Activity.user;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UserDetailActivity2;

public class CallerNotVerifikasiUser extends Thread
{
    public CallSoapNotVerifikasiUser cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapNotVerifikasiUser();
            String resp=cs.Call(a);
            UserDetailActivity2.rslt=resp;
        }catch(Exception ex) {UserDetailActivity2.rslt=ex.toString();}
    }
}
