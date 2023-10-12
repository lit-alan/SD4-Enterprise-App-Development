package controllers;

import model.Account;
import model.AccountDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdjustBalance", value = "/AdjustBalance")
public class AdjustBalance extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double adjustmentIncrement = Double.parseDouble(request.getParameter("adjustmentAmt"));
        String operation = request.getParameter("operation");

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");

        if (operation.equals("debit"))
            a.setBalance(a.getBalance() - adjustmentIncrement);
        else
            a.setBalance(a.getBalance() + adjustmentIncrement);

        AccountDB.updateAccount(a);



        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
