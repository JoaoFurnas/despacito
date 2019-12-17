$(document).ready(function(){

    $(".register_btn").click(function(event){
        
        if($("password").val() == $("confirm").val()){

            alert("match")
        }

        $.ajax({ 
            url: 'http://192.168.1.109:8080/despacito/api/register',
            type: 'POST',
            data: JSON.stringify({name: $("#name").val(), username: $("#username").val(), email: $("#email").val(), password: $("#password").val(), location: $("#location").val()}), 
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback
            
        });
      
        console.log(JSON.stringify({name: $("#name").val(), username: $("#username").val(), email: $("#email").val(), password: $("#password").val(), location: $("#location").val() }))

    });
    function successCallback(data){
        
        location.href = "sidemenu.html";
    };
    


    function errorCallback(){
        
        alert("Wrong data");
        
    }

    
})