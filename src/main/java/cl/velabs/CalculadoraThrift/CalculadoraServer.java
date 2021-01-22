package cl.velabs.CalculadoraThrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class CalculadoraServer {
    public static CalculadoraSvcImpl calculadoraSvc= new CalculadoraSvcImpl();
    public static CalculadoraSvc.Processor processor;

    public static void main(String[] args){
        try {
            processor = new CalculadoraSvc.Processor(calculadoraSvc);
            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };
            new Thread(simple).start();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void simple(CalculadoraSvc.Processor processor){

        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Ejecutando el servidor");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }

}