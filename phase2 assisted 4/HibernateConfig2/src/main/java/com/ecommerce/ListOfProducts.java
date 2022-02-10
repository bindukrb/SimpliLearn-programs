package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.ecommerce.EProduct1;
import com.ecommerce.HibernateUtil;



@WebServlet("/ListOfProducts")
public class ListOfProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
   
    public ListOfProducts() {
        super();
        
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();
            // using HQL
            List<EProduct1> list = session.createQuery("from EProduct").list();
            
            session.close();
            
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
             out.println("<b>Product Listing</b><br>");
             for(EProduct1 p: list) {
                     out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                     ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
             }
             
         out.println("</body></html>");
         
         
     } catch (Exception ex) {
             throw ex;
     }

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
