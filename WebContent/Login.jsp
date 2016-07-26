<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>loginForm</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Rational Application Developer">
	
<script type="text/javascript" src="template/script.js"></script>
<link rel="stylesheet" href="template/style.css" type="text/css" media="screen" />
<script language="javascript">
function login(userid,password)
{
	var user=userid;
	var pass=password;
	if(user=="cbir"&&pass=="cbir")
	{
	return true;
	}
	else
	{
	document.getElementById("message").innerHTML="<font color=red>Error!!!<p>Please enter valid User-name and password</font>";
	return false;
	}
} 
</script>
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
                                 <br> <br> <br> <br> <br>
                                   <center>
                                    <div id="message">
                            		</div>
                                   </center>
                               <br> <br> <br> <br> <br> <br>
                           
             				<div style='width:100% ;height:250px'>
             			
             				<form name="loginform" method="get" action="login">
             				<center>
             				
       						<table>
       						<tr>
       						<td>Enter user-name:</td>
       						<td><input type="text" name="userid"></td>
       						</tr>
       						<tr>
       						<td>Enter password:</td>
       						<td><input type="password" name="password"></td>
       						</tr>
  							<tr>
       						  
       						<td>  <input type="Submit" value="login" onclick="return login(userid.value,password.value);"></td>
       						<td><input type="Reset"></td>
       						</tr>
       						</table>
       						</center>
       						</form>
             				</div>
       						
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
