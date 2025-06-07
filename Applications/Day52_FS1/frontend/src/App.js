// src/App.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {
  Table, TableBody, TableCell, TableContainer, TableHead, TableRow,
  Paper, Typography, TablePagination, TextField, Button, AppBar,
  Toolbar, Box, Container, Alert
} from '@mui/material';

const API_URL = 'http://localhost:5000';

const App = () => {
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [editIndex, setEditIndex] = useState(null);
  const [editData, setEditData] = useState({});
  const [searchTerm, setSearchTerm] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [view, setView] = useState('login');
  const [authForm, setAuthForm] = useState({ username: '', password: '', role: 'consumer' });
  const [message, setMessage] = useState('');
  const [messageType, setMessageType] = useState('success');

  const authData = JSON.parse(localStorage.getItem('auth')) || {};
  const token = authData.token;
  const role = authData.role;

  useEffect(() => {
    if (token) {
      setIsLoggedIn(true);
      setView('products');
    }
  }, [token]);

  useEffect(() => {
    const fetch = async () => {
      if (!isLoggedIn) return;
      try {
        const res = await axios.get(`${API_URL}/api/products/search?name=${searchTerm}`, {
          headers: { Authorization: `Bearer ${token}` }
        });
        setProducts(res.data);
      } catch (err) {
        console.error(err);
      }
    };
    fetch();
  }, [searchTerm, isLoggedIn, token]);

  const handleChangePage = (event, newPage) => setPage(newPage);
  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };
  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
    setPage(0);
  };

  const handleEdit = (index, product) => {
    setEditIndex(index);
    setEditData({ ...product });
  };

  const handleEditChange = (field, value) => {
    setEditData({ ...editData, [field]: value });
  };

  const handleSave = async () => {
    try {
      await axios.put(`${API_URL}/api/products/${editData._id}`, editData, {
        headers: { Authorization: `Bearer ${token}` }
      });
      const res = await axios.get(`${API_URL}/api/products/search?name=${searchTerm}`, {
        headers: { Authorization: `Bearer ${token}` }
      });
      setProducts(res.data);
      setEditIndex(null);
    } catch (err) {
      console.error('Update failed:', err);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`${API_URL}/api/products/${id}`, {
        headers: { Authorization: `Bearer ${token}` }
      });
      const res = await axios.get(`${API_URL}/api/products/search?name=${searchTerm}`, {
        headers: { Authorization: `Bearer ${token}` }
      });
      setProducts(res.data);
    } catch (err) {
      console.error('Delete failed:', err);
    }
  };

  const handleAuthChange = (field, value) => {
    setAuthForm({ ...authForm, [field]: value });
  };

  const handleRegister = async () => {
    try {
      await axios.post(`${API_URL}/api/auth/register`, authForm);
      // Clear the form after successful registration
      setAuthForm({ username: '', password: '', role: 'consumer' });
      setMessage('Registration successful. You can now login.');
      setMessageType('success');
      setTimeout(() => setMessage(''), 3000);
    } catch (err) {
      setMessage('Registration failed: ' + err.response.data.message);
      setMessageType('error');
      setTimeout(() => setMessage(''), 3000);
    }
  };

  const handleLogin = async () => {
    try {
      const res = await axios.post(`${API_URL}/api/auth/login`, authForm);
      localStorage.setItem('auth', JSON.stringify({ token: res.data.token, role: res.data.role }));
      setIsLoggedIn(true);
      setMessage('');
      setView('products');
      // Clear the form after successful login
      setAuthForm({ username: '', password: '', role: 'consumer' });
    } catch (err) {
      alert('Login failed. Please try again.');
    }
  };

  const handleLogout = () => {
    localStorage.removeItem('auth');
    setIsLoggedIn(false);
    setAuthForm({ username: '', password: '', role: 'consumer' });
    // Remove the logout message - no message should be displayed
    setMessage('');
    setView('login');
  };

  // Clear form when switching between login and register views
  const handleViewChange = (newView) => {
    setView(newView);
    setAuthForm({ username: '', password: '', role: 'consumer' });
    setMessage(''); // Clear any existing messages
  };

  return (
    <>
      <AppBar position="static" sx={{ backgroundColor: '#1976d2' }}>
        <Container maxWidth="xl">
          <Toolbar disableGutters sx={{ justifyContent: 'space-between' }}>
            <Typography variant="h6" component="div">
              MERN Product App
            </Typography>
            {!isLoggedIn ? (
              <Box>
                <Button color="inherit" onClick={() => handleViewChange('login')}>Login</Button>
                <Button color="inherit" onClick={() => handleViewChange('register')}>Register</Button>
              </Box>
            ) : (
              <Button color="inherit" onClick={handleLogout}>Logout</Button>
            )}
          </Toolbar>
        </Container>
      </AppBar>

      {view === 'register' || view === 'login' ? (
        <Box sx={{ padding: 3 }}>
          {message && (
            <Alert severity={messageType} sx={{ mb: 2 }} data-testid="registration-success">
              {message}
            </Alert>
          )}
          <Typography variant="h5" gutterBottom>{view === 'register' ? 'Register' : 'Login'}</Typography>
          <TextField 
            label="Username" 
            fullWidth 
            margin="normal" 
            value={authForm.username} 
            onChange={(e) => handleAuthChange('username', e.target.value)} 
          />
          <TextField 
            label="Password" 
            type="password" 
            fullWidth 
            margin="normal" 
            value={authForm.password} 
            onChange={(e) => handleAuthChange('password', e.target.value)} 
          />
          {view === 'register' && (
            <TextField
              select
              label="Role"
              fullWidth
              margin="normal"
              value={authForm.role}
              onChange={(e) => handleAuthChange('role', e.target.value)}
              SelectProps={{ native: true }}
            >
              <option value="consumer">consumer</option>
              <option value="admin">admin</option>
            </TextField>
          )}
          <Button 
            variant="contained" 
            onClick={view === 'register' ? handleRegister : handleLogin}
            sx={{ mt: 2 }}
          >
            {view === 'register' ? 'Register' : 'Login'}
          </Button>
        </Box>
      ) : (
        <div style={{ padding: 20 }}>
          <Typography variant="h4" gutterBottom>Product List</Typography>
          <TextField
            label="Search Products by Name"
            variant="outlined"
            fullWidth
            margin="normal"
            value={searchTerm}
            onChange={handleSearchChange}
          />
          <TableContainer component={Paper}>
            <Table>
              <TableHead sx={{ backgroundColor: '#1976d2' }}>
                <TableRow>
                  <TableCell sx={{ color: 'white', fontWeight: 'bold' }}>Name</TableCell>
                  <TableCell sx={{ color: 'white', fontWeight: 'bold' }}>Price</TableCell>
                  <TableCell sx={{ color: 'white', fontWeight: 'bold' }}>Category</TableCell>
                  <TableCell sx={{ color: 'white', fontWeight: 'bold' }}>In Stock</TableCell>
                  {role === 'admin' && (
                    <TableCell sx={{ color: 'white', fontWeight: 'bold' }}>Actions</TableCell>
                  )}
                </TableRow>
              </TableHead>
              <TableBody>
                {products.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((product, index) => (
                  <TableRow key={product._id}>
                    {editIndex === index ? (
                      <>
                        <TableCell>
                          <TextField
                            value={editData.name}
                            onChange={(e) => handleEditChange('name', e.target.value)}
                          />
                        </TableCell>
                        <TableCell>
                          <TextField
                            type="number"
                            value={editData.price}
                            onChange={(e) => handleEditChange('price', parseFloat(e.target.value))}
                          />
                        </TableCell>
                        <TableCell>
                          <TextField
                            value={editData.category}
                            onChange={(e) => handleEditChange('category', e.target.value)}
                          />
                        </TableCell>
                        <TableCell>
                          <TextField
                            value={editData.inStock ? 'Yes' : 'No'}
                            onChange={(e) => handleEditChange('inStock', e.target.value.toLowerCase() === 'yes')}
                          />
                        </TableCell>
                        {role === 'admin' && (
                          <TableCell>
                            <Button variant="outlined" color="success" size="small" onClick={handleSave}>SAVE</Button>
                          </TableCell>
                        )}
                      </>
                    ) : (
                      <>
                        <TableCell>{product.name}</TableCell>
                        <TableCell>${product.price.toFixed(2)}</TableCell>
                        <TableCell>{product.category}</TableCell>
                        <TableCell>{product.inStock ? 'Yes' : 'No'}</TableCell>
                        {role === 'admin' && (
                          <TableCell>
                            <Button variant="outlined" color="primary" size="small" onClick={() => handleEdit(index, product)} sx={{ marginRight: 1 }}>EDIT</Button>
                            <Button variant="outlined" color="error" size="small" onClick={() => handleDelete(product._id)}>DELETE</Button>
                          </TableCell>
                        )}
                      </>
                    )}
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
          <TablePagination
            component="div"
            count={products.length}
            page={page}
            onPageChange={handleChangePage}
            rowsPerPage={rowsPerPage}
            onRowsPerPageChange={handleChangeRowsPerPage}
            rowsPerPageOptions={[10, 25, 50, 100]}
          />
        </div>
      )}
    </>
  );
};

export default App;