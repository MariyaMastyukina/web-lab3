function currentTime() {
    var currentTime=new Date();
    var hours=currentTime.getHours();
    var minutes=currentTime.getMinutes();
    var seconds=currentTime.getSeconds();
    if (minutes<10){
        minutes='0'+minutes;
    }
    if (seconds<10){
        seconds='0'+seconds;
    }
    document.getElementById('date').innerHTML=currentTime.getFullYear()+"."+currentTime.getMonth()+"."+currentTime.getDate();
    document.getElementById('hours').innerHTML=hours+":";
    document.getElementById('minutes').innerHTML=minutes+":";
    document.getElementById('seconds').innerHTML=seconds;
}
setInterval(currentTime,7000);