const ADD_USER_BUTTON = document.getElementById("__add__user__button");
const CANCEL_BUTTON = document.getElementById("__cancel__button");
const ADD_USER_DIALOG = document.getElementById("__add__user__dialog");
const ADD_USER_FORM = document.getElementById("__create___user__form");

// Events

ADD_USER_BUTTON.onclick = () => {
  ADD_USER_DIALOG.showModal();
};
CANCEL_BUTTON.onclick = () => {
  ADD_USER_DIALOG.close();
};

ADD_USER_FORM.onsubmit = (e) => {
  e.preventDefault();
  const formData = new FormData(e.target);

  const email = formData.get("email");
  const name = formData.get("name");
  const phone = formData.get("phone");
  console.log(name, email, phone);
};
//  user table function

function createUserRow({ name, email, phone }) {
  const tableRow = document.createElement("tr");
  [name, email, phone].forEach((value) => {
    const td = document.createElement("td");
    td.className = "__w__200 __text__left";
    td.textContent = value;
    tableRow.appendChild(td);
  });

  return tableRow;
}

async function getUser() {
  try {
    const response = await fetch("/user.xml");
    if (!response.ok) {
      throw new Error("Failed to fetch XML");
    }
    const xmlText = await response.text();
    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(xmlText, "application/xml");

    const userNodes = xmlDoc.querySelectorAll("user");
    const body = document.getElementById("__user__table__body");

    Array.from(userNodes).map((userNode) => {
      const phone = userNode.querySelector("phone")?.textContent ?? "";
      const name = userNode.querySelector("name")?.textContent ?? "";
      const email = userNode.querySelector("email")?.textContent ?? "";
      const row = createUserRow({ name, email, phone });
      body.appendChild(row);
    });
  } catch (error) {
    console.error("Error:", error);
  }
}
