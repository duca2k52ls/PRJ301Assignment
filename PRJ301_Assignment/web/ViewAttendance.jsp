<%-- 
    Document   : ViewAttendance
    Created on : Nov 1, 2022, 11:16:37 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <link rel="stylesheet" href="Css/viewattendance.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <div class="title">FPT University Academic Portal</div>
       <div class="home"><a href="HomePage.html">Home</a> | <strong>View Schedule</strong></div>
    <div class="function">View attendance</div>
    <div class="row">
        <div class="CTC">
            <div class="col-md-3" style="display:flex ;">
                <div class="campus1">
                    <div id="cam1">
                        <table class="campus">
                            <tr>
                                <th>CAMPUS/PROGRAM</th>
                            </tr>
                            <tr>
                                <td><strong>FU-HL</strong></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="term1">
                    <div id="tem1">
                        <table class="term">
                            <tr>
                                <th>TERM</th>
                            </tr>
                            <tr>
                                <td>Summer2017</td>
                            </tr>
                            <tr>
                                <td>Fall2017</td>
                            </tr>
                            <tr>
                                <td>Spring2017</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="course1">
                    <div id="cou1">
                        <table class="course">
                            <tr>
                                <th>COURSE</th>
                            </tr>
                            <tr>
                                <td>SE1633-PRJ301</td>
                            </tr>
                            <tr>
                                <td>SE1633-PRN211</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="view1">
            <div class="col-md-8" id="vie1">
                <table class="view">
                    <tr>
                        <th>NO.</th>
                        <th>DATE</th>
                        <th>SLOT</th>
                        <th>ROOM</th>
                        <th>LECTURE</th>
                        <th>GROUP NAME</th>
                        <th>ATTENDANCE STATUS</th>
                        <th>LECTURE'S COMMENT</th>
                    </tr>
                    
                    <tr>
                        <td>1</td>
                        <td>Monday 05/09/2022</td>
                        <td>4</td>
                        <td>DE-C201</td>
                        <td>ThangPD10</td>
                        <td>SE1633-PRJ301</td>
                        <td>
                            <font color="green">Present</font>
                        </td>
                        <td></td>
                    </tr>
                    
                </table>
            </div>
        </div>
    </div>
    </body>
</html>
