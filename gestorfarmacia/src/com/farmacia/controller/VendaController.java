

import com.farmacia.model.Cliente;
import com.farmacia.model.Medicamento;

public class VendaController {
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;

    public VendaController(GerirMedicamentos gerirMedicamentos, GerirClientes gerirClientes) {
        this.gerirMedicamentos = gerirMedicamentos;
        this.gerirClientes = gerirClientes;
    }

    public void realizarVenda() {
       
    }
}
