package hello.thymeleafbasic.converter;

import org.springframework.core.convert.converter.Converter;

public class IntegerToString implements Converter<Integer,String> {
    @Override
    public String convert(Integer source) {
        return String.valueOf(source);
    }
}
