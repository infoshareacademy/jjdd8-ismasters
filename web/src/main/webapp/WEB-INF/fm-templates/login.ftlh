<#include "header-section.ftlh">
<#include "search-section.ftlh">
<section class="property-section">
    <div class="container">
        <div class="section-title">
        </div>
        <div class="auth">
        <div class="row">
            <div class="col-3">
<#--                <p>State: ${state ! "Brak danych dla state"}</p>-->
<#--                <p>Code: ${code ! "Brak danych dla code"}</p>-->
<#--                <p>Token: ${token ! "Brak danych dla token"}</p>-->
<#--                <p>Login URL: ${loginUrl ! "Brak danych dla loginUrl"}</p>-->
<#--                <p>Session attribute: ${sessionAttribute ! "Brak danych dla sessionAttribute"}</p>-->

                <p><a href=${loginUrl}>log in with google</a></p>
<#--                <div class="property-item">-->
<#--                    <h6> Miejsce wydarzenia : <p>${event.place ! "Nie podano"}</p></h6>-->
<#--                </div>-->

<#--                <div class="property-item">-->
<#--                    <h6> Organizato wydarzenia : <p>${event.organizer ! "Organizator nie znany"}</p></h6>-->
<#--                </div>-->


<#--                <div class="property-item">-->
<#--                    <h6> Data wydarzenia : <p>${event.startDate ! "Data nie znana"}</p></h6>-->
<#--                </div>-->


<#--                <div class="property-item">-->
<#--                    <h6> Bilety wydarzenia : <p>${event.tickets ! "Brak informacji o biletach"}</p></h6>-->
<#--                </div>-->

<#--                <div class="property-item">-->
<#--                    <h6> <a href="${event.urls ! "brak"}" class="readmore-btn">Find out more</a> </h6>-->

<#--                </div>-->

            </div>

<#--            <div class="col-8">-->
<#--                <div class="property-item">-->
<#--                    <h4> Nazwa wydarzenia : ${event.name ! "Brak nazwy"}</h4>-->
<#--                    <p>Opis wydarzenia : ${event.descLong ! "Brak opisu"}</p>-->
<#--                </div>-->
<#--            </div>-->

            <div class="col">

            </div>
        </div>
        </div>
    </div>
</section>
<#include "newsletter-section.ftlh">
<#include "footer-section.ftlh">