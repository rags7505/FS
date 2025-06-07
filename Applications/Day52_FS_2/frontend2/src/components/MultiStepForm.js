import React, { useReducer, useState } from 'react';
import { TextField, Button, Typography, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const API_URL = 'http://localhost:5000';

const initialState = {
  name: '', email: '', phone: '',
  degree: '', institution: '', year: '',
  interests: '', achievements: ''
};

function reducer(state, action) {
  switch (action.type) {
    case 'UPDATE_FIELD':
      return { ...state, [action.field]: action.value };
    case 'RESET':
      return initialState;
    default:
      return state;
  }
}

function MultiStepForm() {
  const [step, setStep] = useState(1);
  const [state, dispatch] = useReducer(reducer, initialState);
  const navigate = useNavigate();

  const handleChange = (e) => {
    dispatch({ type: 'UPDATE_FIELD', field: e.target.name, value: e.target.value });
  };

  const handleSubmit = async () => {
    await fetch(`${API_URL}/api/profiles`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(state)
    });
    dispatch({ type: 'RESET' });
    navigate('/profiles');
  };

  return (
    <Box sx={{ maxWidth: 500, mx: 'auto' }}>
      {step === 1 && (
        <>
          <Typography variant="h6" gutterBottom>Step 1: Personal Info</Typography>
          <TextField fullWidth margin="normal" label="Name" name="name" value={state.name} onChange={handleChange} />
          <TextField fullWidth margin="normal" label="Email" name="email" value={state.email} onChange={handleChange} />
          <TextField fullWidth margin="normal" label="Phone" name="phone" value={state.phone} onChange={handleChange} />
        </>
      )}
      {step === 2 && (
        <>
          <Typography variant="h6" gutterBottom>Step 2: Education Info</Typography>
          <TextField fullWidth margin="normal" label="Degree" name="degree" value={state.degree} onChange={handleChange} />
          <TextField fullWidth margin="normal" label="Institution" name="institution" value={state.institution} onChange={handleChange} />
          <TextField fullWidth margin="normal" label="Year" name="year" value={state.year} onChange={handleChange} />
        </>
      )}
      {step === 3 && (
        <>
          <Typography variant="h6" gutterBottom>Step 3: Interests</Typography>
          <TextField fullWidth margin="normal" label="Interests (comma-separated)" name="interests" value={state.interests} onChange={handleChange} />
        </>
      )}
      {step === 4 && (
        <>
          <Typography variant="h6" gutterBottom>Step 4: Achievements</Typography>
          <TextField fullWidth margin="normal" label="Achievements (comma-separated)" name="achievements" value={state.achievements} onChange={handleChange} />
        </>
      )}

      <Box mt={2}>
        {step > 1 && <Button onClick={() => setStep(step - 1)}>Previous</Button>}
        {step < 4
          ? <Button variant="contained" onClick={() => setStep(step + 1)}>Next</Button>
          : <Button variant="contained" color="success" onClick={handleSubmit}>Submit</Button>}
      </Box>
    </Box>
  );
}

export default MultiStepForm;
