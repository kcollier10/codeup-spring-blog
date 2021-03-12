// "use strict";
//
//     let hamburger = document.getElementById('hamburgerbtn');
//
//     let mobileMenu = document.getElementById('mobileMenu');
//
//     hamburger.addEventListener('click', function(){
//     mobileMenu.classList.toggle('active');
// });
$(document).ready(function(){

    $("#myform").submit(function(){

        let search = $("#books").val();
        if(search === "")
        {
            alert("Please enter something in the field");
        }
        else{
            let url = "";
            let img = "";
            let title = "";
            let author = "";

            // $.get("https://www.googleapis.com/books/v1/volumes?q=" + search,function(response){
            $.get("https://www.googleapis.com/books/v1/volumes?q=&key=" + $[keys]+ search, function (response){

                for(let i=0;i<response.items.length;i++)
                {
                    title=$('<h5 class="center-align white-text">' + response.items[i].volumeInfo.title + '</h5>');
                    author=$('<h5 class="center-align white-text"> By:' + response.items[i].volumeInfo.authors + '</h5>');
                    img = $('<img class="aligning card z-depth-5" id="dynamic" alt="image"><br><a href=' + response.items[i].volumeInfo.infoLink + '><button id="imagebutton" class="btn red aligning">Read More</button></a>');
                    url= response.items[i].volumeInfo.imageLinks.thumbnail;
                    img.attr('src', url);
                    title.appendTo('#result');
                    author.appendTo('#result');
                    img.appendTo('#result');
                }
            });

        }
        return false;
    });

});