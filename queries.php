<?php

    include('config.php');

    $login_query = pg_prepare($conn, "login_query", "SELECT email FROM users WHERE email=$1 AND password=crypt($2, password) and active=true");
    $registration_query = pg_prepare($conn, "register_query", "INSERT INTO users(first_name, last_name, email, password) values($1, $2, $3, crypt($4, gen_salt('bf')))");

?>