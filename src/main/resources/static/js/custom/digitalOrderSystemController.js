<<<<<<< HEAD
module = angular.module('digitalOrderSystemApp', []);
module.controller('DigitalOrderSystemController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	    console.log(token);
	    
	    /*$scope.addArticle = function(article, form){
        	
        	  	$http({
	                method: "POST",
	                url: "/api/v1/article/create",
	                data: article,
	            }).then(function mySucces(response) {
	            		$scope.createStatus="Article created";
	            }, function myError(response) {
	            		$scope.createStatus="Error in article creation";
	            });

        };*/
        
        $scope.appInit = function(){
        
	        	$http({
	                method: "GET",
	                url: "/rest/dos/category/all",
	                params: {}
	            }).then(function succes(response) {
	               
	            		$scope.categories = response.data;
	            		
	            		$scope.storedCategories = response.data;
	            		
	            		$scope.findAllFoods();
	                
	            }, function error(response) {
	            });
        };
        
        $scope.findFoodsByCategory=function(categoryId){
        		$http({
                method: "GET",
                url: "/rest/dos/food/category/"+categoryId,
                params: {}
            }).then(function succes(response) {
               
            		$scope.foods = response.data;
            		
            		$scope.storedFoods = response.data;
                
            }, function error(response) {
            });
        }
        
        $scope.findAllFoods = function(){
        	$http({
                method: "GET",
                url: "/rest/dos/food/all",
                params: {}
            }).then(function succes(response) {
               
            		$scope.foods = response.data;
            		
            		$scope.storedFoods = response.data;
                
            }, function error(response) {
            });
        };
        
        $scope.filterCategory = function(searchText){
        	$scope.categories = [];
        		for(var i in $scope.storedCategories){
        			if($scope.storedCategories[i].name.toLowerCase().indexOf(searchText) != -1){
        				var result = $scope.storedCategories[i];
        				$scope.categories.push(result);
        			}
        		}
        };
        
        $scope.filterFood = function(searchText){
        	$scope.foods = [];
        		for(var i in $scope.storedFoods){
        			if($scope.storedFoods[i].name.toLowerCase().indexOf(searchText) != -1){
        				var result = $scope.storedFoods[i];
        				$scope.foods.push(result);
        			}
        		}
        };
        
        $scope.chart = [];
        $scope.addToChart = function(item){
        
         	 var itemFound = false;
         	 var foundIndex = -1;
        	 for(var i in  $scope.chart){
        	 	if(item.id == $scope.chart[i].id){
        	 		itemFound = true;
        	 		foundIndex = i;
        	 		break;
        	 	}
        	 } 
        	 
        	 if(itemFound){
        	 	var foundItem = $scope.chart[foundIndex];
        	 	var quantity = foundItem.quantity;
        	 	quantity +=1;
        	 	foundItem['quantity'] = quantity;
        	 	/*var price = foundItem.price;
        	 	price +=item.price;
        	 	foundItem['price'] = price;*/
        	 	$scope.chart.splice(foundIndex, 1);
        	 	$scope.chart.push(foundItem);
        	 }else{
        	 	item['quantity'] = 1;
        	 	$scope.chart.push(item);
        	 }
        	 
        	 $scope.orderPlaced = false;
        }
        
        $scope.chartTotal = function(){
    		var total = 0;
    		for(var i = 0; i < $scope.chart.length; i++){
        		var item = $scope.chart[i];
        		total += (item.price * item.quantity);
    		}
   			 return total;
		}
		
		$scope.removeChartItem = function(index){
			$scope.chart.splice(index, 1);
		}
		
		$scope.addOrder=function(order, orderForm){
			order['orderTotal'] = $scope.chartTotal();
			order['userId'] = 0;
			order['orderItems'] = $scope.chart;
			$http({
                method: "POST",
                url: "/rest/dos/food/place_order",
                data: order,
            }).then(function mySucces(response) {
            		$scope.orderPlaceStatus="Thanks for the order, your order will be process soon, your order number : "+response.data.id;
            		$scope.chart = [];
            		$scope.orderPlaced = true; 
            }, function myError(response) {
            		$scope.orderPlaceStatus="Error in article creation";
            });
		}
		
		$scope.login = function(user,loginForm){
			
			$http({
                method: "POST",
                url: "/rest/dos/user/login",
                data: user,
            }).then(function mySucces(response) {
            		if(response.data){
            				$scope.loginStatus="Logn successfull";
            				window.location = "/";
            		}
            		else{
            			$scope.loginStatus="Error in login, username & password doesn't match";
            		}
            		
            }, function myError(response) {
            		$scope.loginStatus="Error in login, username & password doesn't match";
            });
		}

    }])
