// "use strict";
//
//     let hamburger = document.getElementById('hamburgerbtn');
//
//     let mobileMenu = document.getElementById('mobileMenu');
//
//     hamburger.addEventListener('click', function(){
//     mobileMenu.classList.toggle('active');
// });
function randomQuote() {
    $.ajax({
        url: "https://api.forismatic.com/api/1.0/?",
        dataType: "jsonp",
        data: "method=getQuote&format=jsonp&lang=en&jsonp=?",
        success: function( response ) {

            $("#random_quote").append("<p id='random_quote' class='lead text-center'>" +
                response.quoteAuthor + "<br/>&dash; " + response.quoteAuthor + " &dash;</p>");
        }
    });
}

$(function() {
    randomQuote();
});

$("button").click(function(){
    randomQuote();
});