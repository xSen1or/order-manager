
document.addEventListener("DOMContentLoaded", async () => {
    const username = sessionStorage.getItem("username");
    const password = sessionStorage.getItem("password");
    const response = await fetch("http://localhost:8080/api/getUser", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    if (response.ok) {
        const user = await response.json();

        document.getElementById("username").textContent = user.userId;
        document.getElementById("email").textContent = user.email;
        document.getElementById("fullname").textContent = user.username;

    } else {
        alert("❌ Invalid Information")
    }

    document.getElementById("logoutBtn").addEventListener("click", () => {
        alert("Logging out...");
        window.location.href = "index.html";
    });
});