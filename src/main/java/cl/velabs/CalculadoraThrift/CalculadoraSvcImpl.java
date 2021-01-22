package cl.velabs.CalculadoraThrift;

import org.apache.thrift.TException;

public class CalculadoraSvcImpl  implements CalculadoraSvc.Iface{
    public int multiplicar(int a, int b) throws TException {
        System.out.println("Multiplicando");
        return a*b;
    }

    public int sumar(int a, int b) throws TException {
        System.out.println("Sumando");
        return a+b;
    }
}
