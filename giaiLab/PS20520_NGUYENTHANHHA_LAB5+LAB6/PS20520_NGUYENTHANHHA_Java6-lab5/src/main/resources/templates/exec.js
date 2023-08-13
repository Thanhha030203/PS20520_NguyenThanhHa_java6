var app = angular.module("app",[]);
app.controller("ctrl", function($scope, $http){ 
    $scope.import = function (files) {
        
        var reader = new FileReader();
        reader.onloadend = async () => {
            
            var workbook = new ExcelJS.Workbook();
            await workbook.xlsx.load(reader.result);
            const worksheet = workbook.getWorksheet('sheet')
            worksheet.eachRow((row,index)=>{
                
                    let student ={
                        email: row.getCell(1).value,
                        fullname: row.getCell(2).value,
                        marks: +row.getCell(3).value,
                        gender: true,
                        country: row.getCell(5).value
                    }
                    var url = "http://localhost:8080/rest/students";
                    $http.post(url, student).then(resp => {
                        console.log("Success", resp)
                    }).catch(error => {
                        console.log("fail", error)
                    })
                });
  
        };
        reader.readAsArrayBuffer(files[0]);
    }
})