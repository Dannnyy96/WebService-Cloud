package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import assignment.Film;
import assignment.FilmDAO;

/**
 * Servlet implementation class getFilm
 **/
public class getFilm extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public getFilm() {
  super();

 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  //get the parameter fromt he form on index.html 
  String title = request.getParameter("title");
  //add the results from getFilm into a List
  List < Film > oneFilm = FilmDAO.INSTANCE.getFilm(title);
  System.out.println(oneFilm);
  oneFilm.get(0);
  
  request.setAttribute("films", oneFilm);
  //select a format (determined from button press on index.html or from user entering in url manually)
  String format = request.getParameter("format");
  String outputPage;

  if (request.getParameter("getfilmxml") != null) {
   format = "xml";
  } else if (request.getParameter("getfilmjson") != null) {
   format = "json";
  } else if (request.getParameter("getfilmtext") != null) {
   format = "text";
  } else {

  }
  
  if ("xml".equals(format)) {
   response.setContentType("text/xml");
   outputPage = "/WEB-INF/results/films-xml.jsp";
  } else if ("json".equals(format)) {
   response.setContentType("application/json");
   outputPage = "/WEB-INF/results/films-json.jsp";
  } else {
   response.setContentType("text/plain");
   outputPage = "/WEB-INF/results/films-string.jsp";
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