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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
    let id;

    function deleteUser(x) {
        id = x;
        $.ajax({
            type: "DELETE",
            data: {
                id: id
            },
            success: location.reload(true)
        });
    }

    function editUser(x) {
        id = x;
        $.ajax({

                url: 'edit-user?id=' + id,
                method: 'POST',
                data: {
                    id: $('input[name=id]').val(),
                    name: $('input[name=name]').val(),
                    login: $('input[name=login]').val(),
                    password: $('input[name=password]').val(),
                    age: $('input[name=age]').val(),
                },
                success: location.href = 'edit-user?id=' + id
            },
        )
    }
</script>

<title>Edytuj użytkownika</title>


<#if Error??>
    <h3>Błąd!</h3>

<#else>
    <form>
    <#list .data_model?values as value>
        <ul>
            <#if value.id??>
                <li>Id: ${value.id}</li></#if>
            <#if value.name??>
                <li>Name: ${value.name}</li></#if>
            <#if value.login??>
                <li>Login: ${value.login}</li></#if>
            <#if value.password??>
                <li>Password: ${value.password}</li></#if>
            <#if value.age??>
                <li>Age: ${value.age}</li></#if>
            <#if value.gender??>
                <li>Age: ${value.gender}</li></#if>
            <#if value.imageUrl??>
                <li>Image: ${value.imageUrl}</li></#if>

            <p><a href="edit-user?id=${value.id}">Edit user</a><br>
                <a href="" onclick="deleteUser(${value.id})">Delete user</a></p>
            <#--            <#if value.gender??><li>Gender: ${value.gender}</li></#if>-->

            <#--            <input type="submit" value="DELETE" onclick="deleteUser(${value.id})">-->
        </ul>
        </form>
    </#list>
</#if>
<#include "footer-section.ftlh">



