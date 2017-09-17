package bankindonesia.coba.fragment.penyelenggaraan;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.penyelenggaraan.CallerInsertPenyelenggaraan;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertPenyelenggaraanFragment extends Fragment implements View.OnClickListener{

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

    public static InsertPenyelenggaraanFragment newInstance() {return new InsertPenyelenggaraanFragment();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_penyelenggaraan, container, false);

//        spinnerPeriode = (Spinner) view.findViewById(R.id.spinnerPeriode);
//        addItemsOnSpinnerPeriode();
        editTextPeriode = (EditText) view.findViewById(R.id.editTextPeriode);
        spinnerSatker = (Spinner) view.findViewById(R.id.spinnerSatker);
        addItemsOnSpinnerSatker();
        editTextName = (EditText) view.findViewById(R.id.editTextName);
        editTextPlace = (EditText) view.findViewById(R.id.editTextPlace);

        text = (TextView) view.findViewById(R.id.showDate);
        text.setOnClickListener(this);

        delegasiADG = (EditText) view.findViewById(R.id.DelegasiADG);
//        spinnerSatker2 = (Spinner) view.findViewById(R.id.spinnerSatker2);
        editTextSatker = (EditText) view.findViewById(R.id.editTextSatker);
        topikEvent = (EditText) view.findViewById(R.id.TopikEvent);

        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
        return view;
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

    public void addItemsOnSpinnerPeriode(){
        List<String> list2 = new ArrayList<String>();
        list2.add("Periode ke-1");
        list2.add("Periode ke-2");
        list2.add("Periode ke-3");
        list2.add("Periode ke-4");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPeriode.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinnerSatker(){
        List<String> list2 = new ArrayList<String>();
        list2.add("BINS");list2.add("DAI");list2.add("DEKS");list2.add("DHk");list2.add("DInt");list2.add("DKEM");list2.add("DKeu");
        list2.add("DKMP");list2.add("DKom");list2.add("DKSP");list2.add("DMR");list2.add("DMST");list2.add("DOTP");list2.add("DPD");
        list2.add("DPKL");list2.add("DPLF");list2.add("DPM");list2.add("DPPK");list2.add("DPS");list2.add("DPSI");list2.add("DPSP");
        list2.add("DPU");list2.add("DPUM");list2.add("DPR1");list2.add("DR2");list2.add("DR3");list2.add("DRK");list2.add("DSDM");
        list2.add("DSSK");list2.add("DSTa");list2.add("PPTBI");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSatker.setAdapter(dataAdapter2);
    }

    private void userRegister() {
        try
        {
            rslt="START";
            CallerInsertPenyelenggaraan c=new CallerInsertPenyelenggaraan();
            c.a=((Config) getActivity().getApplication()).getID_USER();
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
                    Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
                }
            }
//            array = rslt.split("\\|");
            if(rslt.equals("1")){
                Toast.makeText(getActivity().getApplicationContext(),"Data berhasil di-insert", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getActivity().getApplicationContext(),"Data tidak berhasil di-insert", Toast.LENGTH_LONG).show();
            }

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    @Override
    public void onClick(View v) {
        if(v == text) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getActivity().getFragmentManager(), "datePicker");
        }
        if(v == buttonRegister) {
            userRegister();
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, InsertPenyelenggaraanFragment.newInstance()).commit();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Rencana Penyelenggaraan");
    }

}
