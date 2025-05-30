const express = require('express');
const router = express.Router();
const User = require('../models/User');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
require('dotenv').config();

const JWT_SECRET = process.env.JWT_SECRET;

router.post('/login', async (req, res) => {
  const { username, password } = req.body;
  const user = await User.findOne({ username });
  if (!user) return res.status(400).json({ message: 'Login failed. Please try again.' });

  const isMatch = await bcrypt.compare(password, user.password);
  if (!isMatch) return res.status(400).json({ message: 'Login failed. Please try again.' });

  const token = jwt.sign({ userId: user._id }, JWT_SECRET, { expiresIn: '1h' });

  // 🔁 Return token and role
  res.json({ token, role: user.role });
});

router.post('/register', async (req, res) => {
  try {
    const { username, password, role } = req.body;
    const hashed = await bcrypt.hash(password, 10);

    const existing = await User.findOne({ username });
    if (existing) {
      existing.password = hashed;
      existing.role = role || existing.role;
      await existing.save();
      return res.json({ message: 'Password updated successfully.' });
    }

    const user = new User({ username, password: hashed, role });
    await user.save();
    res.json({ message: 'Registration successful. You can now login.' });
  } catch (err) {
    res.status(500).json({ message: 'Internal server error' });
  }
});

module.exports = router;
