module = angular.module('digitalOrderSystemApp', []);
module.controller('AdminController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	    console.log(token);
	    
	    $scope.addCategory = function(category, form){
        	
        	  	$http({
	                method: "POST",
	                url: "/rest/dos//admin/category/add",
	                data: category,
	            }).then(function mySucces(response) {
	            		$scope.categoryCreateStatus="Category created";
	            		$scope.appInit();
	            }, function myError(response) {
	            		$scope.categoryCreateStatus="Error in category creation";
	            });

        };
        
        $scope.addFood = function(food, form){
        	
    	  	$http({
                method: "POST",
                url: "/rest/dos//admin/food/add",
                data: food,
            }).then(function mySucces(response) {
            		$scope.foodCreateStatus="Food created";
            }, function myError(response) {
            		$scope.foodCreateStatus="Error in food creation";
            });

    };
        
        $scope.appInit = function(){
        
	        	$http({
	                method: "GET",
	                url: "/rest/dos/category/all",
	                params: {}
	            }).then(function succes(response) {
	               
	            		$scope.categories = response.data;
	                
	            }, function error(response) {
	            });
        };
        
       
    }])
    