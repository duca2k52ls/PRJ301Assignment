<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Css/timetable.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <div class="title">FPT University Academic Portal</div>
        <div class="home"><a href="HomePage.html">Home</a> | <strong>View Schedule</strong></div>
        <div class="function">Activities</div>
        <div class="chuthich1"><strong>Note</strong>: These activities do not include extra-curriculum activities, such as
            club activities ...<br>

            Chú thích: Các ho?t ??ng trong b?ng d??i không bao g?m ho?t ??ng ngo?i khóa, ví d? nh? ho?t ??ng câu l?c b?
            ...<br>
            <br>
            Các phòng b?t ??u b?ng AL thu?c tòa nhà Alpha. VD: AL...<br>
            Các phòng b?t ??u b?ng BE thu?c tòa nhà Beta. VD: BE,..<br>
            Các phòng b?t ??u b?ng G thu?c tòa nhà Gamma. VD: G201,...<br>
            Các phòng t?p b?ng ??u b?ng R thu?c khu v?c sân t?p Vovinam.<br>
            Các phòng b?t ??u b?ng DE thu?c tòa nhà Delta. VD: DE,..<br>
            Little UK (LUK) thu?c t?ng 5 tòa nhà Delta
        </div>
        <table class="timetable">
            <tr>
                <th rowspan="2" class="year">
                    <input type="hidden" name="stdid" value="${param.stdid}"/>
                    From: <input type="date" name="from" value="${requestScope.from}"/>
                    <br>
                    To  : <input type="date" name="to" value="${requestScope.to}"/>
                    <input class="btn-success" type="submit" value="View"/> 
                </th>
                <c:forEach items="${requestScope.dates}" var="d">
                    <th>${helper.getDayNameofWeek(d)}</th>
                    </c:forEach>
            </tr>
            <tr class="day">
            <tr>
                <c:forEach items="${requestScope.dates}" var="d">
                    <th>
                <fmt:formatDate value="${d}" pattern="dd/MM"/>
            </th>
        </c:forEach>
    </tr>    </tr>
<tr>
    <td>Slot 1</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
</tr>
<tr>
    <td>Slot 2</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>
        <p>SE1633-PRJ301</p>
        <p>at DE-416</p>
        <p>Sonnt</p>
        <div class="label label-success">
            (9:10-10:40)
        </div>
    </td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
</tr>

</table>
<div>
    <strong>More note / Chú thích thêm:</strong>
    <ul>
        <li>(<font color="green">attended</font>): Student had attended this activity / Sinh viên ?ã tham gia ho?t ??ng này</li>
        <li>(<font color="red">absent</font>): Student had NOT attended this activity / Sinh viên ?ã v?ng m?t bu?i này</li>
        <li>(-): no data was given / ch?a có d? li?u</li>
    </ul>
</div>
</body>
</html>
