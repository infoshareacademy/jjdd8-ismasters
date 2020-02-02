<!DOCTYPE html>
<head>
    <title>3City Events</title>
    <meta charset="UTF-8">
    <meta name="description" content="3city Events">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i,900%7cRoboto:400,400i,500,500i,700,700i&display=swap" rel="stylesheet">


    <!-- Stylesheets -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/slicknav.min.css"/>

    <!-- Icons -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <!-- Main Stylesheets -->
    <link rel="stylesheet" href="/css/style.css"/>

  <!--Date -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />



    <!--[if lt IE 9]>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <![endif]-->

</head>
<body>

<!-- Page Preloder -->
<div id="preloder" style="display: none;">
    <div class="loader" style="display: none;"></div>
</div>

<!-- Header Section -->
<header class="header-section">
    <a href="/" class="site-logo">
        <img src="/img/logo_100.png" alt="">
    </a>
    <nav class="header-nav">
        <ul class="main-menu">
            <li><a href="/organizers-list">Organizatorzy</a></li>
            <li><a href="/list-events?pageNumber=0">Wydarzenia</a></li>
            <li><a href="contact.html">Kontakt</a></li>
        </ul>

        <div class="header-right">
            <div class="user-panel">
                <#if logged == "yes" >
                    <#if userType = "SUPER_ADMIN"><a href="/admin">ADMIN</a></#if>
                    <a href="/logout" class="btn btn-danger btn-sm"
                       id="logout"><i class="fa fa-google"></i> Wyloguj się  (${googleEmail}) </a>
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
            <li><a href="/list-events?pageNumber=0" role="menuitem" tabindex="-1">Wydarzenia</a></li>
            <li><a href="contact.html" role="menuitem" tabindex="-1">Kontakt</a></li>
        </ul>
    </div>
</header>
<!-- Header Section end -->
