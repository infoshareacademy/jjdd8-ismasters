<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">

            <ul class="event-list">
                <li>
                    <#list eventDtoList as eventDto>
                    <time datetime=${eventDto.startdate ! "Brak opisu"}>
                        <span class="day">4</span>
                        <span class="month">Jul</span>

                    </time>
                    <img alt="Independence Day" src="https://farm4.staticflickr.com/3100/2693171833_3545fb852c_q.jpg" />
                    <div class="info">
                        <h2 class="title">${eventDto.name ! "Brak opisu"}</h2>
                        <p class="desc">${eventDto.organizer.designation ! "Brak Organizatora"}</p>
                    </div>
                        <br>
                    </#list>
                </li>

            </ul>
        </div>
    </div>
</div>

<#include "footer-section.ftlh">