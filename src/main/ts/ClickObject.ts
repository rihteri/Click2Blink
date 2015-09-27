/**
 * Represents a single click on the canvas
 */
class ClickObject {
    constructor(ev: ClickEvent) {
        this._clickEvent = ev;    
    }
    
    public draw(
            ctx: CanvasRenderingContext2D,
            animTime: number,
            width: number,
            height: number) {
        ctx.beginPath();
        ctx.arc(
            this.clickEvent.x * width,
            this.clickEvent.y * height,
            this.getRadius(animTime),
            0,
            2 * Math.PI,
            false);
        ctx.fillStyle = this.clickEvent.colorString;
        ctx.fill();
    }
    
    /**
     * Check whether the click is still visible
     */
    public isStale(): boolean {
        return this.stale;
    }
    
    private static APPEAR_RADIUS = 50;
    
    /**
     * Gets the radius of this circle at a specific time
     */
    private getRadius(animTime: number) {
        if (!this.appearTime) {
            this.appearTime = animTime;
        }
        
        var decay = (animTime - this.appearTime)/1000.0
                        * ClickObject.APPEAR_RADIUS;
        
        if (decay > ClickObject.APPEAR_RADIUS) {
            this.stale = true;
            return 0;    
        }
        
        return ClickObject.APPEAR_RADIUS - decay;
    }
    
    /**
     * Get the event represented by this object
     */
    public get clickEvent(): ClickEvent {
        return this._clickEvent;
    }
    
    private stale: boolean = false;
    private _clickEvent: ClickEvent;
    private appearTime: number = null;
}