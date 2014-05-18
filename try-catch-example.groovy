// stupid little example to help me visualize what happens in try catches

class TestException extends Exception {
    TestException(String message) {
        super(message)
    }
}

void foo() throws TestException {

    try {
        println "hello world"
        throw new TestException("yikes")
    }
    catch(Exception e) {
        println "re throwing"
        throw e
    }
}

try {
    foo()
}
catch(TestException te) {
    println "I caught te: ${te.message}"
}
