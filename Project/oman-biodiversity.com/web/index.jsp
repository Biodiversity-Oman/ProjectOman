<%-- 
    Document   : index
    Created on : Mar 12, 2015, 3:21:18 PM
    Author     : lenny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="css/bootstrap-main.min.css">
	<link rel="StyleSheet" type="text/css" href="css/main.min.css">
	<link rel="stylesheet" href="css/plugins.min.css" media="none" onload="if(media!='all')media='all'">
	<link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css' media="none" onload="if(media!='all')media='all'">
	<link rel="StyleSheet" type="text/css" href="css/icons.min.css" media="none" onload="if(media!='all')media='all'">
	<title>Oman-Biodiversity</title>
    </head>
    <nav>
	    <ul id="menu">
		<li><img src="img/logo-roadshow.png" height="58" width="103"></li>
		<li><a href="#event">Event</a></li>
		<li ><a href="#event-calendar">Calendar</a></li>
		<li><a href="#worlds">Worlds</a></li>
		<li><a href="#fun-stuff">Fun stuff</a></li>
		<li><a href="#about-us">About us</a></li>
	    </ul>
    </nav>
    <body>
        <div class="wrapper">
            <section class="event-container" id="event">
                <div class="col-lg-11 col-lg-offset-1">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="col-lg-1 col-md-2 col-sm-2 col-xs-12"><img class="img-header img-responsive" src="img/oman-mother-children.png" width="80" height="128"></div>
                            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                                <h1><strong>All the treasures of Oman</strong></h1>
                                <p class="lead">The Oman Animal and Plant Genetic Resources Center(OAPGRC), along with its partners, has organized a fun filled event for you to learn about the beautiful plants, animals, marine, and microbial species of Oman</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <h3><u>DNA</u></h3>
                        <p class="text-left">There is also another way of organizing living things, one that all these five kingdoms have in common.</p><p> Scientists have discovered that every living organism has a special unique code. And that code describes every bit of every organism. It shows us how one thing is different from another. This code is called DNA</p><p> DNA describes all the ingredients and characteristics needed to make every living organism.</p>
                        <img class="event-image" src="img/oman-logo.png" width="400" height="288">
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <h3><u>Taxonomy</u></h3>
                        <p class="text-left">There are different ways of organizing all living things. One of the oldest ways is called taxonomy.</p><p> This is when scientists divide up living organisms into groups, based on the way they look and behave. For example, every warm-blooded animal that provides milk for their young belongs to the group we call 'mammals' and every creature that lays eggs and has feathers belongs to the group we call 'birds'.</p> Scientists have divided the living world into five different kingdoms.</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
                            <center><img src="img/oman-boy.png" width="97" height="114" style="margin-top: 5em;"></center>     
                        </div>
                        <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
                            <a href="#worlds"><button class="button btn-material-yellow"><strong>Find out more about Organisms!</strong></button></a>
                        </div>
                    </div>
                </div>
            </section>
            <section class="menu calendar-container" id="event-calendar">
                <div class="col-lg-11 col-md-offset-1">
                    <div class="col-lg-8">
                        <h1> </h1>
                        <p class="lead">Find out when and where the event is taking place!</p>
                    </div>
                    <div class="col-lg-7">
                        <div id='calendar'></div>
                        <div class="col-lg-* col-md-* col-sm-* col-xs-*">
                            <div class="subscribe-container">
				<div class="grey-border">
				    <form class="form form-horizontal" id="create-subscriber-form" data-toggle="validator">
					<div class="form-group">
					    <label class="col-sm-2 col-xs-2 control-label"></label>
					    <div class="col-sm-6 col-xs-9 col-xs-offset-1">
						<h3 class="h3 text-center">Subscribe to our newsletter</h3>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-2 col-xs-2 control-label" for="subscriber-firstname">Name</label>
					    <div class="col-sm-6 col-xs-9 col-xs-offset-1">
						<input class="form-control subscribe-input" type="text" name="subscriber-firstname" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$"  required/>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-2 col-xs-2 control-label" for="subscriber-lastname">Family name</label>
					    <div class="col-sm-6 col-xs-9 col-xs-offset-1">
						<input class="form-control subscribe-input" type="text" name="subscriber-lastname" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$"  required/>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-2 col-xs-2  control-label" for="subscriber-email">E-mail</label>
					    <div class="col-sm-6 col-xs-9 col-xs-offset-1">
						<input class="form-control subscribe-input" type="text" name="subscriber-email" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9!]+$"  required/>
					    </div>
					</div>
					<div class="form-group" >
					    <label class="col-sm-2 col-xs-2 control-label"> </label>
					    <div class="col-sm-6 col-xs-9 col-xs-offset-1">
						<button type="submit" class="button btn-material-white">Submit</button>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-2 control-label"></label>
					    <div class="col-sm-4">
						<div class="message" id="create-subscriber-message"></div>
					    </div>
					</div>
				    </form>
				</div>
                            </div>
                        </div> 
                    </div>
                    <aside class="social-container">
                        <div class="col-lg-5">
                            <div class="row">
                                <div class="col-lg-8">
                                    <p class="lead text-center">Find us on Instagram! & Facebook!</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-8 col-md-5 col-sm-6 col-xs-12">
				    <div class="row"><h3 class="text-center"><span class="icon-instagram"></span>Instagram</h3></div>
				    <div class="row"><div class="text-center" id="instafeed"></div></div><br>
                                </div>
                                <div class=" col-lg-8 col-md-6 col-sm-6 col-xs-12">
				    <div class="row"><h3 class="text-center"><span class="icon-facebook3"></span>Facebook</h3></div>
				    <div class="row"><div id="fb-root"><div class="fb-page" data-href="https://www.facebook.com/pages/Oman-biodiversity/1375638472760746" data-hide-cover="false" data-show-facepile="false" data-show-posts="true"></div></div></div>
                                </div>
                            </div>
                        </div>
                    </aside> 
                </div>               
            </section>
            <section class="worlds-container" id="worlds">
                <div class="col-lg-11 col-md-offset-1">
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12 ">
                        <h1> </h1>
                        <p class="lead">Every animal lives in his desired world. Click on a world to find out more!</p>
                        <form class="form" id="form-search-organism">
                            <div class="form-group">
                                <div class="col-lg-6 col-md-10 col-sm-10 col-xs-7 ">
                                    <input class="form-control search-input" id="keyword" type="text" name="organismkey" placeholder="Search for an organism!">
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-1">
                                <button type="submit" class="button btn-material-orange">Search</button>
                            </div>
                        </form>
                        <div class="search-result col-lg-12 col-md-12 col-sm-12 col-xs-12" id="search-result" ></div>
                    </div>
                    <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                        <div id="slide-marine-world" class="world marine-world">
                            <h2 class="text-center">The Marine World</h2>
                            <h4 class="text-center">Think blue!</h4>                            
                        </div>
                        <div class="slide-panel marine-world" id="marine-world-panel">
                            <img class="img-responsive center-block" src="img/marine-dio.JPG" alt="marine diorama" width="1253" height="801" />
                            <div class="row">
                                <div class="organism-box center-block" id="marine-organisms"></div>
                            </div>
                            <p class="minimize">                                
                                Oman, with its long coastline, harbours a treasure of marine life with over 20 marine mammals, more than 1000 fish species, over 250 coral species and 5 turtle species. 
                                How many things that live in the sea, can you name?
                                A lot of work is currently going on to study the marine diversity in Oman. 
                                It is important that we protect our marine ecosystems, biodiversity, genetic diversity, and make sure that we use them responsibly so they are still there for generations to come.
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                        <div id="slide-animal-world" class="world animal-world">
                            <h2 class="text-center">The Animal World</h2>
                            <h4 class="text-center">Extinction is forever</h4>
                        </div>
                        <div class="slide-panel animal-world" id="animal-world-panel">
                            <img class="img-responsive center-block" src="img/animal-dio.jpg" alt="marine diorama" width="1234" height="622" />
                            <div class="row">
                                <div class="organism-box center-block" id="animal-organisms"></div>
                            </div>
                            <div class="world-text" >
                                <p class="minimize">Oman is blessed with over 47 species of land mammals, 10 livestock species and over a hundred types of birds.  Although we know a lot about Oman’s biodiversity, little is known about their genetic diversity.
                                    What is genetic diversity? 
                                    In every species each individual animal has a unique genetic code. This is what gives them their own special characteristics, like big feet, short feathers or a bright colour. We need to understand these variations so we can look after our animal world properly and make the best use of it. 
                                    Humans have been domesticating wild animals for thousands of years.  The main type of animals that people in Oman farm and eat are: cattle, sheep, goats, camels and poultry. The great majority of these are local. But foreign breeds are used too, for example: dairy cattle and on commercial chicken farms.  
                                    Meat and milk are the most important products from cattle, while meat is the most important product from sheep and goats. Poultry is used for its meat and eggs.  
                                    Cattle are the main source of manure in the country followed by goats, sheep and poultry.
                                    Animals play an important role in society.  They are a source of energy, fertilizers and income. They are also valued as pets.
                                    Animal genetic resources face a lot of threats from the environment as well as humans. Animals are important to us for our food and for our environment. We need to protect them.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                        <div id="slide-plant-world" class="world plant-world">
                            <h2 class="text-center">The Plant World</h2>
                            <h4 class="text-center">Planting for tomorrow</h4>
                        </div>
                        <div class="slide-panel plant-world" id="plant-world-panel">
                            <img class="img-responsive center-block" src="img/plant.JPG" alt="plant diorama" width="1069" height="709" />
                            <div class="row">
                                <div class="organism-box center-block" id="plant-organisms"></div>
                            </div>
                            <p class="minimize">Plant genetic resources are important to Oman, whether they are for agriculture or for things like medicine. 
                                Oman is blessed with so many species of plants – more than 1,200! This biodiversity is because Oman is located between two continents:  Asia and Africa. The plants in the north of Oman are more like those of Asia and those in the south are more like those you can find in Africa and some plants can only be found in Oman. 
                                Because of this combination, Oman has been able to develop a vast diversity of plant genetic resources. That’s why we have so many different kinds of fruits – from mangoes and bananas to pomegranates, plums and peaches. We also have vegetables and plants that animals like to eat as well. 
                                The Oman Animal and Plant Genetic Resources Centre is now gathering all the information about the plants of Oman and storing it in a database so that researchers can use this information to turn our genetic resources into more valuable assets.  
                                Like all genetic resources, our plants are under threat from us humans and the environment! 
                                We need to protect and preserve our plants!</p>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                        <div id="slide-microbial-world" class="world microbial-world">
                            <h2 class="text-center">The Microbial World</h2>
                            <h4 class="text-center">Look into my world!</h4>
                        </div>
                        <div class="slide-panel microbial-world" id="microbial-world-panel">
                            <img class="img-responsive center-block" src="img/microbial.JPG" alt="Microbial diorama" width="1089" height="716" />
                            <div class="row">
                                <div class="organism-box center-block" id="microbial-organisms"></div>
                            </div>
                            <p class="minimize">
                                Micro-organisms - or microbes -  are tiny creatures that usually can only be seen with the help of a microscope. They are mostly just a single cell or made up of a cluster of cells. 
                                There are lots of different types of microbes. They include fungi and bacteria, as well as microscopic plants and animals.
                                You can find microbes in every place that has water such as: soil, the atmosphere, the ocean floor, and even on your hand!

                                Microbes play an important role in maintaining our environment and some are useful in our daily lives. They help us prepare our food, grow our plants and give us medicine. Scientists are even finding ways to use them in an industrial environment. 
                                BUT some microbes are harmful! They can cause diseases to humans and other genetic resources.  Luckily the good microbes give us medicine!
                                Microbial genetic resources are becoming more and more important because of all the help they can give us. Because of this we need to identify them and protect them… just like all our other genetic resources.
                            </p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="fun-stuff-container" id="fun-stuff">
                <div class="col-lg-11 col-md-offset-1">
                    <div class="col-lg-10">
                        <h1> </h1>
                        <p class="lead">Cool stories, facts & games!</p>
                    </div>
                    <div class="col-lg-5">
                        <h2>Coming Soon!</h2>
                    </div>
                </div>
            </section>
            <section class="footer-container" id="about-us">
                <div class="col-lg-11 col-md-offset-1">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h1><u>About us</u></h1>
                    </div>
                    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 text-left">
                        <h2>Developers</h2>
                        <p>Tom Adriaens</p>
                        <p>Lenny Donnez</p>
                        <p>Eric Michiels</p>
                        <p>Bert Cortois</p>
                        <p>Oualid Yousfi</p>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 col-sm-offset-1 text-left ">
                        <h2>Project Leader</h2>
                        <p>Filip Keunen</p>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 col-md-offset-3" >
                        <h2></h2><br>
                        <p><img src="img/logo-aopgrc.png" width="120" height="110"></p>
                    </div>
                </div>
            </section>
        </div>
	<script type="text/javascript" src = 'js/jquery.min.js'></script>
	<script type="text/javascript" src="js/jquery.slicknav.min.js"></script>
	<script type="text/javascript" src="js/plugins.min.js"></script>
        <script type="text/javascript" src='js/view.min.js'></script>
        <script type="text/javascript" src="js/bootstrap-main.min.js" async></script>
	<script type="text/javascript">
	    $("a").click(function(){return $("html, body").animate({scrollTop:$($(this).attr("href")).offset().top},500),!1}),$(function(){$("#menu").slicknav({label:""})}),$("#calendar").fullCalendar({googleCalendarApiKey:"AIzaSyBNJFnwaBuRvwA8ZBswpgV-CyKV8lTz8YQ",events:{googleCalendarId:"developersteam.belgium@gmail.com"},eventAfterRender:function(e,l){$(l).css({"background-color":"#4DB6AC","font-size":"1.2em","font-family":"'Montser', sans-serif",padding:"1em"})},eventClick:function(e){return e.url?(window.open(e.url),!1):void 0},eventColor:"#26A69A",height:"auto"}),$("#slide-marine-world").click(function(){$("#marine-world-panel").slideToggle("slow")}),$("#slide-animal-world").click(function(){$("#animal-world-panel").slideToggle("slow")}),$("#slide-plant-world").click(function(){$("#plant-world-panel").slideToggle("slow")}),$("#slide-microbial-world").click(function(){$("#microbial-world-panel").slideToggle("slow")}),loadOrganisms(),$(function(){var e=$("p.minimize");e.each(function(){var e=$(this).text();e.length<200||$(this).html(e.slice(0,200)+'<span>... </span><a href="#" class="more">more</a><span style="display:none;">'+e.slice(200,e.length)+' <a href="#" class="less">less</a></span>')}),$("a.more",e).click(function(e){e.preventDefault(),$(this).hide().prev().hide(),$(this).next().show()}),$("a.less",e).click(function(e){e.preventDefault(),$(this).parent().hide().prev().show().prev().show()})});var feed=new Instafeed({get:"tagged",tagName:"iranwildlife",clientId:"795b3c3858144130b2a7ce7f41f3b20a",limit:4,template:'<a href="{{link}}" target="_blank"><img src="{{image}}" style="margin: 0.2em" /></a>',sortBy:"most-recent"});feed.run(),function(e,l,n){var a,o=e.getElementsByTagName(l)[0];e.getElementById(n)||(a=e.createElement(l),a.id=n,a.async=!0,a.src="//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=830099023749020&version=v2.3",o.parentNode.insertBefore(a,o))}(document,"script","facebook-jssdk");var url=document.URL;"worlds"===url.slice(-6)&&$(window).load(function(){$("html, body").animate({scrollTop:$("#worlds").offset().top})});
	</script>
    </body>
</html>
