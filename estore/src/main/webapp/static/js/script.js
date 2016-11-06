// create the module and name it eStoreApp
var eStoreApp = angular.module('eStoreApp', [ 'ngRoute' ]);

// configure our routes
eStoreApp.config(function($routeProvider) {
	$routeProvider

	// route for the home page
	.when('/login', {
		templateUrl : 'pages/login.jsp',
		controller : 'loginController'
	})

	// route for the home page
	.when('/', {
		templateUrl : 'pages/home.jsp',
		controller : 'mainController'
	})

	// route for the about page
	.when('/registerStore', {
		templateUrl : 'pages/registerStore.jsp',
		controller : 'regStoreController'
	})

	// Describe Product
	.when('/desProduct', {
		templateUrl : 'pages/desProduct.jsp',
		controller : 'desProdController'
	})

	// route for the about page
	.when('/tables', {
		templateUrl : 'pages/tables.jsp',
		controller : 'tablesController'
	})

	// route for the contact page
	.when('/forms', {
		templateUrl : 'pages/forms.jsp',
		controller : 'formsController'
	})

	// route for the panels-wells page
	.when('/panels-wells', {
		templateUrl : 'pages/panels-wells.jsp',
		controller : 'panels-wellsController'
	})

	// route for the flot page
	.when('/flot', {
		templateUrl : 'pages/flot.jsp',
		controller : 'flotController'
	})

	// route for the buttons page
	.when('/buttons', {
		templateUrl : 'pages/buttons.jsp',
		controller : 'buttonsController'
	})

	// route for the notifications page
	.when('/notifications', {
		templateUrl : 'pages/notifications.jsp',
		controller : 'notificationsController'
	})

	// route for the typography page
	.when('/typography', {
		templateUrl : 'pages/typography.jsp',
		controller : 'typographyController'
	})

	// route for the icons page
	.when('/icons', {
		templateUrl : 'pages/icons.jsp',
		controller : 'iconsController'
	})
	// route for the grid page
	.when('/grid', {
		templateUrl : 'pages/grid.jsp',
		controller : 'gridController'
	})
	// route for the page
	.when('/blank', {
		templateUrl : 'pages/blank.jsp',
		controller : 'blankController'
	})
	

	// visitStore
	.when('/visitStore', {
		templateUrl : 'pages/visitStore.jsp',
		controller : 'visitStoreController'
	})

	// route for the page
	.when('/morris', {
		templateUrl : 'pages/morris.jsp',
		controller : 'morrisController'
	});
});

// create the controller and inject Angular's $scope
eStoreApp.controller('mainController', function($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
});

//alert("script.js loaded ver :1.0.3");
/********************************/
/*  Describe Product Controller */                           
/********************************/
eStoreApp.controller('desProdController', function($scope, $http) {
	//alert("desProdController..called");
	$scope.locationTypes='';
	$scope.locCategoryList='';
	$scope.subCategories='';
	
	/**** function fetchLocationTypeList() *****/
	$scope.fetchLocationTypeList=function()
    { 
	  //alert("fetchLocationTypeList() called");
      $http({
        method: 'POST',
        url: "common/getLoctionTypes"
      })
      .success(function(data, status) { 
    	  //alert("locationTypes size:"+data.length);
    	  $scope.locationTypes=data;
      })
      .error(function(data, status) {
      	$scope.errorMsg= "<strong>Error!</strong> Failed to fetch Location Types.";
    	$scope.showErrorAlert = true;
    	$scope.showSuccessAlert = false;
      });
    };
	
    /**** function init() *****/
	$scope.init = function () {
		//alert("init called");
		$scope.fetchLocationTypeList();
	};
	
	$scope.init();
	
	/****** function fetchCategoryByLocType() *****/
	$scope.fetchCategoryByLocType=function(locType)
    { 
      
      if(locType) { 
	    
	      $http({
	        method: 'POST',
	        url: "common/getCategoryByLocType/"+locType.typeId
	      })
	      .success(function(data, status) { 
	    	  $scope.locCategoryList=data;
	      })
	      .error(function(data, status) { 
	      	$scope.errorMsg= "<strong>Error!</strong> Failed to fetch Categories for <strong><i>"+ locType.type + "</i></strong>.";
	    	$scope.showErrorAlert = true;
	    	$scope.showSuccessAlert = false;
	      });
      
      }else { 
    	  $scope.showErrorAlert = false;
    	  $scope.showSuccessAlert = false;
      }
    };

    $scope.showSubCategoryByCat=function(categoryMaster) {
    	$scope.subCategories=categoryMaster.subCategoryMasters;
    };
	
	$scope.saveProduct=function() { 
		alert("submit called..");
		$http({
	        method: 'POST',
	        url: "product/saveProduct",
	        data: product,
	        contentType: 'application/json',
	        mimeType: 'application/json',
	      })
	      .success(function(data, status) {
	    	  alert("submit success..");
	 		  $scope.sucessMsg= "<strong>Success!</strong> Product <strong><i>"+ product.productName + "</i></strong> successfully saved.";
			  $scope.showSuccessAlert = true;
	          $scope.showErrorAlert = false;
	      })
	      .error(function(data, status) {
	    	  alert("submit error..");
	      	$scope.errorMsg= "<strong>Error!</strong> Failed to save product <strong><i>"+ product.productName + "</i></strong> .";
	    	$scope.showErrorAlert = true;
	    	$scope.showSuccessAlert = false;
	      });
	}
});

eStoreApp.controller('regStoreController', function($scope) {
	$scope.message = 'Look! I am an register Stpre page.';
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