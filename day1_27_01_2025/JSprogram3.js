/*
You are given a date-time string dt in the format YYYY-MM-DDTHH:MM:SS (24-hour format). 
Your task is to convert this date-time string into the following format:

Input Format:
-------------
Line-1: A single date-time string in the format YYYY-MM-DDTHH:MM:SS (24-hour format).

Output Format:
--------------
Line-1: The formatted date-time string in the format :
DaySuffix MonthName, Year Hour:Minute:SecondAM/PM.

Sample Input-1:
---------------
2019-07-18T16:34:21

Sample Output-1:
----------------
18th July, 2019 04:34:21PM


Sample Input-2:
---------------
2022-03-01T23:59:59

Sample Output-2:
----------------
1st March, 2022 11:59:59PM

NOTE:
The output should include:
	Day with an ordinal suffix (e.g., 18th)
	Month as a word (e.g., July)
	12-hour time format with AM/PM

*/

const readline = require('readline');

// Set up readline interface for reading input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Function to convert date string
const convertDateString = (dateStr) => {
 const months = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    const getDaySuffix = (day) => {
        if (day >= 11 && day <= 13) return "th";
        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    };

    const [datePart, timePart] = dateStr.split("T");
    const [year, month, day] = datePart.split("-");
    const [hour, minute, second] = timePart.split(":");
    const daySuffix = getDaySuffix(parseInt(day));

    const monthName = months[parseInt(month) - 1];

    const period = parseInt(hour) >= 12 ? "PM" : "AM";
    const hour12 = parseInt(hour) % 12 || 12;

    return `${parseInt(day)}${daySuffix} ${monthName}, ${year} ${hour12.toString().padStart(2,'0')}:${minute.padStart(2, '0')}:${second.padStart(2, '0')}${period}`;

};

// Function to read input and process the date string
const processDateInput = () => {
  rl.question("", (input) => {
    const formattedDate = convertDateString(input);
    console.log(formattedDate);
    rl.close();
  });
};

// Start the process
processDateInput();