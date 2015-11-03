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
			.when("/newDepartment", {
				templateUrl : "app/components/newDepartment/newDepartment.html",
				controller : "NewDepartmentController as newDepartmentController"
			})
			.when("/departmentsList", {
				templateUrl : "app/components/departmentsList/departmentsList.html",
				controller : "DepartmentsListController as departmentsListController"
			})
			.when("/historyPackage", {
				templateUrl : "app/components/historyPackage/historyPackage.html",
				controller : "HistoryPackageController as historyPackageController"
			})
	});