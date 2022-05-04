package osgiteste.interactor;

import org.springframework.stereotype.Component;
import osgiteste.api.soap.generated.ANIVERSARIANTE;

import java.util.List;

@Component
public class ConsolePrintAniversaraintes {
    public void execute(List<ANIVERSARIANTE> aniversariantes) {
        System.out.println("");
        System.out.println("************ ************ ANIVERSARIANTES DO DIA ************ ************");
        System.out.println("");
        System.out.println("");
        for (ANIVERSARIANTE el : aniversariantes) {
            System.out.println("NOME COMPLETO: " + el.getFUNCIONARIO_NOME_COMPLETO());
            System.out.println("FILIAL: " + el.getFUNCIONARIO_FILIAL());
            System.out.println("EMAIL: " + el.getFUNCIONARIO_EMAIL());
            System.out.println("AREA: " + el.getFUNCIONARIO_AREA());
            System.out.println("NUCLEO: " + el.getFUNCIONARIO_NUCLEO());
            System.out.println("FOTO: " + el.getFUNCIONARIO_FOTO());
            System.out.println("");
            System.out.println("");
        }
    }
}
