const form = document.getElementById("createAccount");

form.addEventListener('submit', async (e) => {
    e.preventDefault()
    const newUsername = document.getElementById("username");
    const newPassword = document.getElementById("password")
    const newEmail = document.getElementById("email")
    const newPhoneNumber = document.getElementById("phone");

    // Create Account Request
    const request = fetch("/api/createUser", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: newUsername, password: newPassword, email: newEmail, phone: newPhoneNumber})
    });

    if(request.ok) {
        alert("OK!")
    } else {
        alert("Not OK!")
    }
})