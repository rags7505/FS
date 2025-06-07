import React from "react";
import EmployeeCard from "./EmployeeCard";

function AdminPanel({ employees, acceptEmployee, rejectEmployee }) {
  const pendingEmployees = employees.filter(
    (employee) => employee.status === "Pending" // Fixed casing
  );

  return (
    <div>
      <h2>Admin Panel - Approve or Reject Employees</h2>
      {pendingEmployees.length === 0 ? (
        <p>No pending employees to approve.</p>
      ) : (
        pendingEmployees.map((employee) => (
          <EmployeeCard
            key={employee.id}
            employee={employee}
            onAccept={acceptEmployee}
            onReject={rejectEmployee}
          />
        ))
      )}
    </div>
  );
}
export default AdminPanel;