let r = 0;

function updatePoints() {
    if (dots!=='') {
        dots = '';
        Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach((button) => {
            if (button.classList.contains("r_active")) r = button.value;
        });
        document.querySelectorAll("circle").forEach((e) => e.remove());
        let points = localStorage.getItem('dots').split(';');
        alert(points);
        for (let i = 0; i < points.length - 2; i += 3) {
            let new_cx = (Number(points[i]) - 150) * Number(points[i + 2]) / r + 150;
            let new_cy = 150 - (150 - Number(points[i + 1])) * Number(points[i + 2]) / r;
            createPoint(new_cx, new_cy, r);
            savePoints(new_cx, new_cy, r);
        }
    }
}

