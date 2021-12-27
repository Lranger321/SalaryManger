$(function () {

    $(document).on('click', '#send-form', function () {
        let from =$("#from").val()
        let to = $("#to").val()
        let name = $("#name").val()
        let weight = $("#weight").val()
        let speedType = $("#speedType").val()
        let type;
        if(weight > 100){
            type = "grave"
        } else if(weight > 50){
            type = "average"
        } else {
            type = "soft"
        }
        console.log({type: type, weight: weight, from:from, to:to, name:name, speedType:speedType})
        $.ajax({
            method: "POST",
            contentType : 'application/json',
            url: "/api/units/getPrice",
            data: JSON.stringify({"unitType": type, "weight": weight, "from":from, "to":to, "name":name, "speedType":speedType}),
            success: function (response) {
                console.log(response)
                alert('Стоимость доставки ' + response)
            }, error: function (response) {
                console.log(response.status)
            }
        })
    })

})