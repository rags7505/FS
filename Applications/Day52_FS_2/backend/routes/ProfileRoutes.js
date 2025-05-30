const express = require('express');
const router = express.Router();
const Profile = require('../models/Profile');

router.post('/', async (req, res) => {
  try {
    const data = {
      ...req.body,
      interests: req.body.interests.split(',').map(i => i.trim()),
      achievements: req.body.achievements.split(',').map(a => a.trim())
    };
    const newProfile = new Profile(data);
    const saved = await newProfile.save();
    res.status(201).json(saved);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

router.get('/', async (req, res) => {
  try {
    const profiles = await Profile.find();
    res.json(profiles);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

router.get('/:id', async (req, res) => {
  try {
    const profile = await Profile.findById(req.params.id);
    if (!profile) return res.status(404).json({ error: 'Not found' });
    res.json(profile);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;
