<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="logo.ico" type="image/x-icon" />
<title>Chat App</title>	
</head>
<body>
	Server-Push demo powered by WebSocket
	<div>
		<label for="mText">Enter Message </label>
		<input type="text" disabled="disabled" id="mText" />
		<button id="conB" onclick="connect(this)">Connect</button>
		<button id="sndB" disabled="disabled" onclick="sendMsg()">Send Message</button>
		<button id="clsB" disabled="disabled" onclick="closeWS(this)">Close</button>
	</div>
	<div>
		<label for="msg">Server Message : </label>
		<span id="msg"></span>
	</div>
	
</body>
<script type="text/javascript">
	var ws;
	var host = "ws://localhost:8080/Chat/echo";
	connect = function(obj){
		obj.disabled = true;
		byId('clsB').disabled = false;
		byId('mText').disabled = false;
		byId('sndB').disabled = false;
		ws = new WebSocket(host);
		ws.onopen = function () {
			alert ('connected to server');
		};
		ws.onmessage = function (event) {
			byId('msg').innerHTML = byId('msg').innerHTML + '<br />' + event.data;
		};
		ws.onclose = function (event){
			alert ('disconnected from server');
		};
	};
	sendMsg = function() {
		var msg = byId('mText').value;
		if (msg.isEmpty()){
			alert("Please enter some message");
		}else{
			ws.send(msg);	
			byId('mText').value = "";
		}
	};
	closeWS = function(obj) {
		byId('msg').innerHTML = '';
		obj.disabled = true;
		byId('sndB').disabled = true;
		byId('conB').disabled = false;
		byId('mText').disabled = true;
		ws.close();
	};
	String.prototype.isEmpty = function(){
		return this.length == 0;
	};
	byId = function(objId){
		return document.getElementById(objId);
	};
</script>
</html>