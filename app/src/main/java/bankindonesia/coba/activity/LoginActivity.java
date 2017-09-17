//Code untuk menampilkan page login

package bankindonesia.coba.activity;

import android.app.Activity;
import android.content.Intent;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import bankindonesia.coba.other.Activity.CallerLogin;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;
//    private ProgressBar loading;

    private String email;
    private String password;
    private  AlertDialog ad;
    private String[] separated;


    public static String rslt="";    /** Called when the activity is first created. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        ad =new AlertDialog.Builder(this).create();

//        loading=(ProgressBar)findViewById(R.id.loading);
//        loading.setVisibility(View.GONE);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001) && (resultCode == Activity.RESULT_OK)){
            ((EditText) findViewById(R.id.editTextEmail)).getText().clear();
            ((EditText) findViewById(R.id.editTextPassword)).getText().clear();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
//            if (android.os.Build.VERSION.SDK_INT >= 11){
//                //Code for recreate
//                recreate();
//            }else{
////                Code for Intent
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);
//            }
    }

    private void userLogin() {
        try
        {
            email = editTextEmail.getText().toString().trim();
            password = editTextPassword.getText().toString().trim();
            rslt="START";
            CallerLogin c=new CallerLogin();
            c.a=email;
            c.b=password;
            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            if(rslt.contains("|")){
                separated = rslt.split("\\|");
                int id = Integer.parseInt(separated[0]);
                ((Config) this.getApplication()).setID_USER(id);
                ((Config) this.getApplication()).setNAMA_SATKER(separated[2]);
                int jabatan =  Integer.parseInt(separated[1]);
                ((Config) this.getApplication()).setID_JABATAN(jabatan);
                if(((Config) this.getApplication()).getID_JABATAN()==2){
                    openProfilePIC();
                }else if(((Config) this.getApplication()).getID_JABATAN()==3){
                    openProfilePJ();
                }else if(((Config) this.getApplication()).getID_JABATAN()==1) {
                    openProfileAdmin();
                }
            } else
                Toast.makeText(this.getApplicationContext(), rslt, Toast.LENGTH_LONG).show();
//            ad.setTitle("TES");
//            ad.setMessage(rslt);
//            Toast.makeText(this.getApplicationContext(), rslt, Toast.LENGTH_LONG).show();
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

//    private void userLogin() {
//        email = editTextEmail.getText().toString().trim();
//        password = editTextPassword.getText().toString().trim();
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        if(response.trim().equals("success")){
//                            openProfilePIC();
//                        }else if(response.trim().equals("PJ")){
//                            openProfilePJ();
//                        }else if(response.trim().equals("Admin")) {
//                            openProfileAdmin();
//                        }else{
//                            Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG ).show();
//                    }
//                }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map = new HashMap<String,String>();
//                map.put(Config.KEY_EMAIL,email);
//                map.put(Config.KEY_PASSWORD,password);
//                return map;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    private void openProfilePIC(){
        Intent intent = new Intent(this, ProfilePICActivity.class);
        startActivityForResult(intent, 10001);
//        startActivity(intent);
    }

    private void openProfilePJ(){
        Intent intent = new Intent(this, ProfilePJActivity.class);
        startActivityForResult(intent, 10001);
//        startActivity(intent);
    }

    private void openProfileAdmin(){
        Intent intent = new Intent(this, ProfileAdminActivity.class);
        startActivityForResult(intent, 10001);
//        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        if (v==buttonLogin){
            if(editTextEmail.getText().toString().compareTo("")==0 || editTextPassword.getText().toString().compareTo("")==0)
                Toast.makeText(this.getApplicationContext(),"Semua data harus diisi", Toast.LENGTH_LONG).show();
            else{
//                loading.setVisibility(View.VISIBLE);
                userLogin();
//                loading.setVisibility(View.GONE);
//            openProfilePJ();
//            Intent intent = new Intent(this, ProfilePICActivity.class);
//            startActivity(intent);
            }
        }
        else if (v==buttonRegister){
            Intent intent = new Intent(this,SignupActivity.class);
            startActivityForResult(intent, 10001);
        }
    }
}