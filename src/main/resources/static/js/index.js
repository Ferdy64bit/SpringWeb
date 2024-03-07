const inputs = document.querySelectorAll(".input");

function addcl() {
    let parent = this.parentNode.parentNode;
    parent.classList.add("focus");
}

function remcl() {
    let parent = this.parentNode.parentNode;
    if (this.value == "") {
        parent.classList.remove("focus");
    }
}

inputs.forEach((input) => {
    input.addEventListener("focus", addcl);
    input.addEventListener("blur", remcl);
});

let password = document.getElementById("password");
let password1 = document.getElementById("password1");
let Eye1 = document.getElementById("eyeicon1");
let Eye2 = document.getElementById("eyeicon2");
Eye1.onclick = function () {
    if (password.type == "password") {
        password.type = "text";
        Eye1.className = "fa-solid fa-eye";
        if (password1.type == "password") {
            password1.type = "text";
            Eye2.className = "fa-solid fa-eye";
        } else {
            password1.type = "password";
            Eye2.className = "fa-solid fa-eye-slash";
        }
    } else {
        password.type = "password";
        Eye1.className = "fa-solid fa-eye-slash";
    }
};