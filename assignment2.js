function temperature(celcius){
     return (celcius * 9/5) + 32
}


const prompt = require("prompt-sync")()
let c = prompt("enter the temperature in celcius")
console.log(temperature(c))
