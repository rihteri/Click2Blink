class ClickCanvas {
    constructor(svgElem: HTMLCanvasElement) {
        this.canvas = svgElem;
        this.canvas.width = this.canvas.clientWidth;
        this.canvas.height = this.canvas.clientHeight;
        
        this.context = this.canvas.getContext("2d");
        
        this.canvas.onclick = this.onCanvasClick.bind(this);
    }
    
    /**
     * Called when we are about to draw
     */
    public onDraw(time: number) {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
        
        for (var i = 0; i < this.clicks.length; i++) {
            this.clicks[i].draw(
                this.context,
                time,
                this.canvas.width,
                this.canvas.height);
        }
        
        this.removeStaleClicks();
        
        if (this.clicks.length > 0) {
            window.requestAnimationFrame(this.onDraw.bind(this));
        }
    }
    
    private removeStaleClicks() {
        var relevantClicks = new Array<ClickObject>();
        for (var i = 0; i < this.clicks.length; i++) {
            if (!this.clicks[i].isStale()) {
                relevantClicks.push(this.clicks[i]);
            }
        } 
        
        this.clicks = relevantClicks;
    }
    
    /**
     * Fired when the user clicks on the canvas
     */
    private onCanvasClick(ev: MouseEvent): void {
        var x = ev.clientX / this.canvas.clientWidth;
        var y = ev.clientY / this.canvas.clientHeight;
        
        for (var i = 0; i < this.clickHandlers.length; i++) {
            this.clickHandlers[i](x, y);    
        }
    }
    
    
    /**
     * Register a handler to receive notification of clicks
     */
    public registerClickHandler(handler: (x: number, y: number) => void): void {
        this.clickHandlers.push(handler);
    }
    
    /**
     * Draw a click event
     */
    public displayClickEvent(ev: ClickEvent): void {
        this.clicks.push(new ClickObject(ev));
        window.requestAnimationFrame(this.onDraw.bind(this));
    }
    
    private context: CanvasRenderingContext2D = null;
    private clicks = new Array<ClickObject>();
    private clickHandlers = new Array<(x: number, y: number) => void>();
    private canvas: HTMLCanvasElement;
}