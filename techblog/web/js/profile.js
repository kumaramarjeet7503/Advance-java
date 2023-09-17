    var  toggle = false ;
    $('#profile-toggle').click(function(){
        if(!toggle){
            $('#profile-edit').show() ;
         $('#profile-overview').hide() ;
         $('#profile-toggle').text("Back") ;
         toggle = true ;
        }else
        {
         $('#profile-edit').hide() ;
         $('#profile-overview').show() ;
         $('#profile-toggle').text("Edit") ;
            toggle = false ;
        }
    }) ;
    
    $('#dopost').on('submit',function(event){
       event.preventDefault();
       let form = new FormData(this) ;
       url = "dopost" ;
       var response = makeAjax(url,form);
    });
    
    function makeAjax(url,data)
    {
          $.ajax({
            url:url,
            data : data,
            method : "POST",
            success:function(response){
                return response ;
            },
            error : function(response)
            {
                console.log(response) ;
                alert("error");
            },
            processData : false ,
            contentType : false     
        });
    }