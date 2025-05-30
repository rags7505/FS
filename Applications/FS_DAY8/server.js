const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')

const app = express()
const port = 3000

app.use(cors())
app.use(bodyParser.json())

let orders = [
  { id: 1, customerName: "Azar" ,totalPrice:150.0}
]

app.get('/orders', (req, res) => {
  res.send(orders)
})

app.get('/orders/:id', (req, res) => {
  const orderId= parseInt(req.params.id)
  const order = orders.find(order => order.id === orderId)
  if(!order){
    return res.status(404).send()
  }
  res.send(order)  
})

app.post('/orders', (req, res) => {
  const { customerName , totalPrice } = req.body
  if(!customerName || !totalPrice){
    return res.status(400).send()
  }
  const order = { id: orders.length + 1, customerName:customerName,totalPrice:totalPrice }
  orders.push(order)
  res.status(201).send(order)
})

app.put('/orders/:id', (req, res) => {
  const orderId= parseInt(req.params.id)
  const { customerName,totalPrice } = req.body
  const order = orders.find(order => order.id === orderId)
  if(!order){
    return res.status(404).send()
  }
  order.customerName = customerName || order.customerName
  order.totalPrice=totalPrice || order.totalPrice
  res.status(200).send(order)
})

app.delete('/orders/:id', (req, res) => {
  const orderId= parseInt(req.params.id)
  orders = orders.filter(order => order.id !== orderId)
  res.status(200).send()
})

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`)
})