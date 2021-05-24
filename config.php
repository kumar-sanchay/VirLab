<?php

    $servername = 'host = 127.0.0.1';
    $port = 'port = 5432';
    $credentials = 'user = codeeditor_admin password = admin123';
    $dbname = 'dbname = codeeditor';

    $conn = pg_connect("$servername $port $dbname $credentials");

    if(!$conn){
        die('Connection not established');
    }

    print_r("Connection established successfully");

?>