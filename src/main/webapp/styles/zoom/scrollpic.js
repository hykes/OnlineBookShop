function $(e) {
    return document.getElementById(e);
}
document.getElementsByClassName = function(cl) {
    var retnode = [];
    var myclass = new RegExp('\\b' + cl + '\\b');
    var elem = this.getElementsByTagName('*');
    for (var i = 0; i < elem.length; i++) {
        var classes = elem[i].className;
        if (myclass.test(classes)) retnode.push(elem[i]);
    }
    return retnode;
}
var MyMar;
var speed = 1; //速度，越大越慢
var spec = 1; //每次滚动的间距, 越大滚动越快
var ipath = 'images/'; //图片路径
var thumbs = document.getElementsByClassName('thumb_img');
for (var i = 0; i < thumbs.length; i++) {
    thumbs[i].onmouseover = function() {
        $('main_img').src = this.rel;
        $('main_img').link = this.link;
    };
    thumbs[i].onclick = function() {
        location = this.link
    }
}
$('main_img').onclick = function() {
    location = this.link;
}
$('gotop').onmouseover = function() {
    this.src = ipath + 'gotop2.gif';
    MyMar = setInterval(gotop, speed);
}
$('gotop').onmouseout = function() {
    this.src = ipath + 'gotop.gif';
    clearInterval(MyMar);
}
$('gobottom').onmouseover = function() {
    this.src = ipath + 'gobottom2.gif';
    MyMar = setInterval(gobottom, speed);
}
$('gobottom').onmouseout = function() {
    this.src = ipath + 'gobottom.gif';
    clearInterval(MyMar);
}
function gotop() {
    $('showArea').scrollTop -= spec;
}
function gobottom() {
    $('showArea').scrollTop += spec;
}