<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sum.com/jsp/jstl/core" prefix="c"%>
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
     <h1>index page</h1>
     ${data}<br>
     ${greet}
     <c:if test="${loginUser!=null}"> <!-- if문 사용 -->
          <div>
               ${loginUser.id} (${loginUser.name})
               <a href="/logout">로그아웃</a>
          </div>
     </c:if>
     <div>
     </div>
</body>
</html>