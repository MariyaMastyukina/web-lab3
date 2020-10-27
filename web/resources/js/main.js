Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach((button) => {
    button.addEventListener('click', () => {
        Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach((button) => {
            if (button.classList.contains("r_active")) button.classList.remove("r_active");
            button.style.backgroundColor = "#E6E6FA";
        });
        //change color
        button.style.backgroundColor = "#D8BFD8";
        button.classList.add("r_active");
        //update SVG points
        updatePoints();
    });
});
document.getElementById("text_block:submit").addEventListener("click", () => {
    let r = 0;
    let x = document.getElementById("text_block:x_value").value;
    let y = document.getElementById("text_block:y_value").value;
    Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach(button => {
        console.log(button.value);
        if (button.classList.contains("r_active")) r = button.value;
    });
   // alert(x + " " + y);
    createPoint(x * 100 / r + 150, 150 - y * 100 / r, r);
    savePoints(x * 100 / r + 150, 150 - y * 100 / r, r, dots);
});


