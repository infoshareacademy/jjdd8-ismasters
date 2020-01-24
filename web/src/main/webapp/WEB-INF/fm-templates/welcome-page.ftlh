<#include "header-section.ftlh">
<#include "search-section.ftlh">

<section class="property-section">
    <div class="container">
        <div class="section-title">
            <h2>Ulubione wydarzenia</h2>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="/img/1.jpg" alt="">
                        <div class="pi-badge new">Ulubione</div>
                    </div>
                    <h5>${eventDTO_mock.name}</h5>
                    <p>${eventDTO_mock.descShort}</p>
                    <a href="${eventDTO_mock.urls}" class="readmore-btn">Find out more</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="/img/2.jpg" alt="">
                        <div class="pi-badge offer">Ulubione</div>
                    </div>
                    <h5>${eventDTO_mock.name}</h5>
                    <p>${eventDTO_mock.descShort}</p>
                    <a href="${eventDTO_mock.urls}" class="readmore-btn">Find out more</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="/img/3.jpg" alt="">
                        <div class="pi-badge new">Ulubione</div>
                    </div>

                    <h5>${eventDTO_mock.name}</h5>
                    <p>${eventDTO_mock.descShort}</p>
                    <a href="${eventDTO_mock.urls}" class="readmore-btn">Find out more</a>
                </div>
            </div>
        </div>
    </div>
</section>
<#include "newsletter-section.ftlh">
<#include "article-section.ftlh">
<#include "footer-section.ftlh">