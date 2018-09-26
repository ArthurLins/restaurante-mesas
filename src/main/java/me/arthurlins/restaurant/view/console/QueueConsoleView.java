package me.arthurlins.restaurant.view.console;

import de.vandermeer.asciitable.AsciiTable;
import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.services.ClientQueueService;
import me.arthurlins.restaurant.view.console.util.ConsoleSection;
import me.arthurlins.restaurant.view.console.util.MenuOption;

import java.util.List;

public class QueueConsoleView extends ConsoleSection {

    private ClientQueueService clientQueueService;

    public QueueConsoleView(ClientQueueService clientQueueService) {
        this.clientQueueService = clientQueueService;
    }

    @Override
    public void mainMenu() {
        makeMenu("Fila de espera", true,
                new MenuOption("1", "Ver todos", this::viewAll),
                new MenuOption("2", "Voltar", () -> getPreviousSection().mainMenu())
        );
    }

    private void viewAll() {
        List<ClientQueue> clientQueues = clientQueueService.viewQueue();
        if (clientQueues.isEmpty()) {
            clear();
            title("Fila vazia");
        } else {
            clear();
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow(null, null, null, null, null, null, "Fila de espera");
            at.addRule();
            at.addRow("Posição", "Código", "Id", "Nome", "Telefone", "QTD Pessoas", "Pulado");
            at.addRule();
            int pos = 1;
            for (ClientQueue clientQueue : clientQueues) {
                at.addRow(pos,
                        clientQueue.getRandomCode(),
                        clientQueue.getId(),
                        clientQueue.getName(),
                        clientQueue.getPhone(),
                        clientQueue.getPersonQtd(),
                        clientQueue.getSkippedCount() + " vezes");
                at.addRule();
                pos++;
            }
            println(at.render());
        }
        makeBackMenu();
    }
}
