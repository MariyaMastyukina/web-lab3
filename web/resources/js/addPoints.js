document.getElementById('svg').addEventListener('click', e => {
    e.preventDefault();
    let svg = document.getElementById('svg');
    let HTMLPoint = svg.createSVGPoint();
    HTMLPoint.x = e.clientX;
    HTMLPoint.y = e.clientY;
    let SVGPoint = HTMLPoint.matrixTransform(svg.getScreenCTM().inverse());
    let cx = SVGPoint.x;
    let cy = SVGPoint.y;
    let r = 0;
    Array.prototype.slice.call(document.getElementsByClassName("r_value")).forEach(button => {
        console.log(button.value);
        if (button.classList.contains("r_active")) r = button.value;
    });
    console.log("r = " + r);
    if (r !== 0) {
        let x = (cx - 150) * r / 100;
        let y = (150 - cy) * r / 100;
        sendJsf([{name: "x", value: x}, {name: "y", value: y}, {name: "r", value: r}]);
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
    circle.setAttribute('fill-opacity', "0.3")
    circle.setAttribute('class', 'points');
    circle.setAttribute('r_value', r.toString());
    if (checkArea(cx, cy, r)) {
        circle.setAttribute("fill", "#2E8B57");
        circle.setAttribute('stroke', "#2E8B57");
    } else {
        circle.setAttribute("fill", "#800000");
        circle.setAttribute('stroke', "#800000");
    }
    document.getElementById('svg').appendChild(circle);
}

let dots = '';

function savePoints(cx, cy, r) {
    dots += cx.toString() + ';' + cy.toString() + ';' + r.toString() + ';';
    localStorage.setItem('dots', dots);
    console.log("okey");
}

function checkArea(cx, cy, r) {
    let x = (cx - 150) * r / 100;
    let y = (150 - cy) * r / 100;
    return (x >= 0 && y >= x - r && x * x + y * y <= r * r) || (x <= 0 && y >= 0 && x >= -r / 2 && y <= r);
}


function sendJsf() {

}