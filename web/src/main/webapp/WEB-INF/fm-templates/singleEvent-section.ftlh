<#include "header-section.ftlh">
<#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
</#if>

<#if event??>
    <section class="property-section">
        <div class="box">
            <div class="title">
                <h1>${event.name}</h1>
            </div>
            <div class="subcontainer">
                <div class="leftBanner">
                    <div class="leftBannerChild1">
                        ${event.organizer}<br>
                        ${event.startDate}
                    </div>
                <div class="leftBannerChild2">
                        <input type="submit" name="favAdd" value="Dodaj do ulubionych">
                        <input type="submit" name="edit" value="Edytuj">
                </div>
            </div>
            <div class="submain">
                ${event.descLong}
            </div>
            </div>
        </div>
    </section>
</#if>
<#include "footer-section.ftlh">