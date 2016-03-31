(function() {
    'use strict';
    angular.module('app.pelicula')
        .controller('PeliculaController',PeliculaController);

    PeliculaController.$inject = ['PeliculaDataService','FuncionDataService','$scope','$stateParams'];

    function PeliculaController(PeliculaDataService,FuncionDataService,$scope,$stateParams) {
        FuncionDataService.buscarPorPeliculaId($stateParams.peliculaId).success(function(funciones){
            $scope.funciones = funciones;
        });
        PeliculaDataService.buscarPorId($stateParams.peliculaId).success(function(pelicula){
            $scope.pelicula = pelicula;
        });
    }
}());