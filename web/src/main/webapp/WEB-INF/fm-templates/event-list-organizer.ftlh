<#include "header-section.ftlh">
<div class="container_org">
        <tr>
            <td>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/list-events-organizer?pageNumber=0<#if idOrganizer??>&id=${idOrganizer}</#if> ">Pierwsza strona</a></li>
                <#if (previous > -1)>
                    <li class="page-item"><a class="page-link" href="/list-events-organizer?pageNumber=${previous}<#if idOrganizer??>&id=${idOrganizer}</#if>">Poprzednia</a>
                    </li>
                <#else>
                    <li style="display: none " class="page-item"><a class="page-link"
                                                                    href="/list-events-organizer?pageNumber=${previous}<#if idOrganizer??>&id=${idOrganizer}</#if>"></a></li>
                </#if>

                <#if (next < 80)>
                    <li class="page-item"><a class="page-link" href="/list-events-organizer?pageNumber=${next}<#if idOrganizer??>&id=${idOrganizer}</#if>">Następna</a></li>
                <#else>
                    <li style="display: none " class="page-item"><a class="page-link"
                                                                    href="/list-events-organizer?pageNumber=${next}<#if idOrganizer??>&id=${idOrganizer}</#if>"></a>
                    </li>
                </#if>
                <li class="page-item"><a class="page-link" href="/list-events-organizer?pageNumber=${lastPageView}<#if idOrganizer??>&id=${idOrganizer}</#if>">Ostatnia
                        strona</a>
                </li>
            </ul>
            </td>
        </tr>
    </table>
    </div>


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
                    </div>
                </tr>
                </tbody>
            </table>
        </#list>
    </div>
</section>
<#include "footer-section.ftlh">
