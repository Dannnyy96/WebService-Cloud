<%@ page import="java.util.List" %>
<%@ page import="assignment.Film" %>
<%@ page import="assignment.FilmDAO" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page trimDirectiveWhitespaces = "true" %>

<%
List<Film> films = (List<Film>) request.getAttribute("films");
Gson gson = new Gson();
String jsonInString = gson.toJson(films);

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write(jsonInString);
%>
