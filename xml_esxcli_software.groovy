def file = new File('esxcli_software.xml')

def results = new XmlSlurper().parse(file).declareNamespace(['esxcli': 'http://www.vmware.com/Products/ESX/5.0/esxcli/'])

results = results.'root'.'list'.'structure'

def result = results.findAll { it.'field'.'string' =~ /OpenM/ }

List res = []
result.each {
    def result_fields = it.field
    Map ires = [:]
    result_fields.each { myresult ->
        ires << ["${myresult.'@name'}": myresult]
    }
    res << ires
}

println res
