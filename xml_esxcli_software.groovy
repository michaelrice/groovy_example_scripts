def file = new File('esxcli_software.xml')

def results = new XmlSlurper().parse(file).declareNamespace(['esxcli': 'http://www.vmware.com/Products/ESX/5.0/esxcli/'])

results = results.'root'.'list'.'structure'

def result = results.find { it.'field'.'string' =~ /OpenManage/ }

def result_fields = result.field
Map res = [:]
result_fields.each {
    res << ["${it.'@name'}": it]
}

println res
