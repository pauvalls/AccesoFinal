<%@page import="Utilities.RespuestasOBJ"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Userdata"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/j.js"></script>
    </head>
    <body>
        <%    ArrayList<RespuestasOBJ> array = (ArrayList<RespuestasOBJ>) request.getAttribute("array");%>
        <div class="jumbotron text-center">
            <h1>Examen</h1>
              </div>
        <div class="container">
            <div class="well">
                <div  class="row" >
                    <h1>inicio</h1>
                    
                    <%=   array.get(0).getPregunta()%>
                    <h1>final</h1>
                </div>
            </div>
            
           
             
            </div>            
       
    </body>
</html>