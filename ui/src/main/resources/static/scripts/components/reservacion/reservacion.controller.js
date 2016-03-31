(function() {
    'use strict';
    angular.module('app.reservacion')
        .controller('ReservacionController',ReservacionController);

    ReservacionController.$inject = ['ReservacionDataService','FuncionDataService','$scope','$stateParams','$state'];

    function ReservacionController(ReservacionDataService,FuncionDataService,$scope,$stateParams,$state) {
        $scope.funcion = $stateParams.funcion;
        $scope.meses= [];
        $scope.years = [];
        $scope.reservacion = {};
        $scope.reservacion.asientos = $stateParams.asientos;
        $scope.reservacion.total = $stateParams.total;
        //$scope.transaccion = {
        //    numeroTarjeta:undefined,
        //    codigoSeguridad:undefined,
        //    mes:undefined,
        //    year:undefined
        //};

        (function(){
            for(var i=1;i<=12;i++){
                $scope.meses.push(i);
            }
            for(var i=2015;i<=2040;i++){
                $scope.years.push(i);
            }

        }());

        $scope.reservar = function(funcion){
            for(var i = 0;i<12;i++){
                for(var j = 0;j<15;j++){
                    funcion.sala.filas[i].asientos[j].deshabilitado = funcion.sala.filas[i].asientos[j].seleccionado;
                }
            }
            $scope.reservacion.nombrePelicula = funcion.pelicula.titulo;
            $scope.reservacion.fechaFuncion = funcion.fecha;
            $scope.reservacion.nombreSala = funcion.sala.nombre;

            FuncionDataService.resource().update(funcion);
            ReservacionDataService.resource().save($scope.reservacion);
            $state.go("respuesta",{reservacion:$scope.reservacion});

        }
    }
}());