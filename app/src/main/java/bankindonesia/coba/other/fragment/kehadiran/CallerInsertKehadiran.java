package bankindonesia.coba.other.fragment.kehadiran;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.kehadiran.InsertKehadiranFragment;
import bankindonesia.coba.other.Activity.kehadiran.CallSoapInsertKehadiran;

public class CallerInsertKehadiran extends Thread{

    public CallSoapInsertKehadiran cs;
    public int a;
    public String Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapInsertKehadiran();
            String resp=cs.Call(a,Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik);
            InsertKehadiranFragment.rslt=resp;
        }catch(Exception ex) {InsertKehadiranFragment.rslt=ex.toString();}
    }
}

