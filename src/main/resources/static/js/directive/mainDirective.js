'use strict';

lorszil.directive('mainDirective', function () {
    return {
        restrict: 'E',
        templateUrl: 'main.html',
        replace : true,
        controller: 'mainCtrl'
    }
});