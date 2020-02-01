<#include "header-section.ftlh">


<h1>Dodaj nowego użtkownika do bazy</h1>
<form method="post" action="/add-event" enctype="multipart/form-data">
    Nazwa użytkownika: <input type="text" name="name"/><br/><br/>
    Mail użytkownika: <input type="LocalDateTime" name="login"/><br/><br/>
    Typ użytkownika: <input type="LocalDateTime" name="password"/><br/><br/>
    </select><br/><br/>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>


<#include "footer-section.ftlh">