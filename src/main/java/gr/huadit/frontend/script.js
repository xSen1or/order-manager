const form = document.getElementById('signupForm');
const messageDiv = document.getElementById('message');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Login request
    const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: username, password: password })
    });

    if (response.ok) {
        window.location.href = "loggedin.html";
    } else {
        console.log("Login Failed")
    }
});

document.addEventListener("DOMContentLoaded", async () => {
    const userInformation = await fetch('http://localhost:8080/api/getUser', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: username, password: password })
    })

    if(userInformation.ok) {
        const email = userInformation.email;
        const phone = userInformation.phone;
    }

    const userData = {
        username: username,
        email: "john@example.com",
        fullname: "John Doe"
    };

    document.getElementById("username").textContent = userData.username;
    document.getElementById("email").textContent = userData.email;
    document.getElementById("fullname").textContent = userData.fullname;
    document.getElementById("phone").textContent = userData.phone;
    document.getElementById("logoutBtn").addEventListener("click", () => {
        alert("Logging out...");
        window.location.href = "index.html";
    });
});
