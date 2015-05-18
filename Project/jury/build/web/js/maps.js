/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initialize() {
    settings.map = new google.maps.Map(document.getElementById(settings.canvas),
            settings.mapOptions);

    settings.map.set('styles', [{featureType: "all", stylers: [
                {saturation: 60}]}]);

    google.maps.event.addListener(settings.map, 'click', function (event) {
        makeArea(event.latLng);
    });

    settings.areaPath = new google.maps.Polygon({
        strokeColor: '#FF0000',
        strokeOpacity: 0.4,
        strokeWeight: 3,
        fillColor: '#FF0000',
        fillOpacity: 0.35,
        editable: true
    });

    google.maps.event.addListener(settings.map, 'mouseout', function () {
        showCoordinates(settings.areaPath, settings.place);
    });

    showArea();

    function makeArea(location) {
        settings.area.push(location);
        showArea();
    }
}

var settings = {area: [], areaPath: null, canvas: 'map-canvas', map: null,
    place: 'area-coordinates', mapOptions: {center: {lat: 20.8723303,
            lng: 55.765891}, zoom: 7, minZoom: 6, maxZoom: 11,
        mapTypeControl: false, streetViewControl: false,
        disableDoubleClickZoom: false}};

function resetArea() {
    settings.areaPath.setMap(null);
    settings.area = [];
    settings.areaPath = new google.maps.Polygon({strokeColor: '#FF0000',
        strokeOpacity: 0.4, strokeWeight: 3, fillColor: '#FF0000',
        fillOpacity: 0.35, editable: true});
    var coord = document.getElementById(settings.place);
    coord.value = "";
}

function showArea() {
    if (settings.area.length > 2) {
        settings.areaPath.setPath(settings.area);
        settings.areaPath.setMap(settings.map);
        settings.area = [];
    }
}

function showCoordinates(areaPath, placecoord) {
    var string = '';

    var coordinates = areaPath.getPath();
    for (var i = 0; i < coordinates.getLength(); i++) {
        var xy = coordinates.getAt(i);
        string += "(" + xy.lat() + ',' + xy.lng() + ')@';
    }

    var coord = document.getElementById(placecoord);
    coord.value = string.slice(0, -1);
}

function loadScript() {
    var check = document.getElementById('maps-script');
    if (check === null) {
        var script = document.createElement('script');
        script.id = 'maps-script';
        script.type = 'text/javascript';
        script.src = 'https://maps.googleapis.com/maps/api/js?v=3.19exp' +
                '&callback=initialize&language=en';

        document.body.appendChild(script);
    } else {
        initialize();
    }
}

function getCoordinates() {
    var input = document.getElementById('update-coordinates').value;
    var split = input.split("@");
    var maxLat = 0.0;
    var minLat = 500.0;
    var maxLng = 0.0;
    var minLng = 500.0;
    if (input.length > 0) {
        for (var i = 0; i < split.length; i++) {
            var part = split[i].split(",");
            var latitude = part[0].slice(1, part[0].length);
            maxLat = ((maxLat > parseFloat(latitude)) ? maxLat : parseFloat(latitude));
            minLat = ((minLat < parseFloat(latitude)) ? minLat : parseFloat(latitude));
            var longitude = part[1].slice(0, -1);
            maxLng = ((maxLng > parseFloat(longitude)) ? maxLng : parseFloat(longitude));
            minLng = ((minLng < parseFloat(longitude)) ? minLng : parseFloat(longitude));
            settings.area.push({lat: parseFloat(latitude), lng: parseFloat(longitude)});
        }
        settings.mapOptions.center = {lat: (maxLat + minLat) / 2, lng: (maxLng + minLng) / 2};
    }
}

$(document).ready(function () {
    $('#edit-map').click(function () {
        $('#edit-map').hide();
        $('#update-canvas').show();
        settings.canvas = 'update-canvas';
        settings.place = 'update-coordinates';
        getCoordinates();
        loadScript();
    });

    $('#geolocation-close1, #geolocation-close2').click(function () {
        settings.canvas = 'map-canvas';
        settings.place = 'area-coordinates';
        settings.mapOptions.center = {lat: 20.8723303, lng: 55.765891};
        resetArea();
    });

    $('#geolocation-reset1, #geolocation-reset2').click(function () {
        resetArea();
    });
});