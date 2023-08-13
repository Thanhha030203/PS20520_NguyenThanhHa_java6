const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($scope,$http){ 
	$scope.cart = { 
		items:[],

		//thêm sản phẩm vào giỏ hàng
		add(id){
			var item = this.items.find(item => item.id == id);
			if(item){ 
				// nếu có trong gỏ hàng items rồi thì tăng số lượng
				item.qty ++;
				this.saveToLocalStorage();

			}
			else{
				$http.get(`/rest/products/${id}`).then(resp =>{ 
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},

		//Xoá sản phẩm trong giỏ
		remove(id){
			var index = this.items.findIndex(item => item.id ==id);
			this.items.splice(index,1);
			this.saveToLocalStorage();
		},

		//Xoá sạch sản phẩm trong giỏ
		clear(){
			this.items=[];
			this.saveToLocalStorage();
		},

		//Tính thành tiền của 1 sp
		amt_of(item){},

		//Tính tổng số lượng của cá mặt hàng
		get count(){
			return this.items
			.map(item => item.qty)
			.reduce((total,qty)=> total += qty,0);
		},

		//Tính tổng tiền của cá mặt hàng
		get amount(){
			return this.items
			.map(item => item.qty* item.price)
			.reduce((total,qty)=> total += qty,0);
		},

		//Lưu giỏ hàng vào Local storage
		saveToLocalStorage(){
			// ta dodoir các mặt hàng từ items sang json
			var json = JSON.stringify(angular.copy(this.items));
			//Sau đó dùng json đó lưu vào local Storage
			localStorage.setItem("cart",json);
		},

		// Đọc giỏ hàng từ LocalStore
		loadFromLocalStore(){
			//Lấy từ localstorage = getItem và gán cho json
			var json = localStorage.getItem("cart");
			//Nếu json có sẽ chuyển về dạng json và gán vào items
			// và ép json về dạng mảng == :[]
			this.items = json?JSON.parse(json):[]
		}
	}
	$scope.cart.loadFromLocalStore();

	$scope.order = {
		createDate : new Date(),
		address : "",
		account:  {username:$("#user1").text()},
		
		//Tạo ra orderDtail là hoá đơn chi tiết trước của từng sản phẩm trong order
		// Rồi sau đó mới đêm toàn bộ order đi tính
		get orderDetails(){ 
				return $scope.cart.items.map(item => {
					return {
						product : {id : item.id},
						price : item.price,
						quantity : item.qty
					}
				})
		},
		
		purchase(){
			var order = angular.copy(this);
			//thực hiện đặt hàng
			$http.post(`/rest/orders`,order).then(resp =>{ 
				alert("Đặt hàng thành công");
				$scope.cart.clear();
				
				location.href = "/order/detail/"+ resp.data.id;
				console.log("ksjd"+ resp.data)
			}).catch(error =>{
				alert("Đặt hàng lỗi !");
				console.log(error)})
		}
	}
		
});



// const app = angular.module("shopping-cart-app",[]);

// app.controller("shopping-cart-ctrl",function($scope, $http){

// 	$scope.cart = {
// 		items: [],
// 		add(id){
// 			var item = this.items.find(item => item.id == id);
// 			if(item){
// 				item.qty++;
// 				this.saveToLocalStorage();
// 			}
// 			else{
// 				$http.get(`/rest/products/${id}`).then(resp => {
// 					resp.data.qty = 1;
// 					this.items.push(resp.data);
// 					this.saveToLocalStorage();
// 				})
// 			}
// 		},
// 		saveToLocalStorage(){
// 			var json = JSON.stringify(angular.copy(this.items));
// 			localStorage.setItem("cart",json);
// 		},
// 		get count(){
// 			return this.items
// 			.map(item => item.qty)
// 			.reduce((total, qty) => total += qty, 0);
// 		},
// 		get amount(){
// 			return this.items
// 			.map(item => item.qty * item.price)
// 			.reduce((total, qty) => total += qty, 0);
// 		},
// 		loadFormLocalStorage(){
// 			var json = localStorage.getItem("cart");
// 			this.items = json ? JSON.parse(json):[];
// 		},
// 		remove(id){
// 			var index = this.items.findIndex(item => item.id == id);
// 			this.items.splice(index, 1);
// 			this.saveToLocalStorage();
// 		},
// 		clear(){
// 			this.items=[]
// 			this.saveToLocalStorage();
// 		}
// 	}
// 	$scope.cart.loadFormLocalStorage();
	
// 	$scope.order = {
// 		createDate: new Date(),
// 		address:"",
// 		account:{username:$("#username").text()},
// 		get orderDetails(){
// 			return $scope.cart.items.map(item => {
// 				return{
// 					product:{id: item.id},
// 					price: item.price,
// 					quantity: item.qty
// 				}
// 			});
// 		},
// 		purchase(){
// 			var order = angular.copy(this);
// 			$http.post("/rest/orders",order).then(resp => {
// 				alert("Đặt hàng thành công");
// 				$scope.cart.clear();
// 				location.href="/order/detail/" + resp.data.id;
// 			}).catch(error => {
// 				alert("Đặt hàng lỗi!")
// 				console.log(error)
				
// 			})
// 		}
// 	}
// })
	
