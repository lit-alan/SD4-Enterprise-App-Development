package com.example.assignmentone;

import model.Customer;
import model.CustomersDB;
import model.Review;

import java.io.*;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GetCustomerByID_Servlet", value = "/GetCustomerByID")
public class GetCustomerByID_Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nextPage = "";

        response.setContentType("text/html");

        int customerID = Integer.parseInt(request.getParameter("id"));

        Optional<Customer> optCust = CustomersDB.getAccountByID(customerID);


        if (optCust.isPresent()) {
            request.setAttribute("customer", optCust.get());

            double reviewAvg = optCust.get().getReviewList().stream().mapToInt(Review::getRating) // Extract 'rating' from each Review
                                                   .average() // Calculate the average
                                                   .orElse(0.0); // Default value if the list is empty

            request.setAttribute("reviewAvg", reviewAvg);
            nextPage = "displayOne.jsp";
        }
        else {
            nextPage = "error.jsp";
            request.setAttribute("message", "Customer " + customerID + " not found");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);

    }


}