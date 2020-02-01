<#include "header-section.ftlh">
<section>
    <div class="container">
        <#list userDtoList as userDto>
            <table class="table">
                <tbody>
                <tr>
                    <div class="text-center">
                        <h4 class="text-danger">${userDto.name} </h4>
                        <h4 class="text-danger">${userDto.email}</h4>
                        <h4 class="text-danger">${userDto.userType}</h4>
                        <hr style="width:50%;height:1px;border:none;color:#ccc;background-color:#ccc;" />
                        <a href="/"><i class="material-icons" title="Edit">&#xE15C;</i></a>
                        <a href="/">
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
