<%--
  Created by IntelliJ IDEA.
  User: wsdevotion
  Date: 15/10/24
  Time: 下午6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Javascript goes in the document HEAD -->
<script type="text/javascript">
    function altRows(id) {
        if (document.getElementsByTagName) {

            var table = document.getElementById(id);
            var rows = table.getElementsByTagName("tr");

            for (i = 0; i < rows.length; i++) {
                if (i % 2 == 0) {
                    rows[i].className = "evenrowcolor";
                } else {
                    rows[i].className = "oddrowcolor";
                }
            }
        }
    }

    window.onload = function () {
        altRows('alternatecolor');
    }
</script>


<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
    input {
        width: 90px;
    }

    table.altrowstable {
        font-family: verdana, arial, sans-serif;
        font-size: 9px;
        /*width: 10px;*/
        color: #333333;
        border-width: 1px;
        border-color: #e3e4e5;
        border-collapse: collapse;

    }

    table.altrowstable th {
        width: 9px;
        border-width: 1px;
        padding: 3px;
        border-style: solid;
        border-color: #a9c6c9;
    }

    table.altrowstable td {
        border-width: 1px;
        width: 9px;
        padding: 3px;
        border-style: solid;
        border-color: #a9c6c9;
    }

    .oddrowcolor {
        background-color: #d4e3e5;
    }

    .evenrowcolor {
        background-color: #c3dde0;
    }
</style>


<!-- Table goes in the document BODY -->
<h1 align="center">信息设定</h1>
<div align="center">
<table class="altrowstable" id="alternatecolor">
<tr>
    <th>类型</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
    <th>Info</th>
</tr>

<%for(int i=0; i<13; i++){%>
    <tr>
    <tr>Type_1</td>
    <td><input type="text" value="${a[0].getType_0}"></td>
    <td><input type="text" value="${a.type_1}"></td>
    <td><input type="text" value="${a.type_2}"></td>
    <td><input type="text" value="${a.type_3}"></td>
    <td><input type="text" value="${a.type_4}"></td>
    <td><input type="text" value="${a.type_5}"></td>
    <td><input type="text" value="${a.type_6}"></td>
    <td><input type="text" value="${a.type_7}"></td>
    <td><input type="text" value="${a.type_8}"></td>
    <td><input type="text" value="${a.type_9}"></td>
    <td><input type="text" value="${a.type_10}"></td>
    <td><input type="text" value="${a.type_11}"></td>
    <td><input type="text" value="${a.type_12}"></td>
    <td><input type="text" value="${a.type_13}"></td>
    <td><input type="text" value="${a.type_14}"></td>
    <td><input type="text" value="${a.type_15}"></td>
    <td><input type="text" value="${a.type_16}"></td>
    <td><input type="text" value="${a.type_17}"></td>
    <td><input type="text" value="${a.type_18}"></td>
    <td><input type="text" value="${a.type_19}"></td>

    </tr>
    <%}%>
    </table>
    </div>

    <!-- The table code can be found here: http://www.textfixer/resources/css-tables.php#css-table03 -->


