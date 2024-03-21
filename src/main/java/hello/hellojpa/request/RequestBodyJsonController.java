package hello.hellojpa.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellojpa.Hello;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class RequestBodyJsonController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messagebody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        Hello hello = objectMapper.readValue(messagebody, Hello.class);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(HttpEntity<Hello> messagebody) throws IOException {
        Hello body = messagebody.getBody();



    }
}
