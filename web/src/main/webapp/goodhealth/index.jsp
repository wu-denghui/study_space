<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="Restyling jQuery UI Widgets and Elements" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="/static/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="/static/layui/dist/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
    <script type="text/javascript"  src="/static/js/jquery.js"></script>
    <script src="/static/layui/dist/layui.js" charset="utf-8"></script>
    <script src="/static/assets/js/ace-extra.min.js"></script>
    <title>主页</title>

</head>
<body>
<jsp:include page="head.jsp"/>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;<span class="layui-breadcrumb" lay-separator="/">
  <a><cite>主页</cite></a>
</span>
<div class="com.goodhealth.design.demo">
    <div id="frameClassified">
        <div class="layui-collapse" lay-accordion="">
            <h1 class="layui-colla-title">所有商品分类</h1>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">消化系统用药</h2>
                <div class="layui-colla-content layui-show">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">胃炎</a><a  onclick="fun(this)">胃肠溃疡</a><a onclick="fun(this)">结肠炎</a><br><a onclick="fun(this)">消化不良</a><a  onclick="fun(this)">便秘</a><a onclick="fun(this)">腹泻</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">心脑血管用药</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">高血压</a><a onclick="fun(this)">脑血管病</a><a onclick="fun(this)">冠心病</a><br><a onclick="fun(this)">高血脂</a><a onclick="fun(this)">心绞痛</a><a onclick="fun(this)">静脉曲张</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">五官科疾病用药</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">鼻炎</a><a onclick="fun(this)">咽喉炎</a><a onclick="fun(this)">眼干眼涩</a><a onclick="fun(this)">白内障</a><a onclick="fun(this)">青光眼</a><a onclick="fun(this)">口腔溃疡</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">皮肤病用药</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a  onclick="fun(this)">皮炎藓症</a><a onclick="fun(this)">痤疮</a><a onclick="fun(this)">白癜风</a><a onclick="fun(this)">灰指甲</a><a onclick="fun(this)">过敏</a><a onclick="fun(this)">黄褐斑</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">肝病科用药</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">乙肝</a><a onclick="fun(this)">保肝护肝</a><a onclick="fun(this)">胆结石</a><br><a onclick="fun(this)">肝纤维化</a><a onclick="fun(this)">肝硬化</a><a onclick="fun(this)">脂肪肝</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">风湿骨痛用药</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">风湿类风湿</a><a onclick="fun(this)">骨关节炎</a><a onclick="fun(this)">跌打骨伤</a><br><a onclick="fun(this)">骨质疏松</a><a onclick="fun(this)">痛风</a><a onclick="fun(this)">骨质增生</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">家庭常备药</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">创可贴</a><a onclick="fun(this)">酒精消毒剂</a><a onclick="fun(this)">绷带纱布</a><br><a onclick="fun(this)">晕车贴</a><a onclick="fun(this)">退热贴</a><a onclick="fun(this)">急救包</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">中药滋补</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">三七</a><a onclick="fun(this)">西洋参</a><a onclick="fun(this)">金银花</a><br><a onclick="fun(this)">天麻</a><a onclick="fun(this)">当归</a><a onclick="fun(this)">罗汉果</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">参茸细贵</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">冬虫夏草</a><a onclick="fun(this)">燕窝</a><a onclick="fun(this)">鹿茸</a><br><a onclick="fun(this)">石斛</a><a onclick="fun(this)">人参</a><a onclick="fun(this)">灵芝孢子</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">健康老人</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">增强免疫力</a><a onclick="fun(this)">降低血脂</a><a onclick="fun(this)">降低血糖</a><br><a onclick="fun(this)">调节血压</a><a onclick="fun(this)">三七粉</a><a onclick="fun(this)">蛋白粉</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">妇婴保健</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">DHA</a><a onclick="fun(this)">鱼肝油</a><a onclick="fun(this)">儿童钙片</a><br><a onclick="fun(this)">儿童益生菌</a><a onclick="fun(this)">合生元</a><a onclick="fun(this)">妈咪爱</a></span>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">美容美颜</h2>
                <div class="layui-colla-content">
                    <span class="layui-breadcrumb" lay-separator="|"><a onclick="fun(this)">减肥瘦身</a><a onclick="fun(this)">补血补气</a><a onclick="fun(this)">美白祛斑</a><br><a onclick="fun(this)">左旋肉碱</a><a onclick="fun(this)">调经养颜</a><a onclick="fun(this)">阿胶</a></span>
                </div>
            </div>
        </div>
    </div>


    <div id="frameSlide" >
        <div class="layui-carousel" id="test10">
            <div carousel-item="">
                <div><a href="https://www.baidu.com"><img src="/static/images/index/lunbo_1.jpg"></a></div>
                <div><img src="/static/images/index/lunbo_1.jpg"></div>
                <div><img src="/static/images/index/lunbo_1.jpg"></div>
            </div>
        </div>
    </div>

    <div id="frameRecommend">
        <table>
            <caption class="layui-colla-title">今日推荐</caption>
            <tr><td><a href=""><img src="/static/images/index/right_1.jpg"></a></td></tr>
            <tr><td><a href=""><img src="/static/images/index/right_2.jpg"></a></td></tr>
            <tr><td><a href=""><img src="/static/images/index/right_3.jpg"></a></td></tr>
            <tr><td><a href=""><img src="/static/images/index/right_4.jpg"></a></td></tr>
        </table>
    </div>
</div>
<br><br><br><br>
<div  align="center">
    <jsp:include page="footer.jsp"/>
</div>

<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;
        //图片轮播
        carousel.render({
            elem: '#test10'
            ,width: '800px'
            ,height: '750px'
            ,interval: 2500
        });
    });
</script>
<script>
    var  change=function (obj){
        obj.value="";
    }
    layui.use('element', function(){
        var element = layui.element;
        element.on('nav(com.goodhealth.design.demo)', function(elem){
            layer.msg(elem.text());
        });
    });
</script>
<script>
    var fun =function(obj){
        var param = obj.innerText;
        // alert(param);
        location.href='http://localhost:8080/drug/user/findByFunction?param='+param+''
    };
</script>
</body>
</html>
