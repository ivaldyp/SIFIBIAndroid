package bankindonesia.coba.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Activity.user.CallerUpdateUser;
import bankindonesia.coba.other.Activity.user.CallerUserDetail;
import bankindonesia.coba.other.Config;

public class UpdateUserActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerSatker;
    private Spinner spinnerJabatan;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonRegister;

    private String[] array;

    public static String rslt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        data();

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        spinnerSatker = (Spinner) findViewById(R.id.spinnerSatker);
        spinnerJabatan = (Spinner) findViewById(R.id.spinnerJabatan);


        editTextName.setText(array[1], TextView.BufferType.EDITABLE);
        editTextEmail.setText(array[3], TextView.BufferType.EDITABLE);
        editTextPassword.setText(array[4], TextView.BufferType.EDITABLE);

        addItemsOnSpinnerJabatan();
        addItemsOnSpinnerSatker();

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
    }

    private void data() {
        try
        {
            rslt="START";
            CallerUserDetail c=new CallerUserDetail();
            c.a=((Config) this.getApplication()).getID_USERPILIHAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            array = rslt.split("\\|");

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),array[2], Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void update() {
        try
        {
            rslt="START";
            CallerUpdateUser c=new CallerUpdateUser();
            c.a=((Config) this.getApplication()).getID_USERPILIHAN();
            c.nama=editTextName.getText().toString();
            c.satker=String.valueOf(spinnerSatker.getSelectedItem());
            c.email=editTextEmail.getText().toString();
            c.password=editTextPassword.getText().toString();
            c.jabatan=String.valueOf(spinnerJabatan.getSelectedItem());

            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                    Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
                }
            }
//            array = rslt.split("\\|");
            if(rslt.equals("1")){
                Toast.makeText(getApplicationContext(),"Data berhasil di-update", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Data tidak berhasil di-update", Toast.LENGTH_LONG).show();
            }

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_OK);
        finish();
    }

    public void addItemsOnSpinnerJabatan(){
        List<String> list2 = new ArrayList<String>();
        list2.add("PIC");
        list2.add("Penanggung Jawab");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJabatan.setAdapter(dataAdapter);
        int spinnerPosition = dataAdapter.getPosition(array[5]);
        spinnerJabatan.setSelection(spinnerPosition);
    }

    public void addItemsOnSpinnerSatker(){
        List<String> list2 = new ArrayList<String>();
        list2.add("BINS");list2.add("DAI");list2.add("DEKS");list2.add("DHk");list2.add("DInt");list2.add("DKEM");list2.add("DKeu");
        list2.add("DKMP");list2.add("DKom");list2.add("DKSP");list2.add("DMR");list2.add("DMST");list2.add("DOTP");list2.add("DPD");
        list2.add("DPKL");list2.add("DPLF");list2.add("DPM");list2.add("DPPK");list2.add("DPS");list2.add("DPSI");list2.add("DPSP");
        list2.add("DPU");list2.add("DPUM");list2.add("DPR1");list2.add("DR2");list2.add("DR3");list2.add("DRK");list2.add("DSDM");
        list2.add("DSSK");list2.add("DSTa");list2.add("PPTBI");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSatker.setAdapter(dataAdapter);
        int spinnerPosition = dataAdapter.getPosition(array[2]);
        spinnerSatker.setSelection(spinnerPosition);
//        spinnerSatker2.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister) {
            update();
            setResult(Activity.RESULT_OK);
            finish();
//            Toast.makeText(this.getApplicationContext(),
//                    String.valueOf(((Config) this.getApplication()).getID_KEHADIRAN())+"\n"+
//                    editTextPeriode.getText().toString()+"\n"+
//                    String.valueOf(spinnerSatker.getSelectedItem())+"\n"+
//                    editTextName.getText().toString()+"\n"+
//                    editTextPlace.getText().toString()+"\n"+
//                    text.getText().toString()+"\n"+
//                    delegasiADG.getText().toString()+"\n"+
//                    editTextSatker.getText().toString()+"\n"+
//                    topikEvent.getText().toString()
//                    , Toast.LENGTH_LONG).show();
        }
    }
}
