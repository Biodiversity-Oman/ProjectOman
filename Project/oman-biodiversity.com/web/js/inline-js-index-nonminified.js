
/// index.jsp inline js

$('a').click(function () {
    $('html, body').animate({
	scrollTop: $($(this).attr('href')).offset().top
    }, 500);
    return false;
});

$(function () {
    $('#menu').slicknav({
	label: ''
    });
});
$(document).ready(function () {
    $('#calendar').fullCalendar({
	googleCalendarApiKey: 'AIzaSyBNJFnwaBuRvwA8ZBswpgV-CyKV8lTz8YQ',
	events: {
	    googleCalendarId: 'developersteam.belgium@gmail.com'
	},
	eventAfterRender: function (event, element, view) {
	    $(element).css({"background-color": "#4DB6AC", "font-size": "1.2em", "font-family": "Helvetica-Light", "padding": "1em"});
	},
	eventClick: function (event) {
	    if (event.url) {
		window.open(event.url);
		return false;
	    }
	},
	eventColor: '#26A69A',
	height: 'auto'
    });
    $("#slide-marine-world").click(function () {
	$("#marine-world-panel").slideToggle("slow");
    });
    $("#slide-animal-world").click(function () {
	$("#animal-world-panel").slideToggle("slow");
    });
    $("#slide-plant-world").click(function () {
	$("#plant-world-panel").slideToggle("slow");
    });
    $("#slide-microbial-world").click(function () {
	$("#microbial-world-panel").slideToggle("slow");
    });
    loadOrganisms();
    $(function () {
	var minimized_elements = $('p.minimize');
	minimized_elements.each(function () {
	    var t = $(this).text();
	    if (t.length < 200)
		return;
	    $(this).html(
		    t.slice(0, 200) + '<span>... </span><a href="#" class="more">more</a>' +
		    '<span style="display:none;">' + t.slice(200, t.length) + ' <a href="#" class="less">less</a></span>'
		    );
	});

	$('a.more', minimized_elements).click(function (event) {
	    event.preventDefault();
	    $(this).hide().prev().hide();
	    $(this).next().show();
	});
	$('a.less', minimized_elements).click(function (event) {
	    event.preventDefault();
	    $(this).parent().hide().prev().show().prev().show();
	});
    });
});
var feed = new Instafeed({
    get: 'tagged',
    tagName: 'iranwildlife',
    clientId: '795b3c3858144130b2a7ce7f41f3b20a',
    limit: 4,
    template: '<a href="{{link}}" target="_blank"><img src="{{image}}" style="margin: 0.2em" /></a>',
    sortBy: 'most-recent'
});
feed.run();

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
	return;
    js = d.createElement(s);
    js.id = id;
    js.async = true;
    js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=830099023749020&version=v2.3";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

var url = document.URL;
if (url.slice(-6) === 'worlds') {
    $(window).load(function () {
	$('html, body').animate({
	    scrollTop: $("#worlds").offset().top
	});
    });
}
/////////////////////////////////////////////////////////////////	    
//organism detail inline js
$(document).ready(function () {

    $("#slide-info").click(function () {
	$("#info-panel").slideToggle("slow");
    });
});
$(function () {
    var minimized_elements = $('p.minimize');
    minimized_elements.each(function () {
	var t = $(this).text();
	if (t.length < 200)
	    return;
	$(this).html(
		t.slice(0, 200) + '<span>... </span><a href="#" class="more">more</a>' +
		'<span style="display:none;">' + t.slice(200, t.length) + ' <a href="#" class="less">less</a></span>'
		);
    });
    $('a.more', minimized_elements).click(function (event) {
	event.preventDefault();
	$(this).hide().prev().hide();
	$(this).next().show();
    });
    $('a.less', minimized_elements).click(function (event) {
	event.preventDefault();
	$(this).parent().hide().prev().show().prev().show();
    });
});