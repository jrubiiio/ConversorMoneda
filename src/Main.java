import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;

        // Consulta la API
        ConsultaAPI consulta = new ConsultaAPI();
        // Para las trabjar con las conversiones
        Logica calculos = new Logica(consulta);

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n***************************************************
                *** Bienvenido al conversor de Monedas ***
                
                1) Dólar ==>> Peso argentino
                2) Peso argentino ==>> Dólar
                3) Dólar ==>> Real brasileño
                4) Real brasileño ==>> Dolar
                5) Dólar ==>> Peso colombiano
                6) Peso colombiano ==>> Dólar
                
                7) Conversión personalizada
                
                8)Salir
                
                Elija una opción para convertir moneda:
                ***************************************************
                """;

        while (opcionElegida != 8) {
            try {
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());
                switch (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("USD", "ARS");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("ARS", "USD");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("USD", "BRL");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("BRL", "USD");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("USD", "COP");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("COP", "USD");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        calculos.almacenarValoresPersonalizados();
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingresa un codigo de moneda valido.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico.");
            }
        }
        System.out.println("¡Hasta pronto!");
    }
}
