'use strict';

lorszil.config(['$routeProvider',
    function ($routeProvider) {

        $routeProvider
            .when('/', {
                templateUrl: 'index.html',
                controller: 'menuCtrl'
            })
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'mainCtrl'
            })
            .when('/blog', {
                templateUrl: 'views/blog.html',
                controller: 'blogCtrl'
            })
            .when('/logout', {
                templateUrl: 'index.html',
                controller: 'logoutCtrl'
            })
            // .when('/project/:projectId', {
            //     templateUrl: 'views/project.html',
            //     controller: 'projectCtrl'
            // })
            .when('/login', {
                templateUrl: 'views/login.html',
                controller: 'loginCtrl'
            })
            .when('/projects', {
                templateUrl: 'views/project.html',
                controller: 'projectCtrl'
            })
            .when('/admin', {
                templateUrl: 'views/admin/admin_main.html',
                controller: 'adminMainCtrl'
            })
            .when('/admin/projectedit', {
                templateUrl: 'views/admin/project_edit.html',
                controller: 'projectEditCtrl'
            })
            .otherwise({
                redirectTo: '/'
            })
    }]);
