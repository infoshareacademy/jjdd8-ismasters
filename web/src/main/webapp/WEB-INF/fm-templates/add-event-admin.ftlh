<#include "header-section.ftlh">


<h1>Dodaj nowe wydarzenie do bazy</h1>
<form method="post" action="/add-event" enctype="multipart/form-data">
    Nazwa Wydarzenia: <input type="text" name="name"/><br/><br/>
    Data rozpoczęcia: <input type="LocalDateTime" name="login"/><br/><br/>
    Data zakończenia: <input type="LocalDateTime" name="password"/><br/><br/>
    Krótki opis: <input type="text" name="password"/><br/><br/>
    Organizator: <input type="text" name="password"/><br/><br/>
    Link do wydarzenia: <input type="password" name="password"/><br/><br/>
    </select><br/><br/>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>


<#include "footer-section.ftlh">