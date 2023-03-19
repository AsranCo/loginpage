/**
 * loadChapter
 * @param chapter
 */
function loadChapter(chapter) {
    //go to chapter
    $('.loadChapter').addClass('d-none');
    $('#' + chapter).removeClass('d-none');
    if (chapter === 'ch1'){
        $('#breadcrumb').text('پنل ارسال');
    }else {
        $('#breadcrumb').text('پنل دریافت');
    }
    //add active class
}
