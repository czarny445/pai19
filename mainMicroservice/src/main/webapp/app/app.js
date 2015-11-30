var app = angular.module("clientBrowser", ['ngRoute'])
	.controller("MainController", MainController);


function MainController($rootScope, $timeout) {
	$rootScope.isCollapsed = false;
	$rootScope.alertMsg = "";
	$rootScope.alertType = "";
	$rootScope.showAlert = function(type, msg){
		$rootScope.alertType = type;
		$rootScope.alertMsg = msg;
		$rootScope.isCollapsed = true;
		$timeout(function(){
			$rootScope.isCollapsed = false;
		}, 5000)
	}
}