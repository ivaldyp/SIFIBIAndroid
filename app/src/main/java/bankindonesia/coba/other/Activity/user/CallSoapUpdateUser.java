package bankindonesia.coba.other.Activity.user;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import bankindonesia.coba.other.Config;


public class CallSoapUpdateUser
{
    public final String SOAP_ACTION = "http://tempuri.org/UpdateUsers";
    public  final String OPERATION_NAME = "UpdateUsers";
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public  final String SOAP_ADDRESS = Config.LOGIN_ASP;

    public CallSoapUpdateUser()
    {
    }

    public String Call(int a, String b, String c, String d, String e, String f)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();pi.setName("id_users");pi.setValue(a);pi.setType(Integer.class);request.addProperty(pi);
        PropertyInfo pi2=new PropertyInfo();pi2.setName("nama_users");pi2.setValue(b);pi2.setType(String.class);request.addProperty(pi2);
        PropertyInfo pi3=new PropertyInfo();pi3.setName("satker_users");pi3.setValue(c);pi3.setType(String.class);request.addProperty(pi3);
        PropertyInfo pi4=new PropertyInfo();pi4.setName("email_users");pi4.setValue(d);pi4.setType(String.class);request.addProperty(pi4);
        PropertyInfo pi5=new PropertyInfo();pi5.setName("password_users");pi5.setValue(e);pi5.setType(String.class);request.addProperty(pi5);
        PropertyInfo pi6=new PropertyInfo();pi6.setName("jabatan_users");pi6.setValue(f);pi6.setType(String.class);request.addProperty(pi6);;


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