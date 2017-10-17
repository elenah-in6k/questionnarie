'use strict';
angular.module("myApp", ["ngRoute", "angularCharts"])
    .config( function ($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "view/main.html",
                controller: "mainCtrl"
            });
    });