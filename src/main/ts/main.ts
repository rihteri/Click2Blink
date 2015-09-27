window.onload = (ev) => {
    var canvas = new ClickCanvas(<SVGElement>document.getElementById("content"));
    var cc = new ClickChannel(canvas);
}