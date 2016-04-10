package cabanas.garcia.ismael.sample.spock;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ismael on 06/04/2016.
 */
public class UpperCaseConverter {
    public List<String> toUpperCase(List<String> items) {
        List<String> upperCaseList = new ArrayList<>();

        items.forEach(item -> {upperCaseList.add(item.toUpperCase());});

        return upperCaseList;
    }

    public String toUpperCase(String string) throws UpperCaseConverterException {
        if(isNumeric(string))
            throw new UpperCaseConverterException();
        return string.toUpperCase();
    }

    public List<String> toUpperCase(File file) {
        List<String> upperCaseList = new ArrayList<>();

        if(file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine()) != null) {
                    upperCaseList.add(line.toUpperCase());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return upperCaseList;
    }

    private boolean isNumeric(String string) {
        boolean result = true;
        try{
            Integer.parseInt(string);
        }
        catch (NumberFormatException e){
            result = false;
        }
        return result;
    }
}
