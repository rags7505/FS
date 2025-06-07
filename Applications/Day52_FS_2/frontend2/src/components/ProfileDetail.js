import React, { useEffect, useState } from 'react';
import { Typography } from '@mui/material';
import { useParams } from 'react-router-dom';

const API_URL = 'http://localhost:5000';

function ProfileDetail() {
  const { id } = useParams();
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    fetch(`${API_URL}/api/profiles/${id}`)
      .then(res => res.json())
      .then(data => setProfile(data));
  }, [id]);

  if (!profile) return <Typography>Loading...</Typography>;

  return (
    <>
      <Typography variant="h5" gutterBottom>Profile of {profile.name}</Typography>
      <Typography variant="subtitle1">Personal Info</Typography>
      <p>Email: {profile.email}</p>
      <p>Phone: {profile.phone}</p>

      <Typography variant="subtitle1">Education</Typography>
      <p>Degree: {profile.degree}</p>
      <p>Institution: {profile.institution}</p>
      <p>Year: {profile.year}</p>

      <Typography variant="subtitle1">Interests</Typography>
      <p>{profile.interests}</p>

      <Typography variant="subtitle1">Achievements</Typography>
      <p>{profile.achievements}</p>
    </>
  );
}

export default ProfileDetail;
