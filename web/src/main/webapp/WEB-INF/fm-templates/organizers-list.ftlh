<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->
<section>
    <div class="container_org">
        <table class="table">
            <#list  organizersDtoList as organizerDto>
                <tr>
                    <h4 class="text-danger"><a href="/list-events-organizer?id=${organizerDto.idDb}&pageNumber=0">${organizerDto.designation} </a></h4>
                    <hr style="width:50%;height:1px;border:none;color:#ccc;background-color:#ccc;" />
                </tr>
            </#list>
        </table>
    </div>
</section>
<#include "footer-section.ftlh">
