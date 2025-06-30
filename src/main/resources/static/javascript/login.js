const form = document.getElementById('signupForm');
const messageDiv = document.getElementById('message');

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("password", password);
    // Login request
    const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: username, password: password })
    });

    if (response.ok) {
        console.log("response okey")
        window.location.href = "loggedin.html";
    } else {
        console.log("Login Failed")
    }
});
//
// document.addEventListener("DOMContentLaded", async () => {
//     const username = sessionStorage.getI em("username");
//     const password = sessionStorage.getItem("password");
//     const response = await fetch("http://localhost:8080/getUser", {
//         method: "POST",
//         headers: { "Content-Type": "application/json" },
//         body: JSON.stringify({
//             username: username,
//             password: password
//         })
//     });
//
//     if (response.ok) {
//         const user = await response.json();
//
//         document.getElementById("username").textContent = user.userId;
//         document.getElementById("email").textContent = user.email;
//         document.getElementById("fullname").textContent = user.username;
//
//     } else {
//         alert("❌ Invalid Information")
//     }
//
//     document.getElementById("logoutBtn").addEventListener("click", () => {
//         alert("Logging out...");
//         window.location.href = "index.html";
//     });
// });
