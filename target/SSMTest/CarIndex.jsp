<%--
  Created by IntelliJ IDEA.
  User: tracy
  Date: 2017/11/13
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>登陆</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">

    <script src="js/jquery-3.2.1.min.js"></script>

    <%------css 开始------%>

    <style>
        html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video{margin:0;padding:0;border:0;font-size:100%;font:inherit;vertical-align:baseline}article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section{display:block}body{line-height:1}ol,ul{list-style:none}blockquote,q{quotes:none}blockquote:before,blockquote:after,q:before,q:after{content:'';content:none}table{border-collapse:collapse;border-spacing:0}

    </style>

    <style>

        /* CSS Document */
        body, html {
            height: 100%;
        }

        body {
            background: rgb(209,228,234);
            background: -moz-radial-gradient(center, ellipse cover,  rgba(209,228,234,1) 0%, rgba(186,228,244,1) 100%);
            background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%,rgba(209,228,234,1)), color-stop(100%,rgba(186,228,244,1)));
            background: -webkit-radial-gradient(center, ellipse cover,  rgba(209,228,234,1) 0%,rgba(186,228,244,1) 100%);
            background: -o-radial-gradient(center, ellipse cover,  rgba(209,228,234,1) 0%,rgba(186,228,244,1) 100%);
            background: -ms-radial-gradient(center, ellipse cover,  rgba(209,228,234,1) 0%,rgba(186,228,244,1) 100%);
            background: radial-gradient(ellipse at center,  rgba(209,228,234,1) 0%,rgba(186,228,244,1) 100%);
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d1e4ea', endColorstr='#bae4f4',GradientType=1 );

            padding:0;
            margin:0;
        }
        .country-wrap {
            position:relative;
            width:100%;
            height:100%;
            overflow:hidden;
        }
        .push-bottom {
            position:absolute;
            bottom:0;
            height:100%;
        }
        .bottom-ground {
            background:#8d773e;
            width:102%;
            left:-1%;
            height:60px;
            bottom:0;
            position:absolute;
            box-shadow:0 2px 3px rgba(0,0,0,0.2) inset;
        }
        .street {
            background:#7a7a7a	 url(data:image/png;base64,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);
            height:80px;
            width:102%;
            position:absolute;
            bottom:0;
            box-shadow:0 1px 16px rgba(111, 35, 51, 0.4) inset;
        }
        .street:after {
            content:'';
            display:block;
            position:absolute;
            width:100%;
            height:10px;
            background:#cdbcb4;
            bottom:0;
            border-bottom:3px solid #72625a;
            z-index:1;
        }
        .street:before {
            content:'';
            display:block;
            position:absolute;
            width:100%;
            height:7px;
            background:#c2a99d;
            bottom:-7px;
            z-index:1;
        }

        .street-stripe {
            background:#d4d4d4;
            height:8px;
            width:100px;
            position:absolute;
            bottom:44px;
            border-radius:2px;
            box-shadow:200px 0 0 #d4d4d4, 400px 0 0 #d4d4d4 , 600px 0 0 #d4d4d4 , 800px 0 0 #d4d4d4 , 1000px 0 0 #d4d4d4 , 1200px 0 0 #d4d4d4 , 1400px 0 0 #d4d4d4 , 1600px 0 0 #d4d4d4 , 1800px 0 0 #d4d4d4 , 2000px 0 0 #d4d4d4;
        }
        .grass {
            height: 40px;
            width: 100%;
            background-color: #dbcac2;
            position:absolute;
            bottom:60px;
        }
        .grass:before {
            position: absolute;
            content: '';
            top: 14px;
            left: 0;
            height: 8px;
            width: 100%;
            background-color: #b99f93;
        }
        .grass:after {
            position: absolute;
            content: '';
            top: -4px;
            left: 0;
            width: 100%;
            height: 8px;
            background-color: #0aa;
            background: linear-gradient(135deg, transparent 25%, #0aa 25%);
            background-size:10px 10px;
        }
        .sun {
            background:#ff9944;
            width:40px;
            height:40px;
            border-radius:50%;
            box-shadow:0 0 50px rgba(255,153,68,0.7);
            position:absolute;
            left:26%;
            bottom:350px;
        }
        .tree-1 {
            position:absolute;
            z-index:2;
            bottom:210px;
            right:10px;
            width:50px;
            height:100px;

        }
        .trunk {
            width:20%;
            height:30%;
            background:brown;
        }
        .branch {
            position:abslute;
            width:60%;
            height:30%;
            background:green;
            -moz-transform:rotate(45deg);
            border-radius:0 0 100% 0;
        }
        .branch-1 {
            border:50px solid;
            border-bottom:90px solid;
            border-color:transparent transparent #a5894a transparent;
            height: 0;
            width: 0;
            position:absolute;
            left:-50px;
            top:-70px;
        }
        .branch-2 {
            border-bottom: 40px solid #9d8346;
            border-left: 30px solid transparent;
            border-right: 30px solid transparent;
            height: 0;
            width: 100px;
            position:absolute;
            top:60px;
            left:-80px;
        }
        .branch-3 {
            border-bottom: 50px solid #90713b;
            border-left: 40px solid transparent;
            border-right: 40px solid transparent;
            height: 0;
            width: 100px;
            position:absolute;
            top:100px;
            left:-90px;
        }
        .mountain-1 {
            background:#cea392;
            width:500px;
            height:500px;
            position:absolute;
            -moz-transform:rotate(45deg);
            -webkit-transform:rotate(45deg);
            bottom:-150px;
            border-radius:40px;
        }
        .mountain-2 {
            background:#e4dbd2;
            width:800px;
            height:800px;
            position:absolute;
            -moz-transform:rotate(45deg);
            -webkit-transform:rotate(45deg);
            bottom:-350px;
            border-radius:40px;
            left:250px;
            z-index:-1;
            box-shadow: 0 0 25px #e4dbd2;
            opacity:0.6;
        }
        .la {
            position: absolute;
            bottom: 200px;
            width: 2px;
            height: 50px;
            background: $cd;
            margin-right: 20px;
        }

        .la:before {
            top: 5px;
            left: -10px;
            width: 22px;
            height: 2px;
            background: $cd;
        }

        .la:after {
            bottom: 0;
            left: -2px;
            width: 6px;
            height: 12px;
            background: $cd;
        }

        .l {
            position: absolute;
            width: 5px;
            height: 5px;
            border-radius: 50%;
            background: #fff;
            box-shadow: 0 0 10px #fff, 0 0 25px #fff, 0 0 50px #fff;
        }

        .l:nth-child(1) { left: -10px; }
        .l:nth-child(2) { right: -10px; }
        /*styles for car*/
        .car {
            position:absolute;

            top:-35%;
            z-index:10;
            -moz-animation:myfirst 10s  linear infinite;
            -webkit-animation:myfirst 10s  linear infinite;
        }
        @-moz-keyframes myfirst
        {
            0%   {left:-25%;}
            100% {left:100%;}
        }
        @-webkit-keyframes myfirst
        {
            0%   {left:-25%;}
            100% {left:100%;}
        }
        .tyre {
            width:30px;
            height:30px;
            border-radius:50%;
            background:#3f3f40;
            position:absolute;
            z-index:2;
            left:9px;
            top:20px;
            -moz-animation:tyre-rotate 1s infinite linear;
            -webkit-animation:tyre-rotate 1s infinite linear;
        }
        @-moz-keyframes tyre-rotate {
            from{-moz-transform:rotate(-360deg);}
            to{-moz-transform:rotate(0deg);}

        }
        @-webkit-keyframes tyre-rotate {
            from{-webkit-transform:rotate(-360deg);}
            to{-webkit-transform:rotate(0deg);}

        }
        .tyre:before {
            content:'';
            width:20px;
            height:20px;
            border-radius:50%;
            background:#bdc2bd;
            position:absolute;
            top:5px;
            left:5px;
        }
        .gap {
            background:#3f3f40;
            width:2px;
            height:4px;
            position:absolute;
            left:14px;
            top:8px;
            box-shadow:0 9px 0 #3f3f40;
        }
        .gap:before {
            content:'';
            display:block;
            width:2px;
            height:4px;
            position:absolute;
            background:#3f3f40;
            box-shadow:0 12px 0 #3f3f40;
            -webkit-transform:rotate(-90deg);
            -webkit-transform-origin:0 7px;
            -moz-transform:rotate(-90deg);
            -moz-transform-origin:0 7px;
            z-index:3;
        }
        .car-base {
            position:absolute;
            display:block;
            width: 125px;
            height: 30px;
            background:#000000;
            border-radius:  10% 10% 50% 50% / 60% 100% 20% 10%;
            -webkit-transform:rotate(-2deg);
            -moz-transform:rotate(-2deg);
            border:solid;
            border-color:#000000;
        }
        .back-bonet {
            background:  #4c4b4b;
            border-radius: 54% 25% 0 0;
            height: 22px;
            left: 11px;
            position: absolute;
            top: 8px;
            width: 40px;
        }
        .tyre.front {
            left:94px;
        }
        .car-body {
            /*width:125px;
            height:24px;
            background:#d1352b;
            border-top:1px solid #a82e27;*/
            border-bottom: 24px solid #d1352b;
            height: 0;
            top:10px;
            width: 120px;
            position:relative;
        }
        .car-body:before {
            content:'';
            display:inline-block;
            width:30px;
            height:24px;
            position:absolute;
            right:-5px;
            background:#d1352b;
            border-top-right-radius:4px;
            z-index:1;
        }
        .car-body:after {
            content:'';
            display:inline-block;
            width:121px;
            border-bottom: 1px solid #942b25;
            border-right: 2px solid transparent;
            height: 0;
            z-index:2;
            position:absolute;
        }
        .car-gate {
            width:32px;
            height:20px;
            background:#d1352b;
            border-radius:0 0 2px 8px / 0 0 2px 8px;
            box-shadow:0 0 0 1px #892924;
            position:absolute;
            left:48px;

        }
        .car-gate:before {
            content:'';
            width:8px;
            height:2px;
            background:#4c4b4b;
            position:absolute;
            top:2px;
            left:4px;
            box-shadow:1px 1px 1px rgba(0,0,0,0.1);
        }
        .car-top-back {
            background: none repeat scroll 0 0 #4C4B4B;
            border-radius: 5px 0 0 0;
            height: 20px;
            left: 4px;
            position: absolute;
            top: -20px;
            width: 58px;
        }
        .car-top-back:before {
            width:30px;
            height:15px;
            background:#736f6f;
            content:'';
            position:absolute;
            top:3px;
            left:8px;
            border-radius:2px;
        }
        .car-top-back:after {
            content:'';
            background:#4c4b4b;
            border-radius:  30%;
            height: 5px;
            left: 3px;
            position: absolute;
            top: -1px;
            width: 62px;
        }
        .car-top-front {
            top:-19px;
            position:absolute;
            left:47px;
            width:20px;
            height:20px;
            background:#dc4630;
            border-left: 1px solid #892924;
            border-radius: 2px 0 0 0;

        }
        .car-top-front:after {
            width:26px;
            height:20px;
            -webkit-transform:skew(37deg);
            -moz-transform:skew(37deg);
            background:#dc4630;
            content:'';
            position:absolute;
            top:0;
            left:6px;
            border-radius:4px 0 4px 4px;
        }
        .car-top-front:before {
            width:12px;
            height:5px;
            background:#dc4630;
            content:'';
            position:absolute;
            top:14px;
            left:28px;
            z-index:1;
            border:solid #a82e27;
            border-width:0 1px 1px 0;
        }
        .wind-sheild {
            top:3px;
            left:3px;
            position:absolute;
            z-index:3;
            width:18px;
            height:12px;
            background:#f5e7e7;
            border-radius:0 3px 0 0;
        }
        .wind-sheild:after {
            width:12px;
            height:12px;
            -webkit-transform:skew(25deg);
            -moz-transform:skew(25deg);
            background:#f5e7e7;
            content:'';
            position:absolute;
            top:0;
            left:10px;
            border-radius:3px;
        }
        .boundary-tyre-cover {
            position:absolute;
            top:14px; left:10px;
            border-bottom: 20px solid #4c4b4b;
            border-right: 10px solid transparent;
            height:0;
            width:20px;
        }
        .boundary-tyre-cover:before {
            content:'';
            position:absolute;
            display:inline-block;
            background:#4c4b4b;
            height:20px;
            width:15px;
            -webkit-transform:skewX(-20deg);
            -moz-transform:skewX(-20deg);
            border-radius:3px;
            left:-6px;
            top:0;
        }
        .boundary-tyre-cover:after {
            content:'';
            position:absolute;
            display:inline-block;
            background:#4c4b4b;
            height:20px;
            width:20px;
            -webkit-transform:skewx(40deg);
            -moz-transform:skewX(40deg);
            border-radius:3px;
            right:-14px;
            top:0;
        }
        .boundary-tyre-cover-inner {
            position:absolute;
            top:4px; left:4px;
            border-bottom: 16px solid black;
            border-right: 10px solid transparent;
            height:0;
            width:15px;
            z-index:2;
        }
        .boundary-tyre-cover-inner:before {
            content:'';
            position:absolute;
            display:inline-block;
            background:black;
            height:16px;
            width:15px;
            -webkit-transform:skewX(-20deg);
            -moz-transform:skewX(-20deg);
            border-radius:3px 3px 0 0;
            left:-6px;
            top:0;
        }
        .boundary-tyre-cover-inner:after {
            content:'';
            position:absolute;
            display:inline-block;
            background:black;
            height:16px;
            width:20px;
            -webkit-transform:skewx(40deg);
            -moz-transform:skewX(40deg);
            border-radius:3px 3px 0 0;
            right:-11px;
            top:0;
        }
        .boundary-tyre-cover-back-bottom {
            position: absolute;
            width: 14px;
            height: 8px;
            background: #4c4b4b;
            top: 12px;
            left: -19px;
        }
        .bonet-front {
            background: #d1352b;
            border-radius: 5px 258px 0 38px / 36px 50px 0 0;
            height: 4px;
            position: absolute;
            right: 0;
            top: -4px;
            width: 40px;
            z-index: 0;
        }
        .back-curve {
            background: none repeat scroll 0 0 #4C4B4B;
            border-radius: 960% 100% 0 0;
            height: 20px;
            left: -3px;
            position: absolute;
            top: 1px;
            transform: rotate(6deg);
            width: 5px;
        }
        .stepney {
            height: 6px;
            left: -4px;
            position: absolute;
            top: 6px;
            width: 8px;
            z-index: -1;
            background:#3f3f40;
        }
        .stepney:before {
            width:8px;
            height:12px;
            background:#3f3f40;
            content:'';
            position:absolute;
            top:-10px;
            left:-7px;
            border-radius:3px 3px 0 0;
        }
        .stepney:after {
            width:8px;
            height:12px;
            background:#0d0c0d;
            content:'';
            position:absolute;
            top:0px;
            left:-7px;
            border-radius:0 0 3px 3px;
        }
        .tyre-cover-front {
            background:#4c4b4b;
            height: 4px;
            left: 97px;
            position: absolute;
            top: 13px;
            width: 22px;
            z-index: 1;
        }
        .tyre-cover-front:before {
            background: none repeat scroll 0 0 #4c4b4b;
            content: "";
            display: inline-block;
            height: 21px;
            left: -10px;
            position: absolute;
            top: 0;
            transform: skewX(-30deg);
            width: 10px;
            z-index: 6;
            border-radius:4px 0 0 0;
        }
        .tyre-cover-front:after {
            background: none repeat scroll 0 0 #4c4b4b;
            content: "";
            display: inline-block;
            height: 6px;
            left: 14px;
            position: absolute;
            top: 0;
            transform: skewX(30deg);
            width: 17px;
            z-index: 6;
            border-radius:0 4px 2px 0;
        }
        .boundary-tyre-cover-inner-front {
            position:absolute;
            top:4px; left:4px;
            border-bottom: 16px solid black;
            border-right: 10px solid transparent;
            height:0;
            width:15px;
            z-index:7;
        }
        .boundary-tyre-cover-inner-front:before {
            background: none repeat scroll 0 0 #000000;
            border-radius: 3px 3px 0 0;
            content: "";
            display: inline-block;
            height: 17px;
            left: -10px;
            position: absolute;
            top: 0;
            transform: skewX(-30deg);
            width: 15px;
        }
        .boundary-tyre-cover-inner-front:after {
            content:'';
            position:absolute;
            display:inline-block;
            background:black;
            height:16px;
            width:20px;
            -webkit-transform:skewx(25deg);
            -moz-transform:skewX(25deg);
            border-radius:3px 3px 0 0;
            right:-12px;
            top:0;
        }
        .base-axcel {
            background: none repeat scroll 0 0 black;
            bottom: -15px;
            height: 10px;
            left: 30px;
            position: absolute;
            transform: rotate(-2deg);
            width: 70px;
            z-index:-1;
        }
        .base-axcel:before {
            background: none repeat scroll 0 0 black;
            border-radius: 0 0 0 10px / 0 0 0 5px;
            content: "";
            height: 10px;
            left: -35px;
            position: absolute;
            top: -2px;
            transform: rotate(6deg);
            width: 30px;
        }
        .base-axcel:after {
            background: none repeat scroll 0 0 black;
            border-radius: 0 0 0 10px / 0 0 0 5px;
            content: "";
            height: 10px;
            right: -33px;
            position: absolute;
            top: -1px;
            transform: rotate(-4deg);
            width: 40px;
            border-radius:0 10px 5px 0;
        }
        .front-bumper {
            background: none repeat scroll 0 0 #4c4b4b;
            border-radius: 0 2px 2px 0;
            height: 8px;
            position: absolute;
            right: -15px;
            width: 11px;
            z-index: 1;
            -moz-transform:rotate(-5deg);
            -webkit-transform:rotate(-5deg);
        }
        .front-bumper:before {
            background: none repeat scroll 0 0 #000000;
            content: "";
            height: 10px;
            left: -7px;
            position: absolute;
            transform: rotate(-22deg);
            width: 9px;
            z-index: 1;
        }
        .car-shadow {
            background: none repeat scroll 0 0 rgba(0, 0, 0, 0);
            bottom: -15px;
            box-shadow: -5px 10px 15px 3px #000000;
            left: -7px;
            position: absolute;
            width: 136px;
        }
        /*noise css*/

        .noise {
            position: relative;
            z-index: 1;
        }

        .noise:before, .body-noise:before {
            content: "";
            position: absolute;
            z-index: -1;
            top:0;
            bottom:0;
            left:0;
            right:0;
            background-image: url(data:image/png;base64,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);

        }
        .hill {
            position: absolute;
            bottom: 0;
            right: 0;
            width: 100%;
            height: 250px;
            border-top-right-radius: 160%;
            border-top-left-radius: 100%;
            background-color: #adde60;
            z-index:-1;
        }
        .hill:after {
            content: '';
            position: absolute;
            bottom: -100px;
            right: -400px;
            width: 120%;
            height: 110%;
            border-top-right-radius: 100%;
            border-top-left-radius: 0%;
            background-color: #94c943;
            -moz-transform:rotate(-12deg);
            -webkit-transform:rotate(-12deg);
            box-shadow:0 0 25px #cbf191 inset;
        }
        .hill:before {
            background-color: #93cc3a;
            border-top-left-radius: 0;
            border-top-right-radius: 100%;
            bottom: -70px;
            content: "";
            height: 110%;
            left: -54px;
            position: absolute;
            transform: rotate(4deg);
            width: 120%;
        }
        .cloud {
            background:#fff;
            width:150px;
            height:50px;
            border-radius:50px;
            position:absolute;
            left:450px;
            top:150px;
        }
        .cloud:before {
            width:100px;
            height:100px;
            content:'';
            position:absolute;
            bottom:0;
            left:-15px;
            border-radius:50px;
            box-shadow:100px 0 0 #fff;
            background:#fff;
        }




        @charset "utf-8";
        /* CSS Document */

        /*公用*/
        .comWidth{width:1000px; margin-left:auto; margin-right:auto;}
        .leftArea{float:left;}
        .rightArea{float:right;}
        .hide{display:none;}
        .show{display:block;}

        /*topBar*/
        .topBar{height:31px; background-color:#F7F7F7; line-height:31px;}
        .collection{background:url(../images/icon/collection.jpg) left center no-repeat; padding-left:19px; font-weight:bold;}
        .topBar a:hover{color:red;}
        /*logo*/
        .logoBar{height:85px; background-color:#1D7AD9;}
        .logo{padding-left:71px; padding-top:13px;}
        /*search*/
        .search_box{width:430px; padding-top:23px; padding-left:185px;}
        /*.search_text{width:350px;height:14px; line-height:14px; padding:11px 5px 10px; background-color:#FFF;}
        */
        .search_text{width:350px;height:35px; line-height:35px\9;/*css hack  \9 代表所有的ie浏览器*/ padding:0 5px; background-color:#FFF;}
        .search_btn{width:70px; height:35px; font-size:14px; font-family:"Microsoft YaHei", "微软雅黑"; background-color:#FF8C00; color:#FFF;}

        /*登陆*/
        .login_logo .comWidth{width:260px;}
        .welcome_title{font:22px/85px "Microsoft YaHei", "微软雅黑"; color:#FFF; float:center; text-align:center;}
        .loginBox{width:458px; border:#999 solid 1px; margin:100px auto; position:relative;}
        .login_cont{padding:15px 76px;}
        .l_tit{color:#666; line-height:20px;}
        .login_input{border:#999 solid 1px; height:32px; line-height:32px\9; text-indent:5px; width:100%;}
        .user_icon{background:url(../images/icon/user_icon.jpg) right center no-repeat;}
        .mb_10{margin-bottom:10px;}
        .autoLogin{padding-top:15px; padding-bottom:28px;}
        .checked{position:relative; top:3px; margin-right:3px;}
        .login_btn{width:309px; height:36px; background:url(../images/icon/login_btn.jpg) left top no-repeat;}
        .login_partners{padding-top:34px;}
        .login_list li{float:left; line-height:20px;}
        .login_list span{color:#999; margin:0 2px;}
        .reg_link{width:115px; height:31px; background:url(../images/icon/red_link.jpg) left top no-repeat; position:absolute; right:31px; bottom:-31px;}
        .red_logo .comWidth{width:630px;}
        .regBox{width:628px; margin:10px auto; border:#CCC solid 1px;}
        .reg_item{font:14px/34px "宋体"; width:110px; text-align:right; float:left;}
        .reg_item i{color:red; font-style:normal; margin-right:5px;}
        .input_item{width:306px; float:left;}
        .regBox li{height:70px; vertical-align:top;}
        .regBox .autoLogin{height:46px; padding:0;}
        .regBox .login_cont{padding:45px 76px 20px 76px;}

        /*公用*/
        .comWidth{width:1000px; margin-left:auto; margin-right:auto;}
        .leftArea{float:left;}
        .rightArea{float:right;}
        .hide{display:none;}
        .show{display:block;}

        /*topBar*/
        .topBar{height:31px; background-color:#F7F7F7; line-height:31px;}
        .collection{background:url(../images/icon/collection.jpg) left center no-repeat; padding-left:19px; font-weight:bold;}
        .topBar a:hover{color:red;}
        /*logo*/
        .logoBar{height:85px; background-color:#1D7AD9;}
        .logo{padding-left:71px; padding-top:13px;}

        body,ul,ol,li,p,h1,h2,h3,h4,h5,h6,form,fieldset,table,td,img,div,dl,dt,dd,input{margin:0;padding:0;}
        body{font-size:12px;}
        img{border:none;}
        li{list-style:none;}
        input,select,textarea{outline:none;border:none; background:none;}
        textarea{resize:none;}
        a{text-decoration:none; color:#656565;}

        /*清浮动*/
        .clearfix:after{content:"";display:block;clear:both;}
        .clearfix{zoom:1;}
        .fl{float:left;}
        .fr{float:right;}



        /* CSS Document */
        body,ul,ol,li,p,h1,h2,h3,h4,h5,h6,form,fieldset,table,td,img,div,dl,dt,dd,input{margin:0;padding:0;}
        body{font-size:12px;}
        img{border:none;}
        li{list-style:none;}
        input,select,textarea{outline:none;border:none; background:none;}
        textarea{resize:none;}
        a{text-decoration:none; color:#656565;}

        /*清浮动*/
        .clearfix:after{content:"";display:block;clear:both;}
        .clearfix{zoom:1;}
        .fl{float:left;}
        .fr{float:right;}


    </style>

    <script src="../js/prefixfree.min.js"></script>
    <script src='../js/jquery.js'></script>


<%--css 结束--%>
</head>
<body>


<div class="country-wrap">

    <!--<div class="mountain-1"></div>
    <div class="mountain-2"></div>-->
    <div style="text-align:center;clear:both">

    </div>
    <div class="loginBox" style="border:2px solid #000">
        <div class="login_cont">
            <form action="/user/FormLogin" method="post">
                <ul class="login">
                    <li class="l_tit" style="color:#000;text-align: center">邮箱/用户名/手机号</li>
                    <li class="mb_10"><input type="text" name="userName" class="login_input"
                                             style="border:#000 solid 1px"></li>
                    <li class="l_tit" style="color:#000;text-align: center">密码</li>
                    <li class="mb_10"><input type="Password" name="userPassword" class="login_input"
                                             id="userPassword" style="border:#000 solid 1px"></li>
                    <li class="autoLogin" style="text-align: center">
                        <label><input name="identity" type="radio" value="user" checked/>用户</label>
                        <label><input name="identity" type="radio" value="admin"/>管理员</label>
                    </li>
                    <li><input type="submit" value="" class="login_btn"></li>
                </ul>
            </form>
            <div class="login_partners">
                <p class="l_tit" style="color:#000;text-align: center">使用合作方账号登陆网站</p>
                <ul class="login_list clearfix">
                    <li><a href="#" style="color:#000">QQ</a></li>
                    <li><span style="color:#000">|</span></li>
                    <li><a href="#" style="color:#000">新浪微博</a></li>
                    <li><span style="color:#000">|</span></li>
                    <li><a href="#" style="color:#000">腾讯微博</a></li>
                    <li><span style="color:#000">|</span></li>
                    <li><a href="#" style="color:#000">新浪微博</a></li>
                    <li><span style="color:#000">|</span></li>
                    <li><a href="#" style="color:#000">腾讯微博</a></li>
                    <li><span style="color:#000">|</span></li>
                    <li><a href="#" style="color:#000">微信</a></li>
                </ul>
            </div>
        </div>
        <a class="reg_link" onclick="doRegister()"></a>
    </div>
    <div class="sun"></div>

    <div class="grass"></div>
    <div class="street">

        <div class="car">
            <!--<div class="car-base"></div>-->
            <div class="car-body">
                <div class="car-top-back">
                    <div class="back-curve"></div>
                </div>
                <div class="car-gate"></div>
                <div class="car-top-front">
                    <div class="wind-sheild"></div>
                </div>
                <div class="bonet-front"></div>
                <div class="stepney"></div>
            </div>
            <div class="boundary-tyre-cover">
                <div class="boundary-tyre-cover-back-bottom"></div>
                <div class="boundary-tyre-cover-inner"></div>
            </div>
            <div class="tyre-cover-front">
                <div class="boundary-tyre-cover-inner-front"></div>
            </div>
            <div class="base-axcel">

            </div>
            <div class="front-bumper"></div>
            <div class="tyre">
                <div class="gap"></div>
            </div>
            <div class="tyre front">
                <div class="gap"></div>
            </div>
            <div class="car-shadow"></div>
        </div>
    </div>
    <div class="street-stripe"></div>
    <div class="hill">
    </div>

</div>

<script src='../js/jquery.js'></script>


</body>
<script src="/js/layui.js"></script>
<script>
    layui.use('layer', function () {
        var layer = layui.layer;
    });

    function doRegister() {
        var index = layer.open({
            type: 2,
            title: '用户注册',
            offset: '100px',  //水平居中
            area: ['700px', '500px'],
            content: 'http://localhost:8080/html/register.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
        layer.iframeAuto(index);    //自适应

    }

</script>
<script>

    $(function () {
//        console.log($('input:radio:checked').val());
    })

</script>
</html>
