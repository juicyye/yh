package hello.hellojpa.web.frontcontroller.v3.controller;

import hello.hellojpa.web.frontcontroller.ModelView;
import hello.hellojpa.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", username);
        return modelView;
    }
}
