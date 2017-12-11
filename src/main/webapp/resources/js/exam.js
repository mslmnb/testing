var ajaxUrl = "ajax/exam/";
var oldUserAnswerEnums;

function initButtons(data) {
    if (data.prevQuestionId !==null) {
        $('#prev').attr("disabled",false);
        $('#first').attr("disabled",false);
    } else {
        $('#prev').attr("disabled",true);
        $('#first').attr("disabled",true);
    }

    if (data.nextQuestionId !== null) {
        $('#next').attr("disabled",false);
        $('#last').attr("disabled",false);
    } else {
        $('#next').attr("disabled",true);
        $('#last').attr("disabled",true);
    }
}

function pageDraw(data) {
    if (data!=="") {
        $('.question')
            .html(data.questionBody)
            .attr("id", data.questionId);

        // $("#oldUserAnswerEnums").val(data.userAnswerEnums);

        oldUserAnswerEnums = data.userAnswerEnums;

        var answersBox = $("#answersBox");

        answersBox.empty();

        for (choice in data.answers) {

            var currAnswerEnum = data.answers[choice].enumerator;


            $("<input type='checkbox'>")
                .attr("name", "userAnswerId")
                .attr("id", currAnswerEnum)
                .attr("value", currAnswerEnum)
                .attr("checked", hasBeenChosen(currAnswerEnum, data.userAnswerEnums))
                .appendTo($("<div class='col-sm-1'>").appendTo(answersBox));

            $("<label></label>")
                .attr("for", currAnswerEnum)
                .html(data.answers[choice].body)
                .appendTo(answersBox);

            $("<br>").appendTo(answersBox);
        }
        initButtons(data);
    }
}

function hasBeenChosen (currEnum, enums) {
    if  (enums===undefined || enums<=0) {
        return false ;
    }
    return (Math.pow(2, currEnum) & enums)> 0;
}

function getData(ajaxQuery) {

    var questionId = $(".question").attr("id");

    var boxes = $("input:checkbox:checked");

    var userAnswerEnums = 0;
    for (var i = 0; i<boxes.length; i++) {
        userAnswerEnums = userAnswerEnums + Math.pow(2,boxes[i].value);
    }

    if (questionId===undefined) {
        questionId = null;
    }

    if (oldUserAnswerEnums===undefined) {
        edited = false;
    } else {
        edited = (oldUserAnswerEnums!=userAnswerEnums);
    }

    var jsonData = JSON.stringify({
        'questionId' : questionId,
        'userAnswerEnums': userAnswerEnums,
        'edited': edited
    });

    $.ajax({
        type: "POST",
        url: ajaxQuery,
        data:  jsonData,
        contentType: 'application/json',
        success: pageDraw
    });
}

$(function() {
    $('#first').attr("onclick","getData('" + ajaxUrl + "first')");
    $('#last').attr("onclick","getData('" + ajaxUrl + "last')");
    $('#next').attr("onclick","getData('" + ajaxUrl + "next')");
    $('#prev').attr("onclick","getData('" + ajaxUrl + "previous')");
    $('#finish').attr("onclick","getData('" + ajaxUrl + "report')");

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function(e, xhr){
        xhr.setRequestHeader(header, token);
    });

    getData(ajaxUrl + "first");

});


