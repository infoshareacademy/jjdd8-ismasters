<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->
<section>
    <div class="container">
        <table class="table">
            <#list  organizersDtoList as organizerDto>
                <tr>
                    <td class="col-lg-2"><a href="/single?id=${organizerDto.idDb}"></a></td>
                    <h4 class="text-danger"><a href="/single?id=${organizerDto.idDb}">${organizerDto.designation} </a></h4>
                </tr>
            </#list>
        </table>
    </div>
</section>
<#include "footer-section.ftlh">
