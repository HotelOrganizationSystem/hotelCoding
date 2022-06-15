<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../views/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="../static/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../views/static/admin/css/style.css">
    <script src="../static/common/jquery-3.3.1.min.js"></script>
    <script src="../views/static/common/vue.min.js"></script>

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form class="layui-form layui-form-pane" >
    <input type="hidden" name="memid" value="${mem.memid}" />
    <input type="hidden" name="usersid" value="${mem.usersid}"/>

    <div class="layui-form-item">
        <label class="layui-form-label">账号</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="account" id="account" autocomplete="off"  lay-verType="tips"
                   lay-verify="account"
                   placeholder="请输入账号"
                   value="${mem.account}"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="password" id="password" autocomplete="off" lay-verType="tips"
                   lay-verify="required" placeholder="请输入密码" value="${mem.password}"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">名字</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="memname" id="memname" autocomplete="off"
                   value="${mem.memname}"
                   lay-verType="tips" lay-verify="required"
                   placeholder="请输入员工姓名"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" overflow="visible">
        <label class="layui-form-label">类型选择</label>
        <div class="layui-input-block" style="z-index: 9999">
            <select  id="memTypeId" name="memTypeId"  lay-verify="" lay-search overflow="visible">
                <option value="${mem.memTypeId}">${mem.memtype}</option>
                <c:forEach var="memts" items="${memT}">
                    <c:if test="${memts.memTypeId!=mem.memTypeId}">
                        <option value="${memts.memTypeId}">${memts.memtype}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">角色选择</label>
        <div class="layui-input-inline">
            <select  id="role"  name="roleid" lay-filter="aihao" >
                <option value="${mem.roleid}" selected>${mem.rolename}</option>
                <c:forEach var="roles" items="${role}">
                    <c:if test="${mem.roleid != roles.roleid}">
                        <option value="${roles.roleid}">${roles.rolename}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item" pane>
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="memsex" value="男"  title="男" <c:if test="${mem.memsex.equals('男')}">checked</c:if> >
            <input type="radio" name="memsex" value="女" title="女" <c:if test="${mem.memsex.equals('女')}">checked</c:if> >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="idcard" id="idcard" autocomplete="off" lay-verType="tips"
                   lay-verify="required|identify"
                   placeholder="请输入身份证"
                   value="${mem.idcard}"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">积分</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="memint" id="memint" autocomplete="off" lay-verType="tips"
                   lay-verify="required|number"
                   value="${mem.memint}"
                   placeholder="请输入积分"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="email" id="email" autocomplete="off" lay-verType="tips"
                   lay-verify="required|email" placeholder="请输入邮箱"
                   value="${mem.email}"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="phone" id="phone" autocomplete="off" lay-verType="tips"
                   lay-verify="required|phone|number" placeholder="请输入电话"
                   value="${mem.phone}"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户状态</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="userstate" id="userstate" autocomplete="off" lay-verType="tips"
                   lay-verify="required" placeholder="请输入状态"
                   value="${mem.userstate}"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">注册时间</label>
        <div class="layui-input-inline">
            <input type="text" id="date"  name="regisdate" value="<fmt:formatDate value="${mem.regisdate}" pattern="yyyy-MM-dd HH:mm:ss"/>" autocomplete="off" placeholder="注册时间" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="remark" style="width: 645px;"  id="remark" lay-verType="tips" lay-verify="required"
                          class="layui-textarea">${mem.remark}</textarea>
        </div>
    </div>

    <div class="layui-form-item" style="text-align: center">
        <button type="submit" class="layui-btn" id="btn" lay-submit="" lay-filter="demo2">提交</button>
    </div>
</form>
<script src="../static/common/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>

    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
            , type: 'datetime'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            account: function (value) {
                if (value.length == 0) {
                    return '账号不能为空哦'
                } else if (value.length < 4) {
                    return '账号长度太少了';
                }
            },
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });



        //监听提交
        form.on('submit(demo2)', function (data) {
            $.ajax({
                url: '<%=request.getContextPath()%>/mem/edit',
                type: 'post',
                data: JSON.stringify(data.field),
                contentType:'application/json',
                async: false,
                dataType: 'json',
                success: function (data) {
                    if (data ==true) { // 插入成功关闭当前窗口
                        layer.alert('插入成功！！！！');
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.location.reload();
                    } else { // 插入失败
                        parent.layer.alert('插入失败,请重新输入');
                    }
                }
            });
            return true;
        });


    });
</script>

</body>
</html>