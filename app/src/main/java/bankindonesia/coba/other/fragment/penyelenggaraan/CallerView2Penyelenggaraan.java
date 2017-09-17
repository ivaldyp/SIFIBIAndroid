package bankindonesia.coba.other.fragment.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.penyelenggaraan.ViewPenyelenggaraanFragment;

public class CallerView2Penyelenggaraan extends Thread
{
    public CallSoapView2Penyelenggaraan cs;
    public String a;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapView2Penyelenggaraan();
            String resp=cs.Call(a);
            ViewPenyelenggaraanFragment.rslt=resp;
        }catch(Exception ex)
        {ViewPenyelenggaraanFragment.rslt=ex.toString();}
    }
}
