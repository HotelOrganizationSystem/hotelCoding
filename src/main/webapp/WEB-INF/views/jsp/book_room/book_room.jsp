<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="javax.sound.midi.Soundbank" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>房间列表</title>

        <link rel="stylesheet" href="../views/static/common/layui/css/layui.css">
        <link rel="stylesheet" href="../static/admin/css/bookRoom.css" media="all">

        <script src="../static/common/jquery-3.3.1.min.js"></script>
        <script src="../views/static/common/vue.min.js"></script>

        <script src="../static/common/layui/layui.js"></script>

        <script>
            layui.use('layer', function(){
                var layer = layui.layer;

                layer.load();
            });
        </script>
    </head>
    <body style="background-color: #f0f2f5">

    <div id="app1">
        <header>
            <div style="float:left;"><img src="../views/static/admin/img/tubiao.png" width="152" height="55"/></div>
            <div style="float: right">
                <i class="layui-icon  layui-anim layui-anim-rotate layui-anim-loop"
                   style="font-size: 30px; color: #969baa;">&#xe614;</i>&nbsp; &nbsp; &nbsp;
            </div>
        </header>

        <div class="main" id="app">
            <div class="left">
                <ul class="cl">
                    <!--顶级分类-->
                    <li v-for="vo,index in menu" :class="{hidden:vo.hidden}">
                        <a href="javascript:;" :class="{active:vo.active}" @click="onActive(index)">
                            <i class="layui-icon" v-html="vo.icon"></i>
                            <span v-text="vo.name"></span>
                            <i class="layui-icon arrow" v-show="vo.url.length==0">&#xe61a;</i> <i v-show="vo.active"
                                                                                                  class="layui-icon active">&#xe623;</i>
                        </a>
                        <!--子级分类-->
                        <div v-for="vo2,index2 in vo.list">
                            <a href="javascript:;" :class="{active:vo2.active}" @click="onActive(index,index2)"
                               v-text="vo2.name"></a>
                            <i v-show="vo2.active" class="layui-icon active">&#xe623;</i>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="right">
                <div class="layui-container">
                    <ul class="layui-nav" lay-filter="" style="background-color: #ffffff">
                        <li class="layui-nav-item layui-this"><a href="" style="color: #1E9FFF;">房间</a></li>
                        <li class="layui-nav-item"><a href="" style="color: #333;">政策</a></li>
                    </ul>

                    <br>

                    <!-- 查询条件 -->
                    <form class="layui-form" style="background-color: #ffffff;padding: 10px 10px 20px 20px;"
                          method="post" action="">
                        <div class="layui-form-item layui-col-space20">
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <select name="rtypeId" lay-verify="choose_" lay-search>
                                        <option value="">房型</option>
                                        <c:forEach items="${requestScope.allTypes}" var="item">
                                            <option value="${item.rtypeid}">${item.rtypename}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <select name="isFoot" lay-verify="choose_" lay-search>
                                        <option value="">早餐</option>
                                        <option value="0">有早餐</option>
                                        <option value="1">没早餐</option>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <select name="isNet" lay-verify="choose_" lay-search>
                                        <option value="">宽带</option>
                                        <option value="0">有宽带</option>
                                        <option value="2">无宽带</option>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <select name="price" lay-verify="choose_" lay-search>
                                        <option value="">价格范围</option>
                                        <option value="0-150">￥ 150以下</option>
                                        <option value="150-300">￥150 - ￥300</option>
                                        <option value="300-450">￥300 - ￥450</option>
                                        <option value="450-600">￥450 - ￥600</option>
                                        <option value="600-1000">￥600 - ￥1000</option>
                                        <option value="1000-2147483647">￥1000以上</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item layui-col-space20">
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <div class="layui-input-inline">
                                        <button style="display: none" class="layui-btn sub_btn" lay-submit lay-filter="formDemo">查询</button>
                                        <button type="reset" class="layui-btn res_btn">重置</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </form>

                    <br>

                    <!-- 房间信息 -->

                </div>

            </div>
        </div>
    </div>

    <script src="..\static\common\book_room\book_room.js"></script>

    <script src="../views/static/admin/js/config.js"></script>
    <script src="../views/static/admin/js/script.js"></script>
    </body>
</html>

