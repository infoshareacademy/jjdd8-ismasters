<#include "header-section.ftlh">
<#include "search-section.ftlh">
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
                </div>
            </div>
        </div>
    </div>
</section>
<#include "footer-section.ftlh">