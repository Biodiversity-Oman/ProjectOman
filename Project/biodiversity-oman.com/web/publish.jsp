<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<%
	if (us.getIsAdmin() == false) {
		response.sendRedirect("notallowed.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<script src="js/ajax.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<div class="tabs">
				<ul class="tab-links">
					<li class="active"><a href="#tab1"><span class="icon-file-text"></span>Published</a></li>
					<li><a href="#tab2"><span class="icon-list"></span>Queue</a></li>
					<li><a href="#tab3"><span class="icon-list"></span>Post</a></li>
					<li><a href="#tab4"><span class="icon-list"></span>Subscriber</a></li>
					
				</ul>
				<div class="tab-content">
					<div id="tab1" class="tab active">
						<p>content</p>
					</div>
					<div id="tab2" class="tab">
						<p>content</p>
					</div>
					<div id="tab3" class="tab">
						<p>content</p>
					</div>
					<div id="tab4" class="tab">
						<p>content</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
