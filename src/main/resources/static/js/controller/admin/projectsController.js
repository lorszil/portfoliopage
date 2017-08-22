'use strict';

lorszil.controller('projectsCtrl', function($scope, $http) {

    $scope.projects = null;

    $http.get("/all_projects")
        .then(function (response) {
            $scope.projects = response.data.projects;
            console.log($scope.projects);
        })

});
