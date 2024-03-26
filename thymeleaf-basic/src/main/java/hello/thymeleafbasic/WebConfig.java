package hello.thymeleafbasic;

import hello.thymeleafbasic.converter.IntegerToString;
import hello.thymeleafbasic.converter.IpPortToStringConverter;
import hello.thymeleafbasic.converter.StringToIntegerConverter;
import hello.thymeleafbasic.converter.StringToIpPortConverter;
import hello.thymeleafbasic.formatter.MyNumberFormatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToString());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
