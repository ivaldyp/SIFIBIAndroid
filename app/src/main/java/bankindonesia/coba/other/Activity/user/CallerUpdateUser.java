package bankindonesia.coba.other.Activity.user;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UpdateUserActivity;

public class CallerUpdateUser extends Thread
{
    public CallSoapUpdateUser cs;
    public int a;
    public String nama,satker,email,password,jabatan;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUpdateUser();
            String resp=cs.Call(a,nama,satker,email,password,jabatan);
            UpdateUserActivity.rslt=resp;
        }catch(Exception ex) {
            UpdateUserActivity.rslt=ex.toString();
        }
    }
}
