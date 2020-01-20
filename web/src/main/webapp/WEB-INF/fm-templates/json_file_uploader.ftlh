<!DOCTYPE html>
<html lang="pl-PL" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="cache-control" content="no-store, no-cache, must-revalidate">
    <meta http-equiv="cache-control" content="post-check=0, pre-check=0">
    <meta http-equiv="pragma" content="no-cache">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <title>Load JSON file</title>
</head>
<body>
<form method="post" action="/admin/upload" enctype="multipart/form-data">
<h2>Wgraj plik z repozytorium w formacie JSON</h2><br>
    Organizers: <input type="file" name="organizers"/><br/>
    Places: <input type="file" name="places"/><br/>
    Events: <input type="file" name="events"/><br/>
    <input type="submit" name="save" value="Add file"/><br/><br/>
</form>
</body>
</html>

