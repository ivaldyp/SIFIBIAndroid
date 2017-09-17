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
        import bankindonesia.coba.other.Activity.laporan.CallerVerifikasiLaporan;
        import bankindonesia.coba.other.Activity.user.CallerDeleteUser;
        import bankindonesia.coba.other.Activity.user.CallerUserDetail;
        import bankindonesia.coba.other.Activity.user.CallerVerifikasiUser;
        import bankindonesia.coba.other.Config;

public class UserDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private String[] mobileArray;
    private String[] asd = {"a","b","c"};
    private Button buttonUpdate;
    private Button buttonVerifikasi;
    private Button buttonDelete;
    public static String rslt="";
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        data();

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview, asd);
//        listView = (ListView) findViewById(R.id.mobile_list);
//        listView.setAdapter(adapter);
        listView = (ListView) findViewById(R.id.mobile_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_listview);
        for(int i = 0; i < mobileArray.length; i++) {
            if(mobileArray[i]==null) {
                adapter.add("Data Kosong");
            } else {
                if(i==0) adapter.add("DETAIL USER");
                else if(i==1) adapter.add("Nama User: "+mobileArray[i]);
                else if(i==2) adapter.add("Satker User: "+mobileArray[i]);
                else if(i==3) adapter.add("Email: "+mobileArray[i]);
                else if(i==4) adapter.add("Password: "+mobileArray[i]);
                else if(i==5) {
                    if(mobileArray[i].compareTo("1")==0) mobileArray[i]="Admin";
                    else if (mobileArray[i].compareTo("2")==0) mobileArray[i]="PIC";
                    else if (mobileArray[i].compareTo("3")==0) mobileArray[i]="Penanggung Jawab";
                    else mobileArray[i]="Error";
                    adapter.add("Jabatan: "+mobileArray[i]);
                }
                else if(i==6) {
                    if(mobileArray[i].compareTo("0")==0) mobileArray[i]="Belum";
                    else if (mobileArray[i].compareTo("1")==0) mobileArray[i]="Sudah";
                    else mobileArray[i]="Error";
                    adapter.add("Verifikasi: "+mobileArray[i]);
                }
                else if(i==7) adapter.add("Create at Time:\n"+mobileArray[i]);
            }
        }
        listView.setAdapter(adapter);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);
        buttonVerifikasi = (Button) findViewById(R.id.buttonVerifikasi);
        buttonVerifikasi.setOnClickListener(this);
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
                        if(i==0) adapter.add("DETAIL USER");
                        else if(i==1) adapter.add("Nama User: "+mobileArray[i]);
                        else if(i==2) adapter.add("Satker User: "+mobileArray[i]);
                        else if(i==3) adapter.add("Email: "+mobileArray[i]);
                        else if(i==4) adapter.add("Password: "+mobileArray[i]);
                        else if(i==5) {
                            if(mobileArray[i].compareTo("1")==0) mobileArray[i]="Admin";
                            else if (mobileArray[i].compareTo("2")==0) mobileArray[i]="PIC";
                            else if (mobileArray[i].compareTo("3")==0) mobileArray[i]="Penanggung Jawab";
                            else mobileArray[i]="Error";
                            adapter.add("Jabatan: "+mobileArray[i]);
                        }
                        else if(i==6) {
                            if(mobileArray[i].compareTo("0")==0) mobileArray[i]="Belum";
                            else if (mobileArray[i].compareTo("1")==0) mobileArray[i]="Sudah";
                            else mobileArray[i]="Error";
                            adapter.add("Verifikasi: "+mobileArray[i]);
                        }
                        else if(i==7) adapter.add("Create at Time:\n"+mobileArray[i]);
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
            mobileArray = rslt.split("\\|");

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(this.getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(this.getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void verifikasi() {
        try
        {
            rslt="START";
            CallerVerifikasiUser c=new CallerVerifikasiUser();
            c.a=((Config) this.getApplication()).getID_USERPILIHAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            if(rslt.equals("1")){
                Toast.makeText(getApplicationContext(),"Data berhasil diverifikasi", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Data tidak berhasil diverifikasi", Toast.LENGTH_LONG).show();
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

    private void delete() {
        try
        {
            rslt="START";
            CallerDeleteUser c=new CallerDeleteUser();
            c.a=((Config) this.getApplication()).getID_USERPILIHAN();
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
            Intent intent = new Intent(this, UpdateUserActivity.class);
            startActivityForResult(intent, 10002);
        }
        else if(v == buttonVerifikasi){
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Apakah anda yakin untuk memverifikasi data?")
                    .setCancelable(true)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            verifikasi();
                            setResult(Activity.RESULT_OK);
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(v == buttonDelete) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Dengan MENGHAPUS USER, anda akan menghapus semua data di SEMUA JADWAL DAN SEMUA LAPORAN yang user tersebut BUAT")
                    .setCancelable(true)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            delete();
                            setResult(Activity.RESULT_OK);
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}

