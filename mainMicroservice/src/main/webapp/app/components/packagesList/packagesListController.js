angular
	.module("clientBrowser")
	.controller("PackagesListController", packagesListController);

function packagesListController($rootScope, $http, $location){
	var ctrl = this;
	
	$http.get("http://localhost:8080/package/getAllPackages").success(function(data){
		ctrl.packages = data;
	})
	.error(function(error){
			$rootScope.showAlert("danger", "Błąd wywołania usługi");
	});
	
	ctrl.remove = function(pack)
	{
		$http.post("http://localhost:8080/package/remove", pack)
		.success(function(data){
			
			for(var i=0;i<ctrl.packages.length;i++){
				if(ctrl.packages[i].id == pack.id){
					ctrl.packages.splice(i,1);
					break;
				}
			}
			$rootScope.showAlert("success", "Paczka została usunięta");
		})
		.error(function(error){
			$rootScope.showAlert("danger", "Błąd wywołania usługi");
		});
	};
	
	ctrl.showHistory = function(pack){
		$rootScope.chosePackage = pack;
		$location.path("/historyPackage");
	};
}
