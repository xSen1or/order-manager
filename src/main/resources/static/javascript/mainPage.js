fetch('api/email-update')
    .then(response => {
        if (!response.ok) throw new Error("Network response was not ok");
        return response.json(); // Assuming backend sends JSON array
    })
    .then(emails => {
        const placeholder = document.getElementById('email-placeholder');

        if (!emails || emails.length === 0) {
            placeholder.innerHTML = "<p>No emails yet...</p>";
        } else {
            placeholder.innerHTML = "<h3>Your Emails</h3><ul>" +
                emails.map(email => `<li>${email.subject}</li>`).join('') +
                "</ul>";
        }
    })
    .catch(error => {
        console.error("Failed to load emails:", error);
        document.getElementById('emailPlaceholder').innerHTML = "<p>Error loading emails</p>";
    });