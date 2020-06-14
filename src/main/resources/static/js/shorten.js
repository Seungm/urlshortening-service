function fn_redirect(innerUrl) {
    $('#result').hide();
    const $error = $('#error');
    $error.hide();
    const data = { 'shortenUrl': innerUrl };
    $.ajax({
        url: '/api/redirect',
        type: 'post',
        data: data,
        success: function (data) {
            window.location.href = data;
        },
        error: function (data) {
            console.log(data);
            $error.show();
            $error.html("등록되지 않은 SHORTEN URL 타입입니다.");
        }
    });
}

$('#shortenButton').click(function (e) {
    e.preventDefault();
    const $error = $('#error');
    $('#result').hide();
    $error.hide();
    let innerUrl = $('[name="innerUrl"]').val();
    if (innerUrl.indexOf("codetest.smk") !== -1) {
        fn_redirect(innerUrl);
    } else {
        $.ajax({
            url: '/api/generated',
            type: 'post',
            contentType: 'application/json; charset=UTF-8',
            data: innerUrl,
            success: function (data) {
                $('#result').show();
                $('#oriUrl').html(data.originUrl);
                $('#shortUrl').html("<a onclick=\"fn_redirect(\'" + data.shortenUrl + "')\">" + data.shortenUrl + "</a>");
            }, error: function (data) {
                $error.show();
                $error.html("적절치 않은 URL 입니다.");
            }
        });
    }
});
