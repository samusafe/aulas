
function hello(a){
    console.log('Hello')
}

hello()
hello("world")
hello(true)
hello(2)

function demo(a,b,c){
    console.log(a)
}

demo(2);
demo(2,3);
demo(2,3,4);

function new_demo(a,b=3){
    console.log(a + " " + b)
}

new_demo(1)
new_demo(1,4)

function odd_demo(a,b){
    if (b == undefined){
        console.log(a)
    } else {
        console.log(a + " " +b)
    }
}
odd_demo(1)
odd_demo("hello", 3)

function soma(a,b){
    return a+b
}

console.log(soma(1,2))
console.log(soma(1))
console.log(soma())

function concat(a,b){
    return a+b
}

console.log(concat("Hello ","World"))
console.log(concat(""))
console.log(concat())

function odd_demo2(a,b) {
    if (b==undefined) {
    console.log(a)
    } else {
    console.log(a + " " +b)
    }
}

odd_demo2(1)
odd_demo2("hello", 3)
odd_demo2()

function element(index){
    var arr =[1,2,3]
    return arr[index]
}

console.log(element(-1));

function sample(c){
    console.log(unknown)
}
sample()