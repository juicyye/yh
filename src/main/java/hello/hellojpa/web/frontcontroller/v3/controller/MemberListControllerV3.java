package hello.hellojpa.web.frontcontroller.v3.controller;

import hello.hellojpa.web.frontcontroller.ModelView;
import hello.hellojpa.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", "members");
        return modelView;
    }
}
