<?php


//for connecting with database


function OpenCon()
{
    $dbhost = "";
    $dbuser = "";
    $dbpass = "";
    $db = "fsdAssignment";

    try{
        $conn = new mysqli($dbhost, $dbuser, $dbpass, $db)or throw_ex("Wrong Information");
        return $conn;
    }catch(Exception $e){
        return $e;
    }
}

//for inserting records in mysql
function insertRecord($conn,$prn,$name,$rollNo)
{
    $sql = "insert into userDatabase values($prn,'$name','$rollNo');";
    try {
        $result = $conn->query($sql) or throw_ex(mysqli_error($conn));
    } catch (Exception $e) {
        return $e;
    }
    return $result;
}

//for deleting records from table
function deleteValue($conn,$prn)
{
    $sql = "delete from userDatabase where prn=$prn";
    try {
        $result = $conn->query($sql) or throw_ex(mysqli_error($conn));
    } catch (Exception $e) {
        return $e;
    }
    return $result;
}

// for updating records in table
function updateRecord($conn,$prn,$name,$rollNo)
{
    $sql = "update userDatabase set name=$name, rollNo=$rollNo where prn=$prn";
    try {
        $result = $conn->query($sql) or throw_ex(mysqli_error($conn));
    } catch (Exception $e) {
        return $e;
    }
    return $result;
}

//for exception handling 
function throw_ex($er)
{
    throw new Exception($er);
}

//for closing connection with mysql
function CloseCon($conn)
{
    $conn->close();
}
?>



