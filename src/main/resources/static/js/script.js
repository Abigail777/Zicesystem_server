document.onkeydown = hback;
window.onhelp = function (e) {
    return false;
}

//屏蔽菜单
document.oncontextmenu = function (e) {
    return false;
}

//覆盖window.close方法
function closeWindow() {
    window.close();
    try {
        var allLayerIfms = jQuery("iframe.xubox_iframe", window.parent.document);//所有layer层
        var len = allLayerIfms.length;
        for (var i = 0; i < len; i++) {
            var layerIfm = allLayerIfms[i];
            if (jQuery(layerIfm).contents().find(jQuery(this.src)).length == 1)//该layer是触发控件所在的layer
            {
                var closeBtn = jQuery(layerIfm).parent().find("a[class='xubox_close xulayer_png32 xubox_close0']");
                //	jQuery(layerIfm).parent().find("iframe[class='xubox_iframe']").attr("src","");
                closeBtn.get(0).click();
                //	jQuery(layerIfm).parent().find("iframe[class='xubox_iframe']").remove();
                break;
            }
            else if (len == 1) {
                var closeBtn = jQuery(layerIfm).parent().find("a[class='xubox_close xulayer_png32 xubox_close0']");
                jQuery(layerIfm).parent().find("iframe[class='xubox_iframe']").attr("src", "");
                closeBtn.get(0).click();
                jQuery(layerIfm).parent().find("iframe[class='xubox_iframe']").remove();
                break;
            }
        }

    }
    catch (ee) {
        throw ee;
    }
};

/* 折叠区域面板隐藏展现 */
function fnHiddenOrShowDiv(divName, btnName) {
    if (document.getElementById(divName).style.display == "none") {
        document.getElementById(divName).style.display = "block";
        document.getElementById(btnName).className = "ConHidden";
    }
    else {
        document.getElementById(divName).style.display = "none";
        document.getElementById(btnName).className = "ConShow";
    }
}

/* 关闭折叠区域面板 */
function fnCloseDiv(div1, div2) {
    document.getElementById(div1).style.display = "none";
    document.getElementById(div2).style.display = "none";
}