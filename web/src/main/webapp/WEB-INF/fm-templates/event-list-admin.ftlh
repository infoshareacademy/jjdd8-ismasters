<#include "header-section.ftlh">
<div class="container_org">
    <table width="100%" align="center">
        <tr>
            <td>
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/event-list-admin?pageNumber=0">Pierwsza strona</a></li>
                    <#if (previous > -1)>
                        <li class="page-item"><a class="page-link" href="/event-list-admin?pageNumber=${previous}">Poprzednia</a>
                        </li>
                    <#else>
                        <li style="display: none " class="page-item"><a class="page-link"
                                                                        href="/event-list-admin?pageNumber=${previous}"></a></li>
                    </#if>

                    <#if (next < 80)>
                        <li class="page-item"><a class="page-link" href="/event-list-admin?pageNumber=${next}">Następna</a></li>
                    <#else>
                        <li style="display: none " class="page-item"><a class="page-link"
                                                                        href="/event-list-admin?pageNumber=${next}"></a>
                        </li>
                    </#if>
                    <li class="page-item"><a class="page-link" href="/event-list-admin?pageNumber=${lastPageView}">Ostatnia
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
                        <a href="/single?id=${eventDto.id}"><i class="material-icons" title="Edit">&#xE15C;</i></a>
                        <a href="/admin/delete/${eventDto.id}">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                        </a>
                    </div>
                </tr>
                </tbody>
            </table>
        </#list>
    </div>
</section>
<#include "footer-section.ftlh">
