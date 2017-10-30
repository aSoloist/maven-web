<%--
  Created by IntelliJ IDEA.
  User: wenka
  Date: 17-9-9
  Time: 下午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>index.html</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <style type="text/css">
        body {
            font-size: 12px;
            font-family: "微软雅黑", sans-serif;
        }

        * {
            margin: 0;
            padding: 0;
        }

        /* screen start*/
        .screen {
            width: 300px;
            height: 100px;
            background: #669900;
        }

        .dm {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            display: none;
        }

        .dm .d_screen .d_del {
            width: 38px;
            height: 38px;
            background: #600;
            display: block;
            text-align: center;
            line-height: 38px;
            text-decoration: none;
            font-size: 20px;
            color: #fff;
            border-radius: 19px;
            border: 1px solid #fff;
            z-index: 2;
            position: absolute;
            right: 20px;
            top: 20px;
            outline: none;
        }

        .dm .d_screen .d_del:hover {
            background: #F00;
        }

        .dm .d_screen .d_mask {
            width: 100%;
            height: 100%;
            background: #000;
            position: absolute;
            top: 0;
            left: 0;
            opacity: 0.6;
            filter: alpha(opacity=60);
            z-index: 1;
        }

        .dm .d_screen .d_show {
            position: relative;
            z-index: 2;
        }

        .dm .d_screen .d_show div {
            font-size: 26px;
            line-height: 36px;
            font-weight: 500;
            position: absolute;
            top: 76px;
            left: 10px;
            color: #fff;
        }

        /*end screen*/

        /*send start*/
        .send {
            width: 100%;
            height: 76px;
            position: absolute;
            bottom: 0;
            left: 0;
            border: 1px solid red;
        }

        .send .s_filter {
            width: 100%;
            height: 76px;
            background: #000;
            position: absolute;
            bottom: 0;
            left: 0;
            opacity: 0.6;
            filter: alpha(opacity=60);
        }

        .send .s_con {
            width: 100%;
            height: 76px;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 2;
            text-align: center;
            line-height: 76px;
        }

        .send .s_con .s_text {
            width: 800px;
            height: 36px;
            border: 0;
            border-radius: 6px 0 0 6px;
            outline: none;
        }

        .send .s_con .s_submit {
            width: 100px;
            height: 36px;
            border-radius: 0 6px 6px 0;
            outline: none;
            font-size: 14px;
            color: #fff;
            background: #65c33d;
            font-family: "微软雅黑", sans-serif;
            cursor: pointer;
            border: 1px solid #5bba32;
        }

        .send .s_con .s_submit:hover {
            background: #3eaf0e;
        }

        /*end send*/
    </style>


</head>
<body>
<form>
    <a href="#" id="startDm">开启弹幕</a>
    <!-- dm start -->
    <div class="dm">
        <!-- d_screen start -->
        <div class="d_screen">
            <a href="#" class="d_del">X</a>
            <div class="d_mask"></div>
            <div class="d_show">
            </div>
        </div>
        <!-- end d_screen -->


        <!-- send start -->
        <div class="send">
            <div class="s_filter"></div>
            <div class="s_con">
                <input type="text" class="s_text" maxlength="30"/>
                <input type="button" value="发表评论" class="s_submit" id="btn"/>
            </div>
        </div>
        <!-- end send -->
    </div>
    <!-- end dm-->
</form>
<!-- <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script> -->
<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
<!-- <script type="text/javascript" src="websocket.js" id="websocket"> </script> -->

<script type="text/javascript">
    $(function () {

        $("#startDm").click(function () {

            $("#startDm, .dm").toggle(1000);
            window.setTimeout(function () {

                // reference to <head>  
                var head = document.getElementsByTagName('head')[0];

                // a new CSS  
                /* var css = document.createElement('link');  
                css.type = "text/css";  
                css.rel = "stylesheet";  
                css.href = "new.css";   */

                // a new JS  
                var js = document.createElement("script");
                js.type = "text/javascript";
                js.src = "js/websocket.js";

                // preload JS and CSS  
                /* head.appendChild(css);   */
                head.appendChild(js);

                // preload image  
                /* new Image().src = "new.png";   */

            }, 1000);
            /* window.setTimeout("document.getElementById('websocket').src='websocket +  js.js'" , 1000) ; */
            /* var websocket=null;
            var _top=80;
            var index=0;
    
            var host=window.location.host;
            //判断当前浏览器是否支持WebSocket
            if('WebSocket' in window){
                websocket=new WebSocket("ws://192.168.50.155:8080/Danmu01/websocket");
            }
            else{
                alert("Not Support WebSocket!");
            }
    
    
            //连接发生错误的回调方法
            websocket.onerror = function(){
                setMessageInnerHTML("error");
            };
    
            //连接成功建立的回调方法
            websocket.onopen = function(){
                setMessageInnerHTML("open");
            }
    
            //接收到消息的回调方法
            websocket.onmessage = function(event){
                setMessageInnerHTML(event);
            }
    
            //连接关闭的回调方法
            websocket.onclose = function(){
                setMessageInnerHTML("close");
            }
    
    
            //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
            window.onbeforeunload = function(){
                websocket.close();
            }
    
    
            //将消息显示在网页上
            function setMessageInnerHTML(innerHTML){
                $(".d_show").append("<div id='"+index+"'>"+ innerHTML.data + "</div>");
                launch();
            }
    
    
    
    
            //发送消息
            function send(){
             //var message = document.getElementById('text').value;
                var message = $(".s_text").val();
                alert(message);
                websocket.send(message);
            } */
            //init_screen();
        });

        $(".d_del").click(function () {

            $("#startDm, .dm").toggle(1000);
            //init_screen();
        });

        $("#btn").click(function () {
            send();
        });
        $(".s_text").keydown(function () {
            var code = window.event.keyCode;

            if (code === 13)//回车键按下时，输出到弹幕
            {
                send();
            }
        });


    });

    

    function launch() {

        var _height = $(window).height();
        var _left = $(window).width() - $("#" + index).width();
        var time = 10000;
        if (index % 2 == 0)
            time = 20000;
        _top += 80;
        if (_top > _height - 100)
            _top = 80;
        $("#" + index).css({
            left: _left,
            top: _top,
            color: getRandomColor()

        });
        $("#" + index).animate({
                left: "-" + _left + "px"
            },
            time,
            function () {
            });
        index++;
    }


    /* //初始化弹幕
    function init_screen() {
    var _top = 0;
    var _height = $(window).height();
    $(".d_show").find("div").show().each(function() {
    var _left = $(window).width() - $(this).width();
    var time=10000;
    if($(this).index()%2==0)
    time=20000; 
    _top+=80;
    if(_top>_height-100)
    _top=80;
    $(this).css({
    left:_left,
    top:_top,
    color:getRandomColor()
    
    });
    $(this).animate({
    left:"-"+_left+"px"},
    time,
    function(){});
    
    
    });
    } 
    */
    //随机获取颜色值
    function getRandomColor() {
        return '#' + (function (h) {
            return new Array(7 - h.length).join("0") + h
        })((Math.random() * 0x1000000 << 0).toString(16))
    }
</script>

</body>
</html>