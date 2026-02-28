document.querySelector("#loginForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const email = document.querySelector("#email").value;
  const password = document.querySelector("#password").value;

  const user = {
    email: email,
    password: password
  };

  fetch("https://aetiological-confarreate-lyle.ngrok-free.dev/api/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user)
  })
    .then(res => {
      if (!res.ok) {
        throw new Error("Invalid credentials");
      }
      return res.json();
    })
    .then(data => {
      // Save user info in localStorage
      localStorage.setItem("userId", data.id);
      localStorage.setItem("userName", data.name);
      localStorage.setItem("userEmail", data.email);
      localStorage.setItem("userPhone", data.phone);
      localStorage.setItem("userAddress", data.address);

      alert("Login Successful!");
      window.location.href = "home.html";
    })
    .catch(err => {
      alert("Login failed! Invalid email or password.");
    });
});
