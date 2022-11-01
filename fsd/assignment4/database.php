<?php

$dbhost = "";
$dbuser = "";
$dbpass = "";
$db = "fsdAssignment";

if($_COOKIE["Type"]==="Insert"){
insertRecord($_GET["prn"],$_GET["name"],$_GET["rollNo"]);

}else if($_COOKIE["Type"]==="Update"){
updateRecord($_GET["prn"],$_GET["name"],$_GET["rollNo"]);	

}elseif($_COOKIE["Type"]==="Delete"){
deleteRecord($_GET["prn"]);
}else if($_COOKIE["Type"]==="Show"){
showRecords();
}
echo "Operation Performed";
function insertRecord($prn, $name, $rollNo)
{
    global $dbhost, $dbuser, $dbpass, $db;
    try {
        $conn = new mysqli($dbhost, $dbuser, $dbpass, $db) or throw_ex("error");
        $sql = "insert into userDatabase values($prn,'$name','$rollNo');";
        try {
            $conn->query($sql) or throw_ex(mysqli_error($conn));
            $result = "Inserted Successfully!!";
        } catch (Exception $e) {
            $result="error while inserting in database!";
        }
        echo '<script type ="text/JavaScript">';
        echo "alert('$result')";
        echo '</script>';
        CloseCon($conn);
    } catch (Exception $e) {
        echo '<script type ="text/JavaScript">';
        echo 'alert("error while accessing database!")';
        echo '</script>';
    }
}
function deleteRecord($prn)
{
    global $dbhost, $dbuser, $dbpass, $db;
    try {
        $conn = new mysqli($dbhost, $dbuser, $dbpass, $db) or throw_ex("error");
        $sql = "delete from userDatabase where prn=$prn";
        try {
            $conn->query($sql) or throw_ex(mysqli_error($conn));
            $result="Record deleted!";
        } catch (Exception $e) {
            $result="error while deleting from database!";
        }
        echo '<script type ="text/JavaScript">';
        echo "alert('$result')";
        echo '</script>';
        CloseCon($conn);
    } catch (Exception $e) {
        echo '<script type ="text/JavaScript">';
        echo 'alert("error while accessing database!")';
        echo '</script>';
    }
}
function updateRecord($prn, $name, $rollNo)
{

    global $dbhost, $dbuser, $dbpass, $db;
    try {
        $conn = new mysqli($dbhost, $dbuser, $dbpass, $db) or throw_ex("error");
        $sql = "update userDatabase set name='$name', rollNo='$rollNo' where prn=$prn";
        try {
            $conn->query($sql) or throw_ex(mysqli_error($conn));
            $result = "Updated Record Successfully!";
        } catch (Exception $e) {
           $result="Error While Updating the record!";
        }
        echo '<script type ="text/JavaScript">';
        echo "alert('$result')";
        echo '</script>';
        CloseCon($conn);
    } catch (Exception $e) {
        echo '<script type ="text/JavaScript">';
        echo 'alert("error while accessing database!")';
        echo '</script>';
    }

    return '$result';
}
function showRecords()
{
    global $dbhost, $dbuser, $dbpass, $db;
    try {
        $conn = new mysqli($dbhost, $dbuser, $dbpass, $db) or throw_ex("error");
        $sql = "select * from userDatabase";
        $result = $conn->query($sql) or throw_ex(mysqli_error($conn));
        if ($result->num_rows > 0) {
            $show = "";
            while ($row = $result->fetch_assoc()) {
                $show .= "prn: " . $row["prn"] . " - Name: " . $row["name"] . " -RollNo:" . $row["rollNo"] . "</br>";
            }
            echo $show;
        } else {
            echo "No Records!";
        }

        CloseCon($conn);
    } catch (Exception $e) {
        echo '<script type ="text/JavaScript">';
        echo 'alert("error while accessing database!")';
        echo '</script>';
    }
}
function throw_ex($er)
{
    throw new Exception($er);
}


function CloseCon($conn)
{
    $conn->close();
}
?>











