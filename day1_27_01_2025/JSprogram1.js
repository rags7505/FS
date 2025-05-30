/*
You are given a string str, and your task is to find the number of vowels and consonants in the string.

Input Format:
-------------
Line-1: A string

Output Format:
--------------
Line-1: A number, Vowels count
Line-2: A number, Consonants count

Sample Input-1:
---------------
Hello

Sample Output-1:
----------------
Vowels: 2
Consonants: 3

Sample Input-1:
---------------
Hello world

Sample Output-1:
----------------
Vowels: 3
Consonants: 7

*/

const readline = require('readline');

// Set up readline interface for reading input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Function to count vowels in a string
const countVowels = (str) => {
  //Write your code here
  let v=0,c=0;
  str=str.toLowerCase();
  for(let i=0;i<str.length;i++){
      if(str.charAt(i)<'a' || str.charAt(i)>'z') continue;
      let char=str.charAt(i);
      if(char ==='a' || char==='e'||char==='i'||char==='o' ||char ==='u') v++;
      else c++;
  }
  return {count1:v,count2:c}
};

// Reading input synchronously
console.log("Enter a string:");
rl.on('line', (input) => {
  const len = input.length;
  const {count1, count2} = countVowels(input);
  console.log(`Vowels: ${count1}\nConsonants: ${count2}`);
  rl.close();
});