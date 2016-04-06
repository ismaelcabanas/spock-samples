package cabanas.garcia.ismael.specs.spock

import spock.lang.Specification

import java.nio.file.Paths

/**
 * Created by Ismael on 04/04/2016.
 */
class UpperCaseSpec extends Specification{

    def UpperCaseConverter upperCaseConverter

    def "Convierte una lista de cadenas a mayúsculas"(){

        given:"Dada una lista con dos cadenas"
        def str1 = "spock"
        def str2 = "framework"
        def list = new ArrayList<String>()
        list.add(str1)
        list.add(str2);
    }

}
