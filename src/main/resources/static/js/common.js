$(document).ready(function () {
    $("#mo-open").click(function () {
        $(".mo-gnb").css('right', '0');
        $(".mo-gnb").css('background', 'rgba(0,0,0,0.85)');
        $("body").css('overflow-x', 'hidden');
        $("body").css('overflow-y', 'hidden');
    });
    $(".mo-gnb i").click(function () {
        $(".mo-gnb").css('right', '-100%');
        $(".mo-gnb").css('background', 'transparent');
        $("body").css('overflow-x', 'hidden');
        $("body").css('overflow-y', 'scroll');
    });
});