package bankindonesia.coba.fragment.kehadiran;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import bankindonesia.coba.R;
import bankindonesia.coba.activity.JadwalDetailKehadiranActivity;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.kehadiran.Admin.CallerJadwalUserAdmin;
import bankindonesia.coba.other.fragment.kehadiran.CallerJadwalDetailUser;
import bankindonesia.coba.other.fragment.kehadiran.PIC.CallerJadwalUserPIC;
import bankindonesia.coba.other.fragment.kehadiran.PJ.CallerJadwalUserPJ;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalKehadiranFragment extends Fragment {

    private ListView listView;
    private String[] mobileArray;
    private String kalimat = "Android,IPhone,WindowsMobile,Blackberry,WebOS,Ubuntu,Windows7,Max OS X,aaa,aaa,aaa,aaa,aaa,aaa,aaa,aaa";

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private String[] lines;
    private String[][] array;
    private AlertDialog ad;
    public static String rslt="";
    public static String rslt2="";

    public static JadwalKehadiranFragment newInstance() {
        return new JadwalKehadiranFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jadwal_kehadiran, container, false);

        if(((Config) getActivity().getApplication()).getID_JABATAN()==2)
            dataPIC();
        else if(((Config) getActivity().getApplication()).getID_JABATAN()==3)
            dataPJ();
        else
            dataAdmin();

        listView = (ListView) view.findViewById(R.id.mobile_list);
//        mobileArray = kalimat.split(",");
//        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, mobileArray);

        if(rslt.compareTo("Data Kosong")==0){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
            adapter.add(rslt);
            listView.setAdapter(adapter);
        } else{
            lines = rslt.split("~");
            array = new String[lines.length][];

            for (int i=0; i<lines.length; i++)
                array[i] = lines[i].split("\\|");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
            for(int i = 0; i < array.length; i++)
                adapter.add("Event: "+array[i][1]+"\nTanggal: "+array[i][2]);
            listView.setAdapter(adapter);
        }

//        ad =new AlertDialog.Builder(getActivity()).create();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position);
                if(value.compareTo("Data Kosong")!=0){
                    int id_kehadiran = Integer.parseInt(array[position][0]);
                    ((Config) getActivity().getApplication()).setID_KEHADIRAN(id_kehadiran);
                    Intent intent = new Intent(getActivity(), JadwalDetailKehadiranActivity.class);
                    startActivityForResult(intent, 10001);
//                    Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
                }
            }
        });

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(((Config) getActivity().getApplication()).getID_JABATAN()==2)
                    dataPIC();
                else if(((Config) getActivity().getApplication()).getID_JABATAN()==3)
                    dataPJ();
                else
                    dataAdmin();
                if(rslt.compareTo("Data Kosong")==0){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
                    adapter.add(rslt);
                    listView.setAdapter(adapter);
                } else{
                    lines = rslt.split("~");
                    array = new String[lines.length][];

                    for (int i=0; i<lines.length; i++)
                        array[i] = lines[i].split("\\|");

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
                    for(int i = 0; i < array.length; i++)
                        adapter.add("Event: "+array[i][1]+"\nTanggal: "+array[i][2]);
                    listView.setAdapter(adapter);
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001) && (resultCode == Activity.RESULT_OK))
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, JadwalKehadiranFragment.newInstance()).commit();
    }

    private void dataPIC() {
        try
        {
            rslt="START";
            CallerJadwalUserPIC c=new CallerJadwalUserPIC();
            c.a=((Config) getActivity().getApplication()).getID_USER();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
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

    private void dataPJ() {
        try
        {
            rslt="START";
            CallerJadwalUserPJ c=new CallerJadwalUserPJ();
            c.a=((Config) getActivity().getApplication()).getID_USER();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getActivity().getApplicationContext(),lines[0], Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void dataAdmin() {
        try
        {
            rslt="START";
            CallerJadwalUserAdmin c=new CallerJadwalUserAdmin();
//            c.a=((Config) getActivity().getApplication()).getID_USER();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getActivity().getApplicationContext(),lines[0], Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void data2() {
        try
        {
            rslt2="START";
            CallerJadwalDetailUser c=new CallerJadwalDetailUser();
            c.a=((Config) getActivity().getApplication()).getID_KEHADIRAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt2=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
//            mobileArray = rslt2.split("\\|");
//            ad.setTitle("TES");
//            ad.setMessage(rslt2);
            Toast.makeText(getActivity().getApplicationContext(),rslt2, Toast.LENGTH_LONG).show();;
        }catch(Exception ex) {
            Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Rencana Kehadiran");
    }
}
