package bankindonesia.coba.fragment.laporan;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import java.util.ArrayList;

import bankindonesia.coba.R;
import bankindonesia.coba.activity.TabelDetailLaporanActivity;
import bankindonesia.coba.activity.TabelDetailLaporanVerifikasiActivity;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.laporan.Admin.CallerTabelUserAdmin;
import bankindonesia.coba.other.fragment.laporan.CallerTabelDetailUser;
import bankindonesia.coba.other.fragment.laporan.PIC.CallerTabelUserPIC;
import bankindonesia.coba.other.fragment.laporan.PJ.CallerTabelUserPJ;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabelLaporanFragment extends Fragment {

    private ListView listView;
    private String[] mobileArray;
    private String kalimat = "Android,IPhone,WindowsMobile,Blackberry,WebOS,Ubuntu,Windows7,Max OS X,aaa,aaa,aaa,aaa,aaa,aaa,aaa,aaa";

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private String[] lines;
    private String[][] array;
    private android.app.AlertDialog ad;
    public static String rslt="";
    public static String rslt2="";

    public static TabelLaporanFragment newInstance() {
        return new TabelLaporanFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tabel_laporan, container, false);

        if(((Config) getActivity().getApplication()).getID_JABATAN()==2)
            dataPIC();
        else if(((Config) getActivity().getApplication()).getID_JABATAN()==3)
            dataPJ();
        else
            dataAdmin();

//        mobileArray = kalimat.split(",");
//        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, mobileArray);
        listView = (ListView) view.findViewById(R.id.mobile_list);

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
            for(int i = 0; i < array.length; i++){
                if(array[i][3].compareTo("0")==0) array[i][3]="Belum";
                else if (array[i][3].compareTo("1")==0) array[i][3]="Sudah";
                else array[i][3]="Error";
                adapter.add("Nama Event: "+array[i][1]+"\nTanggal Event: "+array[i][2]+"\nVerifikasi: "+array[i][3]);
            }
            listView.setAdapter(adapter);
        }

//        ArrayList list = new ArrayList<String>();
//        for(int i = 0; i < array.length; i++) {
//            if(array[i][3].compareTo("0")==0) array[i][3]="Belum";
//            else if (array[i][3].compareTo("1")==0) array[i][3]="Sudah";
//            else array[i][3]="Error";
//            list.add("Nama Event: "+array[i][1]+"\nTanggal Event: "+array[i][2]+"\nVerifikasi: "+array[i][3]);
//        }
//        listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, list) {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View row = super.getView(position, convertView, parent);
//
//                if(getItem(position).contains("Belum"))
//                {
//                    // do something change color
//                    row.setBackgroundColor (Color.RED); // some color
//                }
////                else
////                {
////                    // default state
////                    row.setBackgroundColor (Color.WHITE); // default coloe
////                }
//                return row;
//            }
//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position);
                int id_laporan = Integer.parseInt(array[position][0]);
                ((Config) getActivity().getApplication()).setID_LAPORAN(id_laporan);
                data2();
                if(value.compareTo("Data Kosong")!=0){
                    if(((Config) getActivity().getApplication()).getID_JABATAN()==2 || mobileArray[22].compareTo("1")==0){
                        Intent intent = new Intent(getActivity(), TabelDetailLaporanActivity.class);
                        startActivityForResult(intent, 10001);
//                        Toast.makeText(getActivity().getApplicationContext(), "belom", Toast.LENGTH_LONG).show();
                    }
                    else{
//                        Toast.makeText(getActivity().getApplicationContext(), "sudah", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity(), TabelDetailLaporanVerifikasiActivity.class);
                        startActivityForResult(intent, 10001);
                    }
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
                    for(int i = 0; i < array.length; i++){
                        if(array[i][3].compareTo("0")==0) array[i][3]="Belum";
                        else if (array[i][3].compareTo("1")==0) array[i][3]="Sudah";
                        else array[i][3]="Error";
                        adapter.add("Nama Event: "+array[i][1]+"\nTanggal Event: "+array[i][2]+"\nVerifikasi: "+array[i][3]);
                    }
                    listView.setAdapter(adapter);
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001) && (resultCode == Activity.RESULT_OK))
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, TabelLaporanFragment.newInstance()).commit();
    }

    private void dataPIC() {
        try
        {
            rslt="START";
            CallerTabelUserPIC c=new CallerTabelUserPIC();
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

    private void dataPJ() {
        try
        {
            rslt="START";
            CallerTabelUserPJ c=new CallerTabelUserPJ();
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
            CallerTabelUserAdmin c=new CallerTabelUserAdmin();
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
            CallerTabelDetailUser c=new CallerTabelDetailUser();
            c.a=((Config) getActivity().getApplication()).getID_LAPORAN();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt2=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            mobileArray = rslt2.split("\\|");
//            ad.setTitle("TES");
//            ad.setMessage(rslt2);
//            Toast.makeText(getActivity().getApplicationContext(),mobileArray[1], Toast.LENGTH_LONG).show();;
//            Toast.makeText(getActivity().getApplicationContext(),rslt2, Toast.LENGTH_LONG).show();;
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
        getActivity().setTitle("Laporan Hasil Sidang");
    }

}
