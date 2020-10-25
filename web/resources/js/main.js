Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach((button) => {
    button.addEventListener('click', () => {
        Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach((button) => {
            if (button.classList.contains("r_active")) button.classList.remove("r_active");
            button.style.backgroundColor = "#E6E6FA";
        });
        //change color
        button.style.backgroundColor = "#D8BFD8";
        button.classList.add("r_active");
        //update SVGpoints
        updatePoints();
    });
});
document.getElementById("reset_button").addEventListener('click',()=>{
    document.querySelectorAll("circle").forEach((e) => e.remove());
    localStorage.setItem('dots','');
    dots='';
});

