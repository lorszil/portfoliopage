
lorszil.config(['$routeProvider',
    function ($routeProvider) {

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
            .when('/adminlogin', {
                templateUrl: 'views/login.html',
                controller: 'loginCtrl'
            })
            .otherwise({
                redirectTo: '/'
            })
    }]);
