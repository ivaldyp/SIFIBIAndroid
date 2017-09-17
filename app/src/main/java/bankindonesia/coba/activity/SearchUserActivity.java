package bankindonesia.coba.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Activity.user.CallerSearchUser;
import bankindonesia.coba.other.Activity.user.CallerUserDetail;
import bankindonesia.coba.other.Config;

public class SearchUserActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private Button buttonRegister;
    private ListView listView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Spinner spinnerJabatan;

    private String[] lines;
    private String[] mobileArray;
    private String[][] array;
    private String[] arraydetail;

    public static String rslt="";
    public static String rslt2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        editTextName = (EditText) findViewById(R.id.editTextName);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        listView = (ListView) findViewById(R.id.mobile_list);

        spinnerJabatan = (Spinner) findViewById(R.id.spinnerJabatan);
        addItemsOnSpinnerJabatan();

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                search();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        buttonRegister.setOnClickListener(this);
    }

    public void addItemsOnSpinnerJabatan(){
        List<String> list2 = new ArrayList<String>();
        list2.add("Kosong");
        list2.add("PIC");
        list2.add("Penanggung Jawab");
        list2.add("Admin");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJabatan.setAdapter(dataAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001) && (resultCode == Activity.RESULT_OK))
            search();
    }

    private void search() {
        try
        {
            rslt="START";
            CallerSearchUser c=new CallerSearchUser();

            c.varchar=editTextName.getText().toString();
            c.jabatan=String.valueOf(spinnerJabatan.getSelectedItem());

            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                    Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
                }
            }
            if(rslt.contains("~")){
                lines = rslt.split("~");
                array = new String[lines.length][];
                for (int i=0; i<lines.length; i++) {
                    array[i] = lines[i].split("\\|");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview);
                for(int i = 0; i < array.length; i++) {
                    adapter.add("Nama: "+array[i][1]+"\nSatker: "+array[i][2]);
                }
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int id_user = Integer.parseInt(array[position][0]);
                        ((Config) getApplication()).setID_USERPILIHAN(id_user);
                        data();
                        if(arraydetail[6].compareTo("0")==0){
                            Intent intent = new Intent(getApplicationContext(), UserDetailActivity.class);
                            startActivityForResult(intent, 10001);
//                            startActivity(intent);
                        } else if(arraydetail[6].compareTo("1")==0){
                            Intent intent = new Intent(getApplicationContext(), UserDetailActivity2.class);
                            startActivityForResult(intent, 10001);
//                            startActivity(intent);
                        } else{
                            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            } else{
                if(rslt.compareTo("Data Kosong")==0){
                    Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
                } else {
                    mobileArray = rslt.split("\\|");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview);
                    adapter.add("Nama Event: "+mobileArray[1]+"\nTanggal Event: "+mobileArray[2]);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                              Toast.makeText(getActivity().getApplicationContext(), array[position][0], Toast.LENGTH_LONG).show();
                            int id_user = Integer.parseInt(mobileArray[0]);
                            ((Config) getApplication()).setID_USERPILIHAN(id_user);
                            data();
                            if(arraydetail[6].compareTo("0")==0){
                                Intent intent = new Intent(getApplicationContext(), UserDetailActivity.class);
                                startActivityForResult(intent, 10001);
//                            startActivity(intent);
                            } else if(arraydetail[6].compareTo("1")==0){
                                Intent intent = new Intent(getApplicationContext(), UserDetailActivity2.class);
                                startActivityForResult(intent, 10001);
//                            startActivity(intent);
                            } else{
                                Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }

//            Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void data() {
        try
        {
            rslt2="START";
            CallerUserDetail c=new CallerUserDetail();
            c.a=((Config) this.getApplication()).getID_USERPILIHAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt2=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            arraydetail = rslt2.split("\\|");

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),arraydetail[6], Toast.LENGTH_LONG).show();
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister) {
            if(editTextName.getText().toString().compareTo("")==0 && String.valueOf(spinnerJabatan.getSelectedItem()).compareTo("Kosong")==0)
                Toast.makeText(this.getApplicationContext(),"Isi Data", Toast.LENGTH_LONG).show();
            else
                search();
//            setResult(Activity.RESULT_OK);
//            finish();
        }
    }
}
