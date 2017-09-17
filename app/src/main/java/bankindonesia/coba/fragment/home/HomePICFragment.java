package bankindonesia.coba.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import bankindonesia.coba.R;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.home.CallerHomePIC;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePICFragment extends Fragment {

    private TextView nama;
    private TextView satker;
    private TextView email;
    private TextView jabatan;
    private TextView countKehadiran;
    private TextView countPenyelenggaraan;
    private TextView countLaporan;

    private String[] array;

    public static String rslt="";

    public HomePICFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home_pic, container, false);
        View view = inflater.inflate(R.layout.fragment_home_pic, container, false);

        data();

        nama = (TextView) view.findViewById(R.id.nama);
        satker = (TextView) view.findViewById(R.id.satker);
        email = (TextView) view.findViewById(R.id.email);
        jabatan = (TextView) view.findViewById(R.id.jabatan);
        countKehadiran = (TextView) view.findViewById(R.id.countKehadiran);
        countPenyelenggaraan = (TextView) view.findViewById(R.id.countPenyelenggaraan);
        countLaporan = (TextView) view.findViewById(R.id.countLaporan);

        nama.setText(array[0]);
        satker.setText(array[1]);
        email.setText(array[2]);
        jabatan.setText(array[3]);
        countKehadiran.setText(array[4]);
        countPenyelenggaraan.setText(array[5]);
        countLaporan.setText(array[6]);

        return view;
    }

    private void data() {
        try
        {
            rslt="START";
            CallerHomePIC c=new CallerHomePIC();
            c.a=((Config) getActivity().getApplication()).getID_USER();
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
//            Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();;
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
        getActivity().setTitle("Beranda");
    }

}
