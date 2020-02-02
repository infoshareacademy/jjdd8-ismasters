<#include "header-section.ftlh">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<section>
    <div class="container">
        <#list userDtoList as userDto>
            <table class="table">
                <tbody>
                <tr>
                    <div class="text-center">
                        <h4>${userDto.name ! ""} </h4>
                        <h4>${userDto.email ! ""}</h4>
                        <h4>${userDto.userType ! ""}</h4>
                        <a href="/admin/edit-user?id=${userDto.id}"><i class="material-icons" title="Edit">&#xE15C;</i></a>
                        <a href="/"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        <hr style="width:50%;height:1px;border:none;color:#ccc;background-color:#ccc;" />
                    </div>
                </tr>
                </tbody>
            </table>
        </#list>
    </div>
</section>
<#include "footer-section.ftlh">
