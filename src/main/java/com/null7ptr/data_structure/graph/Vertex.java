package com.null7ptr.data_structure.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex{
    public int val;
    public List<Vertex> neighbors;

    public Vertex(){
        val = 0;
        neighbors = new ArrayList<Vertex>();
    }

    public Vertex(int val){
        this.val = val;
        neighbors = new ArrayList<Vertex>();
    }

    public Vertex(int val, ArrayList<Vertex> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}