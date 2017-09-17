package bankindonesia.coba.other.Activity.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.SearchPenyelenggaraanActivity;

public class CallerSearchPenyelenggaraan extends Thread
{
    public CallSoapSearchPenyelenggaraan cs;
    public String varchar,tanggal;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapSearchPenyelenggaraan();
            String resp=cs.Call(varchar,tanggal);
            SearchPenyelenggaraanActivity.rslt=resp;
        }catch(Exception ex) {
            SearchPenyelenggaraanActivity.rslt=ex.toString();
        }
    }
}
