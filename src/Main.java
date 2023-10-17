import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.frames.DrawingWindow;

public class Main {
    public static void main(String[] args) {
        //DrawCanvas.getInstance().load();
        DrawingWindow drawingWindow = new DrawingWindow();
        drawingWindow.getContentPane().paint(drawingWindow.getGraphics());
    }
}