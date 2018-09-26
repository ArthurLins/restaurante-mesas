package me.arthurlins.restaurant.view.console;

import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.services.ReserveService;
import me.arthurlins.restaurant.view.console.util.ConsoleSection;

public class ReserveConsoleView extends ConsoleSection {


    private ReserveService reserveService;

    public ReserveConsoleView(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @Override
    public void mainMenu() {
        getPreviousSection().mainMenu();
    }


    public void reserve() {
        clear();
        title("Quantidade de pessoas: ");
        final int qtyPerson = getValidIntInput();
        if (reserveService.hasTableForCapacity(qtyPerson)) {
            if (reserveService.hasQueueFor(qtyPerson)) {

                title("Há uma fila de espera para a entrada!");
                title("Digite o nome do responsavel: ");
                final String name = getUserInput();
                title("Digite o numero de telefone: ");
                final String phone = getUserInput();
                try {
                    final String code = reserveService.makeReserve(name, phone, qtyPerson);
                    messageBox("RESERVADO", "Código do cliente: " + code);
                } catch (Exception e) {
                    error(e.getMessage());
                }
            } else {
                try {
                    Table table = reserveService.direct(qtyPerson);
                    messageBox("MESA DISPONIVEL", "Mesa: (" + table.getId() + "|" + table.getName() + ")");
                } catch (Exception e) {
                    error("Não há mesas");
                }
            }
        } else {
            messageBox("MESA GRANDE DEMAIS", "Contacte o gerente");
        }

        makeBackMenu();

    }

}
