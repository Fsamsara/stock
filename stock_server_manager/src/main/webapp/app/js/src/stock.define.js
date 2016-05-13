/**
 * Created by huangbiao on 2016/4/20.
 */
function callAlertDialog(msg) {
    $.gritter
        .add({
            title : '提示',
            text : msg,
            class_name : "gritter-error gritter-center gritter-light"
        });
}

function callInfoDialog(msg) {
    $.gritter
        .add({
            title : '提示',
            text : msg,
            class_name : "gritter-info gritter-center gritter-light"
        });
}


