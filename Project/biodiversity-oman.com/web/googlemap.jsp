<%-- 
    Document   : googlemap
    Created on : Feb 19, 2015, 9:54:51 PM
    Author     : Oualid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            html, body, #map-canvas {
                height: 100%;
                margin: 0px;
                padding: 0px;
            }

            #legend {
                background: rgba(255, 255, 255, 0.9);
                padding: 0.6em;
                margin: 0.6em;
                border: 0.2em solid #ffe128;
                display: table;
            }

            #legend div{
                display: table-row;
            }

            #legend div span{
                display: table-cell;
                padding: 0.4em;
            }

            #control{
                border: 0.2em solid #ffe128;
                border-radius: 0.4em;
                box-shadow: 0 0.3em 0.9em rgba(0, 0, 0, 0.3);
                background: rgba(255, 255, 255, 0.95);
                padding-left: 0.7em;
                padding-right: 0.7em;
                padding: 0.4em;
            }
        </style>
        <script>
            var lang = 'english';
            var markers = [];
            var area = [];
            var areaWindow;
            var infoWindow;
            var map;

            var icons = {
                plant: {
                    name: 'Plant',
                    icon: 'http://i.imgur.com/r96PNDq.png'
                },
                mammal: {
                    name: "Mammal",
                    icon: 'http://i.imgur.com/hVljnCU.png'
                },
                fish: {
                    name: "Fish",
                    icon: 'http://i.imgur.com/aSL4RCR.png'
                },
                reptile: {
                    name: "Reptile",
                    icon: 'http://i.imgur.com/0mUTfRJ.png'
                }
            };

            var features = [
                {
                    position: {lat: 23.692992, lng: 57.435813},
                    type: 'plant',
                    title: 'Alfalfa (type 1)',
                    content: 'testje'
                }, {
                    position: {lat: 24.129879, lng: 56.820579},
                    type: 'plant',
                    title: 'Alfalfa (type 2)',
                    content: 'test'
                }, {
                    position: {lat: 20.017916, lng: 57.567649},
                    type: 'plant',
                    title: 'Alfalfa (type 3)',
                    content: 'test 2'
                }, {
                    position: {lat: 19.687248, lng: 56.073508},
                    type: 'plant',
                    title: 'Alfalfa (type 4)',
                    content: 'test 3'
                }, {
                    position: {lat: 22.840154, lng: 58.007102},
                    type: 'mammal',
                    title: 'Omani camel',
                    content: '<div id="content">' +
                            '<div id="siteNotice">' +
                            '</div>' +
                            '<h1 id="firstHeading" class="firstHeading">CommonName</h1>' +
                            '<div id="bodyContent">' +
                            '<p><b>CommonName</b>, also referred to as <b>LocalName</b>. Description: ' +
                            'lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin posuere ' +
                            'diam vulputate, faucibus ligula a, tincidunt risus. Sed sed tellus non ' +
                            'enim ultrices lobortis. Nullam eget nisl congue, scelerisque lacus a, interdum lorem.</p>' +
                            '<p>--> <a href="https://en.wikipedia.org/">' +
                            'https://relevante.pagina</a> </p>' +
                            '</div>' +
                            '</div>'
                }, {
                    position: {lat: 18.086510, lng: 54.161887},
                    type: 'mammal',
                    title: 'Omani goat',
                    content: 'test 5'
                }, {
                    position: {lat: 22.860402, lng: 56.556907},
                    type: 'reptile',
                    title: 'Omani lizard',
                    content: 'test 6'
                }, {
                    position: {lat: 20.964690, lng: 59.105735},
                    type: 'fish',
                    title: 'Omani shark',
                    content: 'test 7'
                }
            ];

            function initialize() {
                var mapOptions = {
                    center: new google.maps.LatLng(20.8723303, 55.765891),
                    zoom: 7,
                    minZoom: 6,
                    maxZoom: 11,
                    mapTypeControl: false,
                    scaleControl: true,
                    streetViewControl: false
                };

                map = new google.maps.Map(document.getElementById('map-canvas'),
                        mapOptions);

                google.maps.event.addListener(map, 'click', function (event) {
                    makeArea(event.latLng);
                });

                function makeArea(location) {
                    var areaPath;
                    area.push(location);

                    if (area.length > 3) {
                        areaPath = new google.maps.Polygon({
                            paths: area,
                            strokeColor: '#FF0000',
                            strokeOpacity: 0.4,
                            strokeWeight: 3,
                            fillColor: '#FF0000',
                            fillOpacity: 0.35,
                            editable: true
                        });
                        areaPath.setMap(map);
                        google.maps.event.addListener(areaPath, 'click', showCoordinates);
                        areaWindow = new google.maps.InfoWindow();
                        area = [];
                    }
                }

                function showCoordinates(event) {
                    var string = '';

                    var coordinates = this.getPath();
                    for (var i = 0; i < coordinates.getLength(); i++) {
                        var xy = coordinates.getAt(i);
                        string += 'Coordinate ' + (i + 1) + ': ' + xy.lat() + ',' + xy.lng() + '<br>';
                    }

                    areaWindow.setContent(string);
                    areaWindow.setPosition(event.latLng);

                    areaWindow.open(map);
                }

                var styleArray = [
                    {
                        featureType: "all",
                        stylers: [
                            {saturation: 60}
                        ]
                    }
                ];

                map.set('styles', styleArray);

                for (var i = 0, feature; feature = features[i]; i++) {
                    addMarker(feature);
                    infoWindow = new google.maps.InfoWindow();
                }

                map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(
                        document.getElementById('legend'));
                map.controls[google.maps.ControlPosition.TOP_CENTER].push(
                        document.getElementById('control'));

                var legend = document.getElementById('legend');
                for (var key in icons) {
                    var type = icons[key];
                    var name = type.name;
                    var icon = type.icon;
                    var div = document.createElement('div');
                    div.innerHTML = '<div><span><img src="' + icon + '"></span><span>' + name + '</span></div>';
                    legend.appendChild(div);
                }

                var control = document.getElementById('control');
                control.appendChild(control);

                function addMarker(feature) {
                    var marker = new google.maps.Marker({
                        position: feature.position,
                        icon: icons[feature.type].icon,
                        map: map,
                        title: feature.title
                    });

                    google.maps.event.addListener(marker, 'click',
                            function () {
                                infoWindow.setContent(feature.content);
                                infoWindow.open(map, marker);
                            });

                    markers.push(marker);
                }
            }

            function setAllMap(map, string) {
                for (var i = 0; i < markers.length; i++) {
                    if (string === '') {
                        markers[i].setMap(map);
                    }

                    if (string !== '') {
                        var type = markers[i].getIcon();
                        if (string === type) {
                            markers[i].setMap(map);
                        }
                    }
                }
            }

            function clearMarkers() {
                setAllMap(null, '');
            }

            function showMarkers() {
                setAllMap(map, '');
            }

            function showMammals() {
                clearMarkers();
                setAllMap(map, 'http://i.imgur.com/hVljnCU.png');
            }

            function showPlants() {
                clearMarkers();
                setAllMap(map, 'http://i.imgur.com/r96PNDq.png');
            }

            function getLocation() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var pos = new google.maps.LatLng(position.coords.latitude,
                                position.coords.longitude);

                        infoWindow.open(map);
                        infoWindow.setPosition(pos);
                        infoWindow.setContent('Your location');

                        map.setCenter(pos);
                    });
                }
            }

            function loadScript() {
                var script = document.createElement('script');
                script.type = 'text/javascript';

                if (lang === 'english') {
                    script.src = 'https://maps.googleapis.com/maps/api/js?v=3.19exp' +
                            '&callback=initialize&language=en';
                }

                if (lang === 'arabic') {
                    script.src = 'https://maps.googleapis.com/maps/api/js?v=3.19exp' +
                            '&callback=initialize&language=ar';
                }

                document.body.appendChild(script);
            }

            window.onload = loadScript;
        </script>
    </head>
    <body>
        <div id="map-canvas"></div>
        <div id="legend"></div>
        <div id="control">
            <input onclick="clearMarkers();" type=button value="Hide">
            <input onclick="showMarkers();" type=button value="Show All">
            <input onclick="showMammals();" type="button" value="Show Mammals">
            <input onclick="showPlants();" type="button" value="Show Plants">
            <input onclick="getLocation();" type="button" value="Show Location">
        </div>
    </body>
</html>
