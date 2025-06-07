import React from 'react';
import EmployeeCard from './EmployeeCard';

function HRPanel({ employees }) {
  const acceptedEmployees = employees.filter(
    (employee) => employee.status === 'Accepted' // Fixed casing
  );

  return (
    <div>
      <h2>HR Panel - Accepted Employees</h2>
      {acceptedEmployees.length === 0 ? (
        <p>No Accepted Employees.</p>
      ) : (
        acceptedEmployees.map((employee) => (
          <EmployeeCard
            key={employee.id}
            employee={employee}
          />
        ))
      )}
    </div>
  );
}
export default HRPanel;