layui.use('table', function () {
    var table = layui.table;
    //第一个实例
    table.render({
        elem: '#demo'
        , height: 550
        , url: getContextPath() + '/mem/list' //数据接口
        , page: true //开启分页
        ,toolbar: '#toolbar'
        , cols: [[ //表头
            // 重要:  数据格式
            {type: 'checkbox', fixed: 'left',width: "60", align: "center"}
            , {field: 'memid', hide:true, title: 'ID',align:'center', sort: true, fixed: 'left',width: "10%"}
            , {field: 'memTypeId', hide:true, title: '会员类型Id',align:'center',sort: true, width: "10%"}
            , {field: 'usersid', hide:true, title: '用户ID',align:'center',sort: true,width: "10%"}
            , {field: 'account',  title: '账号',align:'center',width: "20%",}
            , {field: 'password', hide:true, title: '密码',align:'center',sort: true,width: "10%"}
            , {field: 'memname', title: '昵称',align:'center',width: "10%"}
            , {field: 'memtype', title: '会员类型',align:'center', width: "10%"}
            , {field: 'memsex', title: '性别',align:'center', width: "5%",sort: true}
            , {field: 'idcard', title: '身份证',align:'center', width: "15%"}
            , {field: 'memint', title: '积分',align:'center', width: "10%" ,sort:true}
            , {field: 'email', title: '邮箱',align:'center', width: "20%"}
            , {field: 'phone', title: '电话',align:'center', width: "20%"}
            , {field: 'userstate', title: '用户状态',align:'center', width: "15%", sort: true}
            , {field: 'regisdate', title: '注册时间',align:'center', width: "20%", sort: true}
            , {field: 'roleid', hide:true, title: '角色ID',align:'center', width: "10%"}
            , {field: 'rolename', title: '角色',align:'center', width: "20%"}
            , {field: 'remark', title: '备注',align:'center', width: "30%"}
            , {fixed: 'right',title: '操作', width: "15%", align: 'center', toolbar: '#barDemo'}
            //这里的toolbar值是模板元素的选择器
        ]]
    });
    table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if (layEvent === 'del') { //删除
            layer.confirm('真的删除行么', function (index) {
                //向服务端发送删除指令
                $.ajax({
                    url: getContextPath() + '/mem/delete',
                    type: 'get',
                    data: {
                        "usersid": data.usersid
                    },
                    contentType: 'application/json;charset=utf-8',
                    dataType: 'json',
                    success: function (d) {
                        if (d == false) {
                            layer.alert("delete fail"); // 删除失败
                        } else {
                            layer.alert("delete success"); // 删除成功
                            obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                            layer.close(index);
                        }
                    }
                })
            });
        } else if (layEvent === 'edit') { //编辑
            //do something
            x_admin_show("编辑会员信息",getContextPath() + "/mem/gotoEdit?memid="+data.memid,650,400);
            //同步更新缓存对应的值
        } else if (layEvent === 'LAYTABLE_TIPS') {
            layer.alert('Hi，头部工具栏扩展的右侧图标。');
        }
    });

    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'mult-del':
                if(data.length === 0){
                    layer.msg('请至少选择一行');
                } else {
                    layer.confirm('真的删除选择行吗', function(index){
                        var result=[];
                        for(var i in data){
                            result.push((data[i]['usersid']));
                        }
                        //关闭弹窗
                        // layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            url: getContextPath() + "/mem/deleteAll",
                            type:"post",
                            data: result.toString(),
                            dataType: 'json',
                            contentType: 'application/json;charset=utf-8',
                            success:function(data){
                                if(data == false) {
                                    layer.alert("delete fail")
                                }else {
                                    layer.alert("delete success")
                                    table.reload('demo', {
                                        url: getContextPath() + '/mem/list'//重载数据的接口,一般和上方初始化render中的url相同
                                        ,where: {} //无则不填,设定异步数据接口的额外的get参数
                                    });
                                }
                            }
                        })
                    });
                }
                break;
            case 'mult-add':
                x_admin_show("添加会员",getContextPath() + "/mem/gotoAdd",650,400);
                break;
        };
    });
});

function x_admin_show(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=800;
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
    });
}

//工具条事件

function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}