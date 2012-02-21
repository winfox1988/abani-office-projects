<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HTML5 File Upload</title>
</head>
<body>
	<form id="upload_form" enctype="multipart/form-data" method="post" action="">
		<table>
			<tr>
				<td>
					<fieldset id="usfs" style="width: 250px">
						<legend>Upload Form</legend>
						<input type="file" id="image_file"onclick="document.getElementById('upload').disabled=false" name="image_file">
						<input type="hidden" id="fname"	name="fname"> 
						<input type="button" id="upload" disabled="disabled" value="Upload" onclick="startUploading(this)" />
					</fieldset>
				</td>
				<td>	
					<fieldset id="usfs" style="width: 250px">
						<legend>Uploaded Files</legend>
						<div id="result"></div>
					</fieldset>
				</td>
			</tr>
		</table>
		<fieldset id="uimg" style="display: none;width: 250px">
			<legend>Upload Status</legend>
			<img alt="" src="js/progress1.gif">
		</fieldset>
	</form>
</body>
<script type="text/javascript">
	function startUploading(obj) {
		obj.disabled = 'true';
		document.getElementById('uimg').setAttribute("style", "display:block;width: 250px");
		var oFile = document.getElementById('image_file').files[0];
		//alert ('uploading' + oFile.size);
		//alert ('uploading' + oFile.name);
		document.getElementById('fname').value = oFile.name;
		var oXHR = new XMLHttpRequest();
		var vFD = new FormData(document.getElementById('upload_form'));
		var content = document.getElementById('result').innerHTML;
		oXHR.onreadystatechange = function(data) {
			if (oXHR.readyState == 4 && oXHR.status == 200) {
				document.getElementById('uimg').setAttribute("style","display:none");
				alert(oXHR.responseText);
				document.getElementById('image_file').value = "";
				document.getElementById('result').innerHTML = content + "<br /><a href='" + oFile.name + "'>" + oFile.name + "</a>" ;
			}
		}
		oXHR.open('POST', 'upload', true);
		oXHR.send(vFD);
	}
</script>
</html>