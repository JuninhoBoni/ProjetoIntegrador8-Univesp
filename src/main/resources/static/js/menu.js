$(document).ready(function(){
    $('.navbar-xbootstrap').click(function(){
      $('.nav-xbootstrap').toggleClass('visible');
      $('body').toggleClass('cover-bg');
    });
  });

function myFunction() {
    let elementBody = document.body;
    if (elementBody.style.backgroundColor != "black") {
        elementBody.style.backgroundColor = "black";
        elementBody.style.color = "yellow";
    } else {
        elementBody.style.backgroundColor = "white";
        elementBody.style.color = "black";
    }
}

