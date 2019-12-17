$(document).ready(function(){

    $(".login_btn").click(function(event){
        
        $.ajax({ 
            url: 'http://192.168.1.109:8080/despacito/api/access/login',
            type: 'POST',
            data: JSON.stringify({email: $("#email").val(), password: $("#password").val()}), 
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback
            
        });
      
    });
    function successCallback(data){
        location.href = "app.html?id="+data.id;
    };
    
    function errorCallback(){
        
        alert("Wrong username/password");
    }
    
    $(".register_btn").click(function(event){
        
        if(($("#password").val()) !== ($("#confirm").val())) {
            alert("Wrong Password Validation INSERT THE SAME PASSWORD")
            location.reload();  
        }

        if(($("#name").val() === "")){
            alert("Insert a valid name!")
            location.reload();
        }
        
        if(($("#username").val() === "")){
            alert("Insert a valid username!")
            location.reload();
        }

        if(($("#email").val() === "")){
            alert("Insert a valid email!")
            location.reload();
        }

        if(($("#password").val() === "")){
            alert("Insert a valid password!")
            location.reload();
        }

        if(($("#confirm").val() === "")){
            alert("Insert a valid confirmation!")
            location.reload();
        }

        if(($("#location").val() === "")){
            alert("Insert a location!")
            location.reload();
        }
    
    

    $.ajax({ 
        url: 'http://192.168.1.109:8080/despacito/api/access/register',
        type: 'POST',
        data: JSON.stringify({name: $("#name").val(), username: $("#username").val(), email: $("#email").val(), password: $("#password").val(), confirm: $("#confirm").val(), location: $("#location").val()}), 
        async: true,
        contentType: 'application/json',
        success: successRegisCallback,
        error: errorRegisCallback
        
    });
});

    function successRegisCallback(data){

        location.href = "LoginView.html"
    }

    function errorRegisCallback(){
        alert("Errorrrr")
    }

    
});