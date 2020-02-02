function postFav(x) {

    $.ajax({
        url: "/list-events",
        method: "POST",
        data: {id: x},
        success: function () {
            confirm('Wydarzenie dodane do listy ulubionych');
            location.reload();
        },
        error: function (error) {
            alert('Nie można dodać wydarzenia do ulubionych. Maksymalna liczba wydarzeń ulubionych wynosi 3');
        }
});
}

function deleteFav(x) {
    $.ajax({
        url: "/favorite-events-list",
        method: "DELETE",
        data: {id: x},
        success: function () {
            confirm('WYDARZENIE USUNIĘTE Z LISTY ULUBIONYCH');
            location.reload();
        },
    });
}

function deleteUser(x) {
    $.ajax({
        url: "/admin/user-list",
        method: "DELETE",
        data: {id: x},
        success: function () {
            confirm('USER USUNIĘTY Z LISTY ULUBIONYCH');
            location.reload();
        },
    });
}



