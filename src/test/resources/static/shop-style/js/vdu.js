
/* hdpic */
$(document).ready(function(){$(".hdpic dd a").hover(function(){$(this).find(".picshine").stop();$(this).find(".picshine").css("background-position","-235px 0");$(this).find(".picshine").animate({backgroundPosition: '235px 0'},500);$(this).find(".pictitle").stop().animate({left:'0px'},{queue:false,duration:450});},function(){$(this).find(".pictitle").stop().animate({left:'-235px'},{queue:false,duration:200});});});
