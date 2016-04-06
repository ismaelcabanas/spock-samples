package cabanas.garcia.ismael.specs.spock

import cabanas.garcia.ismael.sample.spock.UpperCaseConverter
import spock.lang.Specification

import java.nio.file.Paths

/**
 * Created by Ismael on 04/04/2016.
 */
class UpperCaseSpec extends Specification{

    def UpperCaseConverter upperCaseConverter

    def "Convierte una lista de cadenas a mayúsculas"(){

        given: "Dada una lista con dos cadenas"
        def str1 = "spock"
        def str2 = "framework"
        def list = new ArrayList<String>()
        list.add(str1)
        list.add(str2)
        upperCaseConverter = new UpperCaseConverter()

        when: "Cuando aplicamos el UpperCaseConverter sobre la lista"
        List<String> convertedList = upperCaseConverter.toUpperCase(list)

        then: "Entonces todas las cadenas de la lista están en mayúsculas"
        convertedList.get(0) == "SPOCK"
        convertedList.get(1) == "FRAMEWORK"

    }


}
