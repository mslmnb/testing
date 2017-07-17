var ajaxUrl = 'ajax/exam/';

$(function() {
    $('#first').attr('onclick','getData("' + ajaxUrl + 'first")');
    $('#last').attr('onclick','getData("' + ajaxUrl + 'last")');
    $('#next').attr('onclick','getData("' + ajaxUrl + 'next")');
    $('#prev').attr('onclick','getData("' + ajaxUrl + 'previous")');
    debugger;
    getData(ajaxUrl + 'first');
});


function getData(ajaxQuery) {

    var id = $('.question').attr('id');
    var userAnswerId = $('input[name=userAnswerId]:checked').val();
    var userOldAnswerId = $('#userOldAnswerId').val() ;


    if (userAnswerId==undefined) {
        userAnswerId = null;
    }
    if (id==undefined) {
        id = null;
    }

debugger;
    $.ajax({
        type: "POST",
        url: ajaxQuery,
        data: {'questionId': id, 'userAnswerId': userAnswerId, 'userOldAnswerId': userOldAnswerId},
        success: pageDraw
    });
}

function pageDraw(data) {
debugger;
    $('.question')
        .html(data.questionBody)
        .attr('id', data.questionId);

    $('#userOldAnswerId').val(data.userOldAnswerId);


    var answersBox = $("#answersBox");

    answersBox.empty();

    for (choice in data.answers) {

        var currAnswerId = data.answers[choice].id;


        $("<input type='radio'>")
            .attr("name",'userAnswerId')
            .attr("id",currAnswerId)
            .attr("value",currAnswerId)
            .attr("checked", data.userAnswerId!=null&&data.userAnswerId==currAnswerId)
            .appendTo($("<div class='col-sm-1'>").appendTo(answersBox));

        $("<label></label>")
            .attr("for",currAnswerId)
            .html(data.answers[choice].body)
            .appendTo(answersBox);

        $("<br>").appendTo(answersBox);
    }
    initButtons(data);
}

function initButtons(data) {
    if (data.prevQuestionId != null) {
        $('#prev').attr('disabled',false);
        $('#first').attr('disabled',false);
    } else {
        $('#prev').attr('disabled',true);
        $('#first').attr('disabled',true);
    }

    if (data.nextQuestionId != null) {
        $('#next').attr('disabled',false);
        $('#last').attr('disabled',false);
    } else {
        $('#next').attr('disabled',true);
        $('#last').attr('disabled',true);
    }
}

