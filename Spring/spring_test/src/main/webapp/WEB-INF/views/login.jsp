<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Document</title>
     <script>
          const msg = '${loginMessage}';
          if(msg != ''){
               alert(msg);
          }
     </script>
</head>
<body>
     <h1>로그인</h1>
     <form action="/login" method="post">
          <input type="text" name="id"><br>
          <input type="password" name="pwd"><br>
          <button>로그인</button>
     </form>
</body>
</html>