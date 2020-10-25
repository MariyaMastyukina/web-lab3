let r = 0;

function updatePoints() {
    dots = '';
    let arr = Array.prototype.slice.call(document.getElementsByClassName("text_block:r_value"));
    arr.forEach(button => {
        if (button.classList.contains("r_active")) r = button.value;
    });
    document.getElementsByClassName("points").forEach(p => {
        let new_cx = (Number(p.getAttribute('cx')) - 150) * Number(p.getAttribute('r_value')) / r + 150;
        let new_cy = 150 - (150 - Number(p.getAttribute('cy'))) * Number(p.getAttribute('r_value')) / r;
        createPoint(new_cx, new_cy, r);
        savePoints(new_cx, new_cy, r);
    });
}
