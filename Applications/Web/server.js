const webSocket = require('ws');

const server = new webSocket.Server({ port: 8080 });

const employees = [];
let id = 1;
server.on('connection', (socket) => {
  console.log("connected");
  socket.on('message', (message) => {
    const msg = (""+message).split(" ");
    if (msg[0] === "INSERT") {
      employees.push({ ID: id, Name: msg[1],Salary: msg[2] });
      id++;
      socket.send("Employee inserted successfully.");
    }
    else if (msg[0] === "RETRIEVE") {
      let data = ""
      employees.forEach(emp => {
        data+= `ID: ${emp.ID}, Name: ${emp.Name}, Salary: ${emp.Salary}\n`
      })
      socket.send(data)
    }
    else {
      socket.send("Invalid command.");
    }
  });

  socket.on("close", () => {
    console.log("closed");
    })
});