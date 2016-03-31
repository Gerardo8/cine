(function() {
    'use strict';
    angular.module('app.reservacion')
        .factory('ReservacionDataService',ReservacionDataService);

    ReservacionDataService.$inject = ['$resource','$http'];

    function ReservacionDataService($resource,$http) {

        var service = {
            resource: resource,
            buscarPorId: buscarPorId
        };
        return service;

        function buscarPorId(reservacionId){
            return $http.get('http://localhost:9000/resource/reservacion/'+reservacionId.timestamp+'/'+reservacionId.machineIdentifier+'/'+reservacionId.processIdentifier+'/'+reservacionId.counter);
        }

        function resource(){
            return $resource('http://localhost:9000/resource/reservacion',null,
                {
                    'update': { method:'PUT' }
                });
        }
    }
}());