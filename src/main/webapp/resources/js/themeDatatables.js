var ajaxUrl = "ajax/admin/themes/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function renderQuestionsBtn(data, type, row) {
        if (type === "display") {
            var name = '"' + row.name + '"';
            return "<a class='btn btn-info' href='admin/themes/"+ row.id + "/questions' onclick='saveToLocalStorage(" + row.id + ", " + name + ");'>" + i18n["btnQuestions"] + "</a>";
    }
}

function renderUsersBtn(data, type, row) {
    if (type === "display") {
        var name = '"' + row.name + '"';
        return "<a class='btn btn-info' href='admin/themes/"+ row.id + "/users' onclick='saveToLocalStorage(" + row.id + ", " + name + ");'>" + i18n["btnUsers"] + " </a>";
    }
}

    $(function () {
    localStorage.clear();
    localStorage["title"] = "ТЕСТИРОВАНИЕ"
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
