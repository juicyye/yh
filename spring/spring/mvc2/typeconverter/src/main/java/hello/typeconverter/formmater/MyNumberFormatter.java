package hello.typeconverter.formmater;

import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        NumberFormat instance = NumberFormat.getInstance(locale);
        return instance.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        NumberFormat instance = NumberFormat.getInstance(locale);
        return instance.format(object);
    }



}
