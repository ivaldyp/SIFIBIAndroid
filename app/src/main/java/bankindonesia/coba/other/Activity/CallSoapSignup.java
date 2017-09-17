package bankindonesia.coba.other.Activity;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import bankindonesia.coba.other.Config;

public class CallSoapSignup
{
    public final String SOAP_ACTION = "http://tempuri.org/InsertUsers";
    public  final String OPERATION_NAME = "InsertUsers";
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public  final String SOAP_ADDRESS = Config.LOGIN_ASP;

    public CallSoapSignup()
    {
    }
    public String Call(String a, String b, String c, String d, int e)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();pi.setName("nama_users");pi.setValue(a);pi.setType(String.class);request.addProperty(pi);
        PropertyInfo pi2=new PropertyInfo();pi2.setName("satker_users");pi2.setValue(b);pi2.setType(String.class);request.addProperty(pi2);
        PropertyInfo pi3=new PropertyInfo();pi3.setName("email_users");pi3.setValue(c);pi3.setType(String.class);request.addProperty(pi3);
        PropertyInfo pi4=new PropertyInfo();pi4.setName("password_users");pi4.setValue(d);pi4.setType(String.class);request.addProperty(pi4);
        PropertyInfo pi5=new PropertyInfo();pi5.setName("jabatan_users");pi5.setValue(e);pi5.setType(Integer.class);request.addProperty(pi5);

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