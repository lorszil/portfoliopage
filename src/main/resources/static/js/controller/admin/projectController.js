'use strict';

lorszil.run(function(editableOptions) {
    editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
});

lorszil.controller('projectCtrl', function($scope) {
    $scope.message = 'Hello from ProjectController';

    $scope.projectTitle = {
        name: 'Good one'
    };


    $scope.project = {};
    $scope.errorConfirm = false;

    $scope.addProject = function (valid) {
        if (valid) {
            $http({
                method: 'POST',
                url: '/admin/create_project',
                withCredentials: true,
                headers: {'Content-Type': 'application/json; charset=UTF-8', 'Accept': 'text/plain'},
                data: angular.toJson($scope.project)
            })
                .then(function successCallback (response) {
                    if (response.data == "fail") {
                        $(".project-error").text("Project is invalid").addClass("alert alert-danger alert-dismissable").fadeIn();
                        addError($("#projectDiv"));
                    } else {
                        $location.path('/');
                        console.log('saved')
                    }
                    console.log(response);
                }, function errorCallback (response) {
                    alert("failure message: " + angular.toJson($scope.user));
                });
        }
        // Making the fields empty
        $scope.project = null;
    };



});