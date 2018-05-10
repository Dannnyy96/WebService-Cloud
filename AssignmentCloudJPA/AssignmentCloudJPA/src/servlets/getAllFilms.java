package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.Film;
import assignment.FilmDAO;

/**
 * Servlet implementation class ControlServ
 */
public class getAllFilms extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * Default constructor. 
  */
 public getAllFilms() {

 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 

  //add the results of getAllFilms to a List
  List < Film > films = FilmDAO.INSTANCE.getAllFilms();
  
  for (int i = 0; i < films.size(); i++) {
   films.get(i);
   System.out.println(films.get(i));
  }

  request.setAttribute("films", films);
  //select a format (determined from button press on index.html or from user entering in url manually)
  String format = request.getParameter("format");
  String outputPage;

  if (request.getParameter("getallxml") != null) {
   format = "xml";
  } else if (request.getParameter("getalljson") != null) {
   format = "json";
  } else if (request.getParameter("getalltext") != null) {
   format = "text";
  } else {

  }

  if ("xml".equals(format)) {
   response.setContentType("text/xml");
   outputPage = "/WEB-INF/results/films-xml.jsp";
  } else if ("text".equals(format)) {
   response.setContentType("text/plain");
   outputPage = "/WEB-INF/results/films-string.jsp";
  } else {
   response.setContentType("application/json");
   outputPage = "/WEB-INF/results/films-json.jsp";
  }
  RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
  dispatcher.include(request, response);
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  doGet(request, response);


 }
}