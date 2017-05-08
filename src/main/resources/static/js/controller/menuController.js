'use strict';

lorszil.controller('menuCtrl', ['$rootScope', '$location', '$scope', function($rootScope, $location, $scope) {

    $rootScope.$on("$locationChangeStart", function(event, next, current) {
        $scope.currentPath = $location.path();
    });

    console.log("Path: " + $location.path())

}]);
