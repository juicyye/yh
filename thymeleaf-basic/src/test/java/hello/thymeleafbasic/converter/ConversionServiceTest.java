package hello.thymeleafbasic.converter;

import hello.thymeleafbasic.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new IntegerToString());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIntegerConverter());

        Integer result = conversionService.convert("10", Integer.class);
        String result2 = conversionService.convert(10, String.class);
        IpPort convert = conversionService.convert("127.0.1.0.1:8080", IpPort.class);
        String convert1 = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);


    }
}
