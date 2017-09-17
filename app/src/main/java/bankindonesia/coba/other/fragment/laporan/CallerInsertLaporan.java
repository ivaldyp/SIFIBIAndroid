package bankindonesia.coba.other.fragment.laporan;

import android.app.AlertDialog;

import bankindonesia.coba.fragment.laporan.InsertLaporanFragment;

public class CallerInsertLaporan extends Thread{

    public CallSoapInsertLaporan cs;
    public int a;
    public String spinnerSatker,editTextPlace, textdate, namafora, namaworkinggroup,relevansi, delegasiBI, delegasiterkait, negaramitra;
    public String agenda,stanceBI, stancePosisi,stancemitra,kesepakatan,kesepakatan2,pending,rencana,foralain,editTextSatker,jadwal;
    public String lembagalain;
    public AlertDialog ad;

    public void run(){
        try{
            cs=new CallSoapInsertLaporan();
            String resp=cs.Call(a,spinnerSatker,editTextPlace, textdate, namafora, namaworkinggroup, relevansi, delegasiBI, delegasiterkait,
                    negaramitra, agenda, stanceBI, stancePosisi,stancemitra,kesepakatan,kesepakatan2,pending,rencana,foralain,
                    editTextSatker,jadwal,lembagalain);
            InsertLaporanFragment.rslt=resp;
        }catch(Exception ex) {InsertLaporanFragment.rslt=ex.toString();}
    }
}

