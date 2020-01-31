<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->


<section>
    <div class="container">
        <#list  organizersDtoList as organizerDto>
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
                        <td class="col-lg-2"><a href="/single?id=${organizerDto.idDb}"></a></td>
                        <td class="col-lg-10">
                            <div class="text-center">
                                <h3 class="text-danger"><a href="/single?id=${organizerDto.idDb}">${organizerDto.designation} </a></h3>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
        </#list>
    </div>
</section>




<#include "footer-section.ftlh">
