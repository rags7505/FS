import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const credentials = {
  admin: { username: 'admin', password: 'admin123' },
  hr: { username: 'hr', password: 'hr123' },
};

const Login = ({ setRole }) => {
  const [form, setForm] = useState({ username: '', password: '' });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      form.username === credentials.admin.username &&
      form.password === credentials.admin.password
    ) {
      setRole('admin');
      navigate('/admin');
    } else if (
      form.username === credentials.hr.username &&
      form.password === credentials.hr.password
    ) {
      setRole('hr');
      navigate('/hr');
    } else {
      setError('Invalid credentials');
    }
  };

  const handleGuestAccess = () => {
    setRole('guest');
    navigate('/');
  };

  return (
    <div>
      <h2>Login</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username:</label>
          <input type="text" name="username" value={form.username} onChange={handleChange} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" name="password" value={form.password} onChange={handleChange} />
        </div>
        <button type="submit">Login</button>
      </form>
      <hr />
      <button onClick={handleGuestAccess} style={{ marginTop: '10px' }}>
        Continue as Guest
      </button>
    </div>
  );
};

export default Login;