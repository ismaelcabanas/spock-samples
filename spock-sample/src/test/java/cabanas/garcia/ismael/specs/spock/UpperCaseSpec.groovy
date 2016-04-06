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

            expect: "Debería devolver una lista de cadenas mayúsculas cuando aplicamos el UpperCaseConverter sobre una lista dada"
            def convertedList = upperCaseConverter.toUpperCase(list)
            convertedList.get(0) == "SPOCK"
            convertedList.get(1) == "FRAMEWORK"

            and: "Debería devolver una lista vacía cuando aplicamos el UpperCaseConverter sobre una lista vacía"
            def emptyConvertedList = upperCaseConverter.toUpperCase(new ArrayList<String>())
            emptyConvertedList.size() == 0

        }


    }
