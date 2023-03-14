function multiply(a, b) {
    return a * b;
}

var palavras = ["ola", "samuel", "aula"];

function longestString(strings) {
    var maior = strings.reduce((a, b) => a.length > b.length ? a : b, '');
    return maior
}

function isPrime(number) {
    var assert = require('assert');

    var naoTemDivisao = function(num) {
        var i, quantDivisores = 0;

        for(i = 1; i <= num; i++) {
            if (temDivisao(num, i)) {
                quantDivisores++;
            }
        }

        if (quantDivisores == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    var temDivisao = function(dividendo, divisor) {
        if ((dividendo % divisor) > 0) {
            
            } 
        }
        return (dividendo % divisor);
    }



console.log(multiply(1, 2));
console.log(longestString(palavras));
console.log(isPrime(4));