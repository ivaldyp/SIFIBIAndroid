package bankindonesia.coba.fragment.kehadiran;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import bankindonesia.coba.R;
import bankindonesia.coba.activity.JadwalDetailKehadiran2Activity;
import bankindonesia.coba.other.Config;
import bankindonesia.coba.other.fragment.kehadiran.CallerView2Kehadiran;
import bankindonesia.coba.other.fragment.kehadiran.CallerViewKehadiran;

public class ViewKehadiranFragment extends Fragment {

    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    CompactCalendarView compactCalendar;
    private TextView textmonth;
    private ListView listView;
    private String[] mobileArray;
    public static String rslt="";
    private String[] lines;
    private String[][] array;
    private String[][] array2;
    private String tanggal;

    public ViewKehadiranFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_kehadiran, container, false);
        compactCalendar = (CompactCalendarView) view.findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        textmonth = (TextView) view.findViewById(R.id.textmonth);

        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        data();
//        data2();

//        textmonth.setText();
        textmonth.setText(dateFormatForMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));

        for(int i = 0; i < array.length; i++) {
            if(array[i][2].compareTo("NULL")==0) {

            } else{
                long millis= Long.parseLong(array[i][2]);

                Event ev1  = new Event(Color.BLUE, millis, array[i][1]);
                compactCalendar.addEvent(ev1, true);
            }
        }

//        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, mobileArray);
        listView = (ListView) view.findViewById(R.id.mobile_list);
//        listView.setAdapter(adapter);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
//                Context context = getActivity().getApplicationContext();
//                Arrays.fill(lines,"");
//                Arrays.fill(mobileArray,"");
//                for (int i = 0; i < array2.length; i++)
//                    Arrays.fill(array2[i], "");

                tanggal=dateClicked.toString();
                data2();

                if(rslt.compareTo("Data Kosong")==0){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
                    adapter.add("Tidak ada Event di tanggal tersebut");
                    listView.setAdapter(adapter);
//                    Toast.makeText(getActivity().getApplicationContext(),"Tidak ada Event di tanggal tersebut", Toast.LENGTH_LONG).show();
                } else if(rslt.contains("~")){
                    lines = rslt.split("~");
                    array2 = new String[lines.length][];
                    for (int i=0; i<lines.length; i++)
                        array2[i] = lines[i].split("\\|");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
                    for(int i = 0; i < array2.length; i++) {
                        adapter.add("Event: "+array2[i][1]+"\nTempat: "+array2[i][2]+"\nSatker: "+array2[i][3]);
                    }
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(getActivity().getApplicationContext(), array[position][0], Toast.LENGTH_LONG).show();
                        int id_kehadiran = Integer.parseInt(array2[position][0]);
                        ((Config) getActivity().getApplication()).setID_KEHADIRAN(id_kehadiran);
                        Intent intent = new Intent(getActivity(), JadwalDetailKehadiran2Activity.class);
                        startActivityForResult(intent, 10001);
//                        data2();
                        }
                    });
//                    Toast.makeText(getActivity().getApplicationContext(),array2[1][0], Toast.LENGTH_LONG).show();

                } else {
                    mobileArray = rslt.split("\\|");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview);
                    adapter.add("Event: "+mobileArray[1]+"\nTempat: "+mobileArray[2]+"\nSatker: "+mobileArray[3]);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(getActivity().getApplicationContext(), array[position][0], Toast.LENGTH_LONG).show();
                            int id_kehadiran = Integer.parseInt(mobileArray[0]);
                            ((Config) getActivity().getApplication()).setID_KEHADIRAN(id_kehadiran);
                            Intent intent = new Intent(getActivity(), JadwalDetailKehadiran2Activity.class);
                            startActivityForResult(intent, 10001);
//                            data2();
                        }
                    });
//                    Toast.makeText(getActivity().getApplicationContext(),mobileArray[0], Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
//                actionBar.setTitle(dateFormatForMonth.format(firstDayOfNewMonth));
                textmonth.setText(dateFormatForMonth.format(firstDayOfNewMonth));
            }
        });

        return view;
    }

    private void data() {
        try {
            rslt="START";
            CallerViewKehadiran c=new CallerViewKehadiran();
//            c.a=((Config) getActivity().getApplication()).getID_USER();
//            c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                }catch(Exception ex) {
                }
            }
            lines = rslt.split("~");
            array = new String[lines.length][];

            for (int i=0; i<lines.length; i++) {
                array[i] = lines[i].split("\\|");
            }

//            ad.setTitle("TES");
//            ad.setMessage(linesCsv[2][3]);
//            Toast.makeText(getActivity().getApplicationContext(),array[34][2], Toast.LENGTH_LONG).show();
//            Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
        }catch(Exception ex) {
            Toast.makeText(getActivity().getApplicationContext(),ex.toString()+"lalalala", Toast.LENGTH_LONG).show();
//            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
//        ad.show();
    }

    private void data2() {
        try
        {
            rslt="START";
            CallerView2Kehadiran c=new CallerView2Kehadiran();
            c.a=tanggal;
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
//            Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_LONG).show();
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
