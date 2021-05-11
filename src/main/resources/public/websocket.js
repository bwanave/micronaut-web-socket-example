//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/ws/todos");
webSocket.onmessage = function (msg) {
    update(msg);
};
webSocket.onclose = function () {
    alert("WebSocket connection closed")
};

//Update the chat-panel, and the list of connected users
function update(msg) {
    insert("chat", msg.data);
}

//Helper function for inserting HTML as the first child of an element
function insert(targetId, message) {
    id(targetId).insertAdjacentHTML("afterbegin", "<p>" + message + "</p>");
}

//Helper function for selecting element by id
function id(id) {
    return document.getElementById(id);
}

