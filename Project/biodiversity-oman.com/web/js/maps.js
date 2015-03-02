/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var canvas = 'map-canvas';
var area = [];
var areaPath;

function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(20.8723303, 55.765891),
        zoom: 7,
        minZoom: 6,
        maxZoom: 11
    };

    var map = new google.maps.Map(document.getElementById(canvas),
            mapOptions);

    map.set('styles', [{featureType: "all", stylers: [
                {saturation: 60}]}]);

    google.maps.event.addListener(map, 'click', function (event) {
        makeArea(event.latLng);
    });

    areaPath = new google.maps.Polygon({
        strokeColor: '#FF0000',
        strokeOpacity: 0.4,
        strokeWeight: 3,
        fillColor: '#FF0000',
        fillOpacity: 0.35,
        editable: true
    });
    
    google.maps.event.addListener(map, 'mouseout', function () {
        showCoordinates(areaPath);
    });

    if (area.length > 2) {
        areaPath.setPath(area);
        areaPath.setMap(map);
        showCoordinates(areaPath);
        area = [];
    }

    function makeArea(location) {
        area.push(location);

        if (area.length > 3) {
            areaPath.setPath(area);
            areaPath.setMap(map);
            showCoordinates(areaPath);
            area = [];
        }
    }

    canvas = 'map-canvas';
}

function showCoordinates(areaPath) {
    var string = '';

    var coordinates = areaPath.getPath();
    for (var i = 0; i < coordinates.getLength(); i++) {
        var xy = coordinates.getAt(i);
        string += "(" + xy.lat() + ',' + xy.lng() + ')@';
    }

    var coord = document.getElementById('area-coordinates');
    coord.value = string.slice(0, -1);
}

function loadScript() {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'https://maps.googleapis.com/maps/api/js?v=3.19exp' +
            '&callback=initialize&language=en';

    document.body.appendChild(script);
}

function getCoordinates(){
    var input = document.getElementById('update-coordinates').value;
    var split = input.split("@");
    for (var i = 0; i < split.length; i++) {
        var part = split[i].split(",");
        var latitude = part[0].slice(1, part[0].length);
        var longitude = part[1].slice(0, -1);
        area.push({lat: parseFloat(latitude), lng: parseFloat(longitude)});
    }
}

$(document).ready(function () {    
    $('#edit-map').click(function(){
        $('#edit-map').hide();
        $('#update-canvas').show();
        canvas = 'update-canvas';
        getCoordinates();
        loadScript();
    });
});