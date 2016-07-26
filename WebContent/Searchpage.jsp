<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>search</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Rational Application Developer">
	
<script type="text/javascript" src="template/script.js"></script>
<link rel="stylesheet" href="template/style.css" type="text/css" media="screen" />
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.js"></script>
<script type="text/javascript" src="js/receptionist.js"></script>

<script type="text/javascript">
function showpath(str)
{

var path="<a href=\"http://localhost:8080/FinalCBIR/src/JspImageDisplay?id="+str+"\" rel=\"lightbox\"><img src=\"http://localhost:8080/FinalCBIR/src/JspImageDisplay?id="+str+"\" width=\"450\" height=\"300\" /></a>";
var path1="<a class='vlightbox1' href='data/images1/wintermsg.jpg' title='WinterMsg'><img src='data/thumbnails1/wintermsg.jpg' alt='WinterMsg'/></a>";
document.getElementById("image").innerHTML=path;

}
function showpreview(str)
{
if(str=="")
{
document.getElementById("internalimage").innerHTML="";
return;
}
document.getElementById("internalimage").innerHTML="<a href=\""+str+"\"><img src=\""+str+"\" width=\"160\" height=\"130\"></a>";
}
function showImage(str)
{
var key = document.getElementById("color");
 var ext = str.substring(str.length-3,str.length);
  ext = ext.toLowerCase();
  if(ext=='')
  {
  alert('select image path ');
  return false;
  }
  if(ext != 'jpg') 
  {
    alert('You selected a .'+ext+' file; please select a .jpg file instead!');
    return false; 
  }
  else
  {
  if (str=="")
  {
  document.getElementById("displayimagedesc").innerHTML="";
  return;
  }  
 if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("displayimagedesc").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("get","RetrieveServletByColor?path="+str,true);
xmlhttp.send();
}
}


function showImageByShape()
{
	var path=document.getElementById("getpreview").value;
	//alert("Path is "+path);
 var ext = path.substring(path.length-3,path.length);
  ext = ext.toLowerCase();
  if(ext=='')
  {
  alert('select image path ');
  return false;
  }
  if(ext != 'jpg') 
  {
    alert('You selected a .'+ext+' file; please select a .jpg file instead!');
    return false; 
  }
  else
  {
if (path=="")
  {
  document.getElementById("displayimagedesc").innerHTML="";
  return;
  }  
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("displayimagedesc").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("get","RetrieveServletByShape?shape1="+path,true);
xmlhttp.send();
}
}


function showImageByTexture(path)
{
 var ext = path.substring(path.length-3,path.length);
  ext = ext.toLowerCase();
  if(ext=='')
  {
  alert('select image path ');
  return false;
  }
  if(ext != 'jpg') 
  {
    alert('You selected a .'+ext+' file; please select a .jpg file instead!');
    return false; 
  }
  else
  {
	if (path=="")
  {
  document.getElementById("displayimagedesc").innerHTML="";
  return;
  }  
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("displayimagedesc").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("get","RetrieveServletByTexture?texture="+path,true);
xmlhttp.send();
}
}


function refresh()
{
	//alert("!");
	document.getElementById("displayimagedesc").innerHTML="";
}

function check() 
{
  var ext = document.f.datafile.value;
  ext = ext.substring(ext.length-3,ext.length);
  ext = ext.toLowerCase();
  if(ext=='')
  {
  alert('select image path ');
  return false;
  }
  if(ext != 'jpg') {
    alert('You selected a .'+ext+' file; please select a .jpg file instead!');
    return false; }
  else
  {
    return true; 
    }
  }
  
 function check1() 
{
  var ext = document.f1.entfile.value;
  ext = ext.substring(ext.length-3,ext.length);
  ext = ext.toLowerCase();
  if(ext=='')
  {
  alert('select image path ');
  return false;
  }
  if(ext != 'jpg') {
    alert('You selected a .'+ext+' file; please select a .jpg file instead!');
    return false; }
  else
  {
    return true; 
    }
  }
</script>
<style type="text/css">
div.img
  {
  margin:2px;
  height:auto;
  width:auto;
  float:right;
  text-align:center;
  }
