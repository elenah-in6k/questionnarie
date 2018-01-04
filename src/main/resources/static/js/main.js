'use strict';
angular.module('myApp')
    .controller('mainCtrl', function ($scope, $rootScope, $http) {
        $scope.getAll = getAll;
        $scope.save = save;
        $scope.getByTag = getByTag;
        $scope.deleteAnswer = deleteAnswer;
        $scope.deleteQuestion = deleteQuestion;
        $scope.addAnswer = addAnswer;
        $scope.updateIsCorrect = updateIsCorrect;
        $scope.init = init;

        $scope.init();
        $scope.getAll();

        function init() {
            $scope.question = {};
            $scope.question.answers = [{}];
            $scope.freeEntry = false;
            $scope.oneRight = false;
            $scope.manyRight = false;
        }
        function getAll() {
            $http.get('/api/questions')
                .then(function successCallback(response) {
                    $scope.questions = response.data;
                }, function errorCallback(response) {
                });
        }

        function save(quest) {
            if(quest.type === 'freeEntry') quest.answers[0].isCorrect = true;
            $http.post('/api/questions', quest)
                .then(function (response) {
                    $scope.init();
                    $scope.getAll();
                }, function (response) {
                });
        }

        function deleteQuestion(quest) {
            $http.delete('/api/questions', {params: {id: quest.id}})
                .then(function (response) {
                    $scope.getAll();
                }, function (response) {
                });
        }

        function deleteAnswer(quest, index) {
            quest.answers.splice(index, 1);
            $scope.save(quest);
        }

        function getByTag(spec) {
            $http.get('/api/questions/find-by-tags', {params: spec})
                .then(response => $scope.searchResults = response.data);
        }

        function addAnswer() {
            $scope.question.answers.push({});
        }

        function updateIsCorrect(index) {
            if ($scope.oneRight) {
                $scope.question.answers.forEach(function (currentValue, currentIndex) {
                    if (index !== currentIndex) {
                        currentValue.isCorrect = "false";
                    }
                });
            }
        }
    });