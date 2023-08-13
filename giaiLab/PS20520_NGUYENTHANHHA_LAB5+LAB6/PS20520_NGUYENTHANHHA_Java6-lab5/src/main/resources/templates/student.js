let host = "http://localhost:8080/rest";
const app = angular.module("app",[]);
app.controller("ctrl", function ($scope, $http) {
  
    $scope.form = {}
    $scope.items = []
    $scope.reset = function () { 
        $scope.form = {};
        $scope.form.gender=1;
        $scope.load_all();
    }
    $scope.load_all = function () {
        $scope.items = []
        var url = host+'/students';
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    $scope.load_all();
    $scope.edit = function (email) {
        var url = host+'/students/'+email;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
        
    }

    $scope.create = function () {
        var item = angular.copy($scope.form);
        var url = host+'/students';
        $http.post(url, item).then(resp => {
            $scope.items.push(item);
            $scope.reset();
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }

    $scope.update = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/students/${$scope.form.email}`;

        $http.put(url, item).then(resp => {
           var index = $scope.items.findIndex(item => 
               item.email == $scope.form.email
           ) 
              $scope.items[index] = resp.data  ;
          
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    $scope.delete = function (email) {
        var url = host+'/students/'+email;

        $http.delete(url).then(resp => {
            var index = $scope.items.findIndex(item =>{ 
                item.email == email;
            }) 
            $scope.items.splice(index,1)
            $scope.reset();
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
})