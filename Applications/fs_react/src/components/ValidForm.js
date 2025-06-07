import { useState } from "react";

const ValidForm = () => {
    const [formData, setFormData] = useState({
        email: "",
        username: "",
        password: ""
    });
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [error, setError] = useState("");
    const [users, setUsers] = useState([]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({
            ...prev,
            [name]: value
        }));
    };
    const checkPassword = (password) => {
        const passRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()+|?><])[A-Za-z0-9!@#$%^&*()+|?><]{8,}$/;
        return passRegex.test(password);
    };
    const checkUsername = (username) => {
        const userRegex = /^[A-Za-z][A-Za-z0-9]*$/;
        return userRegex.test(username);
    };
    const checkEmail = (email) => {
        const emailRegex = /^[A-Za-z._]+@[A-Za-z]+\.[A-Za-z]{2,}$/;
        return emailRegex.test(email);
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        const trimmed = {
            email: formData.email.trim(),
            username: formData.username.trim(),
            password: formData.password.trim()
        };
        if (!checkUsername(trimmed.username)) {
            setError("Username must start with an alphabet and can only contain alphabets and numbers.");
            setIsSubmitted(false);
            return;
        }

        if (!checkEmail(trimmed.email)) {
            setError("Email must contain only alphabets, '.', '_', followed by '@' and a valid domain.");
            setIsSubmitted(false);
            return;
        }

        if (!checkPassword(trimmed.password)) {
            setError("Password must be at least 8 characters long, contain at least one letter, one number, and one special character.");
            setIsSubmitted(false);
            return;
        }
        setUsers((prev) => [...prev, trimmed]);
        setIsSubmitted(true);
        setError("");
        setFormData({ email: "", username: "", password: "" });
    };

    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="username">Username:</label>
                <input
                    id="username"
                    type="text"
                    name="username"
                    placeholder="Enter username"
                    value={formData.username}
                    onChange={handleChange}
                />

                <label htmlFor="email">Email:</label>
                <input
                    id="email"
                    type="email"
                    name="email"
                    placeholder="Enter your email"
                    value={formData.email}
                    onChange={handleChange}
                />

                <label htmlFor="password">Password:</label>
                <input
                    id="password"
                    type="password"
                    name="password"
                    placeholder="Enter your password"
                    value={formData.password}
                    onChange={handleChange}
                />

                {error && <p>{error}</p>}
                {isSubmitted && !error && <p>Form submitted successfully!</p>}

                <button type="submit">Submit</button>
            </form>

            {users.length > 0 && (
                <div>
                    <h3>Valid Users</h3>
                    <table border="1" cellPadding="8" style={{ borderCollapse: "collapse" }}>
                        <thead>
                            <tr>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Password</th>
                            </tr>
                        </thead>
                        <tbody>
                            {users.map((user, index) => (
                                <tr key={index}>
                                    <td>{user.email}</td>
                                    <td>{user.username}</td>
                                    <td>{user.password}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}
        </>
    );
};

export default ValidForm;
