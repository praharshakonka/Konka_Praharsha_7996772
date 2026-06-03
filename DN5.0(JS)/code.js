// 1. Basics
console.log("Welcome to the Community Portal");

window.onload = () => {
  alert("Page loaded successfully");
};

// 2. Data types
const eventName = "Music Night";
const eventDate = "2026-06-10";
let seats = 10;

// 5. Object + Class
class Event {
  constructor(name, category, seats) {
    this.name = name;
    this.category = category;
    this.seats = seats;
  }
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

// 6. Array of events
let events = [
  new Event("Music Night", "Music", 5),
  new Event("Baking Workshop", "Workshop", 10),
  new Event("DJ Night", "Music", 0)
];

// 4. Closure (registration counter)
function createCounter() {
  let count = 0;
  return function () {
    return ++count;
  };
}
const musicCounter = createCounter();

// 7. DOM
const container = document.querySelector("#events");

// render function
function renderEvents(list) {
  container.innerHTML = "";

  list.forEach(event => {
    if (event.seats <= 0) return;

    const card = document.createElement("div");
    card.className = "card";

    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>${event.category}</p>
      <p>Seats: ${event.seats}</p>
      <button onclick="registerUser('${event.name}')">Register</button>
    `;

    container.appendChild(card);
  });
}

// initial render
renderEvents(events);

// 3 + 8 Registration logic + error handling
function registerUser(eventName) {
  try {
    let event = events.find(e => e.name === eventName);

    if (!event || event.seats <= 0) {
      throw "No seats available";
    }

    event.seats--;
    musicCounter();

    alert("Registered successfully!");
    renderEvents(events);

  } catch (err) {
    console.error(err);
  }
}

// 8. Filter dropdown
document.querySelector("#categoryFilter").onchange = (e) => {
  const value = e.target.value;

  if (value === "all") {
    renderEvents(events);
  } else {
    renderEvents(events.filter(e => e.category === value));
  }
};

// 8. Search box
document.querySelector("#searchBox").onkeydown = (e) => {
  const value = e.target.value.toLowerCase();

  const filtered = events.filter(ev =>
    ev.name.toLowerCase().includes(value)
  );

  renderEvents(filtered);
};

// 9. Async fetch simulation
async function fetchEvents() {
  console.log("Loading events...");

  try {
    let res = await fetch("https://jsonplaceholder.typicode.com/posts");
    let data = await res.json();

    console.log("Fetched data:", data.slice(0, 3));

  } catch (err) {
    console.error("Error fetching data");
  }
}
fetchEvents();

// 10. Modern JS
const [firstEvent] = events;
const clonedEvents = [...events];

// 11. Form handling
document.querySelector("#eventForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const form = e.target;
  const name = form.elements["name"].value;
  const email = form.elements["email"].value;

  if (!name || !email) {
    alert("Fill all fields");
    return;
  }

  alert(`Registered: ${name}`);
});

// 12. Fetch API(POST)
function sendData() {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify({ user: "test" }),
    headers: { "Content-Type": "application/json" }
  })
  .then(res => res.json())
  .then(data => console.log("Success:", data))
  .catch(err => console.error("Fail"));
}
sendData();
//13. DEBUGGING 
function debugRegister(eventName) {
  console.log("Debug start:", eventName);

  try {
    let event = events.find(e => e.name === eventName);
    console.log("Found event:", event);

    if (!event) throw "Not found";

    event.seats--;
    console.log("Seats updated:", event.seats);

    renderEvents(events);

  } catch (err) {
    console.error("Debug error:", err);
  }
}
// 14. jQuery and JSFrameworks
$("#registerBtn").click(() => {
  $(".card").fadeOut(300).fadeIn(300);
});