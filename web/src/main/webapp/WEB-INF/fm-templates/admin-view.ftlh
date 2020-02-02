<#include "header-section.ftlh">
<section class="property-section">
    <div class="container">
        </br>
        </br>
        </br>
        <h1> Panel Admina</h1>
<#--        <div class="row">-->
<#--            <div class="col-lg-6 col-md-6 col-sm-12">-->
<#--                <h4> Zarządzanie wydarzeniami</h4>-->
<#--                <a href="/admin/add-event" class="readmore-btn">-->
<#--                <button type="button" class="btn btn-primary btn-lg btn-block">Dodaj wydarzenie </button>-->
<#--                </a>-->
<#--                <a href="/admin/event-list?pageNumber=0" class="readmore-btn">-->
<#--                    <br>-->
<#--                    <button type="button" class="btn btn-primary btn-lg btn-block">Edytuj / Usuń wydarzenia </button>-->
<#--                </a>-->

<#--            </div>-->
         <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12">
                <h4>Ładowanie danych z pliku</h4>
                <a href="/admin/upload" class="readmore-btn">
                    <br>
                    <button type="button" class="btn btn-primary btn-lg btn-block">Załaduj pliki do bazy</button>
                </a>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12">
                <h4> Zarządzanie użytkownikami</h4>
                <a href="/admin/add-user" class="readmore-btn">
                    <button type="button" class="btn btn-primary btn-lg btn-block">Dodaj użytkownika </button>
                </a>
                <a href="/admin/user-list" class="readmore-btn">
                    <br>
                    <button type="button" class="btn btn-primary btn-lg btn-block">Edytuj / Usuń użytkownika </button>
                </a>
            </div>
        </div>
        <br>

    </div>
</section>
<#include "footer-section.ftlh">