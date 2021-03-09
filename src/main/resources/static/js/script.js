window.onload = function () {

    var button = document.getElementsByClassName("button");
    for (let i = 0; i < button.length; i++) {
        button[i].addEventListener("click", function () {
            if (!button[i].className.includes(" on")) {
                $(".Welcome").css("display", "none");
                hideContent();
                showContent(i);

            }
        });
    }

    function getWeightDetails() {

        var flightNum = document.getElementById("flightNum").value;
        var dateStr = document.getElementById("dateStr").value;
        var res;

        if(!validateWeightsInput(flightNum, dateStr)){
            return alert("Incorrect input!");
        }

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "/getWeightDetails", true);
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhttp.send("dateStr=" + dateStr + "&flightNum=" + flightNum);
        xhttp.onreadystatechange = function () {
            if (this.status == 200 && this.readyState == 4) {
                res = JSON.parse(this.responseText);
                if (!checkRes(res)){
                    return alert("Receiving data error, please try again")
                }
                $(".respond").eq(0).children().css("display", "flex");
                $(".input").eq(0).html(flightNum);
                $(".input").eq(1).html(dateStr);
                $(".table").eq(0).css("display", "table");
                $(".col").eq(0).children().eq(0).html(res.totalBaggage);
                $(".col").eq(0).children().eq(1).html(res.totalCargo);
                $(".col").eq(0).children().eq(2).html(res.totalWeight);

            }
            else if (this.status == 404){
                return alert("Not found in DB!")
            }
            else {
                console.log("WAITNG....")
            }
        }

    }

    function getAirportDetails() {

        var res;
        var string = document.getElementById("airCode").value;
        var dateStr = document.getElementById("dateStr2").value;
        var airCode = string.toUpperCase();

        if (!validateAirportInput(airCode, dateStr)){
            return alert("Incorrect input!");
        }

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "/getAirportDetails", true);
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhttp.send("dateStr=" + dateStr + "&airCode=" + airCode);
        xhttp.onreadystatechange = function () {
            if (this.status == 200 && this.readyState == 4) {
                res = JSON.parse(this.responseText);
                if (!checkRes(res)){
                    return alert("Receiving data error, please try again")
                }
                $(".respond").eq(1).children().css("display", "flex");
                $(".input").eq(2).html(airCode);
                $(".input").eq(3).html(dateStr);
                $(".table").eq(1).css("display", "table");
                $(".col").eq(1).children().eq(0).html(res.numOfFlightDep);
                $(".col").eq(1).children().eq(1).html(res.totalNumOfBaggDep);
                $(".col").eq(1).children().eq(2).html(res.numOfFlightArr);
                $(".col").eq(1).children().eq(3).html(res.totalNumOfBaggArr);

            }
            else if (this.status == 404){
                return alert("Not found in DB!")
            }
            else {
                console.log("WAITNG....")
            }
        }
    }

    function showContent(index) {

        $(".button").eq(index).toggleClass("on");
        $(".text").eq(index).show("slow");
        $(".form").eq(index).slideDown("slow");
        switch (index) {
            case 0: $("#submit0").click(getWeightDetails);
            break;

            case 1: $("#submit1").click(getAirportDetails);
            break;
        }
    }

    function hideContent() {
        for (let i = 0; i < button.length; i++) {
            $(".button").eq(i).removeClass("on");
            $(".text").eq(i).hide("slow");
            $(".form").eq(i).slideUp("slow");
            $(".respond").eq(i).children().hide("fast");
            $(".table").eq(i).css("display", "none");
        }
    }

    function checkRes(obj){
        if (obj == null){
            return false;
        }
        else { return true;}
    }

    function validateWeightsInput(in1, in2){
        const Num = /^([0-9]{4})$/;
        if(!Num.test(in1)){
            return false;
        }
        if(in2 == "" || in2 == null){
            return false;
        }
        return true;
    }

    function validateAirportInput(in1, in2){
        const Num = /^([A-Z]{3})$/;
        if(!Num.test(in1)){
            return false;
        }
        if(in2 == "" || in2 == null){
            return false;
        }
        return true;
    }

}
