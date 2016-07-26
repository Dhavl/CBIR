$(function() {
		$("#retrieve").change(function(e)
			{
				var type=($(this).val());
				var color = new Array();
				color[0] = "red";
				color[1] = "green";
				color[2] = "blue";
				var texture = new Array();
				texture[0] = "texture2";
				texture[1] = "texture3";
				texture[2] = "texture4";
				var shape = new Array();
				shape[0] = "shape2";
				shape[1] = "shape3";
				shape[2] = "shape4";
				var data="";
				if (type!="0" && type=="color")
				{
				data+="<div style='width: 50px;float:left;'>";
				data+="<input type=\"file\" name=\"path\" id=\"getpreview\" ONCHANGE=\"return showpreview(path.value)\"><br>";
                data+="<input type=\"button\" value=\"Search\" onclick=\"return showImage(path.value);\" style=\"color:#050;font: bold 84% 'trebuchet ms',helvetica,sans-serif;  background-color:#fed;  border:1px solid;  border-color: #696 #363 #363 #696;                     \">";
				data+="</div>";
				data+="<div style='float:right;width:600px'>Query Input Image-></div>";
				data+="<div id=\"internalimage\" style='width: 450px; float: right;'></div>";
				}
				if (type!="0" && type=="texture")
				{
				//	 data+="<input type=\"file\" name=\"path\"><br>";
                //     data+="<input type=\"button\" value=\"Search\" onclick=\"return showImageByTexture(path.value);\" style=\"color:#050;font: bold 84% 'trebuchet ms',helvetica,sans-serif;  background-color:#fed;  border:1px solid;  border-color: #696 #363 #363 #696;                     \">";
                     
                data+="<div style='width: 50px;float:left;'>";
				data+="<input type=\"file\" name=\"path\" id=\"getpreview\" ONCHANGE=\"return showpreview(path.value)\"><br>";
                data+="<input type=\"button\" value=\"Search\" onclick=\"return showImageByTexture(path.value);\" style=\"color:#050;font: bold 84% 'trebuchet ms',helvetica,sans-serif;  background-color:#fed;  border:1px solid;  border-color: #696 #363 #363 #696;                     \">";
				data+="</div>";
				data+="<div style='float:right;width:600px'>Query Input Image-></div>";
				data+="<div id=\"internalimage\" style='width: 450px; float: right;'></div>";				
                }
                  
                if (type!="0" && type=="shape")
				{
		      
                data+="<div style='width: 50px;float:left;'>";
				data+="<input type=\"file\" name=\"path\" id=\"getpreview\" ONCHANGE=\"return showpreview(path.value)\"><br>";
                data+="<input type=\"button\" value=\"Search\" onclick=\"return showImageByShape();\" style=\"color:#050;font: bold 84% 'trebuchet ms',helvetica,sans-serif;  background-color:#fed;  border:1px solid;  border-color: #696 #363 #363 #696;                     \">";
				data+="</div>";
				data+="<div style='float:right;width:600px'>Query Input Image-></div>";
				data+="<div id=\"internalimage\" style='width: 450px; float: right;'></div>";	
				}
			
			$("#type").html(data);
		});
		
});