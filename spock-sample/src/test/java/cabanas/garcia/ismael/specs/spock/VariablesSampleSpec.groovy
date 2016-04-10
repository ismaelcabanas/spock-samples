package cabanas.garcia.ismael.specs.spock

import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by Ismael on 08/04/2016.
 */
class VariablesSampleSpec extends Specification{
    static final message = "Hola mundo!"

    def obj1 = new Object()

    @Shared
    def obj2 = new Object()

    def setupSpec(){
        println("Setup de la especificación")
    }
    def setup(){
        println("Setup de la feature")
    }
    def cleanup(){
        println("Cleanup de la feature")
    }
    def cleanupSpec(){
        print("Cleanup de la especificación")
    }

    def "first feature method"(){

        println("Primer método de la feature")
        println("Objeto obj1: " + obj1.toString())
        println("Objeto obj2: " + obj2.toString())

        when: "Mensaje se transforma en minúsculas"
        def result = message.toLowerCase()

        then: "El mensaje se debería haber transformado en minúsculas"
        result == "hola mundo!"

    }

    def "second feature method"(){

        println("Segundo método de la feature")
        println("Objeto obj1: " + obj1.toString())
        println("Objeto obj2: " + obj2.toString())

        when: "Mensaje se transforma en mayúsculas"
        def result = message.toUpperCase()

        then: "El mensaje se debería haber transformado en mayúsculas"
        result == "HOLA MUNDO!"

    }

}
