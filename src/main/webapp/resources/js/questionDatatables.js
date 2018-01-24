var ajaxUrl;
var adminUrl;
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function renderAnswersBtn(data, type, row) {
    if (type === "display") {
        var body = '"' + row.body + '"';
        return "<a class='btn btn-info' href='"+ adminUrl + row.id + "/answers' onclick='saveToLocalStorage(" + row.id + ", " + body + ");'>" + i18n["btnAnswers"] + "</a>";
    }
}

$(function () {
    adminUrl = "admin/themes/" + $("#themeId").html() + "/questions/";
    ajaxUrl = "ajax/" + adminUrl;
    $("#themeName").html(localStorage.getItem($("#themeId").html()));
    datatableApi = $('#datatable').DataTable(extendsOpts({
       "columns": [
           {
               "data": "body"
           },
           {
               "render": renderAnswersBtn,
               "defaultContent": "",
               "orderable": false
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
        ]
   }));
});