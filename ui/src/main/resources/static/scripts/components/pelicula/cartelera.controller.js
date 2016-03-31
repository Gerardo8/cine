(function() {
    'use strict';
    angular.module('app.pelicula')
        .controller('CarteleraController',CarteleraController);

    CarteleraController.$inject = ['PeliculaDataService','$scope'];

    function CarteleraController(PeliculaDataService,$scope) {
        $scope.peliculas = PeliculaDataService.resource().query();
    }
}());