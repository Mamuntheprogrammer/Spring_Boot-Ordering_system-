module = angular.module('digitalOrderSystemApp', []);
module.controller('UserController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	   // console.log(token);
	    
	    $scope.signUp = function(user, form){
        	
        	  	$http({
	                method: "POST",
	                url: "/rest/dos/user/add",
	                data: user,
	            }).then(function mySucces(response) {
	            		if(response.data.id){
	            			$scope.usersignupStatus="You have signup successfully";
	            		}
	            		else{
	            			$scope.usersignupStatus="There is a problem in signup, user may alreday exist";
	            		}
	            }, function myError(response) {
	            		$scope.usersignupStatus="Error in signup";
	            });

        };
        
        /*$scope.addFood = function(food, form){
        	
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
        };*/
        
       
    }])
    