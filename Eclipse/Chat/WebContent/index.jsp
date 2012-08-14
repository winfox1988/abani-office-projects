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
	Chat demo powered by WebSocket
	<div>
		<label id="lblText" for="mText">Enter Name</label>
		<input type="text" id="mText" />
		<button id="conB" onclick="connect(this)">Connect</button><br/>
		<label id="lblStatus" for="sStatus">Server Status : </label>
		<span id="sStatus" style="color:red">Not Connected to Server</span><br />
		<button id="sndB" disabled="disabled" onclick="sendMsg()">Send Message</button>
		<button id="clsB" disabled="disabled" onclick="closeWS(this)">Disconnect</button>
	</div>
	<div>
		<label for="msg"><b>Chat Messages : </b></label>
		<hr width="300px;" align="left"/>
		<span id="msg"></span>
	</div>
	
</body>
<script type="text/javascript">
	var ws;
	var host = "ws://localhost:8080/Chat/wschat";
	connect = function(obj){
		var user = byId('mText').value;
		if(user.isEmpty()){
			alert('Enter a name to join the chat room');
		}else{
			byId('mText').value = "";
			obj.disabled = true;
			byId('lblText').innerHTML='Enter Message';
			byId('clsB').disabled = false;
			byId('sndB').disabled = false;
			ws = new WebSocket(host+'?userName='+user);
			ws.onopen = function () {
				//alert ('connected to server');
				byId('sStatus').style.color = 'green';
				byId('sStatus').innerHTML = 'Connected to Server';
			};
			ws.onmessage = function (event) {
				byId('msg').innerHTML = byId('msg').innerHTML + '<br />' + event.data;
			};
			ws.onclose = function (event){
				//alert ('disconnected from server');
				byId('sStatus').style.color = 'red';
				byId('sStatus').innerHTML = 'Not Connected to Server';
			};
		}
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
		byId('lblText').innerHTML='Enter Name';
		obj.disabled = true;
		byId('sndB').disabled = true;
		byId('conB').disabled = false;
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