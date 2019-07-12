<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    
    <script src="js/jquery-1.12.4.min.js"></script>
    
    <script>
        $(function () {
            //发送ajax请求，加载所有省份数据
            $.get("getProvince",null,function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                //1.获取select
                var province = $("#province");
                //2.遍历json数组
                $(data).each(function () {
                    //3.创建<option>
                    var option = "<option value='"+this.id+"'>"+this.name+"</option>";

                    //4.调用select的append追加option
                    province.append(option);
                });
            });
            $("#province").change(function () {
                //获取省份被选中的id值
                alert($(this).val());
                $.get("getCity",{id:$(this).val()},function (data) {
                    //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                    //1.获取select
                    var city = $("#city");
                    city.empty();
                    city.append("<option>--请选择市份--</option>");
                    //2.遍历json数组
                    $(data).each(function () {
                        //3.创建<option>
                        var option = "<option value='"+this.id+"'>"+this.name+"</option>";
                        //4.调用select的append追加option
                        city.append(option);
                    });
                });
            });

            $("#city").change(function () {
                //获取省份被选中的id值
                alert($(this).val());
                $.get("getCounty",{id:$(this).val()},function (data) {
                    //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                    //1.获取select
                    var county = $("#county");
                    //2.遍历json数组
                    $(data).each(function () {
                        //3.创建<option>
                        var option = "<option value='"+this.id+"'>"+this.name+"</option>";
                        //4.调用select的append追加option
                        county.append(option);
                    });
                });
            });
        });
        
    </script>
    
</head>
<body>
    <form id="form" >
        <select id="province">
            <option>--请选择省份--</option>
        </select>
        <select id="city" >
            <option>--请选择市份--</option>
        </select>
        <select id="county">
            <option>--请选择县份--</option>
        </select>
    </form>

</body>
</html>