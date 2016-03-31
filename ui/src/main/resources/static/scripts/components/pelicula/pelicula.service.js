(function() {
    'use strict';
    angular.module('app.pelicula')
        .factory('PeliculaDataService',PeliculaDataService);

    PeliculaDataService.$inject = ['$resource','$http'];

    function PeliculaDataService($resource,$http) {

        var service = {
            resource: resource,
            buscarPorId: buscarPorId
        };
        return service;

        function buscarPorId(peliculaId){
            return $http.get('http://localhost:9000/resource/pelicula/'+peliculaId.timestamp+'/'+peliculaId.machineIdentifier+'/'+peliculaId.processIdentifier+'/'+peliculaId.counter);
        }

        function resource(){
            return $resource('http://localhost:9000/resource/pelicula',null,
                {
                    'update': { method:'PUT' }
                });
        }
    }
}());