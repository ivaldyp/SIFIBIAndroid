package bankindonesia.coba.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import bankindonesia.coba.other.Activity.penyelenggaraan.CallerUpdatePenyelenggaraan;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.penyelenggaraan.CallerJadwalDetailUser;

public class UpdatePenyelenggaraanActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner spinnerPeriode;
    private EditText editTextPeriode;
    private Spinner spinnerSatker;
    private EditText editTextName;
    private EditText editTextPlace;

    protected static TextView text;

    private EditText delegasiADG;
    private EditText editTextSatker;
    private Spinner spinnerSatker2;
    private EditText topikEvent;
    private Button buttonRegister;

    private String[] array;

    public static String rslt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_penyelenggaraan);

        data();

//        spinnerPeriode = (Spinner) findViewById(R.id.spinnerPeriode);
//        addItemsOnSpinnerPeriode();
        editTextPeriode = (EditText) findViewById(R.id.editTextPeriode);
        spinnerSatker = (Spinner) findViewById(R.id.spinnerSatker);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPlace = (EditText) findViewById(R.id.editTextPlace);
        text = (TextView) findViewById(R.id.showDate);
        delegasiADG = (EditText) findViewById(R.id.DelegasiADG);
        editTextSatker = (EditText) findViewById(R.id.editTextSatker);
//        spinnerSatker2 = (Spinner) findViewById(R.id.spinnerSatker2);
        addItemsOnSpinnerSatker();
        topikEvent = (EditText) findViewById(R.id.TopikEvent);

        editTextPeriode.setText(array[1],TextView.BufferType.EDITABLE);
        editTextName.setText(array[3], TextView.BufferType.EDITABLE);
        editTextPlace.setText(array[4], TextView.BufferType.EDITABLE);
        text.setText(array[5], TextView.BufferType.EDITABLE);
        delegasiADG.setText(array[6], TextView.BufferType.EDITABLE);
        editTextSatker.setText(array[7], TextView.BufferType.EDITABLE);
        topikEvent.setText(array[8], TextView.BufferType.EDITABLE);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        text.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
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
            array = rslt.split("\\|");

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),array[1], Toast.LENGTH_LONG).show();;
//            Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
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
            CallerUpdatePenyelenggaraan c=new CallerUpdatePenyelenggaraan();
            c.a=((Config) this.getApplication()).getID_PENYELENGGARAAN();
            c.Periode=editTextPeriode.getText().toString();
            c.Satker=String.valueOf(spinnerSatker.getSelectedItem());
            c.Event=editTextName.getText().toString();
            c.Tempat=editTextPlace.getText().toString();
            c.Waktu=text.getText().toString();
            c.delegasiADG=delegasiADG.getText().toString();
            c.delegasiSatker=editTextSatker.getText().toString();
            c.topik=topikEvent.getText().toString();

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
            text.setText(String.valueOf(day) + "/" + String.valueOf(month+1)
                    + "/" + String.valueOf(year));
        }
    }

//    public void addItemsOnSpinnerPeriode(){
//        List<String> list = new ArrayList<String>();
//        list.add("Periode ke-1");list.add("Periode ke-2");list.add("Periode ke-3");list.add("Periode ke-4");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerPeriode.setAdapter(dataAdapter);
//    }

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
        if(v == text) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(this.getFragmentManager(), "datePicker");
        }
        if(v == buttonRegister) {
            update();
            setResult(Activity.RESULT_OK);
            finish();
//            Toast.makeText(this.getApplicationContext(),
//                    String.valueOf(((Config) this.getApplication()).getID_PENYELENGGARAAN())+"\n"+
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
