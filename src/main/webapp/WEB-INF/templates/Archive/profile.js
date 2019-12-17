$(document).ready(function(){
        
    $.ajax({ 
        url: 'http://192.168.1.109:8080/despacito/api/access/user/1',
        type: 'GET',
        data: {get_param: 'username', get_param: 'name',get_param: 'location'}, 
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
        
    });
    function successCallback(data){
        alert(data.username);  
        $(".card-body").append(
            '<div class="input-group form-group">'+
            '<div class="input-group-prepend">'+
                '<span class="input-group-text"><i class="fas fa-user"></i></span>'+
            '</div>'+
            data.username+   
        '</div>'
        );
    };

    function errorCallback(){
        alert("fail");
    }
});