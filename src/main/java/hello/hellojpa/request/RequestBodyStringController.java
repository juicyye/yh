package hello.hellojpa.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class RequestBodyStringController {
    @PostMapping("/request-body-string-v2")
    public HttpEntity<String> requestBodyStringV2(HttpEntity<String> httpEntity) {
        String body = httpEntity.getBody();

        return new HttpEntity<>("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
        String body = httpEntity.getBody();

        return new HttpEntity<>("ok");
    }
    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {


        return "ok";
    }
}
