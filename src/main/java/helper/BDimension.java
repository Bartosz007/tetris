package helper;

import java.awt.*;

public class BDimension extends Dimension {
    public BDimension(int width, int height) {
        super(width,height);
    }
    public BDimension divide(int x){

        if(x==0)
            return this;

        return new BDimension(width/x,height = height/x);
    }
}
