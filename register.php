<?php

    include('queries.php');

    if(isset($_POST)){

        $first_name = $_POST['first_name'];
        
        $last_name = array_key_exists('last_name', $_POST) ? $_POST['last_name'] : '';

        $email = $_POST['email'];

        $user_password = $_POST['password'];

        $result = pg_execute($conn, "register_query", array($first_name, $last_name, $email, $user_password));

        header('Content-Type:application/json');

        if(!$result){
            echo json_encode(['status'=>404, 'msg'=>'Server Error. Check logs.']);
            exit;
        }

        echo json_encode(['status'=>200, 'msg'=>'Success.']);
    }

?>