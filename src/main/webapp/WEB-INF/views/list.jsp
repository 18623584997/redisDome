<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/9
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery-1.11.1.min.js">

</script>
<script src="/js/dragslot.js"></script>
<script type="application/javascript">
    $(function () {

        $.ajax({
            url:'/list',
            type:'post',
            dataType:'json',
            success:function (data) {
                for(var i in data){
                    $("#table").append("<tr><td>");
                    $("#table").append(data[i].id+"</td>");
                    $("#table").append("<td>"+data[i].name+"</td>");
                    $("#table").append("</tr>")
                }

            }
        })


        $('#contaiter').dragslot({
            dropCallback: function(el){
                //alert(el);
            }
        });




    })

    function add() {
        $("#form").submit();
    }


</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="contaiter" style="width: 800px;height: 800px; border: 1px solid red">
    <ul>
        <li>dafsdfa</li>
    </ul>

    <ul>
        <li>daf333sdfa</li>
    </ul>

    <ul>
        <li>daf333sdfa</li>
    </ul>



</div>
<table id="table">


</table>
<form action="/add" method="post" id="form">

    名称  <input name="name">
    数量  <input name="count">
    <input type="button" onclick="add()"  value="add">
</form>




</body>
</html>
