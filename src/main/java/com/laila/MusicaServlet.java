/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laila;
import com.laila.dao.MusicaDAO;
import com.laila.dao.MusicaDAOImpl;
import com.laila.model.Musica;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/MusicaServlet")
public class MusicaServlet extends HttpServlet{
 
    private MusicaDAO musicaDAO;

public MusicaServlet() {
    super();
    musicaDAO = new MusicaDAOImpl();
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.procesarSolicitud(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.procesarSolicitud(req, resp);
}

protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    switch (request.getParameter("action")) {
        case "list":
            // this.list(request, response);
            break;
        case "create":
            this.create(request, response);
            break;
        case "read":
            // this.read(request, response);
            break;
        case "update":
            // this.update(request, response);
            break;
        case "delete":
            // this.delete(request, response);
            break;
        case "showRegister":
            this.showRegister(request, response);
            break;
        case "index":
            this.index(request, response);
            break;
        default:
            this.index(request, response);
            break;
    }
}

private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
}

private void showRegister(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
    dispatcher.forward(request, response);
}

private void create(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String origen = request.getParameter("origen");
    String precio = request.getParameter("precio");
    String tipo = request.getParameter("tipo");

    // Crear el objeto que se envía a la base de datos
    Musica objMusica = new Musica();
    objMusica.setNombre(nombre);
    objMusica.setOrigen(origen);
    objMusica.setPrecio(precio);
    objMusica.setTipo(tipo);

    musicaDAO.insert(objMusica);

    // Redireccionar al "index"
    this.index(request, response);
}
}


