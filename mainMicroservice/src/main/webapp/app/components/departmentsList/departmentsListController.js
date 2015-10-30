angular
	.module("clientBrowser")
	.controller("DepartmentsListController", departmentsListController);

function departmentsListController($scope, $http){
	var ctrl = this;
	
	$http.get("http://localhost:8080/department/getAllDepartments").success(function(data){
		ctrl.departments = data;
	});
	

}
