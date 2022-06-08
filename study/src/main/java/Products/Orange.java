package Products;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect
public class Orange extends Product implements Serializable {
    public boolean withBones;
    public Orange() {
    }
    public Orange(int price, String title, int weight, boolean withBones) {
        super(price, title, weight);
        this.withBones = withBones;
    }

    @Override
    public String toString() {
        return "Products.Orange{" +
                "withBones=" + withBones +
                ", weight=" + weight +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}