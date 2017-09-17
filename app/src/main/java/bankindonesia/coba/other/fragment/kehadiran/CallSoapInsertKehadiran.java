package bankindonesia.coba.other.Activity.kehadiran;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import bankindonesia.coba.other.Config;


public class CallSoapInsertKehadiran
{
    public final String SOAP_ACTION = "http://tempuri.org/InsertRencanaKehadiran";
    public  final String OPERATION_NAME = "InsertRencanaKehadiran";
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public  final String SOAP_ADDRESS = Config.LOGIN_ASP;

    public CallSoapInsertKehadiran()
    {
    }

    public String Call(int a, String b, String c, String d, String e, String f, String g, String h, String i)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi2=new PropertyInfo();pi2.setName("periode_kehadiran");pi2.setValue(b);pi2.setType(String.class);request.addProperty(pi2);
        PropertyInfo pi3=new PropertyInfo();pi3.setName("nama_satker");pi3.setValue(c);pi3.setType(String.class);request.addProperty(pi3);
        PropertyInfo pi4=new PropertyInfo();pi4.setName("nama_event");pi4.setValue(d);pi4.setType(String.class);request.addProperty(pi4);
        PropertyInfo pi5=new PropertyInfo();pi5.setName("tempat_event");pi5.setValue(e);pi5.setType(String.class);request.addProperty(pi5);
        PropertyInfo pi6=new PropertyInfo();pi6.setName("waktu_event");pi6.setValue(f);pi6.setType(String.class);request.addProperty(pi6);
        PropertyInfo pi7=new PropertyInfo();pi7.setName("delegasi_adg");pi7.setValue(g);pi7.setType(String.class);request.addProperty(pi7);
        PropertyInfo pi8=new PropertyInfo();pi8.setName("delegasi_satker");pi8.setValue(h);pi8.setType(String.class);request.addProperty(pi8);
        PropertyInfo pi9=new PropertyInfo();pi9.setName("topik");pi9.setValue(i);pi9.setType(String.class);request.addProperty(pi9);
        PropertyInfo pi=new PropertyInfo();pi.setName("id_users");pi.setValue(a);pi.setType(Integer.class);request.addProperty(pi);

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
