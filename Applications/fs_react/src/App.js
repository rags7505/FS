// import { Routes, Route } from 'react-router-dom';
// import Greetings from './components/Greetings.js';
// import Counter from './components/Counter.js';
// import UsersTable from './components/UsersTable.js';
// import Navbar from './components/Navbar.js';
// import ShoppingCart from './components/ShopingCart.js';
// import ToggleMessage from './components/ToggleMessage.js';
// import Calculator from './components/Calculator.js';
// import ValidForm from './components/ValidForm.js';

// function App() {
//   return (
//     <div className="App">
//       <Navbar/>
//      <Routes>
//       <Route path="/greeting" element={<Greetings name="Kmec" />} />
//       <Route path="/counter" element={<Counter />} />
//         <Route path="/userInfo" element={<UsersTable />} />
//         <Route path="/toggleMessage" element={<ToggleMessage />} />
//         <Route path="/calculator" element={<Calculator />} />
//         <Route path="/validForm" element={<ValidForm />} />
//         <Route path="/shoppingCart" element={<ShoppingCart />} />
//      </Routes>
//     </div>
//   );
// }

// export default App;
import React, { useState } from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import EmployeeForm from './components/EmployeeForm';
import EmployeeList from './components/EmployeeList';
import AdminPanel from './components/AdminPanel';
import HRPanel from './components/HRPanel';

function App() {
  const [employees, setEmployees] = useState([]);

  const addEmployee = (employee) => setEmployees([...employees, employee]);
  const acceptEmployee = (id) => setEmployees(employees.map((e) => e.id === id ? { ...e, status: 'Accepted' } : e));
  const rejectEmployee = (id) => setEmployees(employees.map((e) => e.id === id ? { ...e, status: 'Rejected' } : e));

  return (
    <div>
      <nav>
        <Link to="/">Home</Link> | <Link to="/register">Register</Link> | <Link to="/employees">Employees</Link> | <Link to="/admin">Admin</Link> | <Link to="/hr">HR</Link>
      </nav>
      <Routes>
        <Route path="/" element={<h1>Welcome to EMS</h1>} />
        <Route path="/register" element={<EmployeeForm onSubmit={addEmployee} />} />
        <Route path="/employees" element={<EmployeeList employees={employees} />} />
        <Route path="/admin" element={<AdminPanel employees={employees} acceptEmployee={acceptEmployee} rejectEmployee={rejectEmployee} />} />
        <Route path="/hr" element={<HRPanel employees={employees} />} />
      </Routes>
    </div>
  );
}

export default App;