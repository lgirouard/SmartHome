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

// Generic function to turn off any appliance by ID
function turnOffAppliance(id) {
    fetch(`${API_URL}/${id}/off`, { method: 'POST' })
        .then(response => response.text())
        .then(data => {
            if (id === lightId) {
                document.getElementById("light-status").innerText = `Light Status: ${data}`;
            } else if (id === fanId) {
                document.getElementById("fan-status").innerText = `Fan Status: ${data}`;
            } else if (id === acId) {
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
            } else if (id === fanId) {
                document.getElementById("fan-status").innerText = `Fan Status: ${data}`;
            } else if (id === acId) {
                document.getElementById("ac-status").innerText = `AC Status: ${data}`;
            }
        })
        .catch(error => console.error('Error:', error));
}
// Air Conditioner Control
function setACTemperature() {
    const temperature = document.getElementById("temperature-input").value;
    fetch(`${API_URL}/airconditioner/${acId}/temperature?temperature=${temperature}`, { method: 'POST' })
        .then(response => response.text())
        .then(data => {
            document.getElementById("ac-status").innerText = `AC Status: ${data}`;
        })
        .catch(error => console.error('Error:', error));
}



// Status
function getAllStatus(){
  // get the statuses with the ID or appliance type.
    fetch(`${API_URL}/appliances/status/all`, {method: 'GET'}).then(response =>response.text()).then(data =>{
        document.getElementById("")
    })
}