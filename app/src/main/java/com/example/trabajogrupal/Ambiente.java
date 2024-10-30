package com.example.trabajogrupal;

import java.io.Serializable;

public class Ambiente implements Serializable {
    private String nombre;
    private String descripcion;
    private int imagenId;
    private int id;
    private int x1, y1, x2, y2; // Coordenadas
    private String imagenUrl;

    public Ambiente(int id, String nombre, int x1, int y1, int x2, int y2, String descripcion, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getImagenId() { return imagenId; }

    // Métodos para obtener coordenadas
    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
}
