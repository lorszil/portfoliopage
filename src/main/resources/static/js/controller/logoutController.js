'use strict';

lorszil.controller('logoutCtlr',function($location, $scope, $window, $rootScope, $http){

    $scope.logout = function() {
        $http.get('logout').then(function() {
            $rootScope.authenticated = false;
            $location.path("/");
        }, function(data) {
            $rootScope.authenticated = false;
        });
    }

});
