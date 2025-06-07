// models/User.js
const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
  username: String,
  password: String,
  role: { type: String, enum: ['admin', 'consumer'], default: 'consumer' }
});

module.exports = mongoose.model('User', userSchema);
