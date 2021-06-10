function getParishes() {
    console.log("GET parish"); // Log til konsol
    //Ajax request - hent parishes
    $.ajax({
        url:"/parish",
        type:"GET",
        contentType:"application/JSON",
        success:function (data) {
            $.each(data, function (index, item) { // Iterer over collection i data
                $("#parishList").append("<div>" + item.name + "</div>") // Tilføj ny div til parishList
            })
            $("#status").html("Svar fra server OK");
        },
        error:function (data) {
            $("#status").html("Svar fra server ERROR");
        }
    });
}

function preventSubmit(form){
    form.submit(function(event){
        event.preventDefault(); // Forhindrer formen i at blive sendt, når der trykkes submit
        createParish($("#name").val()); // Tekst i inputfeltet
    });
}

function createParish(name){
    var createParishObject = {};
    createParishObject["name"] = name;
    console.log("Create " + name);
    $.ajax({
        url:"/parish",
        type:"POST",
        contentType:"application/JSON",
        data:JSON.stringify(createParishObject),
        success:function(data){
            console.log("Parish created: " + data.name);
            $("#parishList").append("<div>" + data.name + "</div>"); // Tilføj til parish-listen
            $("#status").html("<br>Svar fra server OK");
        },
        error:function(data){
            $("#status").html("<br>Svar fra server ERROR");
        }
    });
}