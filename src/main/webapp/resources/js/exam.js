var ajaxUrl = 'ajax/exam/';

$(function() {
    $('#first').attr('onclick','getData("' + ajaxUrl + 'first")');
    $('#last').attr('onclick','getData("' + ajaxUrl + 'last")');
    $('#next').attr('onclick','getData("' + ajaxUrl + 'next")');
    $('#prev').attr('onclick','getData("' + ajaxUrl + 'previous")');
    getData(ajaxUrl + 'first');
});


function getData(ajaxQuery) {

    var id = $('.question').attr('id');
    var userAnswerId = $('input[name=userAnswerId]:checked').val();

    if (userAnswerId==undefined) {
        userAnswerId = null;
    }
    if (id==undefined) {
        id = null;
    }

    $.ajax({
        type: "POST",
        url: ajaxQuery,
        data: {'id': id, 'userAnswerId': userAnswerId},
        success: pageDraw
    });
}

function pageDraw(data) {
    $('.question')
        .html(data.body)
        .attr('id', data.id);

    var answersBox = $("#answersBox");

    answersBox.empty();

    for (choice in data.answers) {

        var currAnswerId = data.answers[choice].id;
        $("<input type='radio'>")
            .attr("name",'userAnswerId')
            .attr("id",currAnswerId)
            .attr("value",currAnswerId)
            .attr("checked", data.userAnswerId!=null&&data.userAnswerId==currAnswerId)
            .appendTo(answersBox);

        $("<label></label>")
            .attr("for",currAnswerId)
            .html(data.answers[choice].body)
            .appendTo(answersBox);

    }
    initButtons(data);
}

function initButtons(data) {
    if (data.prevId != null) {
        $('#prev').attr('disabled',false);
        $('#first').attr('disabled',false);
    } else {
        $('#prev').attr('disabled',true);
        $('#first').attr('disabled',true);
    }

    if (data.nextId != null) {
        $('#next').attr('disabled',false);
        $('#last').attr('disabled',false);
    } else {
        $('#next').attr('disabled',true);
        $('#last').attr('disabled',true);
    }
}

