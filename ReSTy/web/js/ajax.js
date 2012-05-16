/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function getXmlHttpRequest() {
        try
        {
                // Firefox, Opera 8.0+, Safari
                return new XMLHttpRequest();
        }
        catch (e)
        {
                // Internet Explorer
                try
                {
                        return new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e)
                {
                        try
                        {
                                return new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        catch (e)
                        {
                                alert("Your browser does not support AJAX!");
                                return null;
                        }
                }
        }
}
function getMessages()
{
        var xmlHttp = getXmlHttpRequest();
        
        xmlHttp.onreadystatechange=function() {
                if(xmlHttp.readyState==4)
                {
                        // document.getElementById("output").innerHTML=xmlHttp.responseText;
                        alert (xmlHttp.responseText);
                }
        };
        xmlHttp.open("GET","services/hallo/users/25",true);
        xmlHttp.send(null);
}
function addMessage(message)
{
        alert (message);
        var xmlHttp = getXmlHttpRequest();
        
        
        xmlHttp.onreadystatechange=function()
        {
                if(xmlHttp.readyState==4)
                {
                        alert (xmlHttp.responseText);
                }
        };
        xmlHttp.open("PUT","resources/generic",true);
        xmlHttp.setRequestHeader("Content-Type", "application/xml; charset=utf-8");
        xmlHttp.send(message);
}

