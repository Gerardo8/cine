(function() {
    'use strict';
    angular.module('app.funcion').controller('FuncionController',FuncionController);

    FuncionController.$inject = ['FuncionDataService','$scope','$stateParams','$state'];

    function FuncionController(FuncionDataService,$scope,$stateParams,$state) {
        FuncionDataService.buscarPorId($stateParams.funcionId).success(function(funcion){
            $scope.funcion = funcion;
        });
        $scope.cantidad = 0;
        $scope.precio = 30;
        $scope.total = 0;
        $scope.asientos = [];
        $scope.setCantidad = function(seleccion,fila,numero){
            if(seleccion){
                $scope.asientos.push(fila+'-'+numero);
                $scope.cantidad++;
            }else{
                $scope.asientos.pop(fila+'-'+numero);
                $scope.cantidad--;
            }
            $scope.total = $scope.cantidad*$scope.precio;
        };
        $scope.goToReservacion = function(funcion,total,asientos){
            if($scope.cantidad <= 0){
                alert("No has seleccionado ningun asiento")
            }else $state.go('reservacion',{funcion:funcion,total:total,asientos:asientos});
        }
    }
}());