package by.kirill.text.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {

    public static List<String> handleText(String rawData, final String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawData);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            String element = matcher.group();
            result.add(element);
        }
        return result;
    }
}
