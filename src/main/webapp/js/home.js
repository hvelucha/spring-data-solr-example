var list_carousel_app = angular.module('list_idea', []);
list_carousel_app.controller('formController', function ($scope, $http) {
	$http.get("/rest/everydayIdeas")
		.success(function(response) {$scope.everydayIdeas = response;});

	$scope.deleteData = function(everydayIdea) {
		$http.delete("/rest/carousels/" + carousel.id + "/delete")
			.success(function(response) {
				alert("Delete success!");
				window.location = "/carousels";
			})
			.error(function(response) {
				alert("Unable to delete [" + carousel.id + "]");
			});
	}

});



var edit_carousel_app = angular.module('edit_carousel', []);
edit_carousel_app.controller('formController', function ($scope, $http) {
	id = getUrlParameter('id');

	// if the id param does not exist, do not do a GET
	if(typeof id != 'undefined') {
		$http.get("/rest/carousels/" + id)
			.success(function(response) {$scope.carousel = response;})
			.error(function(response) {
				alert("Invalid id [" + id + "]");
				window.location = "/carousels";
			});
	}

    $scope.submitData = function() {
    		var config= {
    			params: {
    				carousel: $scope.carousel
    			}
    		};

			// if no id, we'll do a create. else update
			if(typeof id != 'undefined') {
	            $http.put("/rest/carousels/" + id + "/update", $scope.carousel, config)
		            .success(function (data, status, headers, config) {
		                alert("Record has been saved");
		                window.location = "/carousels";
		            })
		            .error(function (data, status, headers, config) {
		                alert("Unable to save record");
		            });
	        } else {
	            $http.post("/rest/carousels/create", $scope.carousel, config)
	                .success(function (data, status, headers, config) {
	                    alert("Record has been saved");
	                    window.location = "/carousels";
	                })
	                .error(function (data, status, headers, config) {
						errorMsg = "";

						for(var i = 0; i < data.fieldErrors.length; i++)
		                    errorMsg = data.fieldErrors[0].message + "\n";

		                alert(errorMsg);
	                });
	        }

	};

	cancelButton = document.getElementById("cancel");
    cancelButton.onclick = function(){
        window.location = "/carousels";
    };
});


