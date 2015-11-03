angular
	.module("clientBrowser")
	.controller("PackagesListController", packagesListController);

function packagesListController($rootScope, $http, $location){
	var ctrl = this;
	
	$http.get("http://localhost:8080/package/getAllPackages").success(function(data){
		ctrl.packages = data;
	});
	
	ctrl.remove = function(pack)
	{
		$http.post("http://localhost:8080/package/remove", pack)
		.success(function(data){
			console.log("usunieto paczke");
			for(var i=0;i<ctrl.packages.length;i++){
				if(ctrl.packages[i].id == pack.id){
					ctrl.packages.splice(i,1);
					break;
				}
			}
		})
		.error(function(error){
			console.log("nie udalo sie usunac paczki");
		});
	};
	
	ctrl.showHistory = function(pack){
		$rootScope.chosePackage = pack;
		$location.path("/historyPackage");
	};
}
