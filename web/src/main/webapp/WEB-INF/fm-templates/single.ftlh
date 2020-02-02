<#ftl output_format="plainText" auto_esc=false>
<#include "header-section.ftlh">
    <br>
    <br>
    <section class="property-section" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <div class="container">
        </br>
        <div class="row">
            <div class="col-3">
                <#if placeDto.name??>
                <div class="property-item">
                    <h6> Miejsce: <p>${placeDto.name ! "Nie podano"}</p></h6>
                </div>
                </#if>


                <div class="property-item">
                    <#if addressDto.street??>
                    <h6> Adres: <br>${addressDto.street ! "Nie podano"}</br></#if>
                        <#if addressDto.city??> ${addressDto.city ! "Nie podano"}</p></h6>
                </div>
                </#if>

                <#if organizerDto.designation??>
                <div class="property-item">
                    <h6> Organizator: <p>${organizerDto.designation ! "Organizator nieznany"}</p></h6>
                </div>
                </#if>

                <#if date??>
                <div class="property-item">
                    <h6> Data: <p>${date ! "Data nieznana"}</p></h6>
                </div>
                </#if>

                <#if eventDto.tickets??>
                <div class="property-item">
                    <h6> Bilety: <p>${eventDto.tickets ! "Brak informacji o biletach"}</p></h6>
                </div>
                </#if>

                <#if urlDto.website??>
                <div class="property-item">
                    <h6> <a href="${urlDto.website ! "javascript:void(0);"}" class="readmore-btn" target="_blank">Dowiedz się więcej</a> </h6>
                </div>
                </#if>

            </div>

            <div class="col-8">
                <div class="property-item">
                    <h4> ${eventDto.name ! "Brak nazwy"}</h4>
                    <p> ${eventDto.descLong ! "Brak opisu"}</p>
                    <#if eventDto.attachmentDto.fileName??><img src="${eventDto.attachmentDto.fileName}" alt="" width="50%" height="50%" </#if>>
                </div>
            </div>
        </div>
    </div>
</section>
<#include "footer-section.ftlh">