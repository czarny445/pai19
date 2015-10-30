angular
	.module("clientBrowser")
	.controller("NewDepartmentController", newDepartmentController);

function newDepartmentController($scope, $http){
	var ctrl = this;
	ctrl.newDepartment = {};
	ctrl.create = function() {
		$http.post("http://localhost:8080/department/create", ctrl.newDepartment).success(function(data){
			if(data == ""){
				console.log("cos poszlo nie tak");
			}
			else{
				console.log("dodano oddzial");
				ctrl.newDepartment = {};
			}
		});
	};
}