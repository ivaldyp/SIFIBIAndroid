package bankindonesia.coba.other.Activity.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UpdateKehadiranActivity;
import bankindonesia.coba.activity.UpdatePenyelenggaraanActivity;

public class CallerUpdatePenyelenggaraan extends Thread
{
    public CallSoapUpdatePenyelenggaraan cs;
    public int a;
    public String Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUpdatePenyelenggaraan();
            String resp=cs.Call(a,Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik);
            UpdatePenyelenggaraanActivity.rslt=resp;
        }catch(Exception ex) {
            UpdatePenyelenggaraanActivity.rslt=ex.toString();
        }
    }
}
