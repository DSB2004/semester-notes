const ACCOUNT_FORM = document.getElementById("__create__account__form");
const ACCOUNT_FORM_MESSAGE = document.getElementById(
  "__create__account__form__p"
);

ACCOUNT_FORM.onsubmit = (e) => {
  e.preventDefault();
  const formdata = new FormData(e.target);

  fetch("/user/api/auth/signup/", {
    method: "POST",
    body: formdata,
  })
    .then((res) => res.text())
    .then((xmlText) => {
      const parser = new DOMParser();
      const xmlDoc = parser.parseFromString(xmlText, "application/xml");

      const status = xmlDoc.getElementsByTagName("status")[0]?.textContent;
      const message = xmlDoc.getElementsByTagName("message")[0]?.textContent;

      ACCOUNT_FORM_MESSAGE.textContent = message || "Unknown response";

      if (status === "success") {
        window.location.href = "/user/page/dashboard";
      } else {
        ACCOUNT_FORM_MESSAGE.style.color = "red";
      }
    })
    .catch((err) => {
      console.error(err);
      ACCOUNT_FORM_MESSAGE.textContent = "Network error";
      ACCOUNT_FORM_MESSAGE.style.color = "red";
    });
};
