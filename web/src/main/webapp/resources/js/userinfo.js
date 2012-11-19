var flag = false;

function Validate() {
    var image = document.getElementById("file").value;
    if (image != '') {
        var checkimg = image.toLowerCase();
        if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
            $('#myModal').modal('show');
            document.getElementById("file").focus();
            return false;
        }
    }
    return true;
}

function UpdBtnEnable() {
    if (flag == false) {
        document.getElementById("upload_btn").disabled = false;
    }
    else {
        flag = false;
    }
}

function UpdBtnDisable() {
    flag = true;
    document.getElementById("upload_btn").disabled = true;
}

