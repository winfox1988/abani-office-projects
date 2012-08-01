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
	Server-Push page powered by WebSocket
	<div>
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
	var host = "ws://localhost:8080/Chat/wschat";
	connect = function(obj){
		obj.disabled = true;
		document.getElementById('clsB').disabled = false;
		document.getElementById('sndB').disabled = false;
		ws = new WebSocket(host);
		ws.onmessage = function (event) {
			document.getElementById('msg').innerHTML = document.getElementById('msg').innerHTML + '<br />' + event.data;
		};
	};
	sendMsg = function() {
		ws.send(generateMsg());
	};
	closeWS = function(obj) {
		obj.disabled = true;
		document.getElementById('sndB').disabled = true;
		alert('connection closed');
		document.getElementById('conB').disabled = false;
		ws.close();
	};
	generateMsg = function(){
		var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
		var string_length = 8;
		var randomstring = '';
		for (var i=0; i<string_length; i++) {
			var rnum = Math.floor(Math.random() * chars.length);
			randomstring += chars.substring(rnum,rnum+1);
		}
		return randomstring;
	};
</script>
</html>