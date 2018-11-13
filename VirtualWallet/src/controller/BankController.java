package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inMemoryStorage.InMemoryStorage;
import model.Account;
import model.Bank;
import model.Deposit;
import model.Transaction;
import model.Transfer;
import model.Wallet;
import model.Withdraw;

@WebServlet("/Bank")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Wallet w = (Wallet)session.getAttribute("wallet");
		List<String> accountsNum = w.getAccounts();
		List<Account> accounts = new ArrayList<>();
		for(String s:accountsNum) {
			accounts.add(Bank.getAccount(s));
		}
		request.setAttribute("accounts", accounts);
		RequestDispatcher d = request.getRequestDispatcher("onlinebank.jsp");
        d.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionType = request.getParameter("ActionType");
		switch(actionType){
		case "login":
			String user = request.getParameter("loginname");
			Wallet wallet =null;
			try {
				wallet = Bank.getWallet(user);
			} catch (Exception e1) {
				request.setAttribute("accountError", e1.getMessage());
				RequestDispatcher d = request.getRequestDispatcher("welcome.jsp");
		        d.forward(request, response);
			}
			HttpSession session = request.getSession();
			session.setAttribute("wallet", wallet);
			break;
		case "createWallet":
			String userName = request.getParameter("username");
			Wallet w = Bank.createWallet(userName);
			session = request.getSession();
			session.setAttribute("wallet", w);
			break;
			
		case "Withdraw":
			double amount = Double.parseDouble(request.getParameter("amount"));
			String num = request.getParameter("accountNum");
			try {
				Bank.withdraw(amount,num);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			}
			break;
			
		case "Deposit":
			amount = Double.parseDouble(request.getParameter("amount"));
			num = request.getParameter("accountNum");
			try {
				Bank.deposit(amount,num);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			}
			break;
			
		case "Transfer":
			String accountFrom = request.getParameter("accountFrom");
			String accountTo = request.getParameter("accountTo");
			amount = Double.parseDouble(request.getParameter("amount"));
			try {
				Bank.transfer(amount,accountFrom,accountTo);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			}
			break;
			
		case "history":
			String acc = request.getParameter("accNum");
			List<Transaction>trans = Bank.getTransactions(acc);
			request.setAttribute("transactions", trans);
			break;
		}
		doGet(request,response);	
	}
	
}
