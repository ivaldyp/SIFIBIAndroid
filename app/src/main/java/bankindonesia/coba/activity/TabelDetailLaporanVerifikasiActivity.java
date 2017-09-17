package bankindonesia.coba.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Activity.laporan.CallerDeleteLaporan;
import bankindonesia.coba.other.Activity.laporan.CallerVerifikasiLaporan;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.laporan.CallerTabelDetailUser;

public class TabelDetailLaporanVerifikasiActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private String[] mobileArray;
    private String[] asd = {"a","b","c"};
    private Button buttonUpdate;
    private Button buttonVerifikasi;
    private Button buttonDelete;
    private android.app.AlertDialog ad;
    public static String rslt="";
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_detail_laporan_verifikasi);

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

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);
        buttonVerifikasi = (Button) findViewById(R.id.buttonVerifikasi);
        buttonVerifikasi.setOnClickListener(this);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(this);


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
                        else if(i==22){
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10002) && (resultCode == Activity.RESULT_OK))
            if (android.os.Build.VERSION.SDK_INT >= 11){
                //Code for recreate
                recreate();

            }else{
//                Code for Intent
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void data() {
        try
        {
            rslt="START";
            CallerTabelDetailUser c=new CallerTabelDetailUser();
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

    private void verifikasi() {
        try
        {
            rslt="START";
            CallerVerifikasiLaporan c=new CallerVerifikasiLaporan();
            c.a=((Config) this.getApplication()).getID_LAPORAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            if(rslt.equals("1")){
                Toast.makeText(getApplicationContext(),"Data berhasil diverifikasi", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Data tidak berhasil diverifikasi", Toast.LENGTH_LONG).show();
            }
//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void delete() {
        try
        {
            rslt="START";
            CallerDeleteLaporan c=new CallerDeleteLaporan();
            c.a=((Config) this.getApplication()).getID_LAPORAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            if(rslt.equals("1")){
                Toast.makeText(getApplicationContext(),"Data berhasil dihapus", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Data tidak berhasil dihapus", Toast.LENGTH_LONG).show();
            }
//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate) {
            Intent intent = new Intent(this, UpdateLaporanActivity.class);
//            startActivity(intent);
            startActivityForResult(intent, 10002);
        }
        else if(v == buttonVerifikasi){
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Apakah anda yakin untuk memverifikasi data?")
                    .setCancelable(true)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            verifikasi();
                            setResult(Activity.RESULT_OK);
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(v == buttonDelete) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Apakah anda yakin untuk menghapus data?")
                    .setCancelable(true)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            delete();
                            setResult(Activity.RESULT_OK);
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
