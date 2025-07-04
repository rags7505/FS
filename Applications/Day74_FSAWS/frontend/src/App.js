import React from "react";

const students = [
  { id: 1, name: "Alice", age: 20, grade: "A" },
  { id: 2, name: "Bob", age: 21, grade: "B" },
  { id: 3, name: "Charlie", age: 22, grade: "C" },
  { id: 4, name: "David", age: 23, grade: "B+" },
  { id: 5, name: "Eve", age: 20, grade: "A-" },
  { id: 6, name: "Frank", age: 24, grade: "B" },
  { id: 7, name: "Grace", age: 22, grade: "A+" },
  { id: 8, name: "Heidi", age: 21, grade: "C+" },
  { id: 9, name: "Ivan", age: 23, grade: "B-" },
  { id: 10, name: "Judy", age: 20, grade: "A" }
];

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h2>Student Records</h2>
      <table border="1" cellPadding="10" style={{ borderCollapse: "collapse", width: "100%" }}>
        <thead>
          <tr style={{ backgroundColor: "#f2f2f2" }}>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Grade</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.age}</td>
              <td>{student.grade}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
