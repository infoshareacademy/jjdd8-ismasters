
<#include "header-section.ftlh">
<#include "search-section.ftlh">



    <section class="property-section">
        <div class="container">
            <div class="section-title">
                <h3>Widok pojedynczego wydarzenia</h3>
            </div>
            <div class="row">
                <div class="col-3">

                    <div class="property-item">
                        <h6> Miejsce wydarzenia : <p>${eventDto.place ! "Nie podano"}</p></h6>
                    </div>

                    <div class="property-item">
                        <h6> Organizator wydarzenia : <p>${eventDto.organizer ! "Organizator nie znany"}</p></h6>
                    </div>


                    <div class="property-item">
                        <h6> Data wydarzenia : <p>${eventDto.startDate ! "Data nie znana"}</p></h6>
                    </div>


                    <div class="property-item">
                        <h6> Bilety wydarzenia : <p>${eventDto.tickets ! "Brak informacji o biletach"}</p></h6>
                    </div>

                    <div class="property-item">
                        <h6> <a href="${eventDto.urls ! "brak"}" class="readmore-btn">Find out more</a> </h6>

                    </div>

                </div>

                <div class="col-8">
                    <div class="property-item">
                        <h4> Nazwa wydarzenia : ${eventDto.name ! "Brak nazwy"}</h4>
                        <p>Opis wydarzenia : ${eventDto.descLong ! "Brak opisu"}</p>
                    </div>
                </div>

                <div class="col">

                </div>
            </div>
        </div>
    </section>

<#include "newsletter-section.ftlh">
<#include "footer-section.ftlh">