package bankindonesia.coba.other.Activity.user;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchUserActivity;
import bankindonesia.coba.activity.UpdateUserActivity;
import bankindonesia.coba.activity.UserDetailActivity;
import bankindonesia.coba.activity.UserDetailActivity2;
import bankindonesia.coba.fragment.user.UserVerifFragment;

public class CallerUserDetail extends Thread
{
    public CallSoapUserDetail cs;
    public int a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUserDetail();
            String resp=cs.Call(a);
            UserDetailActivity.rslt=resp;
            UserDetailActivity2.rslt=resp;
            UserVerifFragment.rslt=resp;
            UpdateUserActivity.rslt=resp;
            SearchUserActivity.rslt2=resp;
        }catch(Exception ex) {
            UserDetailActivity.rslt=ex.toString();
            UserDetailActivity2.rslt=ex.toString();
            UserVerifFragment.rslt=ex.toString();
            SearchUserActivity.rslt2=ex.toString();
        }
    }
}
