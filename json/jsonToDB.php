<?php

// $sql = ``INSERT INTO `vacance` (`description`, `start_date`, `end_date`, `zones`, `annee_scolaire`) recordsS ('``.$records['description'].``', '``.$records['start_date'].``', '``.$records['end_date'].``', '``.$records['zones'].``', '``.$records['annee_scolaire'].``');``;

// $conn = mysqli_connect('localhost','root','','calendrier');

// if ($conn->query($sql) === TRUE) {
//     echo ``New record created successfully``;
// } else {
//     echo ``Error: `` . $sql . ``<br>`` . $conn->error;
// }

// $filename = ``dataVacance.json``;

// $data = file_get_contents($filename);

// $array = json_decode($data,true);
// // echo ``<pre>``;
// // print_r($array);
// // echo``</pre>``;
// foreach ($array as $records){
//     $query = ``INSERT INTO `vacance` (`description`, `start_date`, `end_date`, `zones`, `annee_scolaire`) recordsS ('``.$records['description'].``', '``.$records['start_date'].``', '``.$records['end_date'].``', '``.$records['zones'].``', '``.$records['annee_scolaire'].``');``;

//     mysqli_query($con, $query);

// }
// echo``DATA inserted Successfully``;


// Connect to the MySQL database

$conn= new mysqli(`localhost`, `root`,``, `calendrier`);

// Check the connection
if ($conn->connect_error) {
    die(`Connection failed: ` . $conn->connect_error);
}

// Read the contents of the JSON file
$json = file_get_contents(`dataVacance.json`);

// Decode the JSON into an array
$data = json_decode($json, true);

// Loop through the data and insert each record into the MySQL table
foreach ($data as $record) {
    $columnDescription = $record['description'];
    $columnStartDate = $record['start_date'];
    $columnEndDate = $record['end_date'];
    $columnLocation = $record['location'];
    $columnZones = $record['zones'];
    $columnAnneeScolaire = $record['annee_scolaire'];

    $sql ="INSERT INTO `vacance` (`description`, `start_date`, `end_date`, `location`, `zones`, `annee_scolaire`) VALUE ('$columnDescription', '$columnStartDate','$columnEndDate','$columnLocation', '$columnZones', '$columnAnneeScolaire');";

    if ($conn->query($sql) === TRUE) {
        echo `New record created successfully`;
    } else {
        echo `Error: ` . $sql . `<br>` . $conn->error;
    }
}

// Close the connection
$conn->close();

?>
