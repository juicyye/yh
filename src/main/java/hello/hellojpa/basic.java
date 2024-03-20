package hello.hellojpa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class basic extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string = request.getRequestURL().toString();
        String username = request.getParameter("username");

        System.out.println("username = " + username);

        response.getWriter().write("ok");
    }
}
