import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Expression implements Parser, Calc{
    private int a;
    private int b;
    private String sign;
    private int result;

    public int getResult() {
        return result;
    }

    @Override
    public void parseArabic(String s) {
        Pattern pattern = Pattern.compile("(\\A[0-9]+)([\\-\\+\\*\\/])([0-9]+\\Z)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        a = parseInt(matcher.group(1));
        sign = matcher.group(2);
        b = parseInt(matcher.group(3));
        calculate();
    }

    @Override
    public void parseRoman(String s) {
        Pattern pattern = Pattern.compile("(\\A[IVXLCDM]+)([\\-\\+\\*\\/])([IVXLCDM]+\\Z)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        a = Converter.romanToArabic(matcher.group(1));
        sign = matcher.group(2);
        b = Converter.romanToArabic(matcher.group(3));
        calculate();
    }

    @Override
    public void calculate() {
        switch (sign) {
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("*"):
                result = a * b;
                break;
            case ("/"):
                result = a / b;
                break;
        }
    }
}
