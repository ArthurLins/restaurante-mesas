package me.arthurlins.restaurant.view.console;

import de.vandermeer.asciitable.AsciiTable;
import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.services.TableService;
import me.arthurlins.restaurant.view.console.util.ConsoleSection;
import me.arthurlins.restaurant.view.console.util.MenuOption;

import java.util.List;

public class TableConsoleView extends ConsoleSection {

    private TableService tableService;

    public TableConsoleView(TableService tableService) {
        this.tableService = tableService;
    }

    @Override
    public void mainMenu() {
        makeMenu("Mesas", true,
                new MenuOption("1", "Ver", this::viewMenu),
                new MenuOption("2", "Adicionar", this::add),
                new MenuOption("3", "Liberar mesa", this::liberate),
                new MenuOption("4", "Voltar", () -> getPreviousSection().mainMenu())

        );
    }

    private void liberate() {
        clear();
        view(tableService.getAllTakenTables(), false);
        title("Digite o ID da mesa");
        long id = getValidLongInput();
        try {
            tableService.liberateById(id);
            title("Mesa liberada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        makeBackMenu();
    }

    private void add() {
        clear();
        title("Nova mesa");
        title("Digite o nome da mesa: ");
        final String tableName = getUserInput();
        title("Digite a capacidade: ");
        final int capacity = getValidIntInput();
        try {
            tableService.insert(tableName, capacity);
        } catch (Exception e) {
            error(e.getMessage());
        }
        makeBackMenu();
    }

    private void viewMenu() {
        makeMenu("Mesas/Ver", true,
                new MenuOption("1", "Todas", () -> view(tableService.getAllTables(), true)),
                new MenuOption("2", "Vazias", () -> view(tableService.getAllEmptyTables(), true)),
                new MenuOption("3", "Ocupadas", () -> view(tableService.getAllTakenTables(), true)),
                new MenuOption("4", "Voltar", this::mainMenu)
        );
    }

    private void view(List<Table> tables, boolean back) {
        clear();
        if (tables.isEmpty()) {
            error("Não há mesas.");
        } else {
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow(null, null, null, null, "Mesas");
            at.addRule();
            at.addRow("Id", "Nome", "Lugares", "Ocupada", "Pessoas na mesa");
            at.addRule();
            for (Table table : tables) {
                at.addRow(table.getId(), table.getName(), table.getCapacity(), ((table.isTacked()) ? "Sim" : "Não"), table.getPersonsInTable());
                at.addRule();
            }
            println(at.render());
        }
        if (back)
            makeBackMenu();
    }


}
