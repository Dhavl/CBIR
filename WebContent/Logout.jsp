<%
HttpSession http=request.getSession();
http.invalidate();
response.sendRedirect("Login.jsp");
%>