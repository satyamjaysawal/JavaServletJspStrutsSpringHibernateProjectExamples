package com.example.action;

import com.example.model.Address;
import com.example.model.EmployeeForm;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViewEmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {
            List<EmployeeForm> listOfEmployeeForms = getEmployeeFormList();

            request.setAttribute("employeeList", listOfEmployeeForms);

            return mapping.findForward("success");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            return mapping.findForward("failure");
        }
    }

    public List<EmployeeForm> getEmployeeFormList() {
        List<EmployeeForm> listOfEmployeeForms = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            String selectSql = "SELECT * FROM employee";

            try (PreparedStatement statement = connection.prepareStatement(selectSql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    EmployeeForm employeeForm = new EmployeeForm();
                    employeeForm.setFirstName(resultSet.getString("first_name"));
                    employeeForm.setLastName(resultSet.getString("last_name"));
                    employeeForm.setEmail(resultSet.getString("email"));

                    Address address = new Address();
                    address.setCity(resultSet.getString("city"));
                    address.setDistrict(resultSet.getString("district"));
                    employeeForm.setAddress(address);

                    listOfEmployeeForms.add(employeeForm);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfEmployeeForms;
    }
}
