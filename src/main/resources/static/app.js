const API_URL = "http://localhost:8080/api/appliances";
const lightId = 1;
const fanId = 2;
const acId = 3;

// Fan Control
function setFanSpeed(speed) {
    fetch(`${API_URL}/fan/${fanId}/speed?speed=${speed}`, { method: 'POST' })
        .then(response => response.text())
        .then(data => {
            document.getElementById("fan-status").innerText = `Fan Status: ${data}`;
        })
        .catch(error => console.error('Error:', error));
}

function updateFanSpeed() {
    const speed = parseInt(document.getElementById("fan-speed-slider").value);
    const fanIcon = document.getElementById("fan-icon");
    if (speed === 0) {
        fanIcon.src = "/img/fan.svg";
        document.getElementById("fan-status").innerText = "Fan Status: Off";
    } else if (speed === 1) {
        fanIcon.src = "/img/fan-speed-1.svg";
        document.getElementById("fan-status").innerText = "Fan Status: Low Speed";
    } else if (speed === 2) {
        fanIcon.src = "/img/fan-speed-2.svg";
        document.getElementById("fan-status").innerText = "Fan Status: High Speed";
    }
    setFanSpeed(speed);
}

// Generic function to turn off any appliance by ID
function turnOffAppliance(id) {
    fetch(`${API_URL}/${id}/off`, { method: 'POST' })
        .then(response => response.text())
        .then(data => {
            if (id === lightId) {
                document.getElementById("light-status").innerText = `Light Status: ${data}`;
                document.getElementById("light-icon").src = "/img/light-switch-off.svg";

            } else if (id === fanId) {
                document.getElementById("fan-status").innerText = `Fan Status: ${data}`;
            } else if (id === acId) {

                document.getElementById("ac-status").classList.add("black");
                document.getElementById("ac-status").innerText = `AC Status: ${data}`;
            }
        })
        .catch(error => console.error('Error:', error));
}

// Generic function to turn on any appliance by ID
function turnOnAppliance(id) {
    fetch(`${API_URL}/${id}/on`, { method: 'POST' })
        .then(response => response.text())
        .then(data => {
            if (id === lightId) {
                document.getElementById("light-status").innerText = `Light Status: ${data}`;
                document.getElementById("light-icon").src = "/img/light-switch-on.svg";
            } else if (id === fanId) {
                document.getElementById("fan-status").innerText = `Fan Status: ${data}`;
            } else if (id === acId) {
                document.getElementById("ac-status").classList.remove("black");
                document.getElementById("ac-status").innerText = `AC Status: ${data}`;
            }
        })
        .catch(error => console.error('Error:', error));
}
// Air Conditioner Control
function setACTemperature() {
    const temperature = document.getElementById("temperature-input").value;
    if (isNaN(temperature)) {
        acStatus.innerText = "Error: Please enter a valid number for temperature.";
        acStatus.classList.remove("cold", "warm");
        acStatus.classList.add("error");
        return;
    }    const acStatus = document.getElementById("ac-status");
    if (temperature < 10 || temperature > 35) {
        acStatus.innerText = "Error: Temperature must be between 10°C and 35°C.";
        acStatus.classList.remove("cold", "warm");
        acStatus.classList.add("error");
        return;
    }

    acStatus.classList.remove("black");

    fetch(`${API_URL}/airconditioner/${acId}/temperature?temperature=${temperature}`, { method: 'POST' })
        .then(response => response.text())
        .then(data => {

            if (temperature < 20) {
                acStatus.innerText = `AC Status: Cold (${temperature}°C)`;
                acStatus.classList.remove("warm");
                acStatus.classList.add("cold");
            } else {
                acStatus.innerText = `AC Status: Warm (${temperature}°C)`;
                acStatus.classList.remove("cold");
                acStatus.classList.add("warm");
            }
            document.getElementById("ac-status").innerText = `AC Status: ${data}`;
        })
        .catch(error => {
            console.error('Error:', error);
            acStatus.innerText = `Error: Unable to set temperature. ${error.message}`;
            acStatus.classList.remove("cold", "warm");
            acStatus.classList.add("error");
        });
}

// Status
function getAllStatus(){
  // get the statuses with the ID or appliance type.
    fetch(`${API_URL}/status/all`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Server error: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            const [lightStatus,fanStatus,acStatus] = data;

            document.getElementById("fan-status").innerText = `Fan Status: ${fanStatus}`;
            document.getElementById("light-status").innerText = `Light Status: ${lightStatus}`;
            document.getElementById("ac-status").innerText = `AC Status: ${acStatus}`;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById("fan-status").innerText = "Error fetching fan status.";
            document.getElementById("light-status").innerText = "Error fetching light status.";
            document.getElementById("ac-status").innerText = "Error fetching AC status.";
        });
}

window.onload = function() {
    getAllStatus();
};