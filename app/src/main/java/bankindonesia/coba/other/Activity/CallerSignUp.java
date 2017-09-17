package bankindonesia.coba.other.Activity;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SignupActivity;

public class CallerSignUp extends Thread
{
    public CallSoapSignup cs;
    public String a,b,c,d;
    public int e;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapSignup();
            String resp=cs.Call(a, b, c, d, e);
            SignupActivity.rslt=resp;
        }catch(Exception ex)
        {SignupActivity.rslt=ex.toString();}
    }
}
