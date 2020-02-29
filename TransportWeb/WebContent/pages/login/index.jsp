<%
	String url = null;
	if (request.getSession().getAttribute("user_session")!=null) {
		if (request.getServerName().trim().equals("localhost")) {
			url = "https://" + request.getServerName()+ ":" + request.getServerPort()  + request.getContextPath() + "/loginValidate.do";	
		} else {
			url = "https://" + request.getServerName() + request.getContextPath() + "/loginValidate.do";
		}
		response.sendRedirect(url);
	} else {
		if (request.getServerName().trim().equals("localhost")) {
			url = "https://" + request.getServerName()+ ":" + request.getServerPort()  + request.getContextPath() + "/login.do";	
		} else {
			url = "https://" + request.getServerName() + request.getContextPath() + "/login.do";
		}
		response.sendRedirect(url);
	}
%>