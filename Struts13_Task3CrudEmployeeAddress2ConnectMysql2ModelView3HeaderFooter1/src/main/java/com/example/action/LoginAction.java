package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.form.LoginForm;
import com.example.model.User;
import com.example.util.UserManager;

public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginForm loginForm = (LoginForm) form;

        // Perform authentication (replace this with your own logic)
        User user = UserManager.authenticate(loginForm.getUsername(), loginForm.getPassword());

        if (user != null) {
            request.setAttribute("username", user.getUsername());
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }
}
