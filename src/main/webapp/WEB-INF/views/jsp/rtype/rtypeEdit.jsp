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
<form class="layui-form" id="form">
  <input hidden name="rtypeid" id="rtypeid" value="${rtype.rtypeid}">
  <div class="layui-form-item">
    <label class="layui-form-label">类型名称</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="rtypename" id="rtypename" autocomplete="off" lay-verType="tips"
             lay-verify="required"
             placeholder="请输入房间类型名"
             class="layui-input" value="${rtype.rtypename}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">价格</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="price" id="price" autocomplete="off" lay-verType="tips"
             lay-verify="required|number" placeholder="请输入价格"
             class="layui-input" value="${rtype.price}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">居住人数</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="livenum" id="livenum" autocomplete="off" lay-verType="tips" lay-verify="required"
             placeholder="请输入员工姓名"
             class="layui-input" value="${rtype.livenum}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">设备信息</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="facility" id="facility" autocomplete="off" lay-verType="tips"
             lay-verify="required"
             placeholder="请输入设备信息"
             class="layui-input" value="${rtype.facility}" }>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">定金</label><!-- 长输入框 -->
    <div class="layui-input-block">
      <input type="text" name="resmoney" id="resmoney" autocomplete="off" lay-verType="tips"
             lay-verify="required|number" placeholder="请输入需要的定金"
             class="layui-input" value="${rtype.resmoney}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">供应宽带</label>
    <div class="layui-input-inline">
      <input type="radio" name="isnet" value="0" title="有" <c:if test="${rtype.isnet == 0}">checked=""</c:if> >
      <input type="radio" name="isnet" value="1" title="无" <c:if test="${rtype.isnet == 1}">checked=""</c:if> >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">供应早餐</label>
    <div class="layui-input-inline">
      <input type="radio" name="isfoot" value="0" title="有" <c:if test="${rtype.isfoot == 0}">checked=""</c:if> >
      <input type="radio" name="isfoot" value="1" title="无" <c:if test="${rtype.isfoot == 1}">checked=""</c:if> >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">房间图片</label>
    <div class="layui-input-inline">
      <input type="file" name="file" autocomplete="off" lay-verType="tips">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="remark" id="remark" lay-verType="tips" lay-verify="required"
                          class="layui-textarea">${rtype.remark}</textarea>
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
      elem: '#date'
      ,type: 'datetime'
    });

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

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

    //监听指定开关
    form.on('switch(switchTest)', function(data){
      layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
        offset: '6px'
      });
      layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });

    //监听提交
    form.on('submit(demo2)', function(data){
      var formData = new FormData($( "#form" )[0]);
      $.ajax({
        url: '<%=request.getContextPath()%>/rtype/edit',
        type: 'post',
        cache: false,
        data: formData,
        enctype:"multipart/form-data",
        processData: false,
        async: false,
        contentType: false,
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
      return true;
    });

    //表单取值
    layui.$('#LAY-component-form-getval').on('click', function(){
      var data = form.val('example');
      alert(JSON.stringify(data));
    });
  });
</script>

</body>
</html>