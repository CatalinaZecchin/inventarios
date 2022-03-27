package com.demo.inventarios.web;
import java.util.List;
import com.demo.inventarios.domain.Transaccion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/informes")
public class ReportController {

    @GetMapping("/getTransaccionesGrouped")
	public List<Transaccion> getAllTransaccionesGroupedbyDateAndStore() {
        //Devolver número de transacciones agrupadas por tienda y fecha
        /* List<Transaccion> result = transaccionService.getAllTransaccionesGroupedByDateAndStore();
        return result; */

		return List.of(new Transaccion(123L, 1L, "productCode", 1L, "time", "tiendaCode")) ;
	}

    @GetMapping("/getMontos")
	public List<Object> getAllMontosByStoreAndProduct() {
        //Devolver monto vendido por tienda y producto;
        /* List<Object> result = transaccionService.getAllMontosByStoreAndProduct();
        return result; */

		return List.of(new Transaccion(123L, 1L, "productCode", 1L, "time", "tiendaCode")) ;
	}

/*     @RequestMapping(path = "/csv")
    public void getAllTransaccionesByClienteAndDates(@RequestBody Transaccion transaccion, HttpServletResponse servletResponse) throws IOException {
        
        //Devolver csv con la informacion de las transacciones realizadas por un cliente en un rango
        //de fechas. Validar las fechas y la existencia del cliente. 

        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
        csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
     } */
    
}
