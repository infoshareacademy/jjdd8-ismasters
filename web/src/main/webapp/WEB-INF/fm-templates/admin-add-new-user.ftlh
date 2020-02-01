<#include "header-section.ftlh">

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h1>Dodaj nowego użytkownika do bazy</h1>
<form method="post" action="/admin/add-user">
    Nazwa użytkownika: <input type="text" name="name"/><br/>
    Mail użytkownika: <input type="text" name="mail"/><br/>
    Typ użytkownika: <br/>
    <select name="userRole">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
    </select><br/><br/>
    <input type="submit" name="DODAJ" value="DODAJ"/><br/><br/>
</form>

<#include "footer-section.ftlh">