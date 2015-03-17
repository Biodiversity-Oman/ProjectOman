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
                $('#calendar').fullCalendar({
                    googleCalendarApiKey: 'AIzaSyBNJFnwaBuRvwA8ZBswpgV-CyKV8lTz8YQ',
                        events: {
                            googleCalendarId: 'developersteam.belgium@gmail.com'

                            },
                            eventAfterRender: function (event, element, view) {
                                $(element).css({"background-color": "#4DB6AC", "font-size": "1.2em", "font-family": "'Montser', sans-serif", "padding": "1.5em"});
                            },
                            eventColor: '#26A69A'
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
            });
            $('a').click(function () {
                $('html, body').animate({
                    scrollTop: $($(this).attr('href')).offset().top
                }, 500);
                return false;
            });
        </script>
        <script type="text/javascript">
            var feed = new Instafeed({
                get: 'tagged',
                tagName: 'iranwildlife',
                clientId: '795b3c3858144130b2a7ce7f41f3b20a',
                limit: 4,
                template: '<a href="{{link}}" target="_blank"><img src="{{image}}" style="margin: 0.2em" /></a>',
                sortBy: 'most-recent'
            });
            feed.run();
        </script>
        <script>
                    $(document).ready(function () {
                        loadOrganisms();
                    });
        </script>
        <body>
                <div id="fb-root"></div>
                <script>
                    (function(d, s, id) {
                  var js, fjs = d.getElementsByTagName(s)[0];
                  if (d.getElementById(id)) return;
                  js = d.createElement(s); js.id = id;
                  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=878087015554008&version=v2.0";
                  fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));
                </script>
                <div class="wrapper">
                        <section class="event-container" id="event">
                                <div class="col-md-11 col-md-offset-1">
                                                <div class="col-md-1">
                                                        <img src="img/oman-mother-children.png" width="80" height="128">
                                        </div>
                                        <div class="col-md-10">
                                                <h1><strong>All the treasures of Oman</strong></h1>
                                                <p class="lead">The Oman Animal and Plant Genetic Resources Center(OAPGRC), along with its partners, has organized a fun filled event for you to learn about the beautiful plants, animals, marine, and microbial species of Oman</p>
                                        </div>
                                        <div class="col-md-4" >
                                                <h3><u>DNA</u></h3>
                                                <p class="text-left">There is also another way of organizing living things, one that all these five kingdoms have in common.</p><p> Scientists have discovered that every living organism has a special unique code. And that code describes every bit of every organism. It shows us how one thing is different from another. This code is called DNA</p><p> DNA describes all the ingredients and characteristics needed to make every living organism.</p>
                                                <div class="col-md-4"><img class="event-image" src="img/oman-logo.png" ></div>
                                        </div>
                                        <div class="col-md-2">
                                                <h3><u>Taxonomy</u></h3>
                                                <p class="text-left">There are different ways of organizing all living things. One of the oldest ways is called taxonomy.</p><p> This is when scientists divide up living organisms into groups, based on the way they look and behave. For example, every warm-blooded animal that provides milk for their young belongs to the group we call 'mammals' and every creature that lays eggs and has feathers belongs to the group we call 'birds'.</p> Scientists have divided the living world into five different kingdoms.</p>
                                        </div>
                                        <div class="col-md-4"  >
                                                <div class="col-md-10">
                                                        <center><img src="img/oman-boy.png" widt="97" height="114" style="margin-top: 5em;"><center>     
                                                </div>
                                                <div class="col-md-10">
                                                        <a href="#worlds"><button class="button btn-material-yellow"><strong>Find out more about Organisms!</strong></button></a>
                                                </div>
                                        </div>

                                </div>
                        </section>
                        <section class="menu calendar-container" id="event-calendar">
                                <div class="col-lg-11 col-md-offset-1">
                                        <div class="col-lg-8">
                                                <h1><u>Event Calendar</u></h1>
                                                <p class="lead">Find out when and where the event is taking place!</p>
                                        </div>
                                        
                                        <div class="col-lg-7">
                                                <div id='calendar'></div>
                                        </div>
                                        <div class="col-lg-3 col-md-offset-1 social-container">
                                                <div class="row">
                                                <h1 class="text-center"><u>What is Happening?</u></h1>
                                                <p class="lead text-center">Find us on Instagram & Facebook!</p>
                                                </div>
                                                <div class="social-border">
                                                    <div class="row"><h3 class="text-center"><span class="icon-instagram"></span>Instagram</h3></div>
                                                    <div class="row"><div class="text-center" id="instafeed"></div></div><br>
                                                </div>
                                                <div class="social-border">
                                                        <div class="row"><h3 class="text-center"><span class="icon-facebook3"></span>Facebook</h3></div>
                                                        <div class="row"><div class="fb-like-box" data-href="https://www.facebook.com/pages/Oman-biodiversity/1375638472760746" data-colorscheme="light" data-show-faces="false" data-header="false" data-stream="true" data-show-border="false" data-width="450"></div></div>
                                                </div>
                                        </div>
                                </div>
                        </section>
                        <section class="worlds-container" id="worlds">
                                <div class="col-lg-11 col-md-offset-1">
                                        <div class="col-lg-7">
                                                <h1><u>Choose a World</u></h1>
                                                <p class="lead">Every animal lives in his desired world. Click on a world to find out more!</p>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-marine-world" class="world marine-world">
                                                        <h2 class="text-center">The Marine World</h2>
                                                        <h4 class="text-center">Think blue!</h4>
                                                </div>
                                                <div class="slide-panel marine-world" id="marine-world-panel"><p>
                                                                Oman with its long coastline, has a treasure chest of marine life, with over 20 marine mammals, more than 1000 fish species, over 250 coral species and 5 turtle species. 
                                                                How many things that live in the sea can you name?
                                                                A lot of work is currently going on to study the marine diversity in Oman. 
                                                                It is important that we protect our marine ecosystems, biodiversity and genetic diversity and make sure that we use them responsably so they are still there for generations to come.
                                                        </p>
                                                        <ul id="marine-organisms">Organisms</ul>
                                                </div>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-animal-world" class="world animal-world">
                                                        <h2 class="text-center">The Animal World</h2>
                                                        <h4 class="text-center">Extinction is forever</h4>
                                                </div>
                                                <div class="slide-panel animal-world" id="animal-world-panel">
                                                        <p>Oman is blessed with over 47 species of land mammals, 10 livestock species and over a hundred types of birds.  Although we know a lot about Oman’s biodiversity, little is known about their genetic diversity.
                                                                What is genetic diversity? 
                                                                In every species, each individual animal has a unique genetic code – this is what gives them their own special characteristics, like big feet, short feathers or a bright colour. We need to understand these variations so we can look after our animal world properly and make the best use of it. 
                                                                Humans have been domesticating wild animals for thousands of years.  The main types of animals that people in Oman farm and eat are cattle, sheep, goats, camels and poultry. The great majority of these are local but foreign breeds are used too, for example, as dairy cattle and on commercial chicken farms.  
                                                                Meat and milk are the most important products from cattle, while meat is the most important product from sheep and goats. Poultry is used for its meat and eggs.  
                                                                Cattle are the main source of manure in the country followed by goats, then sheep and poultry!
                                                                Animals play an important role in society.  They are a source of energy, fertilizers and income. They are also valued as pets.
                                                                Animal genetic resources face a lot of threats from the environment as well as humans. Animals are important to us for our food and for our environment. We need to protect them.</p>
                                                <ul id="animal-organisms">Organisms</ul>
                                                </div>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-plant-world" class="world plant-world">
                                                        <h2 class="text-center">The Plant World</h2>
                                                        <h4 class="text-center">Planting for tomorrow</h4>
                                                </div>
                                                <div class="slide-panel plant-world" id="plant-world-panel"><p>plant genetic resources are important to Oman, whether they are for agriculture or for things like medicine. 
                                                                Oman is blessed with so many species of plants – more than 1,200! This biodiversity is because Oman sits between two regions – Asia and Africa. The plants in the north of Oman are more like those of Asia and those in the south are more like those you can find in Africa and some plants you can only find in Oman. 
                                                                Because of this combination, Oman has been able to develop a big diversity of plant genetic resources. That’s why we have so many different kinds of fruits – from mangoes and bananas to pomegranates, plums and peaches. We have vegetables too and plants that animals like to eat. 
                                                                The Oman Animal and plant Genetic Resources Center is now collecting all the information about the plants of Oman and storing it in a database so researchers can use thi information to turn our genetic resources into value.. 
                                                                Like all genetic resources, our plants are under threat from us humans and the environment! 
                                                                We need to protect and preserve our plants!</p>
                                                <ul id="plant-organisms">Organisms</ul>
                                                </div>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-microbial-world" class="world microbial-world">
                                                        <h2 class="text-center">The Microbial World</h2>
                                                        <h4 class="text-center">Look into my world!</h4>
                                                </div>
                                                <div class="slide-panel microbial-world" id="microbial-world-panel"><p>
                                                                Microorganisms, or microbes, are tiny creatures that usually can only be seen with the help of a microscope. They are mostly just a single cell or made up of a cluster of cells. 
                                                                There are lots of different types of microbes. They include fungi and bacteria, as well as microscopic plants and animals.
                                                                You can find microbes in every place that has water such as soil, the atmosphere, the ocean floor… even on your hand!

                                                                Microbes play an important role in maintaining our environment and some are useful in our daily lives. They help us make our food, grow our plants and give us medicine. Scientists are even finding ways to use them in industry. 
                                                                BUT some microbes are harmful! They can cause diseases to humans and other genetic resources.  Lucky the good microbes give us medicine!
                                                                Microbial genetic resources are becoming more and more important because of all the help they can give us. Because of this we need to identify them and protect them…  just like all our other genetic resources.
                                                        </p>
                                                <ul id="microbial-organisms">Organisms</ul>
                                                </div>
                                        </div>
                                </div>
                        </section>
                        <section class="fun-stuff-container" id="fun-stuff">
                                <div class="col-lg-11 col-md-offset-1">
                                        <div class="col-lg-10">
                                            <h1><u>Lets have some fun!</u></h1>
                                            <p class="lead">Cool stories, facts & games!</p>
                                        </div>
                                        <div class="col-lg-5">
                                                <h2>Coming Soon!</h2>
                                        </div>
                                </div>
                                
                        </section>
                        <section class="footer-container" id="about-us">
                                <div class="col-lg-11 col-md-offset-1">
                                        <div class="col-lg-12">
                                                <h1><u>About us</u></h1>
                                        </div>
                                        <div class="col-lg-2">
                                                <h2>Developers</h2>
                                                <p>Tom Adriaens</p>
                                                <p>Lenny Donnez</p>
                                                <p>Eric Michiels</p>
                                                <p>Bert Cortois</p>
                                                <p>Oualid Yousfi</p>
                                        </div>
                                        <div class="col-lg-2">
                                                <h2>Project Leader</h2>
                                                <p>Philippe Keunen</p>
                                        </div>
                                        <div class="col-lg-3 col-md-offset-3" >
                                                <h2></h2><br>
                                                <p><img src="img/logo-aopgrc.png" width="120" height="110"></p>
                                        </div>
                                </div>
                        </section>
                </div>
        </body>
</html>
