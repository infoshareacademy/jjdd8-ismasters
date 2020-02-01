<#include "header-section.ftlh">
<br>
<br>
<br>
<br>
<br>
<br>
<form method="post" action="/admin/upload" enctype="multipart/form-data">
    <h2>Wgraj plik z repozytorium w formacie JSON</h2><br>
    Organizers: <input type="file" name="organizers"/><br/>
    Places: <input type="file" name="places"/><br/>
    Events: <input type="file" name="events"/><br/>
    <input type="submit" name="save" value="Add file"/><br/><br/>
</form>
<#include "footer-section.ftlh">
