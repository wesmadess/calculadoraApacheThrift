package cl.velabs.CalculadoraThrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class CalculadoraClient {
    public static void main(String[] args){
        try {
            TTransport transporte = new TSocket("localhost",9090);
            transporte.open();
            System.out.println("Cliente conectado");
            TProtocol protocol= new TBinaryProtocol(transporte);
            CalculadoraSvc.Client cliente = new CalculadoraSvc.Client(protocol);

            System.out.println("Multiplicando en el cliente");
            int resultado = cliente.multiplicar(3,2);
            System.out.println(resultado);

            System.out.println("Sumando en el cliente");
            resultado = cliente.sumar(3,2);
            System.out.println(resultado);

            transporte.close();



        }
        catch(Exception ex){

        }
    }
}
