<%-- 
    Document   : HomePage
    Created on : Nov 9, 2022, 4:38:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/attendofteacher.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${account.role.isRole() eq true}">
            <div class="title">FPT University Academic Portal</div>
            <div class="home"><a href="HomePage.html">Home</a> | <strong>View Schedule</strong></div>
            <div class="function">Welcome ${account.getUsername()}</div>
            <a href="TimetableController?stdid=${account.students.get(0).id}">Timetable</a>
            <a href="ViewAttendanceController?stdid=${account.students.get(0).id}&subid=1&sem=FALL&year=2022">View Attendance</a>
        </c:if>
        <c:if test="${account.role.isRole() eq false}">
            <div class="title">FPT University Academic Portal</div>
            <div class="home"><a href="HomePage.html">Home</a> | <strong>View Schedule</strong></div>
            <div class="function">Welcome ${account.getUsername()}</div>
            <a href="AttendanceController?id=1">Attendance</a>
        </c:if>


    </body>
</html>
