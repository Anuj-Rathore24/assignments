<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="index.css" />
    <title>CRUD</title>
    <script>
      function insertFunction() {
        document.cookie = "Type=Insert";
        const container = document.getElementById("mainContainer");
        container.innerHTML = "";
        const form = document.createElement("form");
        form.action = "db_connection.php";
        form.method = "GET";

        const nameInput = document.createElement("input");
        nameInput.className = "inputWidget";
        nameInput.name = "name";
        nameInput.placeholder = "Enter Name";

        const prn = document.createElement("input");
        prn.className = "inputWidget";
        prn.name = "prn";
        prn.placeholder = "Enter prn";

        const rollNo = document.createElement("input");
        rollNo.className = "inputWidget";
        rollNo.name = "rollNo";
        rollNo.placeholder = "Enter Roll No";

        const button = document.createElement("button");
        button.innerText = "Submit";
        button.type = "submit";
        button.className = "SubmitButton";

        form.append(nameInput);
        form.append(prn);
        form.append(rollNo);
        form.append(button);

        container.append(form);
      }
      function deleteFunction() {
        document.cookie = "Type=Delete";
        const container = document.getElementById("mainContainer");
        container.innerHTML = "";
        const form = document.createElement("form");
        form.action = "db_connection.php";
        form.method = "GET";

        const prn = document.createElement("input");
        prn.className = "inputWidget";
        prn.name = "prn";
        prn.placeholder = "Enter prn";


        const button = document.createElement("button");
        button.innerText = "Submit";
        button.type = "submit";
        button.className = "SubmitButton";

        form.append(prn);
        form.append(button);

        container.append(form);
      }
      function updateFunction() {
        document.cookie = "Type=Update";
        const container = document.getElementById("mainContainer");
        container.innerHTML = "";
        const form = document.createElement("form");
        form.action = "db_connection.php";
        form.method = "GET";

        const nameInput = document.createElement("input");
        nameInput.className = "inputWidget";
        nameInput.name = "name";
        nameInput.placeholder = "Enter Name";

        const prn = document.createElement("input");
        prn.className = "inputWidget";
        prn.name = "prn";
        prn.placeholder = "Enter prn";

        const rollNo = document.createElement("input");
        rollNo.className = "inputWidget";
        rollNo.name = "rollNo";
        rollNo.placeholder = "Enter Roll No";

        const button = document.createElement("button");
        button.innerText = "Submit";
        button.type = "submit";
        button.className = "SubmitButton";

        form.append(nameInput);
        form.append(prn);
        form.append(rollNo);
        form.append(button);

        container.append(form);
      }
      function showFunction() {
        document.cookie = "Type=Show";
        const container = document.getElementById("mainContainer");
        container.innerHTML = "";
        const form = document.createElement("form");
        form.action = "db_connection.php";
        form.method = "GET";

        const button = document.createElement("button");
        button.innerText = "Submit";
        button.type = "submit";
        button.className = "SubmitButton";


        form.append(button);

        container.append(form);
      }
    </script>
  </head>
  <body>
    <div id="rootContainer">
      <div id="controlPanel">
        <div class="optionsBox">
          <button onclick="insertFunction()">Insert a Record</button>
        </div>
        <div class="optionsBox">
          <button onclick="deleteFunction()">Delete a Record</button>
        </div>
        <div class="optionsBox">
          <button onclick="updateFunction()">Update a Record</button>
        </div>
        <div class="optionsBox">
          <button onclick="showFunction()">Show All Records</button>
        </div>
      </div>
      <div id="mainContainer"></div>
    </div>
  </body>
</html>
