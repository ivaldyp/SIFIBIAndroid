package bankindonesia.coba.other.Activity.user;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchUserActivity;

public class CallerSearchUser extends Thread
{
    public CallSoapSearchUser cs;
    public String varchar, jabatan;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapSearchUser();
            String resp=cs.Call(varchar,jabatan);
            SearchUserActivity.rslt=resp;
        }catch(Exception ex) {
            SearchUserActivity.rslt=ex.toString();
        }
    }
}
