angular
	.module("clientBrowser")
	.controller("HistoryPackageController", historyPackageController);

function historyPackageController($rootScope, $http, $location){
	var ctrl = this;
	ctrl.chosePackage = $rootScope.chosePackage;
	ctrl.back = function() {
		$rootScope.chosePackage = {};
		$location.path("/packagesList");
	}
}