<#include "header-section.ftlh">

<br>
<br>
<br>
<br>
<br>
<h1>Dodaj nowe wydarzenie do bazy</h1>
<form method="post" action="/admin/add-event" >
    Nazwa Wydarzenia: <input type="text" name="name"/><br/><br/>
    Data rozpoczęcia: <input value="mm/dd/YYYY" type="text" name="startDate"/><br/><br/>
    Data zakończenia: <input value="mm/dd/YYYY" type="text" name="endDate"/><br/><br/>
    Krótki opis: <input  type="text" name="descShort"/><br/><br/>
    Długi opis: <input type="text" name="descLong"/><br/><br/>
<#--    Link do wydarzenia: <input type="text" name="link"/><br/><br/>-->
    </select><br/><br/>
    <input type="submit" name="save" value="Zapisz"/><br/><br/>
</form>


<#include "footer-section.ftlh">