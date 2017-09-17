//Code untuk menampilkan page detail kehadiran dengan verifikasi

package bankindonesia.coba.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.kehadiran.CallerJadwalDetailUser;

public class JadwalDetailKehadiran2Activity extends AppCompatActivity{

    private ListView listView;
    private String[] mobileArray;
    public static String rslt="";
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_detail_kehadiran2);
        data();

        listView = (ListView) findViewById(R.id.mobile_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview);
        for(int i = 0; i < mobileArray.length; i++) {
            if(mobileArray[i]==null) {
                adapter.add("Data Kosong");
            } else {
                if(i==0) adapter.add("DETAIL RENCANA KEHADIRAN");
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
                        if(i==0) adapter.add("DETAIL RENCANA KEHADIRAN");
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
            CallerJadwalDetailUser c=new CallerJadwalDetailUser();
            c.a=((Config) this.getApplication()).getID_KEHADIRAN();
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            mobileArray = rslt.split("\\|");
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
        }
    }

}
