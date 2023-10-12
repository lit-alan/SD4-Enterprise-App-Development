package controllers;

import model.Account;
import model.AccountDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ShowBalance", value = "/ShowBalance")
public class ShowBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String address;

            try {

                Account customer = AccountDB.getAccountByID(Integer.parseInt(request.getParameter("id")));

                if (customer == null) {
                    address = "/UnknownCustomer.jsp";
                } else if (customer.getBalance() < 0) {
                    address = "/NegativeBalance.jsp";
                    request.setAttribute("badCustomer", customer);
                } else if (customer.getBalance() < 10000) {
                    address = "/NormalBalance.jsp";
                    request.setAttribute("regularCustomer", customer);
                } else {
                    address = "/HighBalance.jsp";
                    request.setAttribute("eliteCustomer", customer);
                }

                //Cookie c = getCookie(request,String.valueOf(customer.getAccountNumber()));

                //As it stands, every time the user searches for a bank account a new
                //Cookie will be created (with a new expiry date and time). Searching for
                //the same bank account multiple times will result in a new cookie
                //being created each time you search for that bank account.
                // Is this the behaviour you want?
                if (customer!=null) {
                    Cookie c = new Cookie(String.valueOf(customer.getAccountNumber()), customer.getFirstName() + customer.getLastName());
                    c.setMaxAge(60 * 60);
                    response.addCookie(c);

                }

            }//end try

            catch(NumberFormatException ex) {
                address = "/Error.jsp";
            }//end catch



            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

    }//end doGET

    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }

        return null;
    }
}//end Servlet
