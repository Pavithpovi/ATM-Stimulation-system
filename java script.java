const users = {
  user1: 1000.0,
  user2: 1500.0
};

let currentUser = "";

function login() {
  const username = document.getElementById("username").value;
  if (users[username] !== undefined) {
    currentUser = username;
    document.getElementById("userDisplay").textContent = username;
    document.getElementById("menu").classList.remove("hidden");
  } else {
    alert("User not found!");
  }
}

function checkBalance() {
  showOutput(`Current Balance: $${users[currentUser].toFixed(2)}`);
}

function deposit() {
  const amount = parseFloat(prompt("Enter amount to deposit:"));
  if (!isNaN(amount) && amount > 0) {
    users[currentUser] += amount;
    showOutput(`Deposited $${amount.toFixed(2)} successfully.`);
  } else {
    showOutput("Invalid amount.");
  }
}

function withdraw() {
  const amount = parseFloat(prompt("Enter amount to withdraw:"));
  if (!isNaN(amount) && amount > 0 && amount <= users[currentUser]) {
    users[currentUser] -= amount;
    showOutput(`Withdrew $${amount.toFixed(2)} successfully.`);
  } else {
    showOutput("Invalid or insufficient amount.");
  }
}

function logout() {
  currentUser = "";
  document.getElementById("menu").classList.add("hidden");
  showOutput("");
}

function showOutput(message) {
  document.getElementById("output").innerText = message;
}
