<%-- 
    Document   : index
    Created on : 15 May, 2012, 5:53:12 PM
    Author     : abani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/ajax.js"></script>
    </head>
    <body>
        <form id="f1" onsubmit="return false;">
	  <div>Name<input type="text" name="firstName" id="firstName" /></div>
	  <div>Id<input type="text" name="eid" id="eid" /></div>
          <input type="button" name="g" onclick="send()" value="Submit" id="g" />
	</form>
    </body>
    <script type="text/javascript">
        var xml = '<employee><eid>12</eid><firstName>abani</firstName></employee>';
        var json = '{"firstName":"abani","eid":"12"}';
        var msg = eval('('+ json +')');
        //alert (msg.firstName);
        send = function() {
            addMessage(xml);
           // var data = $("#f1").serializeArray();
           // alert(data);
           // var json = $.parseJSON(data);
            //alert (json);
        };
     </script>   
</html>
