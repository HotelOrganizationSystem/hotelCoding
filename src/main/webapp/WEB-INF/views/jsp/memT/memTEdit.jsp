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
<form class="layui-form" id="form" action="">
  <input type="hidden" name="memTypeId" value="${memT.memTypeId}">
  <div class="layui-form-item">
    <label class="layui-form-label">会员类型</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="memtype" id="memTName" autocomplete="off" placeholder="请输入会员类型名"
             class="layui-input" lay-verify="require" lay-verType="tips" value="${memT.memtype}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">折扣</label><!-- 长输入框 -->
    <div class="layui-input-inline">
      <input type="text" name="discount" id="discount" autocomplete="off" placeholder="请输入折扣 [0.1,1.0]"
             class="layui-input" lay-verify="require|number|discount" lay-verType="tips" value="${memT.discount}">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="remark" id="remark" ay-verify="require" lay-verType="tips"
                      class="layui-textarea">${memT.remark}</textarea>
    </div>
  </div>
  <div class="layui-form-item" style="text-align: center">
    <button type="submit" class="layui-btn" id="btn" lay-submit="" lay-filter="demo1">提交</button>
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


    //自定义验证规则
    form.verify({
      discount:[
        /^([0]\.[1-9])|([1]\.[0])$/,
        '折扣范围在[0.1,1.0]，保留1位小数'
      ]
    });


    //监听提交
    form.on('submit(demo1)', function (data) {
      $.ajax({
        url: '<%=request.getContextPath()%>/memT/edit',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(data.field),
        dataType: 'json',
        async:false,
        success: function (data2) {
          if (data2 ==true) { // 修改成功关闭当前窗口
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            parent.location.reload();
            return true
          } else { // 修改失败
            parent.layer.alert('修改失败,请重试');
            return false;
          }
        }
      });

    });

  });

</script>

</body>
</html>