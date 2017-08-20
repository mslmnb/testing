var form;

function makeEditable() {
    form = $('#detailsForm');

    // solve problem with cache in IE: https://stackoverflow.com/a/4303862/548473
    $.ajaxSetup({cache: false});

    $(document).ajaxError(function(event, jqXHR, options, jsExc) {
       failNoty(jqXHR);
    });

    var token = $("meta[name='_csrf']").attr("content");
    var header =$("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function(e, xhr, options){
        xhr.setRequestHeader(header, token);
    });
}

// https://api.jquery.com/jquery.extend/#jQuery-extend-deep-target-object1-objectN
function extendsOpts(opts) {
    $.extend(true, opts,
    {
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
            "paging": true,
        "info": true,
        "language": {
            "search": i18n["common.search"],
            "lengthMenu": i18n["common.lengthMenu"],
            "paginate": {
                "first":      i18n["common.first"],
                "last":       i18n["common.last"],
                "next":       i18n["common.next"],
                "previous":   i18n["common.previous"]
            },
        },
        "initComplete": makeEditable
    });
    return opts;
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(key) {
    closeNoty();
    noty({
        text: i18n[key],
        type: "success",
        layout: "bottomRight",
        timeout: 1500
    });
}

function failNoty(jqXHR) {
    closeNoty();
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        // text: i18n['common.errorStatus'] + ': ' + jqXHR.status + '<br>' + errorInfo.cause + '<br>' + errorInfo.details.join("<br>"),
        text: i18n['common.errorStatus'] + ': ' + jqXHR.status + '<br>' + errorInfo + '<br>',
        type: "error",
        layout: "bottomRight"
    });
}

function add() {
    closeNoty();
    $('#modalTitle').html(i18n["addTitle"]);
    form.find(":input").val("");
    $('#editRow').modal();
}

function updateRow(id) {
    closeNoty();
    $('#modalTitle').html(i18n["editTitle"])
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function deleteRow(id) {
    closeNoty();
    $.ajax({
        url: ajaxUrl + id,
        type: "DELETE",
        success: function() {
            updateTable();
            successNoty("common.deleted");
        }
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.find(':input').serialize(),
        success: function () {
            $("#editRow").modal("hide");
            updateTable();
            successNoty("common.saved");
        }
    });
}

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ");'>" +
                "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'>"+
            "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";
    }
}




