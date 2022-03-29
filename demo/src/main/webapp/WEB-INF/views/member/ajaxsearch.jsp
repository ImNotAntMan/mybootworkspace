<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript"> 
	function ajaxTest(){ 
		$.ajax({ url: "/member/ajaxsearch", 
				type: "POST", 
				data: {
		        	m_id:$("#id").val()
		        },
				success : function(data){ 
					$("#m_id").text(data.m_id),
					$("#m_name").text(data.m_name),
					$("#m_rdate").text(data.m_rdate),
					$("#m_udate").text(data.m_udate)
					
					console.log("성공") 
				}, 
				error : function(){alert("없는 회원입니다.")}
			})
	} 
</script>
</head> 
	<body> 
		<input type="text" id="id" value="lion">
		<button type="button" onclick="ajaxTest()">click</button>
		<label id="m_id"></label> 
		<label id="m_name"></label> 
		<label id="m_rdate"></label> 
		<label id="m_udate"></label> 
	</body>
</html>