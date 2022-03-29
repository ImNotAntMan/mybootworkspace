<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript"> 
	function ajaxTest(){ 
		$.ajax({ url: "/member/ajaxtest", 
				type: "GET", 
				success : function(data){ 
					$("#count").text(data) 
					console.log("성공") 
				}, 
				error : function(){alert("통신실패")}
			})
	} 
</script>
</head> 
	<body> 
		<button type="button" onclick="ajaxTest()">click</button>
		<label id="count">0</label> 
	</body>
</html>