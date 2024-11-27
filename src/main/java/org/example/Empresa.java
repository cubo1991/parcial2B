package org.example;

import java.util.ArrayList;

public class Empresa {


        private String cuit;
    private String razonSocial;
    private ArrayList<Empleado> empleados;
    private Empleado mejorEmpleado;
    private double promedioSueldos;

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void mostrarEmpleados(){
        System.out.println("Empresa: " + this.razonSocial);
        System.out.println("CUIT: " + this.cuit);
        System.out.println("------------------------Empleados------------------------------ ");
    for (Empleado empleado : this.empleados){
        this.promedioSueldos += empleado.getSalario();
        System.out.println("Nombre completo: " + empleado.getNombreCompleto());
        System.out.println("Salario: " + empleado.getSalario());
        System.out.println("Nivel educativo: "+ empleado.getNivelAcademico().getNivel() + " (Porcentaje de aumento "+ empleado.getNivelAcademico().getPorcentajeAumento()+ ")");

}


    }

    public void mejorEmpleado(){
        for (Empleado empleado : this.empleados){
            if(this.mejorEmpleado == null){
                this.mejorEmpleado = empleado;
            }
            if(empleado.getSalarioTotal() > this.mejorEmpleado.getSalarioTotal()){
                this.mejorEmpleado = empleado;
            }
        this.promedioSueldos += empleado.getSalarioTotal();

        }

        System.out.println("Resumen");
        System.out.println("El promedio de los salarios de la empresa es: " + this.promedioSueldos/this.empleados.size());
        System.out.println("El empleado con mejor salario es: ");
        System.out.println("Nombre completo: " + this.mejorEmpleado.getNombreCompleto());
        System.out.println("Salario: " + this.mejorEmpleado.getSalario());
        System.out.println("Nivel educativo: "+ this.mejorEmpleado.getNivelAcademico().getNivel() + " (Porcentaje de aumento "+ this.mejorEmpleado.getNivelAcademico().getPorcentajeAumento()+ ")");
    }
}
