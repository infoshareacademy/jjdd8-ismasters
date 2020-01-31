<#include "header-section.ftlh">
<body>
<div class="container bg-white text-white">
    <div class="btn-group">
        <button type="button" class="btn btn-danger dropdown-toggle " data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
           Zarządzanie wydarzeniami
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="/admin/add-book">Dodaj</a>
            <a class="dropdown-item" href="/admin/list-book">Lista</a>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            Użytkownicy
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" id="1" href="#">dodaj</a>
            <a class="dropdown-item" id="3" href="#">edytuj</a>
            <a class="dropdown-item" id="2" href="#">usuń</a>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            Ulubione
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">usuń</a>
        </div>
    </div>
    <div class="container" style="margin-top:30px">
        <#if content??>
            <#include "/${content}">
        </#if>
    </div>
</div>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body" style="color: #0b0b0b" >
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="location.reload()">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
<#include "footer-section.ftlh">