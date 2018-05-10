package assignment;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public enum FilmDAO {
 INSTANCE;
 //this method will select all the films from the datastore using an instance of Entity Manager
 //JPA Method used
 public List < Film > getAllFilms() {
  EntityManager em = EMFService.get().createEntityManager();
  // read the existing entries
  Query q = em.createQuery("select m from Film m");
  List < Film > films = q.getResultList();
  return films;
 }

 //this method will insert data into the datastore (passed details of a film, submitted from user on index.html)
 //JPA Method used
 public static void add(int filmId, String title, int year, String director, String stars, String review) {
  EntityManager em = EMFService.get().createEntityManager();
  Film film = new Film(filmId, title, year, director, stars, review);
  em.persist(film);
  em.close();
 }

 //this method gets a film from the datastore, depending on the film title submitted by the user on the index.html
 //JPA Method used
 public List < Film > getFilm(String title) {
  EntityManager em = EMFService.get().createEntityManager();
  Query q = em.createQuery("select t from Film t where t.title = :title");
  q.setParameter("title", title);
  List < Film > films = q.getResultList();
  return films;
 }
 //this method is used to remove films from the datastore, depending on the id
 //JPA Method used
 public void remove(long id) {
  EntityManager em = EMFService.get().createEntityManager();
  try {
   Film film = em.find(Film.class, id);
   em.remove(film);
  } finally {
   em.close();
  }
 }

 //this method was used to originally create data in the datastore
 //JPA Method used
 public void createAllFilms() {
  Film film = null;
  EntityManager em = EMFService.get().createEntityManager();
  try {
   em.getTransaction().begin();
   film = new Film(10002, "187", 1997, "KEVIN REYNOLDS", "SAMUEL L.JACKSON, JOHN HEARD", "The title number is the police code for a homicide, and its heard more than once in this tough ghetto school drama. Samuel L.Jackson (Pulp Fiction / Sphere) plays a teacher who goes to an inner city school to find it completely out of control. After being robbed by one of the pupils he returns, determined to take the law into his own hands. From the director of Robin Hood - Prince Of Thieves.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10003, "9 1/2 WEEKS", 1986, "ADRIAN LYNE", "MICKEY ROURKE, KIM BASINGER", "Director Lyne shows his pop video roots in this erotic tale reputedly based on a true story. Basinger falls for stubble-cheeked Rourke and a steamy, sadomasochistic relationship begins. It lasts the period of the title before the intensity gets too much for her.  Joe Cockers version of You Can Leave Your Hat On accompanies a Basinger strip routine and then theres the infamous fridge sequence.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10004, "976-EVIL II: THE RETURN", 1988, "JIM WYNORSKI", "PATRICK OBRYAN, DEBBIE JAMES", "Sequel that still finds the ultimate telephone line, the Devils equivalent of an 0898 number, acquiring victims. The head of a high school taps into the line, hoping to receive supernatural powers to help him in his obsessive lust for a young student. Any one who gets in his way suffers a horrible death. With a  supporting role for Brigitte Nielsen as a seductress in league with Satan himself.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10005, "A BETTER TOMORROW", 1986, "JOHN WOO", "CHOW YUN-FAT, LESLIE CHEUNG", "The film which brought international stardom to star Chow Yun-Fat and director John Woo. A roller-coaster of a ride with brothers on both sides of the law becoming united in their quest for personal revenge. After forger Mark (Chow) is crippled and double crossed by an associate, cop Kit (Cheung) risks his badge to help him. Violent and gripping. Also available as a boxed set with a supplementary documentary and booklet.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10006, "A BRONX TALE", 1993, "ROBERT DE NIRO", "ROBERT DE NIRO, CHAZZ PALMINTERI", "De Niros directorial debut, taken from co-star Palminteris own stage play. De Niro leads a cast of virtual unknown as a hard-working Bronx bus driver, alarmed at his sons fascination with the local underworld figures. But the lad is involved even deeper than he knows and soon hell have to confront the gangsters in an effort to win back his sons respect.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10007, "A CHILD LOST FOREVER", 1993, "CLAUDIA WEILL", "BEVERLY DANGELO, WILL PATTON", "Another of the Odyssey labels seemingly endless supply of true-life weepies, this one involves a young woman (Beverly DAngelo from High Spirits) reluctantly giving up her child for adoption. Years later she discovers  that it died in mysterious circumstances at the age of only three and decides to investigate.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10008, "A FEW GOOD MEN", 1992, "ROB REINER", "TOM CRUISE, JACK NICHOLSON", "After the mysterious death of a young Marine in the barracks, a young navy Lawyer (Cruise) is called in to investigate. The further he delves into the mystery the more he is thwarted by the fearsome and unyielding  Colonel Nathan Jessup (Nicholson), a man who knows the truth and is determined to conceal it....");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10009, "A LEAGUE OF THEIR OWN", 1992, "PENNY MARSHALL", "GEENA DAVIS, TOM HANKS", "Loosely based on the true story of the all-womens baseball league which was formed during the war while all the male players were fighting overseas. Concentrating on one team, the Rockford Peaches whose members include Davis, Madonna, and Lori Petty. Broken-down coach Tom Hanks has to knock them into some sort of shape.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10010, "A LITTLE PRINCESS", 1995, "ALFONSO CUARON", "LIESEL MATTHEWS, ELEANOR BRON", "Enchanting family story, with a young shy girl being sent to an austere boarding school in New York after her father leaves to go to war. Initially she has a terrible time, being regarded as an outsider, but slowly realises her own self-worth and becomes liked and admired by both the staff and the pupils. Eleanor Bron plays the strict governess.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10011, "A LOW DOWN DIRTY SHAME", 1994, "KEENAN IVORY WAYANS", "KEENAN IVORY WAYANS, JADA PINKETT", "Cool and sleek comedy thriller directed by and starring IN LIVING COLORs Wayans. Hes the Shame of the name, an ex-cop whose personal vendetta with a drug lord got him thrown off the force. Now a private eye hes given  an opportunity  to get back at the man who wrecked his career. Enjoyable fun with some gripping shoot-outs. Mrs Will Smith, Jada Pinkett co-stars.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10012, "A NIGHTMARE ON ELM ST. 4", 1988, "RENNY HARLIN", "ROBERT ENGLUND, RODNEY EASTMAN", "Not one of the better outings for Freddy Krueger, being little more than a series of admittedly spectacular special effects sequences. Here hes still tormenting a group of teenagers through their dreams, but may have met his match in a girl with telekinetic powers. Each murder is capped off with the usual one-liners. Director Renny Harlin went on to direct Die Hard 2, Cliffhanger and The Long Kiss Goodnight.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10013, "A NIGHTMARE ON ELM ST. PART 2", 1985, "JACK SHOLDER", "ROBERT ENGLUND, KIM MYERS", "Confused sequel with the spirit of Freddy Kruger coming back to possess a young teenager (Mark Patton). Soon hes dispatching his enemies, such as a sadistic gym teacher, until Freddy makes his return to the real world and causes havoc at a poolside party. Not the best in the series.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10014, "A NIGHTMARE ON ELM STREET", 1984, "WES CRAVEN", "HEATHER LANGENKAMP, JOHN SAXON", "The one that started the long-running Freddy Krueger series and still the best. When a group of teenagers start to have dreams about a scarred killer wearing a glove with blades on the fingers, they do not know that he is coming back for revenge for being murdered by their parents years before. When the kids start to die one girl tries to unravel the horrifying mystery of his identity. A very early performance from a young Johnny Depp.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10015, "A NIGHTMARE ON ELM STREET PART 6 - FREDDYS DEAD", 1991, "RACHEL TALALAY", "ROBERT ENGLUND, LISA ZANE", "The man of your dreams is about to go bye-byes, as he finally gets his comeuppance after taking on his own daughter (somebody never even mentioned in the series so far). Some of the cassettes available included the last reel in 3D, although you need the special glasses. And yes, hes well and truly dead. Until Wes Cravens New  Nightmare that is!!");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10016, "A.P.E.X.", 1994, "PHILIP J.ROTH", "RICHARD KEATS, LISA ANN RUSSELL", "Okay sci-fi with good ideas but hampered by a pretty obvious lack of budget. A  scientist travels back in time to retrieve an experimental probe but unwittingly  infects the present with a virus. When he goes back to the future the plague has decimated mankind, and hunter / killer robots roam the wastelands.  Decent effects considering the money available, but its pretty obvious theyve only got three robot suits at any one time.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10017, "A PERFECT WORLD", 1993, "CLINT EASTWOOD", "KEVIN COSTNER, CLINT EASTWOOD", "Costner is a prison escapee who takes a young boy as hostage in order to get across state lines in a stolen car and Clint is the Sheriff on his trail in this absorbing drama. As they proceed the crook and the boy start to respect and even like each other, but the cops are gaining mile by mile, with orders to shoot to kill...");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10018, "A RAGE IN HARLEM", 1991, "BILL DUKE", "GREGORY HINES, FOREST WHITAKER", "Very entertaining period comedy drama set in the 50s, taken from the book by  Chester Himes. Ex-Mrs Mike Tyson Robin Givens hides out in Harlem with a stash of stolen gold and tries to hang onto it while being hunted by everyone from the Mob owners of the loot to Hines as a phony  priest. Danny Glover is superb in a small role as a tough gangster totally devoted to his tiny pet poodle. Terrific soundtrack too.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10019, "A RIVER RUNS THROUGH IT", 1992, "ROBERT REDFORD", "BRAD PITT, EMILY LLOYD", "Slightly rambling but thoroughly enjoyable family saga, with Tom Skeritt teaching his sons the virtues theyll need for later life, as well as instilling in them a love of fly-fishing. The boys (Pitt and Craig Sheffer) eventually leave home but one of them is going to be seduced by the vices of the big city, leading to a tragic end.  Great performances all round including Brenda Blethyn as the boys mother.");
   em.persist(film);
   em.getTransaction().commit();
   em.getTransaction().begin();
   film = new Film(10020, "A SIMPLE WISH", 1997, "MICHAEL RITCHIE", "MARA WILSON, MARTIN SHORT", "Childrens fantasy starring Mara Wilson from Matilda. She plays the daughter of one of Central Parks horse drawn cab drivers who longs for a fairy godmother to grant her special wish for her dad. However, the character who appears with a magic wand is Murray (Martin Short), the least qualified fairy godmother on the block. Lots of wild special effects and with Kathleen Turner as an evil witch.");
   em.persist(film);
   em.getTransaction().commit();
   em.close();
  } finally {

  }
 }
}