<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/4/10
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <!-- particles 背景-->
    <link rel ="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.css">
    <link rel ="stylesheet" href="${pageContext.request.contextPath}/css/nav.css">
</head>
<body>
<h2>登录成功！</h2>
<div id = "particles-js"></div>
<nav>
    <div>
        <a href="blog.html">
            <div>
                <h1>学习笔记</h1>
                <span></span>
            </div>
            <div>
                <h1>学习笔记</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="Snippets.html">
            <div>
                <h1>Code Snippets</h1>
                <span></span>
            </div>
            <div>
                <h1>Code Snippets</h1>
                <span></span>
            </div>
        </a>
    </div>


    <div>
        <a href="Folder.html">
            <div>
                <h1>收藏夹</h1>
                <span></span>
            </div>
            <div>
                <h1>收藏夹</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="schedule.html">
            <div>
                <h1>日历</h1>
                <span></span>
            </div>
            <div>
                <h1>日历</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="about.html">
            <div>
                <h1>null</h1>
                <span></span>
            </div>
            <div>
                <h1>null</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="null.html">
            <div>
                <h1>null</h1>
                <span></span>
            </div>
            <div>
                <h1>null</h1>
                <span></span>
            </div>
        </a>
    </div>

    <div>
        <a href="null.html">
            <div>
                <h1>null</h1>
                <span></span>
            </div>
            <div>
                <h1>null</h1>
                <span></span>
            </div>
        </a>
    </div>
</nav>

<script type ="text/javascript" src = "${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>

<script src ="${pageContext.request.contextPath}/js/particles.min.js"></script>
<script src ="${pageContext.request.contextPath}/js/app.js"></script>
<script src ="${pageContext.request.contextPath}/js/stats.js"></script>
<script>
    var count_particles, stats, update;
    stats = new Stats;
    stats.setMode(0);
    stats.domElement.style.position = 'absolute';
    stats.domElement.style.left = '0px';
    stats.domElement.style.top = '0px';
    document.body.appendChild(stats.domElement);
    count_particles = document.querySelector('.js-count-particles');
    update = function() {
        stats.begin();
        stats.end();
        if (window.pJSDom[0].pJS.particles && window.pJSDom[0].pJS.particles.array) {
            count_particles.innerText = window.pJSDom[0].pJS.particles.array.length;
        }
        requestAnimationFrame(update);
    };
    requestAnimationFrame(update);
</script>

<script>
    $("nav>div").css("left", function (i) {
            return i * 220;
        }
    );
    $("nav>div").click(function () {
        var href = $(this).children().eq(0).attr("href");
        $(window).attr("location", href);
    });
</script>

</body>
</html>
