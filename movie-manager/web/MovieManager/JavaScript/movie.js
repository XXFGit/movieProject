/**
 * Created by 熊显付 on 2017/2/23.
 */
$(function(){
    /*-----------------------------查询所有----------------------------------------*/
    $.get("allMovie",function(result){
        $.each(result,function(index, obj){
            $(".mytable").append("<tr><th>"+obj.mid+"</th><th class='p'>"+obj.moviePhoto+"</th><th>"+obj.movieName+"</th>"+
                "<th>"+obj.type.tname+"</th><th>"+obj.area.aArea+"</th><th>"+obj.year.yNiandai+"</th><th>"+obj.movieDirector+"</th>"+
                "<th>"+obj.movieStar+"</th><th>"+obj.movieTimelong+"</th><th>"+obj.movieText+"</th><th>"+obj.movieState+"</th><th><input type='button' class='btn btn-danger tuji' name='"+obj.mid+"' value='图集详情'></th><th>"+
                "<input type='button' value='删除' name='"+obj.mid+"'  class=' del btn btn-danger'>&nbsp;"+
                "<input type='button' value='修改' name='"+obj.mid+"' class=' update btn btn-danger'>"+
                "</th> </tr>");
        });


        /*----------------------------删除movie----------------------------------------*/
        $(".del").on("click",function(){
            var id=$(this).attr("name");
            alert(id);
            $.post("delMovie",{"ID":id},function (result){alert(result);location.href="movie.html";});
        })

        /*--------------------------------添加电影信息模态框-------------------------------*/
        $(".add1").on("click",function () {
            /*获取类型、年代、地区信息并追加到 模态框上*/
            $.get("allYear",function(result){$("#year").empty();$.each(result,function(index,obj){ $("#year").append("<option value="+obj.yid+">"+obj.yNiandai+"</option>");});})
            $.get("allType",function(result){$("#type").empty(); $.each(result,function(index,obj){ $("#type").append("<option value="+obj.tid+">"+obj.tname+"</option>");});})
            $.get("allArea",function(result){$("#area").empty();$.each(result,function(index,obj){ $("#area").append("<option value="+obj.aid+">"+obj.aArea+"</option>");});})
            /* 清空放照片的那个div*/
            $("#imageDiv").empty();
            $("#MovieModal").modal("toggle");
            //上传图片
            $("#uploadBtn").on("click",function(){
                upload();
            })
            //添加电影信息到数据库
            $(".save").on("click",function(){
                var faam=$("#myform").serialize();
                alert(faam);
                $.post("addMovie",faam,function(result){
                    alert(result);
                    $("#MovieModal").modal("toggle");
                    location.href="movie.html";
                });
            })
        })
        /*------------------------------------------添加电影信息结束----------------------------------*/

        /*---------------------------------------修改电影信息开始------------------------------------*/
        $(".update").on("click",function(){
            $("#zz").html("修改电影信息");
            var id=$(this).attr("name");
            $.post("ByIdMovie",{"ID":id},function(result) {
                $("#mid").val(result.mid);
                $("#movieName").val(result.movieName);
                $("#movieTimelong").val(result.movieTimelong);
                $.get("allYear",function(result){$("#year").empty();$.each(result,function(index,obj){ $("#year").append("<option value="+obj.yid+">"+obj.yNiandai+"</option>");});})
                $.get("allType",function(result){$("#type").empty(); $.each(result,function(index,obj){ $("#type").append("<option value="+obj.tid+">"+obj.tname+"</option>");});})
                $.get("allArea",function(result){$("#area").empty();$.each(result,function(index,obj){ $("#area").append("<option value="+obj.aid+">"+obj.aArea+"</option>");});})
                $("#movieStar").val(result.movieStar);
                $("#movieDirector").val(result.movieDirector);
                $("#movieText").val(result.movieText);
                $("#movieState").val(result.movieState);
                $("#imageDiv").empty();
                $("#imageDiv").append('<img src="../files/'+result.moviePhoto+'" style="width:148px;height:198px"/>');
            })
            $("#MovieModal").modal("toggle");
            //上传图片
            $("#uploadBtn").on("click",function(){
                upload();
            })
            $(".save").on("click",function(){
                var faam=$("#myform").serialize();
                $.post("updateMovie",faam,function(result){
                    alert(result);
                    $("#MovieModal").modal("toggle");
                    location.href="movie.html";
                });
            })


        })
        /*----------------------------------修改电影信息结束-----------------------------------------------*/


    });

    //图片上传的方法
    function upload(){
        var formData = new FormData(document.getElementById("myform"));
        $.ajax({
            url : "uploadMovie", /*//请求的url*/ type : "post", //请求类型
            data : formData, /*//表单数据*/   processData : false, //让Jquery不处理发送的数据
            contentType : false,  //让Jquery不设置Content-Type请求头
            success : function(result){ // 成功响应后的回调函数
                $("#imageDiv").empty();
                $("#imageDiv").append('<img src="../files/'+result+'" style="width:148px;height:198px"/>');
            }
        });
    }
    /*-----------------------------------upload方法结束-------------------------------------------*/
    /*-------------------------------图集------------------------------------*/
    $(".tuji").on("click",function () {
        $("#MovieModal").modal("toggle");
    })

})
