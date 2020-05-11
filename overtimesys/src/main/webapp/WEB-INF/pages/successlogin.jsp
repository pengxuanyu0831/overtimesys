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
        <a href="tool.html">
            <div>
                <h1>TOOL</h1>
                <span></span>
            </div>
            <div>
                <h1>TOOL</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="work.html">
            <div>
                <h1>WORK</h1>
                <span></span>
            </div>
            <div>
                <h1>WORK</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="360.html">
            <div>
                <h1>VR/360</h1>
                <span></span>
            </div>
            <div>
                <h1>VR/360</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="directors.html">
            <div>
                <h1>DIRECTORS</h1>
                <span></span>
            </div>
            <div>
                <h1>DIRECTORS</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="awards.html">
            <div>
                <h1>AWARDS</h1>
                <span></span>
            </div>
            <div>
                <h1>AWARDS</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="about.html">
            <div>
                <h1>ABOUT</h1>
                <span></span>
            </div>
            <div>
                <h1>ABOUT</h1>
                <span></span>
            </div>
        </a>
    </div>
    <div>
        <a href="contact.html">
            <div>
                <h1>CONTACT</h1>
                <span></span>
            </div>
            <div>
                <h1>CONTACT</h1>
                <span></span>
            </div>
        </a>
    </div>
</nav>
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
