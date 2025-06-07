import React, { useEffect, useState } from 'react';
import { Typography, List, ListItem, ListItemText } from '@mui/material';
import { Link } from 'react-router-dom';

const API_URL = 'http://localhost:5000';

function AllProfiles() {
  const [profiles, setProfiles] = useState([]);

  useEffect(() => {
    fetch(`${API_URL}/api/profiles`)
      .then(res => res.json())
      .then(data => setProfiles(data));
  }, []);

  return (
    <>
      <Typography variant="h6" gutterBottom>All Profiles</Typography>
      <List>
        {profiles.map((profile) => (
          <ListItem button component={Link} to={`/profiles/${profile._id}`} key={profile._id}>
            <ListItemText primary={profile.name} secondary={profile.email} />
          </ListItem>
        ))}
      </List>
    </>
  );
}

export default AllProfiles;
