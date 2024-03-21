function validatePasswords() {
    const pass1 = document.getElementById("password").value;
    const pass2 = document.getElementById("password2").value;
    const matchMessage = document.getElementById("password-match");
    const mismatchMessage = document.getElementById("password-mismatch");

    if (pass1 === pass2) {
        matchMessage.style.display = "block";
        mismatchMessage.style.display = "none";
    } else {
        matchMessage.style.display = "none";
        mismatchMessage.style.display = "block";
    }
}