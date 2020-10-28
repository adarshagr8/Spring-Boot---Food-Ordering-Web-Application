<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Madhuram Payment Gateway</title>
</head>
<body>
Processing your transaction...

<form action="https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage?mid=${mid}&orderId=${orderId}" method="post" id="form">
	<input type="hidden" name="mid" value="${mid}">
    <input type="hidden" name="orderId" value="${orderId}">
    <input type="hidden" name="txnToken" value="${txnToken}">
</form>

<script>
function myFunction() {
  document.getElementById("form").submit(); // Click on the checkbox
}
setTimeout(myFunction, 1500);
</script>
</body>
</html>