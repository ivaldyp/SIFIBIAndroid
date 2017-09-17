package bankindonesia.coba.other.Activity.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.activity.UpdateLaporanActivity;

public class CallerUpdateLaporan extends Thread{

    public CallSoapUpdateLaporan cs;
    public int a;
    public String spinnerSatker,editTextPlace, textdate, namafora, namaworkinggroup,relevansi, delegasiBI, delegasiterkait, negaramitra;
    public String agenda,stanceBI, stancePosisi,stancemitra,kesepakatan,kesepakatan2,pending,rencana,foralain,editTextSatker,jadwal;
    public String lembagalain;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapUpdateLaporan();
            String resp=cs.Call(a,spinnerSatker,editTextPlace, textdate, namafora, namaworkinggroup, relevansi, delegasiBI, delegasiterkait,
                    negaramitra, agenda, stanceBI, stancePosisi,stancemitra,kesepakatan,kesepakatan2,pending,rencana,foralain,
                    editTextSatker,jadwal,lembagalain);
            UpdateLaporanActivity.rslt=resp;
        }catch(Exception ex) {UpdateLaporanActivity.rslt=ex.toString();}
    }
}

