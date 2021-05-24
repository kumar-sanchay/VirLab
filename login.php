<?php

    include('./queries.php');

    if(isset($_POST)){

        $email = $_POST['email'];
        $password = $_POST['password'];

        $result = pg_execute($conn, "login_query", array($email, $password));
        
        header('Content-Type:application/json');

        if(!$result){
            echo json_encode(['status'=>400, 'msg'=>'Server Error. Check logs.']);
            exit;
        }

        $total_rows = pg_num_rows($result);
        
        if($total_rows==1){
            echo json_encode(['status'=>200, 'msg'=>"Success"]);

        }else{
            echo json_encode(['status'=>403, 'msg'=>'User not found.']);
        }
    }

?>