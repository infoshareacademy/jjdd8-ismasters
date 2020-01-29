<!DOCTYPE html>
<html>
<head>
    <title>3City Events</title>
    <meta charset="UTF-8">
    <meta name="description" content="Real estate HTML Template">
    <meta name="keywords" content="real estate, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link href="/img/favicon.ico" rel="shortcut icon"/>
    <script src="/js/login_logout.js"></script>


    <!-- Stylesheets -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/slicknav.min.css"/>

    <!-- Main Stylesheets -->
    <link rel="stylesheet" href="/css/style.css"/>

    <!-- Google font -->
    <meta name="google-signin-scope" content="profile email">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i,900%7cRoboto:400,400i,500,500i,700,700i&display=swap" rel="stylesheet">
    <meta name="google-signin-client_id" content="410089355802-edk5jsfjas6cmf08v219irj2i3lvrtcm.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


    <![endif]-->
    <style>


        .auth a {
            display: block;
            border-style: solid;
            border-color: #bbb #888 #666 #aaa;
            border-width: 1px 2px 2px 1px;
            background: #ccc;
            color: #333;
            line-height: 2;
            text-align: center;
            text-decoration: none;
            font-weight: 900;
            width: 13em;
        }

        .auth pre {
            background: #ccc;
        }
    </style>

</head>
<body>

<!-- Page Preloder -->
<div id="preloder" style="display: none;">
    <div class="loader" style="display: none;"></div>
</div>

<!-- Header Section -->
<header class="header-section">
    <a href="index.html" class="site-logo">
        <img src="/img/logo_100.png" alt="">
    </a>
    <nav class="header-nav">
        <ul class="main-menu">
            <li><a href="news.html">Wydarzenia</a></li>
            <li><a href="contact.html">Kontakt</a></li>
        </ul>

        <div class="header-right">
            <div class="user-panel">
                <#if logged == "yes" >
                    <a href="/logout" class="btn btn-danger btn-sm"
                       id="logout"><i class="fa fa-google"></i> Wyloguj się</a>
                <#else>
                    <a href="${loginUrl}" class="btn btn-danger btn-sm" id="login">
                    <i class="fa fa-google"></i> Zaloguj się przez <b>Google</b></a>
                </#if>
            </div>
        </div>
    </nav>
    <div class="slicknav_menu"><a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;">
            <span class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span class="slicknav_icon-bar"></span>
                <span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></a>
        <ul class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
            <li class="header-right-warp"><div class="header-right">
                </div>
            </li>
            <li><a href="news.html" role="menuitem" tabindex="-1">Wydarzenia</a></li>
            <li><a href="contact.html" role="menuitem" tabindex="-1">Kontakt</a></li>
        </ul>
    </div>
</header>
<!-- Header Section end -->
