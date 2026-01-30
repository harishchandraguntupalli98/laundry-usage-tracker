const API_BASE = "https://laundry-usage-tracker.onrender.com/api";

console.log("✅ script.js loaded");
""
function loadStatus() {
  fetch(`${API_BASE}/status`)
    .then(res => res.json())
    .then(data => {
      data.forEach(machine => {
        const statusText = machine.inUse
          ? `In use by ${machine.usedBy}`
          : "Available";

        if (machine.machine === "WASHER") {
          document.getElementById("washerStatus").innerText = statusText;
        } else if (machine.machine === "DRYER") {
          document.getElementById("dryerStatus").innerText = statusText;
        }
      });
    });
}

function useMachine(machine) {
  const nameInput =
    machine === "WASHER"
      ? document.getElementById("washerName")
      : document.getElementById("dryerName");

  fetch(`${API_BASE}/use`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      machine: machine,
      name: nameInput.value
    })
  })
    .then(res => res.text())
    .then(msg => {
      alert(msg);
      loadStatus();
    });
}

function releaseMachine(machine) {
  fetch(`${API_BASE}/release`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ machine: machine })
  })
    .then(res => res.text())
    .then(msg => {
      alert(msg);
      loadStatus();
    });
}

loadStatus();