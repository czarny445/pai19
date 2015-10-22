angular
	.module("clientBrowser")
	.controller("NewPackageController", newPackageController);

function newPackageController($scope, $http){
	var ctrl = this;
	ctrl.newPackage = {};
	ctrl.create = function() {
		$http.post("http://localhost:8080/package/create", ctrl.newPackage).success(function(data){
			if(data == ""){
				console.log("cos poszlo nie tak");
			}
			else{
				console.log("dodano paczke");
			}
		});
	};
}