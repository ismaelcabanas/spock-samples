package cabanas.garcia.ismael.sample.spock;

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
}
