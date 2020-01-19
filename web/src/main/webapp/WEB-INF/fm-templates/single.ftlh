<#include "header-section.ftlh">
<#include "search-section.ftlh">
<#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
</#if>

<#if event??>
<section class="property-section">
    <div class="container">
        <div class="section-title">
            <h2>Widok pojedynczego wydarzenia</h2>
        </div>
        <div class="row">
            <div class="col-3">

                <div class="property-item">
                    <h5> Miejsce wydarzenia : ${event.place ! "Nie podano"}</h5>
                </div>

                <div class="property-item">
                    <h5> Organizato wydarzenia : ${event.organizer ! "Organizator nie znany"}</h5>
                </div>


                <div class="property-item">
                    <h5> Data wydarzenia : ${event.startDate ! "Data nie znana"}</h5>
                </div>


                <div class="property-item">
                    <h5> Bilety wydarzenia : ${event.tickets ! "Brak informacji o biletach"}</h5>
                </div>

                <div class="property-item">
                    <h5> <a href="${event.urls ! "brak"}" class="readmore-btn">Find out more</a> </h5>

                </div>

            </div>

            <div class="col-8">
                <div class="property-item">
                    <h5> Nazwa wydarzenia : ${event.name ! "Brak nazwy"}</h5>
                    <p>Opis wydarzenia : ${event.descLong ! "Brak opisu"}</p>
                </div>
            </div>

            <div class="col">

            </div>
        </div>
    </div>
</section>
</#if>
<#include "newsletter-section.ftlh">
<#include "footer-section.ftlh">