const Web = require("ws")
const client = new Web("ws://localhost:8080")
client.on("open", () => {
  console.log("connected");
  client.send("INSERT ALICE 8800")
})
client.on("message", (message) => {
  console.log(message.toString())
})
client.on("close", () => {
  console.log("closed client")
})