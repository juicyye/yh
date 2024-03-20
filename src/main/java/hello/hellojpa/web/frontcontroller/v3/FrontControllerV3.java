package hello.hellojpa.web.frontcontroller.v3;

import hello.hellojpa.web.frontcontroller.ModelView;
import hello.hellojpa.web.frontcontroller.MyView;
import hello.hellojpa.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.hellojpa.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.hellojpa.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerMap  =new HashMap<>();

    public FrontControllerV3() {
        controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());


    }

    Map<String, String> paramMap = new HashMap<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3 controllerV3 = controllerMap.get(requestURI);
        request.getParameterNames().asIterator()
                .forEachRemaining(m -> paramMap.put(m, request.getParameter(m)));
        ModelView mv = controllerV3.process(paramMap);
        String viewName = mv.getViewName();
        MyView myView = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        myView.render(mv.getModel(),request,response);
    }
}
