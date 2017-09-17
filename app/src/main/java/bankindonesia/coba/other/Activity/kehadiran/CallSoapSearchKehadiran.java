package bankindonesia.coba.other.Activity.kehadiran;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import bankindonesia.coba.other.Config;


public class CallSoapSearchKehadiran
{
    public final String SOAP_ACTION = "http://tempuri.org/SearchKehadiran";
    public  final String OPERATION_NAME = "SearchKehadiran";
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public  final String SOAP_ADDRESS = Config.LOGIN_ASP;

    public CallSoapSearchKehadiran()
    {
    }

    public String Call(String a, String b)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();pi.setName("input1");pi.setValue(a);pi.setType(String.class);request.addProperty(pi);
        PropertyInfo pi2=new PropertyInfo();pi2.setName("input2");pi2.setValue(b);pi2.setType(String.class);request.addProperty(pi2);

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