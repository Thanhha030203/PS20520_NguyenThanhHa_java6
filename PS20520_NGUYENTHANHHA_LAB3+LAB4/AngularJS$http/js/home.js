let host = "https://ps20520-lab4-java6-default-rtdb.firebaseio.com";

var app = angular.module("myApp", []);
app.controller("myCtrl", function($scope, $http) {
    $scope.student = {}

    $scope.students = {}

    $scope.load_All = function() {
        var url = `${host}/students.json`;
        $http.get(url).then(response => {
            $scope.students = response.data;
            alert("Success" + response);
        }).catch(error => {
            alert("Error" + error);
        });
    }

    $scope.edit = function(key) {
        var url = `${host}/students/${key}.json`;
        $http.get(url).then(response => {
            $scope.student = response.data;
            $scope.key = key;
            alert("Success");
        }).catch(error => {
            alert("Error");
        });
    }

    $scope.create = function() {
        var st = angular.copy($scope.student);
        var url = `${host}/students.json`;
        $http.post(url, st).then(response => {
            $scope.key = response.data.name;
            $scope.students[$scope.key] = st;
            $scope.reset();
            alert("Success" + response);
        }).catch(error => {
            alert("Error" + error);
        });
    }

    $scope.update = function() {
        var st = angular.copy($scope.student);
        var url = `${host}/student/${$scope.key}.json`;
        $http.put(url, st).then(response => {
            $scope.students[$scope.key] = response.data;
            alert("Success" + response);
        }).catch(error => {
            alert("Error" + error);
        });
    }

    $scope.delete = function(key) {
        var url = `${host}/student/${key}.json`;
        $http.delete(url).then(response => {
            delete $scope.students[key];
            $scope.reset();
            alert("Success" + response);
        }).catch(error => {
            alert("Error" + error);
        });
    }

    $scope.reset = function() {
        $scope.student = { gender: true, country: "" };
        $scope.key = null;
    }

    //start
    $scope.load_All();
    $scope.reset();
})