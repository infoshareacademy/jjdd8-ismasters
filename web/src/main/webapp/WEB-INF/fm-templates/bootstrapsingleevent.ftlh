<#include "header-section.ftlh">
<#include "search-section.ftlh">

<#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
</#if>

<#if event??>
<section class="intro-section spad">
    <div class="container">
        <div class="section-title">
            <h2>${eventDto.name ! "Brak informacji"}</h2>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <img src="/img/TWO.jpg" alt="">
            </div>
            <div class="col-lg-6 ">
                <div class="about-text">
                    <h3>
                        ${eventDto.organizer ! "Brak informacji"}<br>
                        ${eventDto.startDate ! "Brak informacji"}
                    </h3>
                    ${eventDto.descLong ! " Brak informacji"}
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
        </div>
    </div>
</section>
</#if>
<#include "footer-section.ftlh">