<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>45° imagery</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
<script>
function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 37.552644, lng: 126.937720},
    zoom: 18,
    mapTypeId: google.maps.MapTypeId.SATELLITE
  });
  map.setTilt(45);
}
</script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAA6OVzSoxRBnUo9t_m69YTKdLYNu7VcfU&signed_in=true&callback=initMap"></script>
  </body>
