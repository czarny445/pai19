angular
	.module("clientBrowser")
	.controller("PackagesListController", packagesListController);

function packagesListController($scope, $http){
	var ctrl = this;
	
	$http.get("http://localhost:8080/package/getAllPackages").success(function(data){
		ctrl.packages = data;
	});
	


}
