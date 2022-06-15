<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="title" id="account" autocomplete="off" lay-verType="tips"
                   lay-verify="account"
                   placeholder="请输入账号"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="depName" id="password" autocomplete="off" lay-verType="tips"
                   lay-verify="required" placeholder="请输入密码"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">名字</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="name" id="name" autocomplete="off" lay-verType="tips" lay-verify="required"
                   placeholder="请输入员工姓名"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门选择</label>
        <div class="layui-input-block" style="z-index: 9999">
            <select name="interest" id="dep" lay-verify="" lay-search>
                <c:forEach var="dep" items="${dep}">
                    <option value="${dep.depid}">${dep.depname}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色选择</label>
        <div class="layui-input-block">
            <select name="interest" id="role" lay-filter="aihao">
                <c:forEach var="roles" items="${role}">
                    <option value="${roles.roleid}"
                            <c:if test="${roles.rolename.equals('员工')}"> selected</c:if> >
                            ${roles.rolename}
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="age" id="age" autocomplete="off" lay-verType="tips"
                   lay-verify="required|number"
                   placeholder="请输入年龄"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="phone" id="phone" autocomplete="off" lay-verType="tips"
                   lay-verify="required|phone|number" placeholder="请输入电话"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工龄</label>
        <div class="layui-input-inline">
            <input type="text" name="wage" id="wage" lay-verType="tips" lay-verify="required|number"
                   placeholder="请输入工龄" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工资</label>
        <div class="layui-input-inline">
            <input type="text" name="pay" id="pay" lay-verType="tips" lay-verify="required|number"
                   placeholder="请输入工龄" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="email" id="email" autocomplete="off" lay-verType="tips"
                   lay-verify="required|email" placeholder="请输入邮箱"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入职时间</label>
        <div class="layui-input-inline">
            <input type="text" id="date" autocomplete="off" placeholder="年份" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="remark" id="remark" lay-verType="tips" lay-verify="required"
                          class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item" style="text-align: center">
        <button type="submit" class="layui-btn" id="btn" lay-submit="" lay-filter="demo2">提交</button>
    </div>
</form>
<script src="../static/common/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    // layui.use('laydate', function () {
    //     var laydate = layui.laydate;
    //
    //     //执行一个laydate实例
    //     laydate.render({
    //         elem: '#yearCode' //指定元素
    //         , type: 'datetime'
    //     });
    // });
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

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo2)', function (data) {
            $.ajax({
                url: '<%=request.getContextPath()%>/emp/add',
                type: 'post',
                data: {
                    "account": $('#account').val(),
                    "password": $('#password').val(),
                    "empName": $('#name').val(),
                    "depId": $('#dep').val(),
                    "roleId": $('#role').val(),
                    "sex": $('[name=sex]:checked').val(),
                    "age": $('#age').val(),
                    "phone": $('#phone').val(),
                    "wage": $('#wage').val(),
                    "pay": $('#pay').val(),
                    "email": $('#email').val(),
                    "eTime": $('#date').val(),
                    "remark": $('#remark').val()
                }, async: false,
                dataType: 'json',
                success: function (data) {
                    if (data != null) { // 插入成功关闭当前窗口
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

        //表单赋值
        layui.$('#LAY-component-form-setval').on('click', function () {
            form.val('example', {
                "username": "贤心" // "name": "value"
                , "password": "123456"
                , "interest": 1
                , "like[write]": true //复选框选中状态
                , "close": true //开关状态
                , "sex": "女"
                , "desc": "我爱 layui"
            });
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function () {
            var data = form.val('example');
            alert(JSON.stringify(data));
        });
    });
</script>

</body>
</html>