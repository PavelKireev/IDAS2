$(document).ready(function () {
    $('.pegasus-feed__card').each(function () {
        var size = $(this).find('.feed-card--subcard').length;
        if (size > 1) {
            $(this).find('.feed-card--subcard').each(function (index) {
                if (0 !== index) {
                    $(this).hide();
                }
            });
            $(this).append('<span class="show-more-cards-btn" data-state="close">Show more</span>');
            $(this).find('.show-more-cards-btn').click(function () {
                var state = $(this).data('state');

                if ('close' == state) {
                    $(this).parent().find('.feed-card--subcard').each(function () {
                        $(this).slideDown();
                    });
                    $(this).data('state', 'open');
                    return;
                }

                $(this).parent().find('.feed-card--subcard').each(function (index) {
                    if (0 !== index) {
                        $(this).hide();
                    }
                });
                $(this).data('state', 'close');
            })
        }
    });
});

$(document).ready(function () {
    $('.feed-card-body__text').readmore({
        selector: '.feed-card-body__text',
        embedCSS: true,
        collapsedHeight: 100,
        speed: 200,
        lessLink: '<a class="card-less-link-btn" href="#">Read less</a>',
        moreLink: '<a class="card-more-link-btn" href="#">Read less</a>'
    });
});