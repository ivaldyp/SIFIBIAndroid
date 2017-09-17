package bankindonesia.coba.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Activity.kehadiran.CallerSearchKehadiran;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.kehadiran.CallerJadwalDetailUser;

public class SearchKehadiranActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    protected static TextView text;
    private Button buttonRegister;
    private Button hapus;
    private ListView listView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private String[] lines;
    private String[] mobileArray;
    private String[][] array;
    private String[] arraylagi;

    public static String rslt="";
    public static String rslt2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_kehadiran);

        editTextName = (EditText) findViewById(R.id.editTextName);
        text = (TextView) findViewById(R.id.showDate);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        listView = (ListView) findViewById(R.id.mobile_list);

        hapus = (Button) findViewById(R.id.hapus);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                search();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        buttonRegister.setOnClickListener(this);

        hapus.setOnClickListener(this);

        text.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            text.setText(String.valueOf(day) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year));
        }
    }

    private void search() {
        try
        {
            rslt="START";
            CallerSearchKehadiran c=new CallerSearchKehadiran();

            c.varchar=editTextName.getText().toString();
            c.tanggal=text.getText().toString();

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
                    adapter.add("Nama Event: "+array[i][1]+"\nTanggal Event: "+array[i][2]);
                }
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(((Config) getApplication()).getID_JABATAN()==1){
                            int id_kehadiran = Integer.parseInt(array[position][0]);
                            ((Config) getApplication()).setID_KEHADIRAN(id_kehadiran);
                            Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiranActivity.class);
                            startActivityForResult(intent, 10001);
                        } else if(((Config) getApplication()).getID_JABATAN()==2){
                            int id_kehadiran = Integer.parseInt(array[position][0]);
                            ((Config) getApplication()).setID_KEHADIRAN(id_kehadiran);
                            data();
                            if(String.valueOf(((Config) getApplication()).getID_USER()).compareTo(arraylagi[11])==0) {
//                                Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiranActivity.class);
                                startActivityForResult(intent, 10001);
                            } else{
                                Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiran2Activity.class);
                                startActivity(intent);
                            }
                        } else if(((Config) getApplication()).getID_JABATAN()==3){
                            int id_kehadiran = Integer.parseInt(array[position][0]);
                            ((Config) getApplication()).setID_KEHADIRAN(id_kehadiran);
                            data();
                            if(((Config) getApplication()).getNAMA_SATKER().compareTo(arraylagi[2])==0){
//                                Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiranActivity.class);
                                startActivityForResult(intent,10001);
                            } else{
                                Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiran2Activity.class);
                                startActivity(intent);
                            }
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
                            if(((Config) getApplication()).getID_JABATAN()==1){
                                int id_kehadiran = Integer.parseInt(mobileArray[0]);
                                ((Config) getApplication()).setID_KEHADIRAN(id_kehadiran);
                                Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiranActivity.class);
                                startActivityForResult(intent, 10001);
                            } else if(((Config) getApplication()).getID_JABATAN()==2){
                                int id_kehadiran = Integer.parseInt(mobileArray[0]);
                                ((Config) getApplication()).setID_KEHADIRAN(id_kehadiran);
                                data();
                                if(String.valueOf(((Config) getApplication()).getID_USER()).compareTo(arraylagi[11])==0) {
//                                Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiranActivity.class);
                                    startActivityForResult(intent, 10001);
                                } else{
                                    Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiran2Activity.class);
                                    startActivity(intent);
                                }
                            } else if(((Config) getApplication()).getID_JABATAN()==3){
                                int id_kehadiran = Integer.parseInt(mobileArray[0]);
                                ((Config) getApplication()).setID_KEHADIRAN(id_kehadiran);
                                data();
                                if(((Config) getApplication()).getNAMA_SATKER().compareTo(arraylagi[2])==0){
//                                    Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiranActivity.class);
                                    startActivityForResult(intent,10001);
                                } else{
                                    Intent intent = new Intent(getApplicationContext(), JadwalDetailKehadiran2Activity.class);
                                    startActivity(intent);
                                }
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
            CallerJadwalDetailUser c=new CallerJadwalDetailUser();
            c.a=((Config) this.getApplication()).getID_KEHADIRAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt2=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                    Toast.makeText(this.getApplicationContext(),ex.toString()+"ACACAAAA", Toast.LENGTH_LONG).show();
                }
            }
            arraylagi = rslt2.split("\\|");

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),rslt2, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    @Override
    public void onClick(View v) {
        if(v == hapus){
            text.setText("Klik di sini");
        }
        if(v == text) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(this.getFragmentManager(), "datePicker");
        }
        if(v == buttonRegister) {
            if(editTextName.getText().toString().compareTo("")==0 && text.getText().toString().compareTo("Klik di sini")==0)
                Toast.makeText(this.getApplicationContext(),"Isi Data", Toast.LENGTH_LONG).show();
            else
                search();
//            setResult(Activity.RESULT_OK);
//            finish();
        }
    }
}
