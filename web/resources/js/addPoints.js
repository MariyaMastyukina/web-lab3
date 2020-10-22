document.getElementById('svg').addEventListener('click', e => {
    let svg = document.getElementById('svg');
    let HTMLPoint = svg.createSVGPoint();
    HTMLPoint.x = e.clientX;
    HTMLPoint.y = e.clientY;
    let SVGPoint = HTMLPoint.matrixTransform(svg.getScreenCTM().inverse());
    let cx = SVGPoint.x;
    let cy = SVGPoint.y;
    let r = 0;
    document.getElementsByClassName("text_block:r_value").forEach(button => {
        if (button.classList.contains("r_active")) r = button.value;
    });
    if (r !== 0) {
        createPoint(cx, cy, r);
        savePoints(cx, cy, r, dots);
    } else {
        alert("Выберите знаечние для R");
    }
});

function createPoint(cx, cy, r) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
    circle.setAttribute('cx', cx.toString());
    circle.setAttribute('cy', cy.toString());
    circle.setAttribute('r', "3");
    circle.setAttribute('class', 'points');
    circle.setAttribute('r_value', r.toString());
}

let dots = '';

function savePoints(cx, cy, r) {
    dots += cx.toString() + ';' + cy.toString() + ';' + r.toString() + ';';
    localStorage.setItem('dots', dots);
}