const express = require('express')
const mysql = require('mysql')
let cors = require("cors");
const app = express()
const port = 3000
app.use(cors());

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

//sql connection
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'Extreme$69',
  database: 'testingconnectivety'
})

app.post('/', (req, res) => {
    connection.connect()
    const data=req.body;
    console.log(data);
    connection.query(`insert into userTable values('${data.email}','${data.name}')`, (err, rows, fields) => {
      if (err) throw err
    
      console.log('The solution is: ', rows)
    })
    
    connection.end()
    
})

app.listen(port, () => {
  console.log(`listening on port ${port}`)
})