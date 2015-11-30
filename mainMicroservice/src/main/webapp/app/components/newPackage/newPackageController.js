angular
	.module("clientBrowser")
	.controller("NewPackageController", newPackageController);

function newPackageController($rootScope, $http){
	var ctrl = this;
	ctrl.newPackage = {};
	ctrl.create = function() {
		$http.post("http://localhost:8080/package/create", ctrl.newPackage).success(function(data){
			if(data == ""){
				$rootScope.showAlert("danger", "Błąd wywołania usługi");
			}
			else{
				ctrl.newPackage = {};
				$rootScope.showAlert("success", "Paczka została dodana");
			}
		})
		.error(function(error){
			$rootScope.showAlert("danger", "Błąd wywołania usługi");
		});
	};
}