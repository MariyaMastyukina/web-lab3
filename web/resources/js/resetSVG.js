document.getElementById("text_block:reset_button").addEventListener('click',()=>{
    document.querySelectorAll("circle").forEach((e) => e.remove());
    localStorage.setItem('dots','');
    dots='';
});