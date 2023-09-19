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
          $.ajax({
            url:url,
            data : form,
            method : "POST",
            success:function(response){
                if(response)
                {
                    $('#dopost')[0].reset() ;
                    $('#post-success').show() ;
                }
            },
            error : function(response)
            {
                console.log(response) ;
                alert("error");
            },
            processData : false ,
            contentType : false     
        });
    });
    