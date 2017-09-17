package bankindonesia.coba.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import bankindonesia.coba.R;
import bankindonesia.coba.other.fragment.laporan.CallerViewDetailLaporan;
import bankindonesia.coba.other.Config;

public class ViewDetailLaporanActivity extends AppCompatActivity {

    private ListView listView;
    private String[] mobileArray;
    private String[] asd = {"a","b","c"};
    private android.app.AlertDialog ad;
    public static String rslt="";
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_laporan);

        data();

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview, asd);
//        listView = (ListView) findViewById(R.id.mobile_list);
//        listView.setAdapter(adapter);
        listView = (ListView) findViewById(R.id.mobile_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview);
        for(int i = 0; i < mobileArray.length; i++) {
            if(mobileArray[i]==null) {
                adapter.add("Data Kosong");
            } else {
                if(i==0) adapter.add("DETAIL LAPORAN HASIL SIDANG");
                else if(i==1) adapter.add("Nama Satker: "+mobileArray[i]);
                else if(i==2) adapter.add("Tempat Event: "+mobileArray[i]);
                else if(i==3) adapter.add("Tanggal Event: "+mobileArray[i]);
                else if(i==4) adapter.add("Nama Fora: "+mobileArray[i]);
                else if(i==5) adapter.add("Nama Working Group: "+mobileArray[i]);
                else if(i==6) adapter.add("Delegasi BI: "+mobileArray[i]);
                else if(i==7) adapter.add("Delegasi Terkait: "+mobileArray[i]);
                else if(i==8) adapter.add("Negara Mitra:\n"+mobileArray[i]);
                else if(i==9) adapter.add("Agenda Pembahasan:\n"+mobileArray[i]);
                else if(i==10) adapter.add("Relevansi:\n"+mobileArray[i]);
                else if(i==11) adapter.add("Stance BI:\n"+mobileArray[i]);
                else if(i==12) adapter.add("Stance Posisi Terkait:\n"+mobileArray[i]);
                else if(i==13) adapter.add("Stance Negara Mitra:\n"+mobileArray[i]);
                else if(i==14) adapter.add("Kesepakatan yang telah dihasilkan:\n"+mobileArray[i]);
                else if(i==15) adapter.add("Kesepakatan yang akan dihasilkan:\n"+mobileArray[i]);
                else if(i==16) adapter.add("Pending Issues:\n"+mobileArray[i]);
                else if(i==17) adapter.add("Rencana tidak lanjut:\n"+mobileArray[i]);
                else if(i==18) adapter.add("Fora lain:"+mobileArray[i]);
                else if(i==19) adapter.add("Satker lain: "+mobileArray[i]);
                else if(i==20) adapter.add("Tanggal Event Selanjutnya: "+mobileArray[i]);
                else if(i==21) adapter.add("Lemabaga lain: "+mobileArray[i]);
                else if(i==22) {
                    if(mobileArray[i].compareTo("0")==0) mobileArray[i]="Belum";
                    else if (mobileArray[i].compareTo("1")==0) mobileArray[i]="Sudah";
                    else mobileArray[i]="Error";
                    adapter.add("Verifikasi: "+mobileArray[i]);
                }
                else if(i==23) adapter.add("User: "+mobileArray[i]);
                else if(i==24) adapter.add("Create at Time:\n"+mobileArray[i]);
            }
        }
        listView.setAdapter(adapter);

//        ad =new AlertDialog.Builder(this).create();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                data();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fragment_listview);
                for(int i = 0; i < mobileArray.length; i++) {
                    if(mobileArray[i]==null) {
                        adapter.add("Data Kosong");
                    } else {
                        if(i==0) adapter.add("DETAIL LAPORAN HASIL SIDANG");
                        else if(i==1) adapter.add("Nama Satker: "+mobileArray[i]);
                        else if(i==2) adapter.add("Tempat Event: "+mobileArray[i]);
                        else if(i==3) adapter.add("Tanggal Event: "+mobileArray[i]);
                        else if(i==4) adapter.add("Nama Fora: "+mobileArray[i]);
                        else if(i==5) adapter.add("Nama Working Group: "+mobileArray[i]);
                        else if(i==6) adapter.add("Delegasi BI: "+mobileArray[i]);
                        else if(i==7) adapter.add("Delegasi Terkait: "+mobileArray[i]);
                        else if(i==8) adapter.add("Negara Mitra:\n"+mobileArray[i]);
                        else if(i==9) adapter.add("Agenda Pembahasan:\n"+mobileArray[i]);
                        else if(i==10) adapter.add("Relevansi:\n"+mobileArray[i]);
                        else if(i==11) adapter.add("Stance BI:\n"+mobileArray[i]);
                        else if(i==12) adapter.add("Stance Posisi Terkait:\n"+mobileArray[i]);
                        else if(i==13) adapter.add("Stance Negara Mitra:\n"+mobileArray[i]);
                        else if(i==14) adapter.add("Kesepakatan yang telah dihasilkan:\n"+mobileArray[i]);
                        else if(i==15) adapter.add("Kesepakatan yang akan dihasilkan:\n"+mobileArray[i]);
                        else if(i==16) adapter.add("Pending Issues:\n"+mobileArray[i]);
                        else if(i==17) adapter.add("Rencana tidak lanjut:\n"+mobileArray[i]);
                        else if(i==18) adapter.add("Fora lain:"+mobileArray[i]);
                        else if(i==19) adapter.add("Satker lain: "+mobileArray[i]);
                        else if(i==20) adapter.add("Tanggal Event Selanjutnya: "+mobileArray[i]);
                        else if(i==21) adapter.add("Lemabaga lain: "+mobileArray[i]);
                        else if(i==22) {
                            if(mobileArray[i].compareTo("0")==0) mobileArray[i]="Belum";
                            else if (mobileArray[i].compareTo("1")==0) mobileArray[i]="Sudah";
                            else mobileArray[i]="Error";
                            adapter.add("Verifikasi: "+mobileArray[i]);
                        }
                        else if(i==23) adapter.add("User: "+mobileArray[i]);
                        else if(i==24) adapter.add("Create at Time:\n"+mobileArray[i]);
                    }
                }
                listView.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void data() {
        try
        {
            rslt="START";
            CallerViewDetailLaporan c=new CallerViewDetailLaporan();
            c.a=((Config) this.getApplication()).getID_LAPORAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            mobileArray = rslt.split("\\|");

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }
}
