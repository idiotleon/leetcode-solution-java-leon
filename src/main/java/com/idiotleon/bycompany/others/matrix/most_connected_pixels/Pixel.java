package com.idiotleon.bycompany.others.matrix.most_connected_pixels;

class Pixel {
    protected final int R, G, B;
    protected final double AVERAGE;
    
    protected Pixel(int R, int G, int B){
      this.R = R;
      this.G = G;
      this.B = B;
      
      this.AVERAGE = (R + G + B) / 3.0;
    }
}