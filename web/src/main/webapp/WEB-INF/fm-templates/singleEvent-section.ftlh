<#include "header-section.ftlh">
<#include "search-section.ftlh">
<section class="property-section">
    <div class="container">
        <div class="section-title">
            <dl class="row">
                <dt class="col-sm-3">Description lists</dt>
                <dd class="col-sm-9">A description list is perfect for defining terms.</dd>
                <dt class="col-sm-3">Nazwa Wydarzenia</dt>
                <dd class="col-sm-9">
                    <p>{EventDTO_mock.getName}</p>
                </dd>
                <dt class="col-sm-3">Długi opis wydarzenia</dt>
                <dd class="col-sm-9">{EventDTO_mock.getLongDescription}</dd>
                <dt class="col-sm-3 text-truncate">Organizator/dt>
                <dd class="col-sm-9">{EventDTO_mock.getOrganizer}</dd>
                <dt class="col-sm-3 text-truncate">Miejsce/dt>
                <dd class="col-sm-9">{EventDTO_mock.getPlace}</dd>
            </dl>
        </div>
    </div>
</section>
<#include "footer-section.ftlh">