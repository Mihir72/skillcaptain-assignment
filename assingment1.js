
const prompt = require('prompt-sync')()
let num = prompt("enter the number")
if(num <= 0)
  console.log("the input you had entered is wrong")

else{
    for(let i = 1; i <= 10; ++i){
        console.log(num * i);
    }
}