namespace java com.trabajo.automatserver

typedef i32 int

service ServerSvc
{
   string enviarEvento(1:string tipo, 2:string fecha, 3:string origen, 4:int id_origen, 5:string data, 6:string fecha_recepcion)
}
