import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { AppBar, Toolbar, Typography, Button, Container } from '@mui/material';
import MultiStepForm from './components/MultiStepForm';
import AllProfiles from './components/AllProfiles';
import ProfileDetail from './components/ProfileDetail';

function App() {
  return (
    <Router>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            Profile Manager
          </Typography>
          <Button color="inherit" component={Link} to="/">New Profile</Button>
          <Button color="inherit" component={Link} to="/profiles">All Profiles</Button>
        </Toolbar>
      </AppBar>
      <Container sx={{ mt: 4 }}>
        <Routes>
          <Route path="/" element={<MultiStepForm />} />
          <Route path="/profiles" element={<AllProfiles />} />
          <Route path="/profiles/:id" element={<ProfileDetail />} />
        </Routes>
      </Container>
    </Router>
  );
}

export default App;
