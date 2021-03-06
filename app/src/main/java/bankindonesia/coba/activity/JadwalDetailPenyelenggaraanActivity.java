//Code untuk menampilkan page detail penyelenggaraan tanpa verifikasi

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
import bankindonesia.coba.other.Activity.penyelenggaraan.CallerDeletePenyelenggaraan;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.penyelenggaraan.CallerJadwalDetailUser;

public class JadwalDetailPenyelenggaraanActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private String[] mobileArray;
    private Button buttonUpdate;
    private Button buttonDelete;
    private android.app.AlertDialog ad;
    public static String rslt="";
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_detail_penyelenggaraan);

        data();

//        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, mobileArray);
//        listView = (ListView) view.findViewById(R.id.mobile_list);
//        listView.setAdapter(adapter);
        listView = (ListView) findViewById(R.id.mobile_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview);
        for(int i = 0; i < mobileArray.length; i++) {
            if(mobileArray[i]==null) {
                adapter.add("Data Kosong");
            } else {
                if(i==0) adapter.add("DETAIL RENCANA PENYELENGGARAAN");
                else if(i==1) adapter.add("Periode: "+mobileArray[i]);
                else if(i==2) adapter.add("Satker: "+mobileArray[i]);
                else if(i==3) adapter.add("Nama Event: "+mobileArray[i]);
                else if(i==4) adapter.add("Tempat Event: "+mobileArray[i]);
                else if(i==5) adapter.add("Tanggal: "+mobileArray[i]);
                else if(i==6) adapter.add("Delegasi ADG: "+mobileArray[i]);
                else if(i==7) adapter.add("Delegasi Satker: "+mobileArray[i]);
                else if(i==8) adapter.add("Topik Event: "+mobileArray[i]);
                else if(i==9) adapter.add("User: "+mobileArray[i]);
                else if(i==10) adapter.add("Create at Time:\n"+mobileArray[i]);
            }
        }
        listView.setAdapter(adapter);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);
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
                        if(i==0) adapter.add("DETAIL RENCANA PENYELENGGARAAN");
                        else if(i==1) adapter.add("Periode: "+mobileArray[i]);
                        else if(i==2) adapter.add("Satker: "+mobileArray[i]);
                        else if(i==3) adapter.add("Nama Event: "+mobileArray[i]);
                        else if(i==4) adapter.add("Tempat Event: "+mobileArray[i]);
                        else if(i==5) adapter.add("Tanggal: "+mobileArray[i]);
                        else if(i==6) adapter.add("Delegasi ADG: "+mobileArray[i]);
                        else if(i==7) adapter.add("Delegasi Satker: "+mobileArray[i]);
                        else if(i==8) adapter.add("Topik Event: "+mobileArray[i]);
                        else if(i==9) adapter.add("User: "+mobileArray[i]);
                        else if(i==10) adapter.add("Create at Time:\n"+mobileArray[i]);
                    }
                }
                listView.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
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
            CallerJadwalDetailUser c=new CallerJadwalDetailUser();
            c.a=((Config) this.getApplication()).getID_PENYELENGGARAAN();
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
//            Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
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
            CallerDeletePenyelenggaraan c=new CallerDeletePenyelenggaraan();
            c.a=((Config) this.getApplication()).getID_PENYELENGGARAAN();
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
            Intent intent = new Intent(this, UpdatePenyelenggaraanActivity.class);
//            startActivity(intent);
            startActivityForResult(intent, 10002);
        }
        else if(v == buttonDelete) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Are you sure you want to delete?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            delete();
                            setResult(Activity.RESULT_OK);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
