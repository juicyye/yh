package hello.hellojpa.web.frontcontroller.v2.controller;

import hello.hellojpa.web.frontcontroller.MyView;
import hello.hellojpa.web.frontcontroller.v1.ControllerV1;
import hello.hellojpa.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("v2 list");
    }
}
