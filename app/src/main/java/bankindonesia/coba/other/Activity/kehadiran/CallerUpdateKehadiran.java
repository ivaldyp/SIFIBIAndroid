package bankindonesia.coba.other.Activity.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UpdateKehadiranActivity;

public class CallerUpdateKehadiran extends Thread
{
    public CallSoapUpdateKehadiran cs;
    public int a;
    public String Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUpdateKehadiran();
            String resp=cs.Call(a,Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik);
            UpdateKehadiranActivity.rslt=resp;
        }catch(Exception ex) {UpdateKehadiranActivity.rslt=ex.toString();}
    }
}
