var ajaxUrl;
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function renderAnswersBtn(type, row) {
    if (type === "display") {
        return "<a class='btn btn-info' href='"+ ajaxUrl + row.id + "/answers'>" + i18n["btnAnswers"] + "</a>";
    }
}


$(function () {
    ajaxUrl = "ajax/admin/themes/100000/questions/";
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