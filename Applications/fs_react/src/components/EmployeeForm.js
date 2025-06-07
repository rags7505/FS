import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Form, Row, Col, Alert } from 'react-bootstrap';

const initialState = {
  fullName: '',
  email: '',
  mobile: '',
  dob: '',
  aadhar: '',
  pan: '',
  address: {
    houseNo: '',
    buildingName: '',
    area: '',
    city: '',
    state: '',
    pincode: '',
  },
};

const EmployeeForm = ({ onSubmit }) => {
  const [form, setForm] = useState(initialState);
  const [errors, setErrors] = useState({});
  const [submitted, setSubmitted] = useState(false);
  const navigate = useNavigate();

  const validate = () => {
    const errs = {};
    if (!form.fullName.trim()) errs.fullName = 'Full Name is required';
    if (!form.email.trim()) {
      errs.email = 'Email is required';
    } else if (!/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(form.email)) {
      errs.email = 'Invalid email format';
    }
    if (!form.mobile.trim()) {
      errs.mobile = 'Mobile Number is required';
    } else if (!/^[6-9]\d{9}$/.test(form.mobile)) {
      errs.mobile = 'Invalid mobile number';
    }
    if (!form.dob) errs.dob = 'Date of Birth is required';
    if (!/^[2-9]{1}[0-9]{11}$/.test(form.aadhar)) {
      errs.aadhar = 'Invalid AADHAR number';
    }
    if (!/^[A-Z]{5}[0-9]{4}[A-Z]{1}$/.test(form.pan)) {
      errs.pan = 'Invalid PAN number';
    }
    const addr = form.address;
    if (!addr.houseNo.trim()) errs.houseNo = 'House No is required';
    if (!addr.buildingName.trim()) errs.buildingName = 'Building Name is required';
    if (!addr.area.trim()) errs.area = 'Area is required';
    if (!addr.city.trim()) errs.city = 'City is required';
    if (!addr.state.trim()) errs.state = 'State is required';
    if (!addr.pincode.trim()) {
      errs.pincode = 'Pincode is required';
    } else if (!/^\d{6}$/.test(addr.pincode)) {
      errs.pincode = 'Invalid pincode';
    }
    return errs;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name in form.address) {
      setForm({ ...form, address: { ...form.address, [name]: value } });
    } else {
      setForm({ ...form, [name]: value });
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validate();
    setErrors(validationErrors);
    setSubmitted(true);

    if (Object.keys(validationErrors).length === 0) {
      const employeeData = {
        ...form,
        id: Date.now(),
        status: 'Pending',
      };

      const existing = JSON.parse(localStorage.getItem('employees') || '[]');
      existing.push(employeeData);
      localStorage.setItem('employees', JSON.stringify(existing));

      if (onSubmit) onSubmit(employeeData);
      setForm(initialState);
      setSubmitted(false);
    }
  };

  return (
    <div className="position-relative">
      <Button
        variant="secondary"
        className="position-absolute top-0 start-0 m-2"
        onClick={() => navigate('/')}
      >
        Home
      </Button>
      <Button
        variant="info"
        className="position-absolute top-0 end-0 m-2"
        onClick={() => navigate('/employees')}
      >
        Employee List
      </Button>
      <Form onSubmit={handleSubmit} className="p-4 border rounded shadow-sm bg-white mt-5">
        <h3 className="mb-4 text-center">Register Employee</h3>
        {submitted && Object.keys(errors).length > 0 && (
          <Alert variant="danger">Please fix the errors below.</Alert>
        )}
        <Form.Group className="mb-3">
          <Form.Label>Full Name</Form.Label>
          <Form.Control
            type="text"
            name="fullName"
            value={form.fullName}
            onChange={handleChange}
            isInvalid={!!errors.fullName}
          />
          <Form.Control.Feedback type="invalid">{errors.fullName}</Form.Control.Feedback>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
            isInvalid={!!errors.email}
          />
          <Form.Control.Feedback type="invalid">{errors.email}</Form.Control.Feedback>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Mobile Number</Form.Label>
          <Form.Control
            type="text"
            name="mobile"
            value={form.mobile}
            onChange={handleChange}
            isInvalid={!!errors.mobile}
            maxLength={10}
          />
          <Form.Control.Feedback type="invalid">{errors.mobile}</Form.Control.Feedback>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Date of Birth</Form.Label>
          <Form.Control
            type="date"
            name="dob"
            value={form.dob}
            onChange={handleChange}
            isInvalid={!!errors.dob}
          />
          <Form.Control.Feedback type="invalid">{errors.dob}</Form.Control.Feedback>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>AADHAR</Form.Label>
          <Form.Control
            type="text"
            name="aadhar"
            value={form.aadhar}
            onChange={handleChange}
            isInvalid={!!errors.aadhar}
          />
          <Form.Control.Feedback type="invalid">{errors.aadhar}</Form.Control.Feedback>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>PAN</Form.Label>
          <Form.Control
            type="text"
            name="pan"
            value={form.pan}
            onChange={handleChange}
            isInvalid={!!errors.pan}
          />
          <Form.Control.Feedback type="invalid">{errors.pan}</Form.Control.Feedback>
        </Form.Group>
        <h5 className="mt-4 mb-3">Address</h5>
        <Row>
          <Col md={6}>
            <Form.Group className="mb-3">
              <Form.Label>House No</Form.Label>
              <Form.Control
                type="text"
                name="houseNo"
                value={form.address.houseNo}
                onChange={handleChange}
                isInvalid={!!errors.houseNo}
              />
              <Form.Control.Feedback type="invalid">{errors.houseNo}</Form.Control.Feedback>
            </Form.Group>
          </Col>
          <Col md={6}>
            <Form.Group className="mb-3">
              <Form.Label>Building Name</Form.Label>
              <Form.Control
                type="text"
                name="buildingName"
                value={form.address.buildingName}
                onChange={handleChange}
                isInvalid={!!errors.buildingName}
              />
              <Form.Control.Feedback type="invalid">{errors.buildingName}</Form.Control.Feedback>
            </Form.Group>
          </Col>
        </Row>
        <Row>
          <Col md={6}>
            <Form.Group className="mb-3">
              <Form.Label>Area</Form.Label>
              <Form.Control
                type="text"
                name="area"
                value={form.address.area}
                onChange={handleChange}
                isInvalid={!!errors.area}
              />
              <Form.Control.Feedback type="invalid">{errors.area}</Form.Control.Feedback>
            </Form.Group>
          </Col>
          <Col md={6}>
            <Form.Group className="mb-3">
              <Form.Label>City</Form.Label>
              <Form.Control
                type="text"
                name="city"
                value={form.address.city}
                onChange={handleChange}
                isInvalid={!!errors.city}
              />
              <Form.Control.Feedback type="invalid">{errors.city}</Form.Control.Feedback>
            </Form.Group>
          </Col>
        </Row>
        <Row>
          <Col md={6}>
            <Form.Group className="mb-3">
              <Form.Label>State</Form.Label>
              <Form.Control
                type="text"
                name="state"
                value={form.address.state}
                onChange={handleChange}
                isInvalid={!!errors.state}
              />
              <Form.Control.Feedback type="invalid">{errors.state}</Form.Control.Feedback>
            </Form.Group>
          </Col>
          <Col md={6}>
            <Form.Group className="mb-3">
              <Form.Label>Pincode</Form.Label>
              <Form.Control
                type="text"
                name="pincode"
                value={form.address.pincode}
                onChange={handleChange}
                isInvalid={!!errors.pincode}
                maxLength={6}
              />
              <Form.Control.Feedback type="invalid">{errors.pincode}</Form.Control.Feedback>
            </Form.Group>
          </Col>
        </Row>
        <Button variant="success" type="submit" className="w-100 mt-3">
          Register Employee
        </Button>
      </Form>
    </div>
  );
};

export default EmployeeForm;