package bankindonesia.coba.other.fragment.penyelenggaraan;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.penyelenggaraan.InsertPenyelenggaraanFragment;

public class CallerInsertPenyelenggaraan extends Thread{

    public CallSoapInsertPenyelenggaraan cs;
    public int a;
    public String Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapInsertPenyelenggaraan();
            String resp=cs.Call(a,Periode,Satker,Event,Tempat,Waktu,delegasiADG,delegasiSatker,topik);
            InsertPenyelenggaraanFragment.rslt=resp;
        }catch(Exception ex) {
            InsertPenyelenggaraanFragment.rslt=ex.toString();}
    }
}

