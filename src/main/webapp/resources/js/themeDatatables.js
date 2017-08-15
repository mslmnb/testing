var ajaxUrl = "ajax/admin/themes/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function renderAnswersBtn(data, type, row) {
    if (type === "display") {
        return "<a class='btn btn-info' href='admin/themes/answers'>" + i18n["btnAnswers"] + "</a>";
    }
}

function renderUsersBtn(data, type, row) {
    if (type === "display") {
        return "<a class='btn btn-info' href='admin/themes/users'>" + i18n["btnUsers"] + "</a>";
    }
}

    $(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "name"
            },
            {
                "render": renderAnswersBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderUsersBtn,
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
            },
        ],
        "order": [
            [
                0,
                "asc"
            ]

        ]
    }));
    });
