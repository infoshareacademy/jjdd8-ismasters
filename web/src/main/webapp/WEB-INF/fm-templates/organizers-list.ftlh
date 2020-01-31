<#include "header-section.ftlh">

<!------ Include the above in your HEAD tag ---------->
<section>
    <div class="container">
        <#list  organizersDtoList as organizerDto>
                <table class="table">

                    <tr>
<<<<<<< HEAD
                        <th></th>
                        <td class="col-lg-2"><a href="/list-events-organizer?id=${organizerDto.idDb}"></a></td>
                        <td class="col-lg-10">
                            <div class="text-center">
                                <h3 class="text-danger"><a href="/list-events-organizer?id=${organizerDto.idDb}">${organizerDto.designation} </a></h3>
                            </div>
=======
                        <td class="col-lg-2"><a href="/single?id=${organizerDto.idDb}"></a></td>
                        <td class="col-lg-10">
                         <h4 class="text-danger"><a href="/single?id=${organizerDto.idDb}">${organizerDto.designation} </a></h4>
>>>>>>> develop
                        </td>
                    </tr>

                </table>
        </#list>
    </div>
</section>
<<<<<<< HEAD


=======
>>>>>>> develop
<#include "footer-section.ftlh">
