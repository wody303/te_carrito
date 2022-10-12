package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                System.out.println("En el servlet");
                //obtner acceso al objeto session
                HttpSession ses = request.getSession();
                //se elimina la sesion
                ses.invalidate();
                //transfiere el control a index.jsp
                response.sendRedirect("index.jsp");
            }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("En el metodo POST del Servlet");
        //Recupera el producto enviado desde formulario
        String producto = request.getParameter("producto");
        //Se obtiene el acceso a la sesion 
        HttpSession ses = request.getSession();
        //Se obtiene la lista que esta como atributo de sesion
        ArrayList<String> lista = (ArrayList<String>) ses.getAttribute("lista");
        //A la coleccion se adiciona el elemento producto
        lista.add(producto);
        //Se redirecciona a index.jsp
        response.sendRedirect("index.jsp");
        

    }
}
