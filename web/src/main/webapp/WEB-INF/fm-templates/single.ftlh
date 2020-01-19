<#include "header-section.ftlh">
<#include "search-section.ftlh">

<section class="property-section">
    <div class="container">
        <div class="section-title">
            <h2>Widok pojedynczego wydarzenia</h2>
        </div>
        <div class="row">
            <div class="col">

                <div class="property-item">
                    <h5> Miejsce wydarzenia : ${eventDTO_mock.place}</h5>
                </div>

                <div class="property-item">
                    <h5> Organizato wydarzenia : ${eventDTO_mock.organizer}</h5>
                </div>


                <div class="property-item">
                    <h5> Data wydarzenia : ${eventDTO_mock.startDate}</h5>
                </div>


                <div class="property-item">
                    <h5> Bilety wydarzenia : ${eventDTO_mock.tickets}</h5>
                </div>

                <div class="property-item">
                    <a href="${eventDTO_mock.urls}" class="readmore-btn">Find out more</a>
                </div>

            </div>

            <div class="col-10">
                <div class="property-item">
                    <h5> Nazwa wydarzenia : ${eventDTO_mock.name}</h5>
                    <p>Opis wydarzenia : ${eventDTO_mock.descLong}</p>
                </div>
            </div>

            <div class="col">

            </div>
        </div>
    </div>
</section>
<#include "newsletter-section.ftlh">
<#include "footer-section.ftlh">