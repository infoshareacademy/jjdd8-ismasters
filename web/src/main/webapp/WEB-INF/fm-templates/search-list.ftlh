<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->


<section>
    <div class="container">
        <#list  eventDtoList as eventDto>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th></th>
                        <td class="col-lg-2"><a href="/single?id=${eventDto.id}"></a></td>
                        <td class="col-lg-10">
                            <div class="text-center">
                                <h3 class="text-danger"><a href="/single?id=${eventDto.id}">${eventDto.name} </a></h3>
                                <h3>Organizator: ${eventDto.name} </h3>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
        </#list>
    </div>
</section>

<div class="container">
    <div class="col-sm-12 col-lg-12 row">
<#--        <nav aria-label="Pagination">-->
<#--            <ul class="pagination">-->
<#--                <li class="page-item"><a class="page-link" href="/list-events?pageNumber=0">Pierwsza strona</a></li>-->
<#--                <#if (previous > -1)>-->
<#--                    <li class="page-item"><a class="page-link" href="/list-events?pageNumber=${previous}">Poprzednia</a>-->
<#--                    </li>-->

<#--                <#else>-->
<#--                    <li style="display: none " class="page-item"><a class="page-link"-->
<#--                                                                    href="/list-events?pageNumber=${previous}"></a></li>-->
<#--                </#if>-->

<#--                <#if (next < 80)>-->
<#--                    <li class="page-item"><a class="page-link" href="/list-events?pageNumber=${next}">Następna</a></li>-->

<#--                <#else>-->
<#--                    <li style="display: none " class="page-item"><a class="page-link" href="/list-events?pageNumber=${next}"></a>-->
<#--                    </li>-->
<#--                </#if>-->
<#--                <li class="page-item"><a class="page-link" href="/list-events?pageNumber=${lastPageView}">Ostatnia strona</a>-->
<#--                </li>-->
<#--            </ul>-->
<#--        </nav>-->
    </div>
</div>


<#include "footer-section.ftlh">
