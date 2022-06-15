<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 22278
  Date: 2021-07-19
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="../layui/css/layui.css" media="all">
        <script src="../static/common/jquery-3.3.1.min.js"></script>
        <script src="../layui/layui.js"></script>
    </head>
    <body>

    <div class="layui-container">
        <form class="layui-form" action="">

            <div class="layui-form-item">
                <div class="layui-form-item">
                    <label class="layui-form-label">尊敬的 ${memT.memtype}</label>

                    <div class="layui-input-block">
                        <input type="text" name="title" readonly placeholder="请输入标题" value="${member.memname}"
                               autocomplete="off" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">您选择的房间是</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" readonly placeholder="请输入标题" value="${rtypename}"
                               autocomplete="off" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">入住人数为</label>
                    <div class="layui-input-block liveNum_">
                        <select name="liveNum" lay-verify="" lay-search>
                            <c:forEach var="s" begin="1" end="${livenum}">
                                <option value="${s}">${s}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">您的折扣为</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" readonly placeholder="请输入标题"
                               value="${memT.discount}" autocomplete="off" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">支付金额</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" readonly placeholder="请输入标题" value="${price}" autocomplete="off"
                               class="layui-input"/>
                    </div>
                </div>
            </div>

        </form>
    </div>

    <script>
        //Demo
        layui.use('form', function () {
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function (data) {
                layer.msg(JSON.stringify(data.field));

                return false;
            });
        });
    </script>

    </body>
</html>
