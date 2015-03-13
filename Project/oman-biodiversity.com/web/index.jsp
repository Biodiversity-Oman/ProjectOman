<%-- 
    Document   : index
    Created on : Mar 12, 2015, 3:21:18 PM
    Author     : lenny
--%>
<%@include file="/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
	$(document).ready(function () {

	    // page is now ready, initialize the calendar...

	    $('#calendar').fullCalendar({
		// put your options and callbacks here
	    });

	});

	$('a').click(function () {
	    $('html, body').animate({
		scrollTop: $($(this).attr('href')).offset().top
	    }, 500);
	    return false;
	});
    </script>
    <body>
    <div class="wrapper">
	<div class="event-container" id="event">
	    <div class="col-md-12 col-md-offset-1">
		<div class="col-md-12">
		    <h1>Lorem Ipsum</h1>
		    <p class="lead">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
		</div>
		<div class="col-md-4">
		    <h3>DNA</h3>
		    <p class="text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam viverra, est eu scelerisque placerat, erat dolor consectetur tellus, id elementum urna tortor nec massa. Donec eros tellus, commodo at nibh at, dapibus faucibus nisl. Sed pellentesque mi id scelerisque ultricies. Ut facilisis egestas varius. Pellentesque suscipit leo nec leo posuere, in auctor ante ornare. Sed tempus nunc diam, ut rhoncus eros pulvinar ac. In non nisl auctor, ornare augue ut, luctus odio. Vestibulum ut vulputate quam. Etiam in leo risus. Aenean luctus eget nisi quis rutrum. Nulla facilisi.</p>
		</div>
		<div class="col-md-2">
		    <h3>blabla</h3>
		    <p class="text-left">In hac habitasse platea dictumst. Ut posuere non ligula a dignissim. Duis pharetra ex vel nibh vestibulum, sed ultricies urna feugiat. Nam lacus risus, gravida at bibendum sed, convallis ut neque. Morbi sed scelerisque mi. Nulla quis erat et tortor mattis ornare ac eget elit. Duis eget sapien mollis, faucibus nisi vitae, tempus massa. Pellentesque et vulputate velit. Nulla arcu nisi, volutpat sed porta nec, congue sed ligula. Nunc vulputate metus eu orci imperdiet, in blandit massa scelerisque. Duis est turpis, posuere a molestie sit amet, ullamcorper nec orci. </p>
		</div>
		<div class="col-md-4">
		    <div class="col-xs-12">
			<div class="col-md-12">
			    <a href="#worlds"><button class="button btn-material-yellow"><strong>Find out more about Organisms!</strong></button></a>
			</div>
			<div class="col-md-9">
			</div>
		    </div>
		</div>
	    </div>
	</div>
	<div class="menu calendar-container" id="event-calendar">
	    <div class="col-lg-12 col-md-offset-1">
		<div class="col-lg-10">
		    <h1><u>Event Calendar</u></h1>
		    <p class="lead">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
		</div>
		<div class="col-lg-8">
		    <div id='calendar'></div>
		</div>
	    </div>
	</div>
	<div class="worlds-container" id="worlds">
	    <div class="col-lg-10 col-md-offset-1">
		<div class="col-lg-7">
		    <h1><u>Choose a World</u></h1>
		    <p class="lead">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
		</div>
		<div class="col-lg-7">
		    <div class="world marine-world">
			<h2 class="text-center">The Marine World</h2>
			<p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
		    </div>
		</div>
		<div class="col-lg-7">
		    <div class="world animal-world">
			<h2 class="text-center">The Animal World</h2>
			<p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
		    </div>
		</div>
		<div class="col-lg-7">
		    <div class="world plant-world">
			<h2 class="text-center">The Plant World</h2>
			<p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
		    </div>
		</div>
		<div class="col-lg-7">
		    <div class="world microbial-world">
			<h2 class="text-center">The Microbial World</h2>
			<p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
		    </div>
		</div>
	    </div>
	</div>
	<div class="howto-container" id="howto">
	    <div class="col-lg-12 col-md-offset-1">
		<h1><u>How to user this website</u></h1>
		<p class="lead">"You are an idiot if you dont know how to use this website"</p>
	    </div>
	</div>
	<div class="footer-container" id="credits">
	    <div class="col-lg-12">
		<div class="col-lg-10">
		    <h1><u>Credits</u></h1>
		</div>
		<div class="col-lg-3">
		    <h2>Developers</h2>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		</div>
		<div class="col-lg-3">
		    <h2>Project Leader</h2>
		    <p>Philippe </p>
		</div>
		<div class="col-lg-3">
		    <h2>the idiots</h2>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		</div>
		<div class="col-lg-3">
		    <h2>more idiots</h2>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		    <p>name</p>
		</div>
	    </div>
	</div>
    </div>
    </body>
</html>
