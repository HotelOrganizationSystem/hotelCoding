// Demo
layui.use('form', function () {
    var form = layui.form;

    form.on('select()', function (data) {
        $(".sub_btn").click();
    });

    form.on('submit(formDemo)', function (data) {
        // console.log(data.elem)  // 被执行事件的元素DOM对象，一般为button对象
        // console.log(data.form)  // 被执行提交的form对象，一般在存在form标签时才会返回
        // console.log(data.field) // 当前容器的全部表单字段，名值对形式：{name: value}

        var da = data.field;

        $.ajax({
            url: getContextPath() + "/book/book_choose",
            type: "get",
            data: da,
            dataType: 'json',
            success: function (data) {
                init(data);
            }
        });

        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
});

// 基本事件
$(function () {
    $(".res_btn").click(function () {
        $.ajax({
            url: getContextPath() + "/book/book_choose",
            type: "get",
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                console.log(data);
                init(data)
            }
        });
    });

    $("body").delegate(".payment_btn", "click", function () {
        let rtypes = $(this).parents(".room_info").get(0).rtypes;

        $.ajax({
            url: getContextPath() + "/book/payment",
            type: "get",
            data: {
                price: rtypes.price
            },
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                layer.open({
                    title: ["确认支付", "font-weight: bold"],
                    skin: 'demo-class',
                    type: 1,
                    area: ['700px', '400px'],
                    offset: '150px', // 只定义top坐标，水平保持居中
                    content: show_info(data, rtypes),
                    btn: ['支付', '取消'],
                    yes: function (index) {
                        let num = $(".number_num").val();

                        if (num === "" || num === null) {
                            layer.tips('必填项不能为空', '.number_num');

                            return false;
                        }

                        layer.close(index);

                        $.ajax({
                            url: getContextPath() + "/book/order",
                            data: {
                                rtypeid: rtypes.rtypeid,
                                personnum: num,
                                price: data.price
                            },
                            type: "get",
                            dataType: 'json',
                            contentType: 'application/json;charset=utf-8',
                            success: function (data) {
                                layer.close(index);
                                $(".sub_btn").click();

                                if (data === 1) {
                                    layer.msg("支付成功");
                                } else {
                                    layer.msg("支付失败");
                                }
                            }
                        });
                    }
                });
            }
        });
    });

    $(".layui-nav a").click(function () {
        $(this).css({
            color: "#1E9FFF"
        })

        $(this).parents(".layui-nav-item").siblings().find("a").css({
            color: "#333"
        })

        return false;
    })

    $.ajax({
        url: getContextPath() + "/book/book_choose",
        type: "get",
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            console.log(data);
            init(data)
        }
    });

    layer.closeAll('loading'); //关闭加载层

    $("body").delegate(".detail_btn", "click", function () {
        $(this).parents(".room_info").find(".room_detail").fadeToggle(200);
    });
});

