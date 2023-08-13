const app = angular.module("app",[]);
app.config(function($httpProvider) {
	$httpProvider.defaults.headers.common['Authorization'] = "Basic dXNlcjE6MTIz";
});
app.controller("ctrl", function($scope, $http) {
	let url = "http://localhost:8080/rest/authorities";
	$http.get(url).then(resp => {
		$scope.db = resp.data;
	}).catch(error => {
		console.log("Error", error);
	})
	
	$scope.index_of = function(username, role) {
		return $scope.db.authorities.
		findIndex(a => a.account.username == username && a.role.id == role);
	}
	
	$scope.update = function(username, role) {
		console.log("click");
		let index = $scope.index_of(username, role);
		if(index >= 0) {
			let id = $scope.db.authorities[index].id;
			$http.delete(`http://localhost:8080/rest/authorities/${id}`).then(resp => {
				$scope.db.authorities.splice(index, 1);
			})
		} else {
			let authority = {
				account:{username: username},
				role:{id: role}
			};
			$http.post("http://localhost:8080/rest/authorities", authority).then(resp => {
				$scope.db.authorities.push(resp.data);
			})
		}
	}
})