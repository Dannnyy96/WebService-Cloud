package assignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Film {

 public Film(int filmId, String title, int year, String director, String stars,
  String review) {
  super();
  this.filmId = filmId;
  this.title = title;
  this.year = year;
  this.director = director;
  this.stars = stars;
  this.review = review;
 }


 int filmId;
 String title;
 int year;
 String director;
 String stars;
 String review;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;


 public long getFilmId() {
  return filmId;
 }

 public void setFilmId(int filmId) {
  this.filmId = filmId;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public int getYear() {
  return year;
 }

 public void setYear(int year) {
  this.year = year;
 }
 public String getDirector() {
  return director;
 }

 public void setDirector(String director) {
  this.director = director;
 }
 public String getStars() {
  return stars;
 }
 public void setStars(String stars) {
  this.stars = stars;
 }
 public String getReview() {
  return review;
 }
 public void setReview(String review) {
  this.review = review;
 }
 @Override
 public String toString() {
  return "Film [filmid=" + filmId + ", title=" + title + ", year=" + year + ", director=" + director + ", stars=" + stars + ", review=" + review + "]";
 }
}