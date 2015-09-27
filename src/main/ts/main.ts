window.onload = (ev) => {
    var canvas = new ClickCanvas(<HTMLCanvasElement>document.getElementById("content"));
    var e = document.createElement("svg");
    
    var cc = new ClickChannel(canvas);
}