(function() {
    'use strict';
    angular.module('app.reservacion')
        .controller('RespuestaController',RespuestaController);

    RespuestaController.$inject = ['$scope','$stateParams','$state'];

    function RespuestaController($scope,$stateParams,$state) {
        $scope.reservacion = $stateParams.reservacion;
        $scope.goToHome = function(){
            $state.go('/');
        }
    }
}());