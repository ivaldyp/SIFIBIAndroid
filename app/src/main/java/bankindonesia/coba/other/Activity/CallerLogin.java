package bankindonesia.coba.other.Activity;

import android.app.AlertDialog;

import bankindonesia.coba.activity.LoginActivity;

public class CallerLogin extends Thread
{
    public CallSoapLogin cs;
    public String a,b;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapLogin();
            String resp=cs.Call(a, b);
            LoginActivity.rslt=resp;
        }catch(Exception ex)
        {
            LoginActivity.rslt=ex.toString();}
    }
}
