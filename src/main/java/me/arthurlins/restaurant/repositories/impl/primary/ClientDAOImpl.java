package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Client;
import me.arthurlins.restaurant.repositories.bridge.ClientDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientDAOImpl implements ClientDAO {
    private AtomicLong increment;
    private List<Client> clients;

    public ClientDAOImpl() {
        this.clients = new ArrayList<>();
        this.increment = new AtomicLong(0);
    }

    public void insert(Client client) throws Exception {
        final Client finalClient = client;
        if (clients.parallelStream().anyMatch(ano -> ano.getId() == finalClient.getId())){
            throw new Exception("Client already exists.");
        }
        client = new Client(increment.getAndIncrement(), client.getName(), client.getPhone(), client.getPersonQtd());
        clients.add(client);
    }

    public void edit(Client client) throws Exception {
        Client anon;
        for (int i = 0; i < clients.size(); i++){
            anon = clients.get(i);
            if (anon.getId() == client.getId()){
                client = new Client(increment.getAndIncrement(), client.getName(), client.getPhone(), client.getPersonQtd());
                clients.set(i, client);
                return;
            }
        }
        throw new Exception("Client not exists");
    }

    public void remove(Client client) {
        this.clients.removeIf(ano -> client.getId() == ano.getId());
    }

    public Client getById(int id) {
        final Optional<Client> value = this.clients
                .parallelStream()
                .filter(client -> client.getId() == id)
                .findFirst();
        return value.orElse(null);
    }

    public List<Client> view() {
        return this.clients;
    }

    public List<Client> view(int qtdPerPage, int page) {
        //Todo..
        return null;
    }
}
