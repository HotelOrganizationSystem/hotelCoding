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
    <script src="../static/common/room/roomList.js"></script>
    <script src="../views/static/common/vue.min.js"></script>

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">会员选择</label>
        <div class="layui-input-block" style="z-index: 99999">
            <select name="memid" id="memid" lay-verify="" lay-search >
                <c:forEach var="mems" items="${mem}">
                    <option value="${mems.memid}">${mems.memname}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">房间类型</label>
        <div class="layui-input-block" style="z-index: 9999">
            <select  id="rtypeid" lay-verify="" lay-filter="roomt" lay-search >
                <c:forEach var="roomt" items="${roomT}">
                    <option value="${roomt.rtypeid}">${roomt.rtypename}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">房间选择</label>
        <div class="layui-input-block"style="z-index: 6666">
            <select name="roomid" id="roomid" lay-verify="" lay-filter="roomid" lay-search >
                <c:forEach var="rooms" items="${room}">
                    <option value="${rooms.roomid}">${rooms.roomNum}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单状态</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="radio" name="orderstate" title="未入住" value="未入住" checked="">
            <input type="radio" name="orderstate" title="已入住" value="已入住">
            <input type="radio" name="orderstate" title="已退房" value="已退房">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">下单时间</label>
        <div class="layui-input-inline">
            <input type="text" id="ordertime" name="ordertime" autocomplete="off" placeholder="年份" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">人数</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="personnum" id="personnum" autocomplete="off" lay-verType="tips"
                   lay-verify="required|number"
                   placeholder="请输入预计人数"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入住时间</label>
        <div class="layui-input-inline">
            <input type="text" id="intime" name="intime" autocomplete="off" placeholder="年份" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">离开时间</label>
        <div class="layui-input-inline">
            <input type="text" id="outtime" name="outtime" autocomplete="off" placeholder="年份" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">定金</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="deposit" id="deposit" autocomplete="off" lay-verType="tips"
                   lay-verify="required|number"
                   placeholder="请输入定金"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">价格</label><!-- 长输入框 -->
        <div class="layui-input-block">
            <input type="text" name="oprice" id="oprice" autocomplete="off" lay-verType="tips"
                   lay-verify="required|number"
                   placeholder="请输入订单价格"
                   class="layui-input">
            <button type="submit" id="cal_price" class="layui-btn" lay-submit="" lay-filter="cal_price">计算价格</button>
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
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#ordertime'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#intime'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#outtime'
            , type: 'datetime'
        });

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
            , roomNum: [
                /^([1-6][0][1-9])|([1-6][1][0-9])$/,
                '房间号要为101-619,后面不能超过19哦'
            ]
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
                url: getContextPath() + '/order/add',
                type: 'POST',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(data.field),
                async: false,
                dataType: 'json',
                success: function (d) {
                    if (d > 0) { // 插入成功关闭当前窗口
                        layer.alert('插入成功！！！！');
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.location.reload();
                    } else { // 插入失败
                        parent.layer.alert('插入失败,请重新输入');
                    }
                }
            });
            return false;
        });

        form.on('select(roomid)', function () {
            $.ajax({
                url: getContextPath() + '/order/personnumCheck',
                type: 'get',
                data: {
                    "personnum": $('#personnum').val(),
                    "roomid": $('#roomid').val()
                },
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',

                success: function (data) {
                    if (data == false) {
                        $('#personnum').css('background-color', 'red');
                        $('#personnum').val('');
                    } else {
                        $('#personnum').css('background-color', 'green');
                    }
                }
            });
        });
        form.on('select(roomt)', function () {
            $.ajax({
                url: getContextPath() + '/order/getRTypeOfRoom',
                type: 'get',
                async:false,
                data: {
                    "rtypeid": $('#rtypeid').val()
                },
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',
                success: function (data) {
                    var  options ='';
                    $.each(data,function (i,item){
                       var roomid= item.roomid;
                       var room_num=item.roomNum;
                      options+="<option value='" +roomid+
                           "'>" +room_num+
                           "</option>";
                    });
                    $('#roomid').html(options);
                    form.render('select');

                }
            });
        });

        form.on('submit(cal_price)', function (data) {
            $.ajax({
                url: getContextPath() + '/order/getPrice',
                type: 'get',
                data: {
                    "rtypeid": $('#rtypeid').val(),
                    "memid": $('#memid').val()
                },
                async:false,
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',
                success: function (data) {
                    $('#oprice').val(data);
                }
            });
            return false;
        });
    });
    $('#personnum').change(function () {
        $.ajax({
            url: getContextPath() + '/order/personnumCheck',
            type: 'get',
            data: {
                "personnum": $('#personnum').val(),
                "roomid": $('#roomid').val()
            },
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            success: function (data) {
                if (data == false) {
                    $('#personnum').css('background-color', 'red');
                    $('#personnum').val('');
                    $('#personnum').placeholder();
                } else {
                    $('#personnum').css('background-color', 'green');
                }
            }
        });
    });

</script>

</body>
</html>