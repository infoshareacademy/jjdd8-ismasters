<#include "header-section.ftlh">
<#include "search-section.ftlh">
<section class="property-section">
    <div class="container">
        <div class="section-title">
            <h3>Opis Wydarzenia</h3>
        </div>
        <div class="row">
            <div class="col-3">

                <div class="property-item">
                    <h6> Miejsce  : <p>${placeDto.name ! "Nie podano"}</p></h6>
                </div>

                <div class="property-item">
                    <h6> Adres  : <p>${addressDto ! "Nie podano"}</p></h6>
                </div>

                <div class="property-item">
                    <h6> Organizator  : <p>${organizerDto.designation ! "Organizator nie znany"}</p></h6>
                </div>


                <div class="property-item">
                    <h6> Data  : <p>${eventDto.startDate ! "Data nie znana"}</p></h6>
                </div>


                <div class="property-item">
                    <h6> Bilety  : <p>${eventDto.tickets ! "Brak informacji o biletach"}</p></h6>
                </div>

                <div class="property-item">

                    <h6> <a href="${urlDto.website ! "brak"}" class="readmore-btn">Dowiedz się więcej</a> </h6>

                </div>

            </div>

            <div class="col-8">
                <div class="property-item">
                    <h4> ${eventDto.name ! "Brak nazwy"}</h4>
                    <p> ${eventDto.descLong ! "Brak opisu"}</p>
                </div>
            </div>
        </div>
    </div>
</section>
<#include "footer-section.ftlh">