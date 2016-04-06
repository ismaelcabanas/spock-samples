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
}
