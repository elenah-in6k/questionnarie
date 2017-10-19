'use strict';
angular.module('myApp', [])
    .controller('mainCtrl',  function ($scope, $rootScope, $http) {
        $scope.getAll();
        $scope.getAll = function (){
            $http({
                method: 'GET',
                url: '/questions'
            }).then(function successCallback(response) {
                    console.log(response);
                $scope.questions = response;
            }, function errorCallback(response) {
            });
        };

        $scope.save = function (quest){
            $http({
                method: 'POST',
                url: '/questions',
                data:quest
            }).then(function successCallback(response) {
                console.log(response)
            }, function errorCallback(response) {
            });
        };

        $scope.getByTag = function (tag){
            $http({
                method: 'GET',
                url: '/findByTagsContains',
                data: {tags:tag}
            }).then(function successCallback(response) {
                console.log(response);
                $scope.searchResults = response;
            }, function errorCallback(response) {
            });
        };
    });