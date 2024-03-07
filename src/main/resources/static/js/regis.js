function myRegis() {
    var x = document.getElementById("password1");
    var y = document.getElementById("password2")
    if (x.type === "password" || y.type === "password") {
        x.type = "text";
        y.type = "text"
    } else {
        x.type = "password";
        y.type = "password";
    }
}

function validatePassword(){
    var x = document.getElementById("password1");
    var y = document.getElementById("password2");
    if(y.value != x.value) {
        alert("Passwords Don't Match");
    } else {
        y.setCustomValidity('');
    }
}