=======
module = angular.module('digitalOrderSystemApp', []);
module.controller('DigitalOrderSystemController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	    console.log(token);
	    
	    /*$scope.addArticle = function(article, form){
        	
        	  	$http({
	                method: "POST",
	                url: "/api/v1/article/create",
	                data: article,
	            }).then(function mySucces(response) {
	            		$scope.createStatus="Article created";
	            }, function myError(response) {
	            		$scope.createStatus="Error in article creation";
	            });

        };*/
        
        $scope.appInit = function(){
        
	        	$http({
	                method: "GET",
	                url: "/rest/dos/category/all",
	                params: {}
	            }).then(function succes(response) {
	               
	            		$scope.categories = response.data;
	            		
	            		$scope.storedCategories = response.data;
	            		
	            		$scope.findAllFoods();
	                
	            }, function error(response) {
	            });
        };
        
        $scope.findFoodsByCategory=function(categoryId){
        		$http({
                method: "GET",
                url: "/rest/dos/food/category/"+categoryId,
                params: {}
            }).then(function succes(response) {
               
            		$scope.foods = response.data;
            		
            		$scope.storedFoods = response.data;
                
            }, function error(response) {
            });
        }
        
        $scope.findAllFoods = function(){
        	$http({
                method: "GET",
                url: "/rest/dos/food/all",
                params: {}
            }).then(function succes(response) {
               
            		$scope.foods = response.data;
            		
            		$scope.storedFoods = response.data;
                
            }, function error(response) {
            });
        };
        
        $scope.filterCategory = function(searchText){
        	$scope.categories = [];
        		for(var i in $scope.storedCategories){
        			if($scope.storedCategories[i].name.toLowerCase().indexOf(searchText) != -1){
        				var result = $scope.storedCategories[i];
        				$scope.categories.push(result);
        			}
        		}
        };
        
        $scope.filterFood = function(searchText){
        	$scope.foods = [];
        		for(var i in $scope.storedFoods){
        			if($scope.storedFoods[i].name.toLowerCase().indexOf(searchText) != -1){
        				var result = $scope.storedFoods[i];
        				$scope.foods.push(result);
        			}
        		}
        };
        
        $scope.chart = [];
        $scope.addToChart = function(item){
        
         	 var itemFound = false;
         	 var foundIndex = -1;
        	 for(var i in  $scope.chart){
        	 	if(item.id == $scope.chart[i].id){
        	 		itemFound = true;
        	 		foundIndex = i;
        	 		break;
        	 	}
        	 } 
        	 
        	 if(itemFound){
        	 	var foundItem = $scope.chart[foundIndex];
        	 	var quantity = foundItem.quantity;
        	 	quantity +=1;
        	 	foundItem['quantity'] = quantity;
        	 	/*var price = foundItem.price;
        	 	price +=item.price;
        	 	foundItem['price'] = price;*/
        	 	$scope.chart.splice(foundIndex, 1);
        	 	$scope.chart.push(foundItem);
        	 }else{
        	 	item['quantity'] = 1;
        	 	$scope.chart.push(item);
        	 }
        	 
        	 $scope.orderPlaced = false;
        }
        
        $scope.chartTotal = function(){
    		var total = 0;
    		for(var i = 0; i < $scope.chart.length; i++){
        		var item = $scope.chart[i];
        		total += (item.price * item.quantity);
    		}
   			 return total;
		}
		
		$scope.removeChartItem = function(index){
			$scope.chart.splice(index, 1);
		}
		
		$scope.addOrder=function(order, orderForm){
			order['orderTotal'] = $scope.chartTotal();
			order['userId'] = 0;
			order['orderItems'] = $scope.chart;
			$http({
                method: "POST",
                url: "/rest/dos/food/place_order",
                data: order,
            }).then(function mySucces(response) {
            		$scope.orderPlaceStatus="Thanks for the order, your order will be process soon, your order number : "+response.data.id;
            		$scope.chart = [];
            		$scope.orderPlaced = true; 
            }, function myError(response) {
            		$scope.orderPlaceStatus="Error in article creation";
            });
		}
		
		$scope.login = function(user,loginForm){
			
			$http({
                method: "POST",
                url: "/rest/dos/user/login",
                data: user,
            }).then(function mySucces(response) {
            		if(response.data){
            				$scope.loginStatus="Logn successfull";
            				window.location = "/";
            		}
            		else{
            			$scope.loginStatus="Error in login, username & password doesn't match";
            		}
            		
            }, function myError(response) {
            		$scope.loginStatus="Error in login, username & password doesn't match";
            });
		}

    }])
>>>>>>> branch 'master' of https://github.com/Mamuntheprogrammer/final-_project.git
    