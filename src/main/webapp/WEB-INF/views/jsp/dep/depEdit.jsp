<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../static/common/layui/css/layui.css" media="all">
  <script src="../static/common/jquery-3.3.1.min.js"></script>

  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%--<form class="layui-form layui-form-pane">--%>
<input hidden name="depid" id="depid" value="${dep.depid}">
<div class="layui-form-item">
  <label class="layui-form-label">部门</label><!-- 长输入框 -->
  <div class="layui-input-block">
    <input type="text" name="depName" id="depName" autocomplete="off" value="${dep.depname}" required
           placeholder="请输入部门"
           class="layui-input">
  </div>
</div>
<div class="layui-form-item layui-form-text">
  <label class="layui-form-label">备注</label>
  <div class="layui-input-block">
    <textarea placeholder="请输入内容" name="remark" id="remark"  required class="layui-textarea">${dep.remark}</textarea>
  </div>
</div>
<div class="layui-form-item" style="text-align: center">
  <button class="layui-btn" id="btn"  lay-filter="demo2">提交</button>
</div>
<script src="../static/common/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
  $(function () {
    $('#btn').click(function () {
      $.ajax({
        url: '<%=request.getContextPath()%>/dep/edit',
        data: {
          "depid":$('#depid').val(),
          "depName":$('#depName').val(),
          "remark":$('#remark').val()
          },
        dataType: 'json',
        success: function (data) {
          if(data == true) { // 修改成功关闭当前窗口
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            parent.location.reload();
          }else { // 修改失败
            parent.layer.alert('修改失败,请重新输入');
          }
        }
      });
    });
  });
</script>

</body>
</html>