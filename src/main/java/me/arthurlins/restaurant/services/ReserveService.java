package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.Announce;
import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.utils.StringRandom;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ReserveService {


    private TableService tableService;
    private ClientQueueService clientQueueService;
    private AnnounceService announceService;


    public ReserveService(TableService tableService, ClientQueueService clientQueueService, AnnounceService announceService) {
        this.tableService = tableService;
        this.clientQueueService = clientQueueService;
        this.announceService = announceService;
    }

    public void newTableLiberate(Table table) throws Exception {
        if (clientQueueService.viewQueue().isEmpty()) {
            return;
        }
        ClientQueue clientQueue = clientQueueService.getBestClientQueueTo(table.getCapacity());
        clientQueueService.attend(clientQueue);
        tableService.takeTable(table, clientQueue.getPersonQtd());
        announceService.makeNewAnnounce(new Announce(clientQueue, table));
    }

    public boolean hasTableForCapacity(int qtdPersons) {
        return tableService.hasTableForCapacity(qtdPersons);
    }

    public String makeReserve(String name, String phone, int qtdPersons) throws Exception {
        if (tableService.hasEmptyTable()) {
            throw new Exception("Has tables! not able to reserve.");
        }
        String rCode = StringRandom.getRandom(4);
        clientQueueService.enqueue(new ClientQueue(name, phone, qtdPersons, rCode));
        return rCode;
    }

    public Table direct(int qtdPersons) throws Exception {
        if (!tableService.hasEmptyTable()) {
            throw new Exception("Not have empty tables");
        }
        Table table = tableService.getBestTableTo(qtdPersons);
        table.take(qtdPersons);
        return table;
    }


    public boolean hasQueueFor(int qtyPerson) {
        return tableService.getAllEmptyTables().parallelStream().noneMatch((t) -> t.getCapacity() >= qtyPerson);
    }
}
