/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var area = [];

function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(20.8723303, 55.765891),
        zoom: 7,
        minZoom: 6,
        maxZoom: 11
    };

    var map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);

    map.set('styles', [{featureType: "all", stylers: [
                {saturation: 60}]}]);

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
            showCoordinates(areaPath);
            area = [];
        }
    }
}

function showCoordinates(areaPath) {
    var string = '';

    var coordinates = areaPath.getPath();
    for (var i = 0; i < coordinates.getLength(); i++) {
        var xy = coordinates.getAt(i);
        string += "(" + xy.lat() + ',' + xy.lng() + ')@';
    }

    var coord = document.getElementById('area-coordinates');
    coord.value = string;
}

function loadScript() {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'https://maps.googleapis.com/maps/api/js?v=3.19exp' +
            '&callback=initialize&language=en';

    document.body.appendChild(script);
}

window.onload = loadScript;
