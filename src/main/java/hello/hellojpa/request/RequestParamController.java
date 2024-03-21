package hello.hellojpa.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class RequestParamController {

    @RequestMapping("/request-param-v2")
    public String requestParamV1(@RequestParam(value = "memberName",required = false) String memberName,
                               @RequestParam("age") int memberAge) {
        log.info("memberName = {}, age = {} ", memberName, memberAge);
        return "ok";
    }
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(value = "memberName",defaultValue = "guest") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("memberName = {}, age = {} ", memberName, memberAge);
        return "ok";
    }

    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, String> paramMap) {
        log.info("memberName = {}, age = {} ",paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }


}
