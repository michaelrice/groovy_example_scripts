def foo = new XmlSlurper().parse(new File('/home/errr/Downloads/fluxbox-wiki/Category_Howtos/Fluxbox-wiki-20140621231421.xml'))
def pages = foo.page
println pages.size()

String title
pages.each {
    title = it.title
    title = title.replaceAll(" ","_")
    title = title.replaceAll("/", "-")
    title = title.replaceAll(":", "-")
    tfile = new File("/home/errr/programs/fluxbox-wiki.org/${title}")
    tfile.withWriter { out ->
        out.write(it.revision.text)
    }
}
