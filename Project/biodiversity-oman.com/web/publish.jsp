<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
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
				</ul>
				<div class="tab-content">
					<div id="tab1" class="tab active">
						<p>content</p>
					</div>
					<div id="tab2" class="tab">
						<p>content</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
