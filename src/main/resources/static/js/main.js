'use strict';
angular.module('myApp')
    .controller('mainCtrl', function ($scope, $rootScope, $http) {
        $scope.getAll = getAll;
        $scope.save = save;
        $scope.getByTag = getByTag;
        $scope.deleteAnswer = deleteAnswer;
        $scope.deleteQuestion = deleteQuestion;

        $scope.getAll();

        function getAll() {
            $http.get('/api/questions')
                .then(function successCallback(response) {
                $scope.questions = response.data;
                console.log($scope.questions);
            }, function errorCallback(response) {
            });
        }

        function save(quest) {
            $http.post('/api/questions', quest)
                .then(function (response) {
                    console.log(response);
                    $scope.getAll();
                }, function (response) {
                });
        }
        function deleteQuestion(quest) {
            $http.delete('/api/questions', {params:{id: quest.id}})
                .then(function (response) {
                    console.log(response);
                    $scope.getAll();
                }, function (response) {
                });
        }
        function deleteAnswer(answer) {
            $http.delete('/api/questions', {params:{id: answer.id}} )
                .then(function (response) {
                    console.log(response)
                }, function (response) {
                });
        }

        function getByTag(tag) {
            $http.get('/api/questions/find-by-tags', {params:{tags: tag}})
                .then(function successCallback(response) {
                    $scope.searchResults = response.data;
                    console.log($scope.searchResults);
                }, function errorCallback(response) {
                });
        }

    });