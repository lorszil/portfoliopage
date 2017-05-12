admin.config(['$routeProvider',
    function ($routeProvider) {

        $routeProvider
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
