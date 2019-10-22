$(document).ready(function () {
    $('#getSum').click(function (e) {
        e.preventDefault()
        var num1 = $("#num1").val()
        var num2 = $("#num2").val()
        $.ajax({
            url: "/math/data/server/"+num1+"/"+num2,
            type : 'GET',
            success: function (e) { $("#getSum").show(); $("#getSum").text(e) },
            error: function (e) { console.log(e) }
        });
    });
})