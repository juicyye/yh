package hello.hellojpa.web.frontcontroller.v3;

import hello.hellojpa.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
