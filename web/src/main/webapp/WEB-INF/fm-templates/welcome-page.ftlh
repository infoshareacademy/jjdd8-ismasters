<#include "header-section.ftlh">
<#include "search-section.ftlh">

<section class="property-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="${eventDto1.attachmentDto.fileName}" alt="">
                        <div class="pi-badge new">Ulubione</div>
                    </div>
                    <h5>${eventDto1.name}</h5>
                    <p>${eventDto1.descShort}</p>
                    <a href="${eventDto1.urls.website}" class="readmore-btn">Dowiedz się więcej</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="${eventDto2.attachmentDto.fileName}" alt="">
                        <div class="pi-badge offer">Ulubione</div>
                    </div>
                    <h5>${eventDto2.name}</h5>
                    <p>${eventDto2.descShort}</p>
                    <a href="${eventDto2.urls.website}" class="readmore-btn">Dowiedz się więcej</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="${eventDto3.attachmentDto.fileName}" alt="">
                        <div class="pi-badge new">Ulubione</div>
                    </div>

                    <h5>${eventDto3.name}</h5>
                    <p>${eventDto3.descShort}</p>
                    <a href="${eventDto3.urls.website}" class="readmore-btn">Dowiedz się więcej</a>
                </div>
            </div>
        </div>
    </div>
</section>
<#include "newsletter-section.ftlh">
<#include "article-section.ftlh">
<#include "footer-section.ftlh">