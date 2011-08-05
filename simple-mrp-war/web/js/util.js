function popup(p_url, p_width, p_height, p_top, p_left, p_name) {
    var width = 500;
    var height = 400;
    var left = parseInt((screen.availWidth/2) - (p_width/2));
    var top = parseInt((screen.availHeight/2) - (p_height/2));

    if(p_width != null) {
        width = p_width;
    }
    if(p_height != null) {
        height = p_height;
    }
    if(p_top != null) {
        top = p_top;
    }
    if(p_left != null) {
        left = p_left;
    }

    var popupName = p_name;
    if(popupName == null) {
        popupName = "popup";
    }

    var windowFeatures = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top + ',location=no,buttons=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,status=yes';
    window.open(p_url, popupName, windowFeatures);
}