package pl.woonkievitch.Authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.woonkievitch.Authentication.entity.User;
import pl.woonkievitch.Authentication.service.UserService;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class mainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public ModelAndView createNewUSer(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists != null){
            bindingResult.rejectValue("email", "error.user", "There is already a  registred user");
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
        }else{
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "user has been registred");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;

    }

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByEmail = userService.findUserByEmail(authentication.getName());
        modelAndView.addObject("userName", "Welcome "+userByEmail.getLogin());
        modelAndView.setViewName("home");
        return modelAndView;

    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
