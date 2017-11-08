'use strict';
angular.module('myApp')
    .controller('questionCtrl', function ($scope, $rootScope, $http, $routeParams) {
        $scope.get = get;
        $scope.init = init;

        $scope.init();
        $scope.get();

        function init() {
            $scope.question = {};
        }
        function get() {
            $http.get('/api/questions/'+$routeParams.id)
                .then(function successCallback(response) {
                    $scope.question = response.data;
                }, function errorCallback(response) {
                });
        }
    });