div.img img
  {
  display:inline;
  margin:3px;
  border:1px solid #ffffff;
  }
 #img1 {
 width:724px; 
 height:133px;
 padding: 0px;} 
</style>

</head>
<body>

<div class="PageBackgroundSimpleGradient">
    </div>
    <div class="PageBackgroundGlare">
        <div class="PageBackgroundGlareImage"></div>
    </div>
    <div class="Main">
        <div class="Sheet">
            <div class="Sheet-tl"></div>
            <div class="Sheet-tr"><div></div></div>
            <div class="Sheet-bl"><div></div></div>
            <div class="Sheet-br"><div></div></div>
            <div class="Sheet-tc"><div></div></div>
            <div class="Sheet-bc"><div></div></div>
            <div class="Sheet-cl"><div></div></div>
            <div class="Sheet-cr"><div></div></div>
            <div class="Sheet-cc"></div>
            <div class="Sheet-body">
                <div class="nav">
                    <ul class="artmenu">
                        <li><a href="home.jsp" class=" active"><span><span>Store</span></span></a></li>
                        <li><a href="Searchpage.jsp" class=" active"><span><span>Search</span></span></a></li>
                        
                        <li><a href="help.jsp" class=" active"><span><span>Help</span></span></a></li>
                        <li><a href="aboutus.jsp" class=" active"><span><span>About</span></span></a></li>               
                          <li><a href="Logout.jsp" class=" active"><span><span>Logout</span></span></a></li>               
                    </ul>
                    <div class="l">
                    </div>
                    <div class="r">
                        <div>
                        </div>
                    </div>
                </div>
                <div class="Header">
                    <div class="Header-jpeg"></div>
                    <div class="logo">
                        <h1 id="name-text" class="logo-name"><a href="#">Query Based Image Retrieval System</a></h1>
                    </div>
                </div>
                    </div>
                    <div class="content">
                        <div class="Post">
                            <div class="Post-tl"></div>
                            <div class="Post-tr"><div></div></div>
                            <div class="Post-bl"><div></div></div>
                            <div class="Post-br"><div></div></div>
                            <div class="Post-tc"><div></div></div>
                            <div class="Post-bc"><div></div></div>
                            <div class="Post-cl"><div></div></div>
                            <div class="Post-cr"><div></div></div>
                            <div class="Post-cc"></div>
                            <div class="Post-body">
                        <div class="Post-inner">
                            <div class="PostMetadataHeader">
                                <h2 class="PostHeaderIcon-wrapper">
                                    <img src="template/images/PostHeaderIcon.png" width="22" height="21" alt="PostHeaderIcon" />
                                    <span class="PostHeader">WELCOME!!</span>
                                </h2>
                            </div>
                            <div class="PostContent">
                                
								
							
								<br>
								<p>
								Retrieve Images from the database
								</p>
								
								
								<br/>
								<label>Retrieve by feature</label>
								<select name="retrieve" id="retrieve" onchange="refresh()">
									<option value="0" selected>Select type</option>
									<option value="color">COLOR</option>
									<option value="texture">TEXTURE</option>
									<option value="shape">SHAPE</option>
								
								</select>
								<br />
								<br /> 
								<br />
								
								<br /> 
								<div id="type" style="float:left;">
								
								</div>
								
								<br/>
							
								<br />
								OUTPUT RESULT:<br>
								<font color=blue>(TIP: Click on the Image for Full View)</font>
								
								<br /> 
								
								<center>
									
								<div id="displayimagedesc">
									
								Output Images will be displayed here.
								
								</div>
								</center>
									
									
								<br>
							
								<br/>
								<br />
								<br /> 
								
								<div id="image"></div>
       
                               
                            </div>
                            <div class="cleared"></div>
                        </div>
                        
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="cleared"></div><div class="Footer">
                    <div class="Footer-inner">
                        
                        <div class="Footer-text">
                            <p>
                               <br />
                                Copyright &copy; 2016 ---. All Rights Reserved.</p>
                        </div>
                    </div>
                    <div class="Footer-background"></div>
                </div>
            </div>
   
        <div class="cleared"></div>
       
 
</body>
</html>
