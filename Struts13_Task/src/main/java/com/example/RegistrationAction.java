package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrationAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
       
        RegistrationForm registrationForm = (RegistrationForm) form;
        
        
        String name = registrationForm.getName();
        String email = registrationForm.getEmail();
        
        
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        
       
        return mapping.findForward("success");
    }
}
