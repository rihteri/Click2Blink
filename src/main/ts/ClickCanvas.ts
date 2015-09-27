class ClickCanvas {
    constructor(svgElem: HTMLSVGElement) {
        this.svgElem = svgElem;
        
        this.svgElem.onclick = this.onCanvasClick.bind(this);
    }
    
    private onCanvasClick(ev: MouseEvent): void {
        var x = ev.clientX / this.svgElem.clientWidth;
        var y = ev.clientY / this.svgElem.clientHeight;
        
        for (var i = 0; i < this.clickHandlers.length; i++) {
            this.clickHandlers[i](x, y);    
        }
    }
    
    public registerClickHandler(handler: (x: number, y: number) => void): void {
        this.clickHandlers.push(handler);
    }
    
    public displayClickEvent(ev: ClickEvent): void {
        
    }
    
    private clickHandlers = new Array<(x: number, y: number) => void>();
    private svgElem: SVGElement;
}