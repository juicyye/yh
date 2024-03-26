package hello.thymeleafbasic.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        // "1,000" -> 1000
        NumberFormat format = NumberFormat.getInstance(locale);
        Number parse = format.parse(text);
        return parse;
    }

    @Override
    public String print(Number object, Locale locale) {
        NumberFormat instance = NumberFormat.getInstance(locale);
        return instance.format(object);
    }
}
