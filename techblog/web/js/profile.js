$(document).ready(function(){
        allPost = $(".c-link")[0] ;
        getPosts(0,allPost) ;
});

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
    
    
     function getPosts(Cid,obj)
    {
        $(".c-link").removeClass("active") ;
        $.ajax({
        url : "load-posts.jsp",
        data : {cid:Cid},
        success:function(response)
        {
            $('#post-container').html(response);
            $(obj).addClass("active") ;
        },
        error : function(response)
            {
                console.log(response) ;
                alert("error");
            }
    });
    }
    
    function doLike(postId, userId)
    {
        var dataObj = {
            postId : postId,
            userId : userId ,
            operation : "like"
        } ;
        
        $.ajax({
            url : 'like',
            data : dataObj,
            success : function(response){
            },
            error : function(response)
            {
                alert(response) ;
            }
        }) ;
    }
    
    