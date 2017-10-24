'use strict';
angular.module('myApp')
    .controller('mainCtrl', function ($scope, $rootScope, $http) {
        getAll();
        $scope.getAll = getAll;
        $scope.save = save;
        $scope.getByTag = getByTag;


        function getAll() {
            $http({
                method: 'GET',
                url: '/questions'
            }).then(function successCallback(response) {
                console.log(response);
                $scope.questions = response;
            }, function errorCallback(response) {
            });
        }

        function save(quest) {
            $http.post('/questions', quest)
                .then(function (response) {
                    console.log(response)
                }, function (response) {
                });
        }

        function getByTag(tag) {
            $http({
                method: 'GET',
                url: '/findByTagsContains',
                data: {tags: tag}
            }).then(function successCallback(response) {
                console.log(response);
                $scope.searchResults = response;
            }, function errorCallback(response) {
            });
        }
    });