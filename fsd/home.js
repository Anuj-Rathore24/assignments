window.addEventListener("load", function () {
  async function sendQuery(userEmail,userName) {
    data={
        email:userEmail,
        name:userName
    }
    console.log(data);
    await fetch("http://localhost:3000/", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }
  const form = document.getElementById("form");
  form.onsubmit = (e) => {
    e.preventDefault();
    const emailAddr = document.getElementById("InputEmail");
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailAddr.value)) {
      alert("working");
      const email=this.document.getElementById("InputEmail")
      const name=this.document.getElementById("nameInput")
      sendQuery(email.value,name.value);
    } else {
      alert("You have entered an invalid email address!");
    }
  };
});