function show_info(data, rtypes) {
    let choose;

    for (let i = 1; i <= rtypes.livenum; i++) {
        choose += "<option style='padding: 3px;height: 15px;' value=\"" + i + "\">" + i + "</option>"
    }

    let $item = "<form class=\"layui-form\" style=\"background-color: #ffffff;padding: 10px 10px 20px 20px;\" action=\"\">\n" +
        "\n" +
        "            <div class=\"layui-form-item\">\n" +
        "                <div class=\"layui-form-item\">\n" +
        "                    <label class=\"layui-form-label\">尊敬的 " + data.memT.memtype + "</label>\n" +
        "                    <div class=\"layui-input-block\">\n" +
        "                        <input type=\"text\" name=\"title\" readonly placeholder=\"请输入标题\" value=\"" + data.member.memname + "\"\n" +
        "                               autocomplete=\"off\" class=\"layui-input\"/>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"layui-form-item\">\n" +
        "                    <label class=\"layui-form-label\">您选择的房间是</label>\n" +
        "                    <div class=\"layui-input-block\">\n" +
        "                        <input type=\"text\" name=\"title\" readonly placeholder=\"请输入标题\" value=\"" + rtypes.rtypename + "\"\n" +
        "                               autocomplete=\"off\" class=\"layui-input\"/>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"layui-form-item\">\n" +
        "                    <label class=\"layui-form-label\">入住人数为</label>\n" +
        "                    <div class=\"layui-input-inline\">\n" +
        "                      <select class='number_num' style='display:inline-block;width: 100%;height: 35px;border: 1px solid rgba(0, 0, 0, 0.1);padding: 6px'>\n" +
        "                        <option value=\"\">请选择</option>\n" +
        choose +
        "                       </select>" +
        "                    </div>\n" +
        "                </div>" +
        "                <div class=\"layui-form-item\">\n" +
        "                    <label class=\"layui-form-label\">您的折扣为</label>\n" +
        "                    <div class=\"layui-input-block\">\n" +
        "                        <input type=\"text\" name=\"title\" readonly placeholder=\"请输入标题\"\n" +
        "                               value=\"" + data.memT.discount + "\" autocomplete=\"off\" class=\"layui-input\"/>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"layui-form-item\">\n" +
        "                    <label class=\"layui-form-label\">支付金额</label>\n" +
        "                    <div class=\"layui-input-block\">\n" +
        "                        <input type=\"text\" name=\"title\" readonly placeholder=\"请输入标题\" value=\"" + data.price + "\" autocomplete=\"off\"\n" +
        "                               class=\"layui-input\"/>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "\n" +
        "        </form>";

    return $item;
}

//工具条事件
function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    return pathName.substr(0, index + 1);
}

function init(arr) {
    $(".room_info").remove();
    $.each(arr, function (index, value) {
        let $items = creat_item(value);
        $(".layui-container").append($items);
    })
}

