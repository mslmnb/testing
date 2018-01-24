var ajaxUrl;
var adminUrl;
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function correct(chkbox, id) {
    var correct = chkbox.is(":checked");
    $.ajax({
        url: ajaxUrl + id,
        type: "POST",
        data: "correct=" + correct,
        success: function () {
            chkbox.closest('tr').toggleClass("success");
            successNoty(correct ? "answer.correct" : "answer.wrong");
        },
        error: function () {
            $(chkbox).prop("checked", !correct);
        }
    });
}

$(function () {
    adminUrl = "/admin/themes/" + $("#themeId").html() + "/questions/" + $("#questionId").html() + "/answers/";
    ajaxUrl = "ajax/" + adminUrl;
    $("#themeName").html(localStorage.getItem($("#themeId").html()));
    $("#questionBody").html(localStorage.getItem($("#questionId").html()));
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "correct",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return '<input type="checkbox" ' + (data ? 'checked' : '') + ' onclick="correct($(this),' + row.id + ');"/>';
                    }
                    return data;
                }
            },
            {
                "data": "body"
            },
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            if (data.correct) {
                $(row).addClass("success");
            }
        }
    }));
});


