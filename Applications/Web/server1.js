const WebSocket = require('ws')
const server = new WebSocket.Server({ port: 8080 })
let clients=[]
server.on('connection', (socket) => {
  console.log('connected')
  clients.push(socket)
  socket.on('message', (message) => {
    const msg = message.toString();
    for (const client of clients) {
      if (client.readyState == WebSocket.OPEN) {
        client.send(msg)
      }
    }
  })
  socket.on('close', () => {
    clients=clients.filter((client)=> client!==socket)
  })
})

console.log('server running on ws://localhost:8080')