class ClickChannel {
    constructor(canvas: ClickCanvas) {
        this.socket = new WebSocket("ws://localhost:8080/clicks");
        this.socket.onmessage = this.onWsMessage.bind(this);
        
        canvas.registerClickHandler(this.onCanvasClick.bind(this));
    }
    
    private onCanvasClick(x: number, y: number): void {
        var ce = new ClickEvent();
        ce.x = x;
        ce.y = y;
        
        this.socket.send(JSON.stringify(ce));
    }
    
    public onWsMessage(ev: MessageEvent): void {
        
    }
    
    private socket: WebSocket = null;
}