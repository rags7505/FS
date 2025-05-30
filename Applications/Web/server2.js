const webSocket = require('ws');
const mongoose = require('mongoose')
mongoose
  .connect('mongodb://127.0.0.1:27017/userDB', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch((err) => console.error('MongoDB connection error:', err));
const server = new webSocket.Server({ port: 8080 });
const employeeSchema = new mongoose.Schema({
    ID:Number,
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});

const Employee = mongoose.model('Employee', employeeSchema);
let id = 1;
server.on('connection', (socket) => {
  console.log("connected");
  socket.on('message', async (message) => {
    const msg = (""+message).split(" ");
    if (msg[0] === "INSERT") {
      
      const newEmp = new Employee({ ID: id, name: msg[1], salary: parseInt(msg[2]), role: msg[3], department: msg[4], experience: parseInt(msg[5]) });
      id++;
      await newEmp.save();
      socket.send("Employee inserted successfully.");
    }
    else if (msg[0] === "RETRIEVE") {
      const emps = await Employee.find();
      let data = ""
      emps.forEach(emp => data += `ID: ${emp.ID}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years\n`)
      console.log(data)
      socket.send(data)
    }
    else if (msg[0] === "RETRIEVE_BY_DEPT") {
      const dept = msg[1]
      const emps = await Employee.find({ department: dept });
      let data = ""
      emps.forEach(emp => data += `ID: ${emp.ID}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years\n`)
      console.log(data)
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