var ajaxUrl = "ajax/admin/themes/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function renderQuestionsBtn(type, row) {
        if (type === "display") {
        return "<a class='btn btn-info' href='admin/themes/"+ row.id + "/questions'>" + i18n["btnQuestions"] + "</a>";
    }
}

function renderUsersBtn(type, row) {
    if (type === "display") {
        return "<a class='btn btn-info' href='admin/themes/"+ row.id + "/users'>" + i18n["btnUsers"] + "</a>";
    }
}

    $(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "name"
            },
            {
                "render": renderQuestionsBtn,
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
