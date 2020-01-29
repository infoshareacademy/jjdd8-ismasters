$(function() {
    $("#result-div").hide();
});
$('#eventsearch').keyup(function (e) {
    console.log("dziala");
    e.preventDefault(); // Prevent the form from submitting via the browser
    $("#result-div").html("");
    if($('#eventsearch').val().length >=3) {
        $.ajax({
            type: "GET",
            url: "/api/search/" + $('#eventsearch').val()+"?startDate="+ $('#datepicker').val() +"&endDate="+  $('#datepicker2').val(),
            enctype: 'application/json; charset=UTF-8',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8'
        })
            .done(
                function (data) {
                    $("#result-div").show();
                    if (data.length==0){
                        return;
                    }
                    $.each(data, function (i, item) {
                        $("#result-div").append('<a href="/single?id='+item.id+'" class="list-group-item list-group-item-action list-group-item-primary">'+item.name+', '+item.organizer.designation+'</a>');
                    });
                })
            .fail(
                function () {
                    $("#result-div").show();
                    $("#result-div").html("");
                });
    }
});