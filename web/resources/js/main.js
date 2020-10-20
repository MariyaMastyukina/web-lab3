document.getElementsByClassName("r_value").forEach((button)=> {
    button.addEventListener('click',()=>{
        document.getElementsByClassName("r_value").forEach((button)=>{
            if (button.classList.contains("R_active")) button.classList.remove("R_active");
        });
        button.classList.add("R_active");
    });
});
//some js code
