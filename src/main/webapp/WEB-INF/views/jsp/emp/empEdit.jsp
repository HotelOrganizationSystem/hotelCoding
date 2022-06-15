<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  <input hidden name="empid" id="empid" value="${emp.empid}">
  <input hidden name="usersid" id="usersid" value="${emp.usersid}">
  <div class="layui-form-item">
    <label class="layui-form-label">账号</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="account" id="account" autocomplete="off" lay-verType="tips"
             lay-verify="account"
             placeholder="请输入账号"
             class="layui-input" value="${emp.account}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="password" id="password" autocomplete="off" lay-verType="tips"
             lay-verify="required" placeholder="请输入密码"
             class="layui-input" value="${emp.password}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">名字</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="empname" id="empname" autocomplete="off" lay-verType="tips" lay-verify="required"
             placeholder="请输入员工姓名"
             class="layui-input" value="${emp.empname}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">部门选择</label>
    <div class="layui-input-block" style="z-index: 9999">
      <select name="interest" id="depid" name="depid" lay-verify="" lay-search >
        <option value="${emp.depid}" selected>${emp.depname}</option>
        <c:forEach var="deps" items="${dep}" >/
          <c:if test="${emp.depid != deps.depid}">
            <option value="${deps.depid}">${deps.depname}</option>
          </c:if>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">角色选择</label>
    <div class="layui-input-block">
      <select name="interest" id="roleid" name="roleid" lay-filter="aihao">
        <option value="${emp.roleid}" selected>${emp.rolename}</option>
        <c:forEach var="roles" items="${role}">
          <c:if test="${emp.roleid != roles.roleid}">
            <option value="${roles.roleid}">${roles.rolename}</option>
          </c:if>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item" pane="">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input type="radio" name="empsex" value="男" title="男" <c:if test="${emp.empsex.equals('男')}">checked=""</c:if> >
      <input type="radio" name="empsex" value="女" title="女" <c:if test="${emp.empsex.equals('女')}">checked=""</c:if> >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">年龄</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="empage" id="empage" autocomplete="off" lay-verType="tips"
             lay-verify="required|number"
             placeholder="请输入年龄"
             class="layui-input" value="${emp.empage}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">电话</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="empphone" id="empphone" autocomplete="off" lay-verType="tips"
             lay-verify="required|phone|number" placeholder="请输入电话"
             class="layui-input" value="${emp.empphone}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">工龄</label>
    <div class="layui-input-inline">
      <input type="text" name="empwage" id="empwage" lay-verType="tips" lay-verify="required|number"
             placeholder="请输入工龄" autocomplete="off"
             class="layui-input" value="${emp.empwage}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">工资</label>
    <div class="layui-input-inline">
      <input type="text" name="emppay" id="emppay" lay-verType="tips" lay-verify="required|number"
             placeholder="请输入每月工资" autocomplete="off"
             class="layui-input" value="${emp.emppay}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="empemail" id="empemail" autocomplete="off" lay-verType="tips"
             lay-verify="required|email" placeholder="请输入邮箱"
             class="layui-input" value="${emp.empemail}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">入职时间</label>
    <div class="layui-input-inline">
      <input type="text" id="etime" name="etime" autocomplete="off" placeholder="年份" class="layui-input"
             value="<fmt:formatDate value="${emp.etime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="remark" id="remark" lay-verType="tips" lay-verify="required"
                          class="layui-textarea">${emp.remark}</textarea>
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
  layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

    //日期
    laydate.render({
      elem: '#etime'
      ,type: 'datetime',
    });


    //自定义验证规则
    form.verify({
      account: function (value) {
        if(value.length == 0){
          return '账号不能为空哦'
        }else if(value.length < 4) {
          return '账号长度太少了';
        }
      },
      title: function(value){
        if(value.length < 5){
          return '标题至少得5个字符啊';
        }
      }
      ,pass: [
        /^[\S]{6,12}$/
        ,'密码必须6到12位，且不能出现空格'
      ]
      ,content: function(value){
        layedit.sync(editIndex);
      }
    });


    //监听提交
    form.on('submit(demo2)', function(data){
      $.ajax({
        url: '<%=request.getContextPath()%>/emp/edit',
        type: 'post',
        data: JSON.stringify(data.field),
        contentType: 'application/json;charset=utf-8'
        ,async: false,
        dataType: 'json',
        success: function (data) {
          if(data == true) { // 修改成功关闭当前窗口
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            parent.location.reload();
          }else { // 修改失败
            layer.alert('修改失败,请重新输入');
          }
        }
      });
      return true;
    });

  });
  </script>

</body>
</html>