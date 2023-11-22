package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SaveEmployeeAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {
            EmployeeForm employeeForm = (EmployeeForm) form;

            // Retrieve data from the form
            String firstName = employeeForm.getFirstname();
            String lastName = employeeForm.getLastname();
            String email = employeeForm.getEmail();
            Address address = employeeForm.getAddress();

         // Set data in request attributes
            request.setAttribute("name", firstName + " " + lastName);
            request.setAttribute("email", email);
            request.setAttribute("address", address);

            // Forward to the success page
            return mapping.findForward("success");
        } catch (Exception e) {
            e.printStackTrace();
            
            // Forward to the failure page
            return mapping.findForward("failure");
        }
    }
}
