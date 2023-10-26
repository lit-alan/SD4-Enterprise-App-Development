package com.example.assignmentone;

import model.Customer;
import model.CustomersDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllCustomers_Servlet", value = "/GetAllCustomers")
public class GetAllCustomers_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nextPage = "";

        response.setContentType("text/html");

        List<Customer> allCustomers = CustomersDB.getAll();

        if(allCustomers ==null || allCustomers.isEmpty()) {
            nextPage= "error.jsp";
            request.setAttribute("message", "There are no customers in the database");
        }
        else {
            request.setAttribute("customers", allCustomers);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}