package hello.thymeleafbasic.converter;

import org.junit.jupiter.api.Test;

public class ConverterTest {


    @Test
    void stringToInterger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        converter.convert("10");
    }
}
