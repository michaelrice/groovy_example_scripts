import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil


Closure buildSoapPayload(String alarmVal, String entityVal) {
    Closure soapPayload = {
        'soap:Envelope'('xmlns:xsd': "http://www.w3.org/2001/XMLSchema", 'xmlns:xsi': "http://www.w3.org/2001/XMLSchema-instance", 'xmlns:soap': "http://schemas.xmlsoap.org/soap/envelope/") {
            'soap:Body' {
                vim25:SetAlarmStatus ('xmlns': "urn:vim25") {
                    vim25:_this ('xsi:type': "ManagedObjectReference", type: "AlarmManager", "AlarmManager")
                    vim25:alarm(type: "Alarm", alarmVal)
                    vim25:entity('xsi:type': "ManagedObjectReference", type: "HostSystem", entityVal)
                    vim25:status('' + "green")
                }
            }
        }
    }
    return soapPayload
}

Closure soapPayload = buildSoapPayload("alarm-1234", "host-12345")
StreamingMarkupBuilder builder = new StreamingMarkupBuilder()
builder.encoding = "UTF-8"
String xml = XmlUtil.serialize(builder.bind(soapPayload))
println(xml)
