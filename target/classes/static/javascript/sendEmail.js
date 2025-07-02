const form = document.getElementById("emailForm");
const statusDiv = document.getElementById("status");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const receiver = document.getElementById("to").value;
    const subject = document.getElementById("subject").value;
    const body = document.getElementById("message").value;

    try {
        const response = await fetch("http://localhost:8080/api/sendEmail", {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ to: receiver, subject: subject, body: body })
        });

        if (response.ok) {
            statusDiv.textContent = "✅ Email sent!";

            } else {
            statusDiv.textContent = "❌ Failed to send email."
        }
    } catch (error) {
        console.error(error);
    }
});
