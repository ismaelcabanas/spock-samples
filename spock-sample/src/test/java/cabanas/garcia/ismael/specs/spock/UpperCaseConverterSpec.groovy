    package cabanas.garcia.ismael.specs.spock

    import cabanas.garcia.ismael.sample.spock.UpperCaseConverter
    import cabanas.garcia.ismael.sample.spock.UpperCaseConverterException
    import spock.lang.Specification

    import java.nio.file.Paths

    /**
     * Created by Ismael on 04/04/2016.
     */
    class UpperCaseConverterSpec extends Specification{

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

        def "Convierte el contenido de un fichero a mayúsculas"(){

            given: "Dado un fichero con contenido y un fichero vacío"
            def pathToEmptyFile = Paths.get("empty.txt")
            def emptyFile = pathToEmptyFile.toFile()
            def pathToFile = Paths.get("foo.txt")
            pathToFile.write("spock\nframework")
            def file = pathToFile.toFile()
            upperCaseConverter = new UpperCaseConverter()

            expect: "Debería devolver una lista de cadenas mayúsculas cuando aplicamos el UpperCaseConverter sobre un fichero dado con contenido"
            def convertedList = upperCaseConverter.toUpperCase(file)
            convertedList.get(0) == "SPOCK"
            convertedList.get(1) == "FRAMEWORK"

            and: "Debería devolver una lista vacía cuando aplicamos el UpperCaseConverter sobre un fichero vacío"
            def emptyConvertedList = upperCaseConverter.toUpperCase(emptyFile)
            emptyConvertedList.size() == 0

            cleanup:
            emptyFile.delete()
            file.delete()

        }

        def "Debería lanzar una UpperCaseConverterException al convertir una cadena numérica" (){

            given: "Dado una cadena numérica"
            def numericString = "123"
            upperCaseConverter = new UpperCaseConverter()

            when: "Cuando se convierte a mayúsculas la cadena numérica"
            upperCaseConverter.toUpperCase(numericString)

            then: "Entonces debería lanzar una excepción de tipo UpperCaseConverterException"
            thrown(UpperCaseConverterException) // se pueden eliminar los paréntesis

        }
    }