function creat_item(data) {
    let bed;
    if (data.rtypename.indexOf("双床") > -1) {
        bed = "2张大床"
    } else if (data.rtypename.indexOf("三床") > -1) {
        bed = "3张大床"
    } else {
        bed = "1张大床"
    }

    let food;
    if (data.isfoot === 0) {
        food = "有早餐"
    } else if (data.isfoot === 1) {
        food = "没早餐"
    }

    let btn;
    if (data.remainNum >= 1) {
        btn = "<button type=\"button\" class=\"layui-btn layui-btn-lg payment_btn\">立即下单</button>";
    } else {
        btn = "<button type=\"button\" class=\"layui-btn layui-btn-lg layui-btn-disabled\">立即下单</button>";
    }

    let $item = $("<div class=\"room_info _selected\">\n" +
        "                            <h2 class=\"layui-colla-title\" style=\"height: 150px;\">\n" +
        "                                <div class=\"content\">\n" +
        "                                    <div class=\"content_left\">\n" +
        "                                        <img src=\"https://seopic.699pic.com/photo/50042/0407.jpg_wh1200.jpg\" alt=\"加载失败\">\n" +
        "                                        <span>" + data.rtypename + "</span>\n" +
        "                                    </div>\n" +
        "                                    <div class=\"content_right\">\n" +
        "                                        <ul>\n" +
        "                                            <li>\n" +
        "                                                <div>\n" +
        "                                                    <i class=\"layui-icon layui-icon-friends\"></i>\n" +
        "                                                    |\n" +
        "                                                    <i class=\"layui-icon layui-icon-friends\"></i>\n" +
        "                                                    <br> <br>\n" +
        "\n" +
        "                                                    <span class=\"detail_btn\"><a href=\"javascript:void(0);\">详情</a><i\n" +
        "                                                            class=\"layui-icon layui-icon-triangle-d\"></i></span>\n" +
        "\n" +
        "                                                </div>\n" +
        "                                            </li>\n" +
        "                                            <li>\n" +
        "                                                <div>\n" +
        "                                                    <span>\n" +
        "                                                        <a href=\"javascript:void(0);\">" + bed + "</a>\n" +
        "                                                    </span>\n" +
        "                                                    <br>\n" +
        "                                                    <span>\n" +
        "                                                        <a href=\"javascript:void(0);\">" + food + "</a>\n" +
        "                                                    </span>\n" +
        "                                                </div>\n" +
        "                                            </li>\n" +
        "                                            <li>\n" +
        "                                                <div>\n" +
        "                                                    <span><a href=\"javascript:void(0);\">禁烟</a></span>\n" +
        "                                                    <br>\n" +
        "                                                    <span><a href=\"javascript:void(0);\">有窗</a></span>\n" +
        "                                                </div>\n" +
        "                                            </li>\n" +
        "                                            <li>\n" +
        "                                                <div>\n" +
        "                                                    <span><a\n" +
        "                                                            href=\"javascript:void(0);\">剩下房间：" + data.remainNum + " 间</a></span>\n" +
        "                                                    <br>\n" +
        "                                                    <span><a href=\"javascript:void(0);\">限住：" + data.livenum + " 人</a></span>\n" +
        "                                                </div>\n" +
        "                                            </li>\n" +
        "                                            <li>\n" +
        "                                                <div>\n" +
        "                                    <span style=\"background-color: #fff0e5;border: 2px solid #fff0e5;\"><a\n" +
        "                                            href=\"javascript:void(0);\" style=\"color: #ff6f00;\">闪住</a></span>\n" +
        "                                                    <br>\n" +
        "                                                    <span style=\"background-color: #fff0e5;border: 2px solid #fff0e5;\"><a\n" +
        "                                                            href=\"javascript:void(0);\"\n" +
        "                                                            style=\"color: #ff6f00;\">礼</a></span>\n" +
        "                                                </div>\n" +
        "                                            </li>\n" +
        "                                        </ul>\n" +
        "                                        <div class=\"content_book\">\n" +
        "                                            <div class=\"book_title\">\n" +
        "                                                <span>￥ " + data.price + "</span>\n" +
        "                                            </div>\n" +
        "                                            <div class=\"book_btn\">" + btn + "</div>\n" +
        "                                        </div>\n" +
        "                                    </div>\n" +
        "                                </div>\n" +
        "                            </h2>\n" +
        "                            <div class=\"room_detail\">\n" +
        "                                <ul>\n" +
        "                                    <li>\n" +
        "                                        <h4>基本信息</h4>\n" +
        "                                        <p><i class=\"layui-icon layui-icon-senior\"> " + data.rtypename + "</i></p>\n" +
        "                                        <p>\n" +
        "                                           <a href=\"javascript:void(0);\"> " + bed + "</a>\n" +
        "                                        </p>\n" +
        "                                    </li>\n" +
        "                                    <li>\n" +
        "                                        <h4>全部设施</h4>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 牙膏</i>\n" +
        "                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 牙刷</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 洗发水</i>\n" +
        "                                            &nbsp;&nbsp;&nbsp;&nbsp;\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 香皂</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 沐浴露</i>\n" +
        "                                            &nbsp;&nbsp;&nbsp;&nbsp;\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 梳子</i>\n" +
        "                                        </p>\n" +
        "                                    </li>\n" +
        "                                    <li>\n" +
        "                                        <h4>便利设施</h4>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 客房WIFI</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 空调（免费）</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 洗衣用品</i>\n" +
        "                                        </p>\n" +
        "                                    </li>\n" +
        "                                    <li>\n" +
        "                                        <h4>浴室</h4>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 独立淋浴间</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 24小时热水</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 吹风机</i>\n" +
        "                                        </p>\n" +
        "                                    </li>\n" +
        "                                    <li>\n" +
        "                                        <h4>食品</h4>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 瓶装水</i>\n" +
        "                                        </p>\n" +
        "                                        <p>\n" +
        "                                            <i class=\"layui-icon layui-icon-ok-circle\"> 电热水壶</i>\n" +
        "                                        </p>\n" +
        "                                    </li>\n" +
        "                                </ul>\n" +
        "                            </div>\n" +
        "                        </div>");

    $item.get(0).rtypes = data;

    return $item;
}