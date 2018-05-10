package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.Film;
import assignment.FilmDAO;

/**
 * Servlet implementation class insertFilm
 */
public class insertFilm extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public insertFilm() {
  super();
 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  PrintWriter out = response.getWriter();

  String filmIdStr = request.getParameter("filmId");
  int filmId = Integer.parseInt(filmIdStr);
  String title = request.getParameter("title");
  String yearStr = request.getParameter("year");
  int year = Integer.parseInt(yearStr);
  String director = request.getParameter("director");
  String stars = request.getParameter("stars");
  String review = request.getParameter("review");
  Film f = new Film(filmId, title, year, director, stars, review);
  //use the data requested from the parameters into the add method, this will then be added into the datastore
  FilmDAO.add(filmId, title, year, director, stars, review);

  request.setAttribute("films", f);
  //print out a success message so the user knows the data was entered correctly
  out.println("Insert successful" + f);
  System.out.println("Insert successful" + f);
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request, response);
 }}