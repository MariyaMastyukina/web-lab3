document.getElementsByClassName("text_block:r_value").forEach((button)=> {
    button.addEventListener('click',()=>{
        document.getElementsByClassName("text_block:r_value").forEach((button)=>{
            if (button.classList.contains("r_active")) button.classList.remove("r_active");
            button.style.backgroundColor="red";
        });
        //change color
        button.style.backgroundColor="green";
        button.classList.add("r_active");
        //update SVGpoints
        updatePoints();
    });
});
window.performance=function () {
    let dots=localStorage.getItem('dots').split(';');
    for (let i=0; i<dots.length-2;i+3){
        createPoint(Number(dots[i]),Number(dots[i+1]),Number(dots[i+2]));
    }
}
//some js code
