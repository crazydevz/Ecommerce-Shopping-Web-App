<%-- 
    Document   : ImageList
    Created on : Aug 7, 2018, 9:27:05 PM
    Author     : Talha Iqbal
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image List</title>
    </head>
    <body>
        <%
            File f = new File("F:\\Temporary Codes\\OnlineShoppingSystem\\web\\Images");
            if(!f.exists()){
                System.err.println("file not accessible!");
            }
            List<File> files = new ArrayList(Arrays.asList(f.listFiles()));
            
            for(File filePath : files){
                out.println("<p><img src = \"Images\\" + filePath.getName() + "\"></p>");
            }
        %>
        <!--<p><img src = "F:\\Temporary Codes\\OnlineShoppingSystem\\Files\\Images\\download.jpg"></p>-->
    </body>
</html>
