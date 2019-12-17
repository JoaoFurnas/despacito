
var loggedInId;

$(document).ready(function(){
    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    }
    loggedInId = $.urlParam('id');
    
    populateNextBattlesNear();
    populateMyBattles();
    populateDancersCards();
    populateBattleCards();
    populateProfile();
    hide('.profileView')
    hide('.find-battles')
    hide('.find-dancers')
    hide('.my-battles')
});

function populateProfile(){
    $.ajax({ 
        url: 'http://192.168.1.109:8080/despacito/api/access/user/' + loggedInId,
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
        
    });

    function successCallback(data){  
        
            $('#username-label').text(data.username);  
            $('#name-label').text(data.name);   
            $('#email-label').text(data.email);
            $('#location-label').text(data.locationToString);
            $('#dancer-label').text(data.dancer);
            $('#balance').text(data.wallet + ' €')
        };
        function errorCallback(){
            alert("fail");
        }
    };

function populateNextBattlesNear(){
    $.ajax({
        url: 'http://192.168.1.109:8080/despacito/api/battle/local/0',
        type: 'GET',
        async: true,
        dataType: 'JSON',
        success: successCallback,
        error: errorCallback
    });

    function successCallback(response) {
        var element = response;
        console.log(element);
        for (var i = 0; i < element.length; i++) {
            $('#scheduledBattles').append($('<tr><td>'+element[i].user1.username +
            '</td><td>' + element[i].user2.username +'</td><td>' + element[i].date +
            '</td><td>' + element[i].hour +'</td> <td><button type="button" id="'+ element[i].id +
            '" class="btn btn-success join" id="'+ element[i].id + '">Join</button> </td><td> <button type="button" id="'+ element[i].id +
            '" class="btn btn-success bet" >Bet</button></td></tr>'));
        };
    }
    
    function errorCallback(request, status, error) {
        alert("Something went wrong.");
    }
    
    $('#profile').click(function(event){
        show('.profileView');
        hide('.find-battles')
        hide('.find-dancers')
        hide('.my-battles')
        hide('.overview');
    });
    
    $('#overview').click(function(event){
        show('.overview');
        hide('.profileView');
        hide('.find-battles');
        hide('.find-dancers');
        hide('.my-battles');
    });
    
    $('#listbattles').click(function(event){
        show('.find-battles');
        hide('.profileView');
        hide('.find-dancers');
        hide('.my-battles');
        hide('.overview');
    });
    
    $('#listdancers').click(function(event){
        show('.find-dancers');
        hide('.profileView');
        hide('.find-battles');
        hide('.my-battles');
        hide('.overview');
    });
    
    $('#my-battles').click(function(event){
        show('.my-battles');
        hide('.profileView');
        hide('.find-battles');
        hide('.find-dancers');
        hide('.overview');
    });
}

function populateMyBattles(){
    $.ajax({
        url: 'http://192.168.1.109:8080/despacito/api/battle/'+loggedInId+'/joined',
        type: 'GET',
        async: true,
        dataType: 'JSON',
        success: successCallback,
        error: errorCallback
    });

    function successCallback(response) {
        var element = response;
        
        for (var i = 0; i < response.length; i++) {
           
            $('#my-battles-table').append($('<tr><td>'+ element[i].user1.username +
            '</td><td>' + element[i].user2.username +'</td><td>' + element[i].date +
            '</td><td>' + element[i].hour +'</td> <td> ---------------- </td></tr>'));
        };
    }

    function errorCallback(request, status, error) {
        alert("Something went wrong.");
    }
};

function populateDancersCards(local) {
    
    $.ajax({
        url: 'http://192.168.1.109:8080/despacito/api/search/dancers/0',
        type: 'GET',
        async: true,
        success: successCallback,
        error: errorCallback
    });
    
    function successCallback(response) {
        console.log(response)
        var dancers = response;
        for (var i = 0; i < dancers.length; i++) {
            var htmlStr =
            '<div class="card text-center" style="margin: 10px">' +
            '<div class="card-body">' +
            '<h4 class="card-title">' + dancers[i].username + '</h4>' +
            '<h6 class="card-subtitle mb-2 text-muted">' + dancers[i].name + '</h6>' +
            '<p class="card-text">' + dancers[i].description + '</p>' +
                                            
            '<button id="' + dancers[i].id + '" class="btn btn-success challenge" >Challenge!</button></div></div>'
            $(htmlStr).appendTo('.find-dancers');
        }
        
        $(".challenge").click(function(event){
            talk(event);
        });
        
        function talk(event){
            alert('Clicked' + event.target.id)
        }
    }

    function errorCallback(request, status, error) {
        alert('Something went wrong');
    }

    
   
}

function populateBattleCards(local) {
    
    $.ajax({
        url: 'http://192.168.1.109:8080/despacito/api/battle/local/0',
        type: 'GET',
        async: true,
        success: successCallback,
        error: errorCallback
    });

    function successCallback(response) {
        console.log(response)
        var dancers = response;

        for (var i = 0; i < dancers.length; i++) {
            var htmlStr =
            '<div class="card text-center col" style="margin: 10px"><div class="card-body">' +
            '<h4 class="card-title">' + dancers[i].user1.username + '&nbsp;VS&nbsp;' + dancers[i].user2.username + '</h4>' +
            '<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>' +
            '<p class="card-text">' + dancers[i].date + '&nbsp;' + dancers[i].hour + '</p>' +
            '<button class="btn btn-primary bet" id="' + dancers[i].id + '" style="margin: 5px">Bet!</button>' +
            '<button class="btn btn-success attend" id="' + dancers[i].id + '" style="margin: 5px">Attend!</button></div></div>';

            $(htmlStr).appendTo('.find-battles');
        
        }
        $('.bet').click(function () {
            bet(event.target.id)
        });
    }

    function errorCallback(request, status, error) {
        alert('Something went wrong');
    }
}

function bet(id){
        $.ajax({ 
            url: 'http://192.168.1.109:8080/despacito/api/battle/addBettor/'+ loggedInId+ '/battle/' + id,
            type: 'GET',
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback
            
        });
    
        function successCallback(data){  
            alert("Success!");
            window.location.reload();
            };

            function errorCallback(){
                alert("Something went wrong on betting");
            }
};

function show(element){
    $(element).show();
}

function hide(element){
    $(element).hide();
}

