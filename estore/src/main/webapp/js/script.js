// create the module and name it eStoreApp
var eStoreApp = angular.module('eStoreApp', [ 'ngRoute' ]);

// configure our routes
eStoreApp.config(function($routeProvider) {
	$routeProvider

	// route for the home page
	.when('/login', {
		templateUrl : 'pages/login.html',
		controller : 'loginController'
	})

	// route for the home page
	.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})

	// route for the about page
	.when('/tables', {
		templateUrl : 'pages/tables.html',
		controller : 'tablesController'
	})

	// route for the contact page
	.when('/forms', {
		templateUrl : 'pages/forms.html',
		controller : 'formsController'
	})

	// route for the panels-wells page
	.when('/panels-wells', {
		templateUrl : 'pages/panels-wells.html',
		controller : 'panels-wellsController'
	})

	// route for the flot page
	.when('/flot', {
		templateUrl : 'pages/flot.html',
		controller : 'flotController'
	})

	// route for the buttons page
	.when('/buttons', {
		templateUrl : 'pages/buttons.html',
		controller : 'buttonsController'
	})

	// route for the notifications page
	.when('/notifications', {
		templateUrl : 'pages/notifications.html',
		controller : 'notificationsController'
	})

	// route for the typography page
	.when('/typography', {
		templateUrl : 'pages/typography.html',
		controller : 'typographyController'
	})

	// route for the icons page
	.when('/icons', {
		templateUrl : 'pages/icons.html',
		controller : 'iconsController'
	})
	// route for the grid page
	.when('/grid', {
		templateUrl : 'pages/grid.html',
		controller : 'gridController'
	})
	// route for the page
	.when('/blank', {
		templateUrl : 'pages/blank.html',
		controller : 'blankController'
	})
	
	// Describe Product
	.when('/desProduct', {
		templateUrl : 'pages/desProduct.html',
		controller : 'desProdController'
	})
	
	// Describe Product
	.when('/registerStore', {
		templateUrl : 'pages/registerStore.html',
		controller : 'regStoreController'
	})

	// route for the page
	.when('/morris', {
		templateUrl : 'pages/morris.html',
		controller : 'morrisController'
	});
});

// create the controller and inject Angular's $scope
eStoreApp.controller('mainController', function($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
});

eStoreApp.controller('tablesController', function($scope) {
	$scope.message = 'Look! I am an about page.';
});

eStoreApp.controller('formsController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});

eStoreApp.controller('panels-wellsController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});

eStoreApp.controller('buttonsController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});

eStoreApp.controller('notificationsController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a notifications.';
});

eStoreApp.controller('typographyController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a typography.';
});

eStoreApp.controller('iconsController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a icons.';
});

eStoreApp.controller('gridController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a grid.';
});

eStoreApp.controller('blankController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a blank.';
});

eStoreApp.controller('morrisController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a morris.';
});