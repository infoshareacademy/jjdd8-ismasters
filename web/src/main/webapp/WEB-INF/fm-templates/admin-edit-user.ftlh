<#include "header-section.ftlh">

<br>
<br>
<br>
<br>
<br>
<br>
<title>Edycja użytkownika</title>

<#if error??>
    <h3>Błąd! ${error}</h3>
<#else>
    <h4>Edycja użytkownika</h4>
<form method="POST" action="/admin/edit-user">
        Id: <input type="text" name="id" required="required" readonly value="${id !""}"/><br/>
        Name: <input type="text" name="name" required="required" value="${name !""}"/><br/>
        Email: <input type="text" name="email" required="required" value="${email !""}"/><br/>
        User type: <br/>
    <select name="userType">
        <option value="USER" <#if userType == "USER"> selected</#if>>USER</option>
        <option value="ADMIN" <#if userType == "ADMIN"> selected</#if>>ADMIN</option>
        <option value="SUPER_ADMIN" <#if userType == "SUPER_ADMIN"> selected</#if>>SUPER_ADMIN</option>
    </select>
    <br/><br/>
        <input type="reset" name="reset" value="Reset">
        <input type="submit" name="save" value="Zapisz"><br/><br/>
    </form>
</#if>
<#include "footer-section.ftlh">



