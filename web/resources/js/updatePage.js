if (window.performance){
    let points = localStorage.getItem('dots').split(';');
    for (let i = 0; i < points.length - 2; i += 3) {
        createPoint(Number(points[i]),Number(points[i + 1]),Number(points[i + 2]));
        savePoints(Number(points[i]),Number(points[i + 1]),Number(points[i + 2]));
    }
}