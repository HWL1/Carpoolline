<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><html>
<body>
<h2>Hello World!</h2>

 <!-- <form action="Passenger/Insert.carpoolline" method="post">
<input type="text" name="username" id="username">
<input type="text" name="userpassword" id="userpassword">
<input type="text" name="usertel" id="usertel">
<input type="submit" ></form>-->

 <!--  <form action="Passenger_login/Submit.carpoolline" method="post">
<input type="text" name="userName" id="userName">
<input type="text" name="userPassword" id="userPassword">

<input type="submit" ></form>-->

 <!-- <form action="Driver/Insert.carpoolline" method="post">
<input type="text" name="driverName" id="driverName">
<input type="text" name="driverPassword" id="driverPassword">
<input type="text" name="driverTel" id="driverTel">
<input type="text" name="carType" id="carType">
<input type="text" name="carCard" id="carCard">
<input type="text" name="driverType" id="driverType">

<input type="text" name="smalldep" id="smalldep">
<input type="text" name="smalldes" id="smalldes">
<input type="text" name="waitingTimeType" id="waitingTimeType">
<input type="text" name="price" id="price">


  <input type="submit" ></form>--> 
  
 
<!-- 
<form action="Driver/Login.carpoolline" method="post">
<input type="text" name="driverName" id="driverName">
<input type="text" name="driverPassword" id="driverPassword">

<input type="submit" ></form>-->


<!--   <form action="Driver_release/Insert.carpoolline" method="post">
<input type="text" name="departure" id="departure">
<input type="text" name="destination" id="destination">
<input type="text" name="startTime" id="startTime">
<input type="text" name="endTime" id="endTime">
<input type="text" name="personNumber" id="personNumber">
<input type="text" name="state" id="state">
<input type="submit" ></form>-->

<!--  <form action="Driver_release/Update.carpoolline" method="post">
<input type="text" name="departure" id="departure">
<input type="text" name="destination" id="destination">
<input type="text" name="startTime" id="startTime">
<input type="text" name="endTime" id="endTime">
<input type="text" name="state" id="state">
<input type="text" name="waitingId" id="waitingId">
<input type="submit" ></form>--> 
<!-- 
<form action="Driver_release/Select.carpoolline" method="post">
id1<input type="text" name="driverId" id="driverId"><br>
driverName<input type="text" name="driverName" id="driverName"><br>
driverPassword<input type="text" name="driverPassword" id="driverPassword">
<input type="submit" ></form> -->
<!--  
<form action="Driver_release/Delete.carpoolline" method="post">
waitingId<input type="text" name="waitingId" id="waitingId"><br>
driverName<input type="text" name="driverName" id="driverName"><br>
driverPassword<input type="text" name="driverPassword" id="driverPassword">
<input type="submit" ></form>-->



<!-- user查询待拼车表 -->

<!--  <form action="Query/From.carpoolline" method="post">
<input type="text" name="userName" id="userName">
<input type="text" name="userPassword" id="userPassword">
<input type="text" name="startTime" id="startTime">
<input type="text" name="departure" id="departure">
<input type="text" name="destination" id="destination">
<input type="text" name="waitingTimeType" id="waitingTimeType">
<input type="text" name="stateClock" id="stateClock">

<input type="submit" ></form>--> 

<!-- user取消拼车表并等待拼车 -->

 <!-- <form action="Query/Remove.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>

userPassword<input type="text" name="userPassword" id="userPassword"><br>
personNumber<input type="text" name="personNumber" id="personNumber"><br>
waitingId<input type="text" name="waitingId" id="waitingId">
<input type="submit" ></form>-->

<!-- user拼车表并等待拼车 -->

 <!--拼车<form action="Query/Carpoolling.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userName2<input type="text" name="userName2" id="userName2"><br>
userName3<input type="text" name="userName3" id="userName3"><br>
userName4<input type="text" name="userName4" id="userName4"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>
waitingId<input type="text" name="waitingId" id="waitingId">
personNumber<input type="text" name="personNumber" id="personNumber">
<input type="submit" ></form> -->


<!--  user付款 -->
<!-- <form action="Payment/Refund.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>
waitingId<input type="text" name="waitingId" id="waitingId">
userId<input type="text" name="userId" id="userId">
<input type="submit" ></form>-->


 
<!-- 
<form action="Driver/Search.carpoolline" method="post">
driverId<input type="text" name="driverId" id="driverId">


<input type="submit" ></form>-->

<!-- 
<form action="Query/State.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>
waitingId<input type="text" name="waitingId" id="waitingId">

<input type="submit" ></form>-->


<!-- 查找订单
<form action="Order/Select_userId.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>
userId<input type="text" name="userId" id="userId">

<input type="submit" ></form>-->
<!-- 查找订单-->
<form action="Query/Waitingcar.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>

<input type="submit" ></form>
<!--  user付款-->
<!-- user付款 <form action="Payment/Payment.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>
waitingId<input type="text" name="waitingId" id="waitingId">
userId<input type="text" name="userId" id="userId">
<input type="submit" ></form> 

 user取消付款 <form action="Payment/Refund.carpoolline" method="post">
userName<input type="text" name="userName" id="userName"><br>
userPassword<input type="text" name="userPassword" id="userPassword"><br>
waitingId<input type="text" name="waitingId" id="waitingId">
userId<input type="text" name="userId" id="userId">
<input type="submit" ></form>-->

</body>
</html>
