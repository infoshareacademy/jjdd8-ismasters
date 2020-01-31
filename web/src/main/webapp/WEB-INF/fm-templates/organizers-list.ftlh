<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->
<section>
    <div class="container">
        <#list  organizersDtoList as organizerDto>
                <table class="table">

                    <tr>
                        <td class="col-lg-2"><a href="/single?id=${organizerDto.idDb}"></a></td>
                        <td class="col-lg-10">
                         <h4 class="text-danger"><a href="/single?id=${organizerDto.idDb}">${organizerDto.designation} </a></h4>
                        </td>
                    </tr>

                </table>
        </#list>
    </div>
</section>
<#include "footer-section.ftlh">
