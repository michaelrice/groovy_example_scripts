String xml = """<?xml version="1.0" encoding="utf-8"?>
<output xmlns="http://www.vmware.com/Products/ESX/5.0/esxcli">
<root>
   <structure typeName="Cpu">
      <field name="CPUCores">
         <integer>4</integer>
      </field>
      <field name="CPUPackages">
         <integer>1</integer>
      </field>
      <field name="CPUThreads">
         <integer>4</integer>
      </field>
      <field name="HVReplayCapable">
         <boolean>false</boolean>
      </field>
      <field name="HVReplayDisabledReasons">
         <list type="string">
            <string>incompatible CPU</string>
         </list>
      </field>
      <field name="HVSupport">
         <integer>0</integer>
      </field>
      <field name="HyperthreadingActive">
         <boolean>false</boolean>
      </field>
      <field name="HyperthreadingEnabled">
         <boolean>true</boolean>
      </field>
      <field name="HyperthreadingSupported">
         <boolean>false</boolean>
      </field>
   </structure>
</root>
</output>"""

def results = new XmlSlurper().parseText(xml).declareNamespace(['esxcli': 'http://www.vmware.com/Products/ESX/5.0/esxcli/'])

results = results.'root'.'structure'.'field'

Map cpu_info = [:]
results.each {
    cpu_info << ["${it.'@name'}": it]
}

println cpu_info
