package com.example.examenc1;

public class Rectangulo {
    private float base;
    private float altura;

    //Constructor vacio
    public Rectangulo() {
    }

    //Constructor de parametros
    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    //Encapsulamiento

    public float getBase() {
        return base;
    }

    public float getAltura() {
        return altura;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    //Metodos
    public float calcularArea(){
        float area = 0.0f;
        area = base * altura;
        return area;
    }
    public float calcularPerimetro(){
        float perimetro = 0.0f;
        perimetro = (altura * 2) + (base * 2);
        return perimetro;
    }

}
