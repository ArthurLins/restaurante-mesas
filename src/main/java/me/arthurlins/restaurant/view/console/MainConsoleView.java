package me.arthurlins.restaurant.view.console;

import me.arthurlins.restaurant.services.AnnounceService;
import me.arthurlins.restaurant.services.ClientQueueService;
import me.arthurlins.restaurant.services.ReserveService;
import me.arthurlins.restaurant.services.TableService;
import me.arthurlins.restaurant.view.console.util.ConsoleSection;
import me.arthurlins.restaurant.view.console.util.MenuOption;

public class MainConsoleView extends ConsoleSection {

    private QueueConsoleView queueConsoleView;
    private ReserveConsoleView reserveConsoleView;
    private TableConsoleView tableConsoleView;
    private AnnounceConsoleView announceConsoleView;

    public MainConsoleView(QueueConsoleView queueConsoleView, TableConsoleView tableConsoleView,
                           ReserveConsoleView reserveConsoleView, AnnounceConsoleView announceConsoleView) {
        this.queueConsoleView = queueConsoleView;
        this.tableConsoleView = tableConsoleView;
        this.reserveConsoleView = reserveConsoleView;
        this.announceConsoleView = announceConsoleView;
        mainMenu();
    }

    public static void main(String[] args) {
        //Table
        TableService tableService = new TableService();
        TableConsoleView tableConsoleView = new TableConsoleView(tableService);

        //ClientQueue
        ClientQueueService clientQueueService = new ClientQueueService();
        QueueConsoleView queueConsoleView = new QueueConsoleView(clientQueueService);

        //Announcer
        AnnounceService announceService = new AnnounceService();
        AnnounceConsoleView announceConsoleView = new AnnounceConsoleView();
        announceService.setView(announceConsoleView);

        //Reserve
        ReserveService reserveService = new ReserveService(tableService, clientQueueService, announceService);
        ReserveConsoleView reserveConsoleView = new ReserveConsoleView(reserveService);

        tableService.setReserveService(reserveService);

        new MainConsoleView(queueConsoleView, tableConsoleView, reserveConsoleView, announceConsoleView);

    }

    @Override
    public void mainMenu() {
        makeMenu("Menu principal", true,
                new MenuOption("1", "Ver mesas", () -> {
                    tableConsoleView.setPreviousSection(this);
                    tableConsoleView.mainMenu();
                }),
                new MenuOption("2", "Ver Fila", () -> {
                    queueConsoleView.setPreviousSection(this);
                    queueConsoleView.mainMenu();
                }),
                new MenuOption("3", "Novo cliente", () -> {
                    reserveConsoleView.setPreviousSection(this);
                    reserveConsoleView.reserve();
                }),

                new MenuOption("5", "Sair", () -> {
                    System.exit(0);
                })
        );
    }

}
