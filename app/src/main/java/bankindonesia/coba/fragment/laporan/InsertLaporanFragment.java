package bankindonesia.coba.fragment.laporan;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.laporan.CallerInsertLaporan;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertLaporanFragment extends Fragment implements View.OnClickListener{

    private Spinner spinnerSatker;
    private EditText editTextPlace;
    protected static TextView textdate;
    private EditText namafora;
    private EditText namaworkinggroup;
    private EditText delegasiBI;
    private EditText delegasiterkait;
    private EditText negaramitra;
    private EditText agenda;
    private EditText relevansi;
    private EditText stanceBI;
    private EditText stancePosisi;
    private EditText stancemitra;
    private EditText kesepakatan;
    private EditText kesepakatan2;
    private EditText pending;
    private EditText rencana;
    private EditText foralain;
    private EditText editTextSatker;
    protected static TextView jadwal;
    private EditText lembagalain;
    private Button buttonRegister;

    private String[] array;

    public static String rslt="";

    public static InsertLaporanFragment newInstance() {return new InsertLaporanFragment();}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_laporan, container, false);

        spinnerSatker = (Spinner) view.findViewById(R.id.spinnerSatker);
        editTextPlace = (EditText) view.findViewById(R.id.editTextPlace);
        textdate = (TextView) view.findViewById(R.id.showDate);
        textdate.setOnClickListener(this);
        namafora = (EditText) view.findViewById(R.id.editTextFORA);
        namaworkinggroup = (EditText) view.findViewById(R.id.editTextGroup);
        delegasiBI = (EditText) view.findViewById(R.id.editTextDelegasiBI);
        delegasiterkait = (EditText) view.findViewById(R.id.editTextDelegasiTerkait);
        negaramitra = (EditText) view.findViewById(R.id.editTextMitra);
        agenda = (EditText) view.findViewById(R.id.editTextAgenda);
        relevansi = (EditText) view.findViewById(R.id.editTextRelevansi);
        stanceBI = (EditText) view.findViewById(R.id.stanceBI);
        stancePosisi = (EditText) view.findViewById(R.id.stanceposisi);
        stancemitra = (EditText) view.findViewById(R.id.stancemitra);
        kesepakatan = (EditText) view.findViewById(R.id.kesepakatan1);
        kesepakatan2 = (EditText) view.findViewById(R.id.kesepakatan2);
        pending = (EditText) view.findViewById(R.id.pending);
        rencana = (EditText) view.findViewById(R.id.editTextRencana);
        foralain = (EditText) view.findViewById(R.id.foralain);
        editTextSatker = (EditText) view.findViewById(R.id.editTextSatker);
        jadwal = (TextView) view.findViewById(R.id.showDate2);
        jadwal.setOnClickListener(this);
        lembagalain = (EditText) view.findViewById(R.id.lembagalain);

        stanceBI.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.stanceBI) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        stancePosisi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.stanceposisi) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        stancemitra.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.stancemitra) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        kesepakatan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.kesepakatan1) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        kesepakatan2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.kesepakatan2) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        pending.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.pending) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        rencana.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.editTextRencana) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        addItemsOnSpinnerSatker();
        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);

        return view;
    }

    private void userRegister() {
        try
        {
            rslt="START";
            CallerInsertLaporan c=new CallerInsertLaporan();
            c.spinnerSatker=String.valueOf(spinnerSatker.getSelectedItem());
            c.editTextPlace=editTextPlace.getText().toString();
            c.textdate=textdate.getText().toString();
            c.namafora=namafora.getText().toString();
            c.namaworkinggroup=namaworkinggroup.getText().toString();
            c.delegasiBI=delegasiBI.getText().toString();
            c.delegasiterkait=delegasiterkait.getText().toString();
            c.negaramitra=negaramitra.getText().toString();
            c.agenda=agenda.getText().toString();
            c.relevansi=relevansi.getText().toString();
            c.stanceBI=stanceBI.getText().toString();
            c.stancePosisi=stancePosisi.getText().toString();
            c.stancemitra=stancemitra.getText().toString();
            c.kesepakatan=kesepakatan.getText().toString();
            c.kesepakatan2=kesepakatan2.getText().toString();
            c.pending=pending.getText().toString();
            c.rencana=rencana.getText().toString();
            c.foralain=foralain.getText().toString();
            c.editTextSatker=editTextSatker.getText().toString();
            c.jadwal=jadwal.getText().toString();
            c.lembagalain=lembagalain.getText().toString();
            c.a=((Config) getActivity().getApplication()).getID_USER();

            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                    Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
                }
            }
////            array = rslt.split("\\|");
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
            textdate.setText(String.valueOf(day) + "/" + String.valueOf(month+1)
                    + "/" + String.valueOf(year));
        }
    }

    public static class DatePickerFragment2 extends DialogFragment implements DatePickerDialog.OnDateSetListener {

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
            jadwal.setText(String.valueOf(day) + "/" + String.valueOf(month+1)
                    + "/" + String.valueOf(year));
        }
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

    @Override
    public void onClick(View v) {
        if(v == textdate) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getActivity().getFragmentManager(), "datePicker");
        }
        if(v == jadwal) {
            DialogFragment newFragment = new DatePickerFragment2();
            newFragment.show(getActivity().getFragmentManager(), "datePicker");
        }
        if(v == buttonRegister) {
            userRegister();
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, InsertLaporanFragment.newInstance()).commit();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Laporan Hasil Sidang");
    }

}
