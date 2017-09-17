package bankindonesia.coba.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bankindonesia.coba.other.Activity.CallerSignUp;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.R;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Spinner spinnerSatker;
    private Spinner spinnerJabatan;
    private Button buttonRegister;
//    private ProgressBar loading;

    public static String rslt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);

//        loading=(ProgressBar)findViewById(R.id.loading);
//        loading.setVisibility(View.GONE);

        spinnerSatker = (Spinner) findViewById(R.id.spinnerSatker);
        addItemsOnSpinnerSatker();

        spinnerJabatan = (Spinner) findViewById(R.id.spinnerJabatan);
        addItemsOnSpinnerJabatan();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_OK);
        finish();
    }

    public void addItemsOnSpinnerSatker(){
        List<String> list2 = new ArrayList<String>();
        list2.add("BINS");list2.add("DAI");list2.add("DEKS");list2.add("DHk");list2.add("DInt");list2.add("DKEM");list2.add("DKeu");
        list2.add("DKMP");list2.add("DKom");list2.add("DKSP");list2.add("DMR");list2.add("DMST");list2.add("DOTP");list2.add("DPD");
        list2.add("DPKL");list2.add("DPLF");list2.add("DPM");list2.add("DPPK");list2.add("DPS");list2.add("DPSI");list2.add("DPSP");
        list2.add("DPU");list2.add("DPUM");list2.add("DPR1");list2.add("DR2");list2.add("DR3");list2.add("DRK");list2.add("DSDM");
        list2.add("DSSK");list2.add("DSTa");list2.add("PPTBI");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSatker.setAdapter(dataAdapter2);
    }

    public void addItemsOnSpinnerJabatan(){
        List<String> list2 = new ArrayList<String>();
        list2.add("PIC");
        list2.add("Penanggung Jawab");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJabatan.setAdapter(dataAdapter);
    }

    private void userRegister() {
        try
        {
            rslt="START";
            CallerSignUp c=new CallerSignUp();
            c.a=editTextName.getText().toString();
            c.b=String.valueOf(spinnerSatker.getSelectedItem());
            c.c=editTextEmail.getText().toString();
            c.d=editTextPassword.getText().toString();
            if(String.valueOf(spinnerJabatan.getSelectedItem()).compareTo("PIC")==0)
                c.e=2;
            else if(String.valueOf(spinnerJabatan.getSelectedItem()).compareTo("Penanggung Jawab")==0)
                c.e=3;

            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                    Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
                }
            }
//            array = rslt.split("\\|");
            if(rslt.compareTo("Email sudah pernah terdaftar")==0){
                Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
                finish();
            }
//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

//    private void userRegister() {
//
//        name = editTextName.getText().toString().trim();
//        email = editTextEmail.getText().toString().trim();
//        password = editTextPassword.getText().toString().trim();
//        satker = String.valueOf(spinnerSatker.getSelectedItem());
//        jabatan = String.valueOf(spinnerJabatan.getSelectedItem());
//
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.INSERT_USER_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        if(response.trim().equals("success")){
//                            Toast.makeText(SignupActivity.this,"DATA BERHASIL MASUK, Menunggu Persetujuan ADMIN",Toast.LENGTH_LONG).show();
//                            finish();
//                        }else{
//                            Toast.makeText(SignupActivity.this,response,Toast.LENGTH_LONG).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(SignupActivity.this,error.toString(),Toast.LENGTH_LONG ).show();
//                    }
//                }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map = new HashMap<String,String>();
//                map.put(Config.KEY_NAME,name);
//                map.put(Config.KEY_SATKER,satker);
//                map.put(Config.KEY_EMAIL,email);
//                map.put(Config.KEY_PASSWORD,password);
//                map.put(Config.KEY_JABATAN,jabatan);
//                return map;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister) {
            if(editTextName.getText().toString().compareTo("")==0 || editTextPassword.getText().toString().compareTo("")==0 || editTextEmail.getText().toString().compareTo("")==0)
                Toast.makeText(this.getApplicationContext(),"Semua data harus terisi", Toast.LENGTH_LONG).show();
            else {
//                loading.setVisibility(View.VISIBLE);
                userRegister();
//                loading.setVisibility(View.GONE);
//                ((EditText) findViewById(R.id.editTextName)).getText().clear();
//                ((EditText) findViewById(R.id.editTextEmail)).getText().clear();
//                ((EditText) findViewById(R.id.editTextPassword)).getText().clear();
            }
        }
    }
}