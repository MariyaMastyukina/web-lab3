function currentTime() {
    let currentTime = new Date();
    let hours=currentTime.getHours();
    let minutes = currentTime.getMinutes();
    let seconds = currentTime.getSeconds();
    let day = currentTime.getDate();
    let month = currentTime.getMonth();
    if(hours<10){
        hours="0" + hours;
    }
    if (minutes < 10) {
        minutes = '0' + minutes;
    }
    if (seconds < 10) {
        seconds = '0' + seconds;
    }
    if (day < 10) {
        day = '0' + day;
    }
    if (month < 10) {
        month = '0' + month;
    }
    document.getElementById('date').innerHTML = day + "." + month + "." + currentTime.getFullYear();
    document.getElementById('hours').innerHTML = hours + ":";
    document.getElementById('minutes').innerHTML = minutes + ":";
    document.getElementById('seconds').innerHTML = seconds;
}
currentTime();
setInterval(currentTime, 7000);