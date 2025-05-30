const mongoose = require('mongoose');

const profileSchema = new mongoose.Schema({
  name: String,
  email: String,
  phone: String,
  degree: String,
  institution: String,
  year: String,
  interests: [String],
  achievements: [String],
});

module.exports = mongoose.model('Profile', profileSchema);
