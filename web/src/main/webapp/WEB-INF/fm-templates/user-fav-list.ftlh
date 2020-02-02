<#include "header-section.ftlh">
<section>
    <div class="container">
        <#list eventDtoList as eventDto>
            <table class="table">
                <tbody>
                <tr>
                    <div class="text-center">
                        <h4 class="text-danger"><a href="/single?id=${eventDto.id}">${eventDto.name} </a></h4>
                        <h4>Organizator: ${(eventDto.organizer.designation) ! "Brak danych"} </h4>
                        <hr style="width:50%;height:1px;border:none;color:#ccc;background-color:#ccc;" />
                        <#if logged == "yes" >
                            <a href="" onclick="deleteFav(${eventDto.id})">Usuń z ulubionych!</a>
                        </#if>
                    </div>
                </tr>
                </tbody>
            </table>
        </#list>
    </div>
</section>
<#include "footer-section.ftlh">
