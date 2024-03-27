package hello.servlet.web.springmvc.springmvc.v1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-forms")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }

}
