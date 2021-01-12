$(function(){
    $('#table tr').click(function() { 
        var customerId = $(this).find("th:first").html(); 
        console.log(customerId);
    });
});