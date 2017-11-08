'use strict';
angular.module("myApp", ["ngRoute"])
    .config( function ($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "view/main.html"
                , controller: "mainCtrl"
            })
            .when("/:id", {
                templateUrl : "view/question.html"
                , controller: "questionCtrl"
            });
    });