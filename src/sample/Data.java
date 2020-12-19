package sample;

import javafx.scene.control.ComboBox;

public class Data {
    private int num;
    private ComboBox<String> variants;

    public Data(int num, ComboBox<String> variants) {
        this.num = num;
        this.variants = variants;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ComboBox<String> getVariants() {
        return variants;
    }

    public void setVariants(ComboBox<String> variants) {
        this.variants = variants;
    }
}
