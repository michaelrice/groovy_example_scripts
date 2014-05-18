// stupid little example to help me visualize what happens in try catches

class TestException extends Exception {
    TestException(String message) {
        super(message)
    }
}

void foo() throws TestException {

    try {
        println "hello world"
        throw new Exception("yikes")
    }
    catch(Exception e) {
        println e.message
        println e.getClass()
        throw new TestException(e.message)
    }
}

try {
    foo()
}
catch(TestException te) {
    println "I caught te: ${te.message}"
}

