package com.example.opsos_control_panel;

public class station {
    private double X;
    private double Y;
    private String description;
    private int type;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }
}
