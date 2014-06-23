List files = [
        "Fluxbox-wiki-br-howtos.xml",
        "Fluxbox-wiki-en-howtos.xml",
        "Fluxbox-wiki-fin-howtos.xml",
        "Fluxbox-wiki-it-howtos.xml",
        "Fluxbox-wiki-ru-howtos.xml",
        "Fluxbox-wiki-de-howtos.xml",
        "Fluxbox-wiki-es-howtos.xml",
        "Fluxbox-wiki-fr-howtos.xml",
        "Fluxbox-wiki-ko-howtos.xml"
]
files.each {
    def foo = new XmlSlurper().parse(new File("/home/errr/Downloads/${it}"))
    def pages = foo.page
    println pages.size()

    String title
    String countrycode = it.toString().split("-")[2]
    pages.each { wikipage ->
        title = wikipage.title
        title = title.replaceAll(" ", "_")
        title = title.replaceAll("/", "-")
        title = title.replaceAll(":", "-")
        tfile = new File("/home/errr/programs/fluxbox-wiki.org/category/howtos/${countrycode}/${title}")
        tfile.withWriter { out ->
            out.write(wikipage.revision.text)
        }
    }
}