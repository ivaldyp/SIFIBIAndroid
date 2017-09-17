package bankindonesia.coba.other.fragment.laporan.Admin;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import bankindonesia.coba.other.Config;


public class CallSoapTabelUserAdmin
{
    public final String SOAP_ACTION = "http://tempuri.org/SelectAllIDNamaTanggalHasilSidangAdmin";
    public  final String OPERATION_NAME = "SelectAllIDNamaTanggalHasilSidangAdmin";
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public  final String SOAP_ADDRESS = Config.LOGIN_ASP;

    public CallSoapTabelUserAdmin()
    {
    }
    public String Call()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
//        PropertyInfo pi=new PropertyInfo();
//        pi.setName("id_users");
//        pi.setValue(a);
//        pi.setType(Integer.class);
//        request.addProperty(pi);

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