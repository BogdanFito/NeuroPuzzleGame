package sample;

import javafx.scene.image.ImageView;

public class OnePuzzle {
    private  ImageView image;
    private final double width;
    private final double height;
    private boolean completed;

    public OnePuzzle(ImageView image, double width, double height) {
        this.image = image;
        this.width = width;
        this.height = height;
        completed = false;
    }

    public void setCompleted() {
        completed = true;
    }

    public boolean getCompleted() {
        return completed;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public ImageView getImage() {
        return image;
    }
}
