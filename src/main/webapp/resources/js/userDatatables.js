var ajaxUrl;
var adminUrl;
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    adminUrl = "admin/themes/" + $("#themeId").html() + "/users/";
    ajaxUrl = "ajax/" + adminUrl;
    $("#themeName").html(localStorage.getItem($("#themeId").html()));
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "login"
            },
            {
                "data": "name"
            },
            {
                "data": "position"
            },
            {
                "data": "department"
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