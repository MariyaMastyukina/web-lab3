document.getElementsByClassName("text_block:r_value").forEach((button)=> {
    button.addEventListener('click',()=>{
        document.getElementsByClassName("text_block:r_value").forEach((button)=>{
            if (button.classList.contains("r_active")) button.classList.remove("r_active");
        });
        //change color
        button.classList.add("r_active");
        //update SVGpoints
    });
});

//some js code
