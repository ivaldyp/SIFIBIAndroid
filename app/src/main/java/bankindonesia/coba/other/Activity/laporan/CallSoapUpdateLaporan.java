package bankindonesia.coba.other.Activity.laporan;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import bankindonesia.coba.other.Config;


public class CallSoapUpdateLaporan
{
    public final String SOAP_ACTION = "http://tempuri.org/UpdateHasilSidang";
    public  final String OPERATION_NAME = "UpdateHasilSidang";
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public  final String SOAP_ADDRESS = Config.LOGIN_ASP;

    public CallSoapUpdateLaporan()
    {
    }

    public String Call(int a,String spinnerSatker,String editTextPlace, String textdate, String namafora, String namaworkinggroup,
                       String delegasiBI, String delegasiterkait,String negaramitra,String agenda,String relevansi,String stanceBI,String stancePosisi,
                       String stancemitra,String kesepakatan,String kesepakatan2,String pending,String rencana,String foralain,
                       String editTextSatker,String jadwal,String lembagalain)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi21=new PropertyInfo();pi21.setName("id_sidang");             pi21.setValue(a);pi21.setType(Integer.class);request.addProperty(pi21);
        PropertyInfo pi=new PropertyInfo();pi.setName("nama_satker");               pi.setValue(spinnerSatker);pi.setType(String.class);request.addProperty(pi);
        PropertyInfo pi1=new PropertyInfo();pi1.setName("tempat_sidang");           pi1.setValue(editTextPlace);pi1.setType(String.class);request.addProperty(pi1);
        PropertyInfo pi2=new PropertyInfo();pi2.setName("waktu_sidang");            pi2.setValue(textdate);pi2.setType(String.class);request.addProperty(pi2);
        PropertyInfo pi3=new PropertyInfo();pi3.setName("nama_fora");               pi3.setValue(namafora);pi3.setType(String.class);request.addProperty(pi3);
        PropertyInfo pi4=new PropertyInfo();pi4.setName("nama_working_group");      pi4.setValue(namaworkinggroup);pi4.setType(String.class);request.addProperty(pi4);
        PropertyInfo pi5=new PropertyInfo();pi5.setName("delegasi_bi");             pi5.setValue(delegasiBI);pi5.setType(String.class);request.addProperty(pi5);
        PropertyInfo pi6=new PropertyInfo();pi6.setName("delegasi_terkait");        pi6.setValue(delegasiterkait);pi6.setType(String.class);request.addProperty(pi6);
        PropertyInfo pi7=new PropertyInfo();pi7.setName("negara_mitra");            pi7.setValue(negaramitra);pi7.setType(String.class);request.addProperty(pi7);
        PropertyInfo pi8=new PropertyInfo();pi8.setName("agenda_pembahasan");       pi8.setValue(agenda);pi8.setType(Integer.class);request.addProperty(pi8);
        PropertyInfo pi9=new PropertyInfo();pi9.setName("relevansi");               pi9.setValue(relevansi);pi9.setType(String.class);request.addProperty(pi9);
        PropertyInfo pi10=new PropertyInfo();pi10.setName("stance_bi");             pi10.setValue(stanceBI);pi10.setType(String.class);request.addProperty(pi10);
        PropertyInfo pi11=new PropertyInfo();pi11.setName("stance_posisi_terkait"); pi11.setValue(stancePosisi);pi11.setType(String.class);request.addProperty(pi11);
        PropertyInfo pi12=new PropertyInfo();pi12.setName("stance_negara_mitra");   pi12.setValue(stancemitra);pi12.setType(String.class);request.addProperty(pi12);
        PropertyInfo pi13=new PropertyInfo();pi13.setName("kesepakatan_telah");     pi13.setValue(kesepakatan);pi13.setType(String.class);request.addProperty(pi13);
        PropertyInfo pi14=new PropertyInfo();pi14.setName("kesepakatan_akan");      pi14.setValue(kesepakatan2);pi14.setType(String.class);request.addProperty(pi14);
        PropertyInfo pi15=new PropertyInfo();pi15.setName("pending_issues");        pi15.setValue(pending);pi15.setType(String.class);request.addProperty(pi15);
        PropertyInfo pi16=new PropertyInfo();pi16.setName("rencana_tidak_lanjut");  pi16.setValue(rencana);pi16.setType(Integer.class);request.addProperty(pi16);
        PropertyInfo pi17=new PropertyInfo();pi17.setName("fora_lain");             pi17.setValue(foralain);pi17.setType(String.class);request.addProperty(pi17);
        PropertyInfo pi18=new PropertyInfo();pi18.setName("satker_lain");           pi18.setValue(editTextSatker);pi18.setType(String.class);request.addProperty(pi18);
        PropertyInfo pi19=new PropertyInfo();pi19.setName("jadwal_sidang_next");    pi19.setValue(jadwal);pi19.setType(String.class);request.addProperty(pi19);
        PropertyInfo pi20=new PropertyInfo();pi20.setName("lembaga_lain");          pi20.setValue(lembagalain);pi20.setType(String.class);request.addProperty(pi20);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION, envelope);
            response = envelope.getResponse();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }
}
