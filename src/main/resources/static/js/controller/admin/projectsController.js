'use strict';

lorszil.controller('projectsCtrl', function($scope, $http) {
    $scope.message = 'Hello from ProjectController';

    $scope.getProjects = function () {

        $scope.projects = null;

        $http.get("/projects")
            .then(function (response) {
                $scope.projects = response.data.projects;
            })
    };

    $scope.getProjects();

});