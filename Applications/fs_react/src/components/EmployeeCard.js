import React from 'react';

function EmployeeCard({ employee, onAccept, onReject }) {
  const style = {
    border: '1px solid #ccc',
    padding: '10px',
    margin: '10px',
    backgroundColor: employee.status === 'Accepted' ? '#d4edda' : employee.status === 'Rejected' ? '#f8d7da' : '#fff3cd',
  };
  return (
    <div style={style}>
      <h4>{employee.fullName} ({employee.status})</h4>
      <p>Email: {employee.email}</p>
      <p>Mobile: {employee.mobile}</p>
      <p>City: {employee.address.city}, State: {employee.address.state}</p>
      {employee.status === 'Pending' && (
        <div>
          {onAccept && <button onClick={() => onAccept(employee.id)}>Accept</button>}
          {onReject && <button onClick={() => onReject(employee.id)} style={{ marginLeft: '10px' }}>Reject</button>}
        </div>
      )}
    </div>
  );
}
export default EmployeeCard;