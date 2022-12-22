<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <link href="Css/attendofteacher.css" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        .intro{
            margin-left: 2%;
        }
    </style>
    <body>
        <div class="title">FPT University Academic Portal</div>
        <div class="home"><a href="HomePage.html">Home</a> | <strong>View Schedule</strong></div>
        <div class="function">Take attendance</div>
        <div class="intro">
            Take attendance for Group:<strong> ${requestScope.ses.group.name}</strong><br/>
            <form action="AttendanceController" method="get">
            Your Lesson:
                <select name="id">
                    <c:forEach items="${requestScope.listses}" var="lecture">
                    <option value="${lecture.getId()}">${lecture.getId()} - ${lecture.getDate()}</option>
                    </c:forEach>
                    <input type="submit" value="Attend">
                </select>
            </form>
            Room: <strong>${requestScope.ses.room.name}</strong><br/>
            Date: <strong>${requestScope.ses.date}</strong><br>
            Time: <strong>${requestScope.ses.timeslot.description}</strong><br/>
            Attended: <span style="color: red;"> 
                <c:if test="${requestScope.ses.attendated eq true}">
                    <strong>Yes</strong>
                </c:if>
                <c:if test="${requestScope.ses.attendated eq false}">
                    <strong>No</strong>
                </c:if>
            </span>
        </div>
        <form action="AttendanceController" method="POST">
            <input type="hidden" name="sesid" value="${param.id}"/>
            <table class="main">
                <tr>
                    <th>STT</th>
                    <th>COURSE</th>
                    <th>MSSV</th>
                    <th>NAME</th>
                    <th>PRESENT</th>
                    <th>ABSENT</th>
                    <th>DOCUMENT</th>
                    <th>IMAGE</th>
                </tr>
                <c:forEach items="${requestScope.ses.attendances}" var="attend" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <td>${attend.session.group.subject.name}</td>
                        <td>${attend.student.id}
                            <input type="hidden" name="stdid" value="${attend.student.id}"/>
                        </td>
                        <td>${attend.student.name}</td>
                        <td><input type="radio" 
                                   <c:if test="${attend.present eq true}">
                                       checked="checked"
                                   </c:if> 
                                   name="present${attend.student.id}" value="present"></td>
                        <td><input type="radio" 
                                   <c:if test="${attend.present eq false}">
                                       checked="checked"
                                   </c:if> 
                                   name="present${attend.student.id}" value="absent"></td>
                        <td><input type="text" name="description${attend.student.id}" value="${attend.description}"></td>
                        <td class="hyperlink"><a href="#">Show image</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="button_save">
                <input type="submit" value="Save">
            </div>
        </form>
    </body>
</html>
