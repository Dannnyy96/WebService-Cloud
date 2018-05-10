package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.FilmDAO;

/**
 * Servlet implementation class ControlServ
 */
public class createAllFilms extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * Default constructor. 
  */
 public createAllFilms() {

 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //response.getWriter().append("Served at: ").append(request.getContextPath());

  PrintWriter out = response.getWriter();

  response.setContentType("text/plain");
  try {
   FilmDAO.INSTANCE.createAllFilms();

  } finally {
   out.print("Create films in the datastore");
  }


 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  doGet(request, response);


 }
}