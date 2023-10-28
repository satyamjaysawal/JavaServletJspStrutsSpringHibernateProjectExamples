package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

public class LoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, 
                                 HttpServletResponse response) {
    	
    	
        LoginForm loginForm = (LoginForm) form;
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        // Add your login logic here
        if (email.equals("example@example.com") && password.equals("password")) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }
}
