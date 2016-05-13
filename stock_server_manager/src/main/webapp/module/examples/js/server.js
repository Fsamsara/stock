/**
 * Created by yxt on 2015/6/5.
 */

    $("#p_component").hide();
    $('.card.hover .fa-cubes').click(function(){
        $(this).parents(".card.hover").find(".back .panel").hide();
        console.log($(this).parent().attr("for"));
        $("#" + $(this).parent().attr("for")).show();
        $(this).parents(".card.hover").addClass('flip');
    });

    $('.card.hover .fa-lock').click(function(){
        $(this).parents(".card.hover").find(".back .panel").hide();
        //$(this).parents(".card.hover").find(".back .panel.password").show();
        $("#" + $(this).parent().attr("for")).show();
        $(this).parents(".card.hover").addClass('flip');
    });

    $('.card.hover .module-back').click(function(){
        $(this).parents(".card.hover").removeClass("flip");
    });

    $("#p_component .module-back").click(function(){
        $("#p_server").show();
        $("#p_component").hide();
    });

    $('.card.hover .back .label').click(function(){
        $("#p_server").hide();
        $("#p_component").show();
    });

    $(".back .list-group .list-group-item").tooltip();
    $(".card-container .card .back .panel .panel-body").niceScroll({
        cursorcolor : "#000000",
        zindex : 999999,
        bouncescroll : true,
        cursoropacitymax : 0.4,
        cursorborder : "",
        cursorborderradius : 0,
        cursorwidth : "7px",
        //railalign : "right",
        autohidemode : true,
        railoffset : {
            top : 0,
            left : 0
        }
    });