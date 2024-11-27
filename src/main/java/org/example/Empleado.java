package org.example;

public class Empleado {

    private String nombreCompleto;
    private double salario;
    private int legajo;
    private NivelAcademico nivelAcademico;
    private double salarioTotal;

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public double salarioTotalCalculado(){
        double salarioTotal = 0;
        salarioTotal = this.salario * (this.nivelAcademico.getPorcentajeAumento() / 100);
        this.salarioTotal = salarioTotal;
        return salarioTotal;
    }

}
