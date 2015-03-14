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
        <body>
                <div class="wrapper">
                        <section class="event-container" id="event">
                                <div class="col-md-11 col-md-offset-1">
                                        <div class="col-md-11">
                                                <h1>Lorem Ipsum</h1>
                                                <p class="lead">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
                                        </div>
                                        <div class="col-md-4">
                                                <h3>DNA</h3>
                                                <p class="text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam viverra, est eu scelerisque placerat, erat dolor consectetur tellus, id elementum urna tortor nec massa. Donec eros tellus, commodo at nibh at, dapibus faucibus nisl. Sed pellentesque mi id scelerisque ultricies. Ut facilisis egestas varius. Pellentesque suscipit leo nec leo posuere, in auctor ante ornare. Sed tempus nunc diam, ut rhoncus eros pulvinar ac. In non nisl auctor, ornare augue ut, luctus odio. Vestibulum ut vulputate quam. Etiam in leo risus. Aenean luctus eget nisi quis rutrum. Nulla facilisi.</p>
                                                <img class="event-image" src="img/oman-logo.png" >
                                        </div>
                                        <div class="col-md-2">
                                                <h3>blabla</h3>
                                                <p class="text-left">In hac habitasse platea dictumst. Ut posuere non ligula a dignissim. Duis pharetra ex vel nibh vestibulum, sed ultricies urna feugiat. Nam lacus risus, gravida at bibendum sed, convallis ut neque. Morbi sed scelerisque mi. Nulla quis erat et tortor mattis ornare ac eget elit. Duis eget sapien mollis, faucibus nisi vitae, tempus massa. Pellentesque et vulputate velit. Nulla arcu nisi, volutpat sed porta nec, congue sed ligula. Nunc vulputate metus eu orci imperdiet, in blandit massa scelerisque. Duis est turpis, posuere a molestie sit amet, ullamcorper nec orci. </p>
                                        </div>
                                        <div class="col-md-4"  >
                                                <div class="col-xs-12 col-md-offset-3" >

                                                        <a href="#worlds"><button class="button btn-material-yellow"><strong>Find out more about Organisms!</strong></button></a>

                                                </div>
                                        </div>

                                </div>
                        </section>
                        <section class="menu calendar-container" id="event-calendar">
                                <div class="col-lg-11 col-md-offset-1">
                                        <div class="col-lg-10">
                                                <h1><u>Event Calendar</u></h1>
                                                <p class="lead">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
                                        </div>
                                        <div class="col-lg-8">
                                                <div id='calendar'></div>
                                        </div>
                                </div>
                        </section>
                        <section class="worlds-container" id="worlds">
                                <div class="col-lg-11 col-md-offset-1">
                                        <div class="col-lg-7">
                                                <h1><u>Choose a World</u></h1>
                                                <p class="lead">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-marine-world" class="world marine-world">
                                                        <h2 class="text-center">The Marine World</h2>
                                                        <p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                                                </div>
                                                <div class="slide-panel marine-world" id="marine-world-panel"></div>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-animal-world" class="world animal-world">
                                                        <h2 class="text-center">The Animal World</h2>
                                                        <p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                                                </div>
                                                <div class="slide-panel animal-world" id="animal-world-panel"></div>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-plant-world" class="world plant-world">
                                                        <h2 class="text-center">The Plant World</h2>
                                                        <p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                                                </div>
                                                <div class="slide-panel plant-world" id="plant-world-panel"></div>
                                        </div>
                                        <div class="col-lg-7">
                                                <div id="slide-microbial-world" class="world microbial-world">
                                                        <h2 class="text-center">The Microbial World</h2>
                                                        <p class="text-center">Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                                                </div>
                                                <div class="slide-panel microbial-world" id="microbial-world-panel"></div>
                                        </div>
                                </div>
                        </section>
                        <section class="footer-container" id="credits">
                                <div class="col-lg-12">
                                        <div class="col-lg-12">
                                                <h1><u>Credits</u></h1>
                                        </div>
                                        <div class="col-lg-2">
                                                <h2>Developers</h2>
                                                <p>name</p>
                                                <p>name</p>
                                                <p>name</p>
                                                <p>name</p>
                                                <p>name</p>
                                        </div>
                                        <div class="col-lg-2">
                                                <h2>Project Leader</h2>
                                                <p>Philippe </p>
                                        </div>
                                        <div class="col-lg-2">
                                                <h2>the idiots</h2>
                                                <p>name</p>
                                                <p>name</p>
                                                <p>name</p>
                                                <p>name</p>
                                                <p>name</p>
                                        </div>
                                        <div class="col-lg-3 col-md-offset-3" >
                                                <h2></h2><br>
                                                <p><img src="img/logo-aopgrc.jpg" width="120" height="111"></p>
                                        </div>
                                </div>
                        </section>
                </div>
        </body>
</html>
