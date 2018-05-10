//get all films from xml
function xmlgetAllFilmsTable(resultRegion) {
  var address = "getAllFilms";
  var data = "format=xml";
  ajaxPost(address, data, 
           function(request) { 
	  showXmlFilmsInfo(request, resultRegion); 
           });
}
//get films by searching in xml
function xmlgetFilmTable(inputField, resultRegion) {
	  var address = "getFilm";
	  var data = "title=" + getValue(inputField) +
      "&format=xml";
	  ajaxPost(address, data, 
	           function(request) { 
		  showXmlFilmsInfo(request, resultRegion); 
	           });
	}

function showXmlFilmsInfo(request, resultRegion) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    var xmlDocument = request.responseXML;
    var headings = ["director", "review", "stars", "title", "year"];
    var films = xmlDocument.getElementsByTagName("film");
    console.log(films);
    var rows = new Array(films.length);
    console.log(rows);
    var subElementNames = ["director", "review", "stars", "title", "year"];
    for(var i=0; i<films.length; i++) {
      rows[i] = 
        getElementValues(films[i], subElementNames);
    }
    var table = getTable(headings, rows);
    htmlInsert(resultRegion, table);
  }
}
//get all films json
function jsonGetAllFilmsTable(resultRegion) {
  var address = "getAllFilms";
  var data = "format=json";
  ajaxPost(address, data, 
           function(request) { 
             showJsonFilmInfo(request, resultRegion); 
           });
}
//get films from search json
function jsonGetFilmTable(inputField, resultRegion) {
	  var address = "getFilm";
	  var data = "title=" + getValue(inputField) +
      "&format=json";
	  ajaxPost(address, data, 
	           function(request) { 
	             showJsonFilmInfo(request, resultRegion); 
	           });
	}

function showJsonFilmInfo(request, resultRegion) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    var rawData = request.responseText;
    var data = eval("(" + rawData + ")"); 
    console.log(data);
    var table = JsonToTable(data, ['id', 'title', 'year', 'director', 'stars', 'review']);
    htmlInsert(resultRegion, table);
  }
}

function JsonToTable(data, columns) {
	var table = '<table border="1">';
  
  table += '<tr>';
  
  for (var i = 0; i < columns.length; i++) {
  	table += '<th>' + columns[i] + '</th>';
  }
  
  table += '</tr>';
  
  for (var i = 0; i < data.length; i++) {
  	table += '<tr>';
    
    for (var j = 0; j < columns.length; j++) {
    	table += '<td>' + data[i][columns[j]] + '</td>';
    }
    
    table += '</tr>';
  }

	table += '</table>';
  
  return table;
}

//get all films in text to table
function textGetAllFilmTable(resultRegion) {
  var address = "getAllFilms";
  var data = "format=text";
  ajaxPost(address, data, 
           function(request) { 
             showTextFilmInfo(request, resultRegion); 
           });
}
//text get film by search
function textGetFilmTable(inputField, resultRegion) {
	  var address = "getFilm";
	  var data = "title=" + getValue(inputField) +
      "&format=text";
	  ajaxPost(address, data, 
	           function(request) { 
	             showTextFilmInfo(request, resultRegion);
	           });
	}

function showTextFilmInfo(request, resultRegion) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    var rawData = request.responseText;
    var rowStrings = rawData.split(/[\n\r]+/);
    var headings = ["id", "title", "year", "director", "stars", "review"];
    var rows = new Array(rowStrings.length-1);
    for(var i=0; i<rowStrings.length; i++) {
      rows[i] = rowStrings[i].split("#");
    }
    var table = getTable(headings, rows);
    htmlInsert(resultRegion, table);
  }
}
