package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LiquidacionEmpresa {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner sc = new Scanner(System.in);

        ArrayList<NivelAcademico> nivelesAcademicos = new ArrayList<NivelAcademico>();
        NivelAcademico na = new NivelAcademico(10, "Secundario Completo", 10);
        nivelesAcademicos.add(na);
        na = new NivelAcademico(20, "Universitario Completo", 30);
        nivelesAcademicos.add(na);
        na = new NivelAcademico(30, "Maestría Completo", 40);
        nivelesAcademicos.add(na);
        na = new NivelAcademico(40, "Doctorando Completo", 50);
        nivelesAcademicos.add(na);
        ArrayList<Empleado> empleados = new ArrayList<>();
        HashSet<String> legajosUsados = new HashSet<>();

        while(true) {
            System.out.println("Ingrese razon social");
            String razonSocial = sc.nextLine();
            System.out.println("Ingrese cuit (11 digitos)");
            String cuil = sc.nextLine();
            if(!razonSocial.isEmpty() &&  cuil.length() == 11){
                empresa.setRazonSocial(razonSocial);
                empresa.setCuit(cuil);
                break;

            }else System.out.println("Verifique los valores ingresados");
        }


        while(true) {
            Empleado empleado = new Empleado();
            System.out.println("Ingrese el nombre completo del empleado");
            String nombreCompleto = sc.nextLine();
            while(true){
                if(!nombreCompleto.isEmpty() && !nombreCompleto.isBlank()) {
                    empleado.setNombreCompleto(nombreCompleto);
                    break;
                }else System.out.println("El valor no puede estar vacio");

            }
            System.out.println("Ingrese legajo de empleado");
            while(true){
                String legajo = sc.nextLine();
                if(legajosUsados.contains(legajo)) {
                    System.out.println("El legajo ingresado ya fue cargado anteriormente. Vuelva a intentar.");
                    continue;
                }
                if(!legajo.isEmpty() && !legajo.isBlank() && !legajosUsados.contains(legajo)) {
                    empleado.setLegajo(Integer.parseInt(legajo));
                    legajosUsados.add(legajo);
                    break;
                }else System.out.println("El valor no puede estar vacio");
            }

            System.out.println("Ingrese el salario");
            while(true){
                double salario = Double.parseDouble(sc.nextLine());
                if(salario > 0){
                    empleado.setSalario(salario);
                    break;
                }else System.out.println("El salario no puede ser menor a 0");
            }

            System.out.println("Ingrese el nivel academico");
            boolean nivelAcademicoEncontrado = false;
            while(!nivelAcademicoEncontrado){
                int codigo = Integer.parseInt(sc.nextLine());
                for(NivelAcademico nivel : nivelesAcademicos){
                    if(nivel.getCodigo() == codigo){
                        empleado.setNivelAcademico(nivel);
                        nivelAcademicoEncontrado = true;


                    }

                }
                    if (!nivelAcademicoEncontrado) System.out.println("El código ingresado no existe, intente nuevamente");;
                    if (nivelAcademicoEncontrado) break;




            }

            empleados.add(empleado);

                System.out.println("Desea continuar con la carga de empleados? S/N");
                String continuar = sc.nextLine();
                if(continuar.equalsIgnoreCase("n"))break;
        }
        empresa.setEmpleados(empleados);

        empresa.mostrarEmpleados();
        empresa.mejorEmpleado();

        //Hasta aca llega main
    }
}
