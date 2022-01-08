$(function() {
    if ($(window).width() < 769) {
        $(".sidebar").addClass("toggled");
    }

    $(window).on('resize', function() {
        if ($(this).width()  < 769) {
            $(".sidebar").addClass("toggled");
            return;
        }

        $(".sidebar").removeClass("toggled");
    });
});