angular
	.module("clientBrowser")
	.controller("NewDepartmentController", newDepartmentController);

function newDepartmentController($rootScope, $http){
	var ctrl = this;
	ctrl.newDepartment = {};
	ctrl.create = function() {
		$http.post("http://localhost:8080/department/create", ctrl.newDepartment).success(function(data){
			if(data == ""){
				$rootScope.showAlert("danger", "Błąd wywołania usługi");
			}
			else{
				ctrl.newDepartment = {};
				$rootScope.showAlert("success", "Oddział został dodany");
			}
		})
		.error(function(error){
			$rootScope.showAlert("danger", "Błąd wywołania usługi");
		});
	};
}