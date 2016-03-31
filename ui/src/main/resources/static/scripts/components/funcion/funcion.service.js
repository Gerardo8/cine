(function() {
    'use strict';
    angular.module('app.funcion')
        .factory('FuncionDataService',FuncionDataService);

    FuncionDataService.$inject = ['$resource','$http'];

    function FuncionDataService($resource,$http) {

        var service = {
            resource: resource,
            buscarPorId: buscarPorId,
            buscarPorPeliculaId: buscarPorPeliculaId
        };
        return service;

        function buscarPorId(funcionId) {
            return $http.get('http://localhost:9000/resource/funcion/' + funcionId.timestamp + '/' + funcionId.machineIdentifier + '/' + funcionId.processIdentifier + '/' + funcionId.counter);
        }

        function resource() {
            return $resource('http://localhost:9000/resource/funcion', null,
                {
                    'update': {method: 'PUT'}
                });
        }

        function buscarPorPeliculaId(peliculaId) {
            return $http.get('http://localhost:9000/resource/funcionPelicula/' + peliculaId.timestamp + '/' + peliculaId.machineIdentifier + '/' + peliculaId.processIdentifier + '/' + peliculaId.counter);
        }
    }
}());