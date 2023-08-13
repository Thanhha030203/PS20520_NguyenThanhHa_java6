var app = angular.module("app",[]);
app.controller("ctrl",function($scope, $http){ 
    $http.get("http://localhost:8080/rest/authorities").then(resp =>{ 
        $scope.db = resp.data;
        console.log("jlsas",resp.data)
    })

    $scope.index_of = function(username, role){ 
        return $scope.db.authorities.findIndex(
            a => a.accounts.username = username 
            && a.role.id == role
        )
    }
})