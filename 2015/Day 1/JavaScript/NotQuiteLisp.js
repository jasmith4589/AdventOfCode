const fs = require('fs');
const input = fs.readFileSync('input.txt', 'utf8');
let floor = 0;
let basement = 0;

function findFloor(input){
    for (let x in input){
        if (input[x] === '('){
            floor ++;
        }
        else{
            floor --;
        }
    }
}

//This second function is still funky
function findBasement(input){
    for (let i = 0; i<input.length; i++){
        if (basement <=-1){
            return;
        }
        else if (input[i] === '('){
            floor ++;
            basement = i;
        }
        else{
            floor --;
            basement = i;
        }
    }
}

findFloor(input);
findBasement(input);
console.log('The instructions take Santa to floor: ' + floor);
console.log('Following the instructions, we hit the basement at location: ' + basement);

