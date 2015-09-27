/**
 * A class for handling the connection to the server websocket pipe
 */
class ClickChannel {
    constructor(canvas: ClickCanvas) {
        this.socket = new WebSocket("ws://localhost:8080/clicks");
        this.socket.onmessage = this.onWsMessage.bind(this);
        
        this.canvas = canvas;
        this.canvas.registerClickHandler(this.onCanvasClick.bind(this));
    }
    
    /**
     * Fired when our user clicks on screen
     */
    private onCanvasClick(x: number, y: number): void {
        var ce = new ClickEvent();
        ce.x = x;
        ce.y = y;
        
        this.socket.send(JSON.stringify(ce));
    }
    
    /**
     * Fired when a message arrives from websocket
     */
    public onWsMessage(ev: MessageEvent): void {
        this.canvas.displayClickEvent(<ClickEvent>JSON.parse(ev.data));
    }
    
    private socket: WebSocket = null;
    private canvas: ClickCanvas = null;
}