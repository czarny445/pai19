angular
	.module("clientBrowser")
	.config(function($routeProvider) {
		$routeProvider
			.when("/newPackage", {
				templateUrl : "app/components/newPackage/newPackage.html",
				controller : "NewPackageController as newPackageController"
			})
			.when("/packagesList", {
				templateUrl : "app/components/packagesList/packagesList.html",
				controller : "PackagesListController as packagesListController"
			})
	});