(function() {
    'use strict';
    angular.module('app').config(routes);
    routes.$inject = ['$stateProvider','$urlRouterProvider'];
    function routes($stateProvider,$urlRouterProvider){

        $urlRouterProvider.otherwise("/");

        $stateProvider.state('/', {
            url:'/',
            templateUrl: 'scripts/components/home/home.html'
        }).state('cartelera', {
            templateUrl: 'scripts/components/pelicula/cartelera.html',
            controller: 'CarteleraController'
        }).state('pelicula',{
            params: {
                peliculaId: null
            },
            templateUrl: 'scripts/components/pelicula/pelicula.html',
            controller: 'PeliculaController'
        }).state('pelicula.funcion',{
            params: {
                funcionId: null
            },
            templateUrl: 'scripts/components/funcion/funcion.html',
            controller: 'FuncionController'
        }).state('reservacion',{
            params: {
                funcion: null,
                total:null,
                asientos:null
            },
            templateUrl: 'scripts/components/reservacion/reservacion.html',
            controller: 'ReservacionController'
        }).state('respuesta',{
            params: {
                reservacion: null
            },
            templateUrl: 'scripts/components/reservacion/respuesta.html',
            controller: 'RespuestaController'
        });
    }
})();
