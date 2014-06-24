String xml = """<?xml version="1.0"?>
<output xmlns:esxcli="http://www.vmware.com/Products/ESX/5.0/esxcli/">
    <list type="structure">
        <structure typeName="VMKPing">
            <field name="Trace">
                <list type="structure">
                    <structure typeName="VMKPingTrace">
                        <field name="Received Bytes"><int>64</int></field>
                        <field name="Host"><string>8.8.8.8</string></field>
                        <field name="ICMP Seq"><int>0</int></field>
                        <field name="TTL"><int>63</int></field>
                        <field name="Round-trip Time MS"><int>56950</int></field>
                        <field name="Dup"><bool>false</bool></field>
                        <field name="Detail"><string></string></field>
                    </structure>
                </list>
            </field>
            <field name="Summary">
                <structure typeName="VMKPingSummary">
                    <field name="Host Addr"><string>8.8.8.8</string></field>
                    <field name="Transmitted"><int>1</int></field>
                    <field name="Recieved"><int>1</int></field>
                    <field name="Duplicated"><int>0</int></field>
                    <field name="Packet Lost"><int>0</int></field>
                    <field name="Round-trip Min MS"><int>56950</int></field>
                    <field name="Round-trip Avg MS"><int>56950</int></field>
                    <field name="Round-trip Max MS"><int>56950</int></field>
                </structure>
            </field>
        </structure>
    </list>
</output>"""

def results = new XmlSlurper().parseText(xml).declareNamespace(['esxcli': 'http://www.vmware.com/Products/ESX/5.0/esxcli/'])
results = results.list
def vmk_ping_summary_fields = results.':structure'.':field'.':structure'.':field'
assert 8 == vmk_ping_summary_fields.size()
def output = vmk_ping_summary_fields.find { it.'@name' == 'Packet Lost' }
println "Packets lost: ${output}"
