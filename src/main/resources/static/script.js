window.onload = function () {

    document.getElementById("submit").addEventListener("click", getWeightDetails)

    function getWeightDetails() {

        var flightNum = document.getElementById("flightNum").value;
        var dateStr = document.getElementById("dateStr").value;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "/getWeightDetails", true);
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhttp.send("dateStr=" + dateStr + "&flightNum=" + flightNum);
        xhttp.onreadystatechange = function () {
            if (this.status == 200 && this.readyState == 4) {
                document.body.innerHTML = this.responseText;
            } else {
                console.log("WAITNG....")
            }
        }

    }
}