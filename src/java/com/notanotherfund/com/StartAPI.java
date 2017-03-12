/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notanotherfund.com;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.rainmatter.kiteconnect.KiteConnect;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author psharma
 */
@WebServlet(name = "StartAPI", urlPatterns = {"/StartAPI"})
public class StartAPI extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         KiteConnect kiteSdk = new com.rainmatter.kiteconnect.KiteConnect("0ik2gu1f75jbf2hi");
        kiteSdk.setUserId("HODP0008");
        String url = kiteSdk.getLoginUrl();
        URLConnection con = new URL(url).openConnection();
        con.connect();
        System.out.println( "connected url: " + con.getURL() );
InputStream is = con.getInputStream();
System.out.println( "redirected url: " + con.getURL() );
 final WebClient webClient = new WebClient();
 //webClient.getOptions().setUseInsecureSSL(true);
 HtmlPage page1 = webClient.getPage(con.getURL());
//  final HtmlForm form = page1.getFormByName("loginform");
   HtmlForm form = page1.getFirstByXPath(".//*[@id='loginform']");
 	    form.getInputByName("password").setValueAttribute("abc007");
 	    form.getInputByName("user_id").setValueAttribute("DP0008");
            HtmlButton button = form.getButtonByName("login");
             page1 = (HtmlPage) form.getButtonByName("login").click();
            HtmlTextInput user_id = form.getInputByName("inputone");
  user_id.setValueAttribute("DP0008");
  final HtmlTextInput passwd = form.getInputByName("password");
  passwd.setValueAttribute("abc005");
  //HtmlSubmitInput button = form.getInputByName("login");
   final HtmlPage page2 = button.click();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StartAPI</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StartAPI at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
