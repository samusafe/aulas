const uuid = require('uuid');
const moduleTest = require('./myModule');
const fs = require('fs');
var events = require('events');
var eventEmitter = new events.EventEmitter();

/*
eventEmitter.addListener('Lousada', function (data) {
    console.log('Associaçao desportiva de lousada ' + data.jogador + data.cartao);
})

eventEmitter.on('SegundoEvento', function (data) {
    console.log(data);
})

eventEmitter.emit('Lousada', {jogador: "Samuel", cartao: "Vermelho"})
eventEmitter.emit('SegundoEvento', "Hello world");
eventEmitter.emit('TerceiroEvento', {jogador: "Jorge", cartao: "Amarelo"})

console.log("Inicio")
let data = fs.writeFile("text.txt", "Hello world", function name(err) {
    if (err) return console.log(err);
    console.log("Data escrita")
});
console.log("Fim");

console.log("Inicio")
let data = fs.readFileSync("text.txt", function (err, data) {
    if (err) {
        console.log("Error");
        return;
    }
    console.log(data.toString());
});
console.log("Fim");

var a = 1;
var b = 2;

var c = a + b;

console.log(moduleTest.myDateTime());
console.log(moduleTest.aulaTest);
console.log(moduleTest.pessoa);
console.log(`Hello world! ${c}`);
console.log(uuid.NIL);
*/