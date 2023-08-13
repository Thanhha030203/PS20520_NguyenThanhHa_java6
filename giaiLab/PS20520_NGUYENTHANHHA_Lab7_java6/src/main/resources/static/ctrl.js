var app = angular.module("app",[]);

app.config(function($httpProvider){ 
    $httpProvider.defaults.headers.common['Authorization'] = "Basic dXNlcjI6MTIz";
})
app.controller("ctrl",function($scope, $http){ 
    $http.get("http://localhost:8080/rest/a").then(resp =>{ 
        $scope.db = resp.data;
        console.log("jlsas",resp.data)
    })

    $scope.index_of = function(username, role){ 
		console.log("jlsas")
        return $scope.db.authorities.findIndex(
			
            a => a.account.username == username 
            && a.role.id == role
        )
    }

    $scope.update = function(username, role){ 
        var index = $scope.index_of(username, role) ;
        if(index >=0){ 
            var id = $scope.db.authorities[index].id;
            $http.delete(`http://localhost:8080/rest/a/${id}`).then(resp =>{ 
                $scope.db.authorities.splice(index,1)
            })
        }
        else{
            // Tạo ra 1 authority mới để đưa lên json
            var authority = { 
                account:{username: username},
                role: {id:role}
            };
            $http.post("http://localhost:8080/rest/a",authority).then(resp=>{ 
                $scope.db.authorities.push(resp.data);
            });
        }
    }
   
})