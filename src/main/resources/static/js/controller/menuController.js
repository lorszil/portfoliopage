'use strict';

lorszil.controller('menuCtrl', ['$rootScope', '$location', '$scope', '$http', function($rootScope, $location, $scope, $http) {

    $rootScope.$on("$locationChangeStart", function(event, next, current) {
        $scope.currentPath = $location.path();
    });

    console.log("Path: " + $location.path());

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
            authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('user', {headers : headers})
            .then(function(response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }, function() {
                $rootScope.authenticated = false;
                callback && callback();
            });

    };

    var self = this;

    authenticate();
    self.credentials = {};
    self.login = function() {
        authenticate(self.credentials, function(authenticated) {
            if (authenticated) {
                console.log("Login succeeded");
                $location.path("/admin");
                self.error = false;
                $rootScope.authenticated = true;
            } else {
                console.log("Login failed");
                $location.path("/login");
                self.error = true;
                $rootScope.authenticated = false;
            }
        })
    };

}]);
