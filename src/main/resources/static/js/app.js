'use strict';

var lorszil = angular.module('lorszil', [
    'ngRoute',
    'ngResource'
])

    .config(['$httpProvider', '$routeProvider', '$locationProvider',
        function ($httpProvider, $routeProvider, $locationProvider) {
            $httpProvider.defaults.withCredentials = true;
            $httpProvider.defaults.headers['Content-Type'] = 'application/json; charset=UTF-8';
            $httpProvider.defaults.useXDomain = true;
            delete $httpProvider.defaults.headers.common['X-Requested-With'];
            $httpProvider.defaults.headers.post["Content-Type"] = "application/json";

            $locationProvider
                .html5Mode(true)
                .hashPrefix('!');

            $routeProvider
                .when('/', {
                    templateUrl: 'views/main.html',
                    controller: 'mainCtrl'
                })
                .when('/blog', {
                    templateUrl: 'views/blog.html',
                    controller: 'blogCtrl'
                })
                .when('/project/:projectId', {
                    templateUrl: 'views/project.html',
                    controller: 'projectCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                })
        }]);

