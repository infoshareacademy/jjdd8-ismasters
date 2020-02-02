function postFav(x) {

    $.ajax({
        url: "/list-events",
        method: "POST",
        data: {id: x},
        success: function () {
            location.reload();
            alert('Wydarzenie dodane do listy ulubionych')
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
            location.reload();
            alert('WYDARZENIE USUNIĘTE Z LISTY ULUBIONYCH')
        },
    });
}



