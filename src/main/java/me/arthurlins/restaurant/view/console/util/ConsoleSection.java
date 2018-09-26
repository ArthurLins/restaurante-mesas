package me.arthurlins.restaurant.view.console.util;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.HashMap;
import java.util.Scanner;

public abstract class ConsoleSection {

    private ConsoleSection previousSection;

    protected void clear() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception ignored) {
        }
    }

    protected void title(String title) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(title);
        at.addRule();
        println(at.render());
    }

    protected void messageBox(String title, String description) {
        clear();
        AsciiTable at = new AsciiTable();
        AT_Row row;
        at.addRule();
        row = at.addRow(title);
        row.getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow(description);
        at.addRule();

        System.out.println(at.render(79));
    }

    private void selectableOption(String option, String description) {
        println(option + " -> " + description);
    }

    protected void print(String text) {
        System.out.print(text);
    }

    protected void println(String text) {
        System.out.println(text);
    }

    protected void error(String error) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("ERROR", error);
        at.addRule();
        println(at.render());
    }

    protected String getUserInput() {
        final Scanner in = new Scanner(System.in);
        print("> ");
        return in.nextLine();
    }

    protected int getValidIntInput() {
        try {
            return Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            error("A entrada deve ser um numero.");
        }
        return getValidIntInput();
    }

    protected long getValidLongInput() {
        try {
            return Long.parseLong(getUserInput());
        } catch (NumberFormatException e) {
            error("A entrada deve ser um numero.");
        }
        return getValidLongInput();
    }

    protected void makeMenu(String title, boolean clear, MenuOption... options) {
        if (clear)
            clear();
        println("");
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(null, title);
        at.addRule();
        final HashMap<String, Runnable> optionMap = new HashMap<>();
        for (MenuOption option : options) {
            at.addRow(option.getOption(), option.getDescription());
            at.addRule();
            optionMap.put(option.getOption(), option.getExecute());
        }
        println(at.render());
        final String optionString = getUserInput();
        Runnable runnable = optionMap.get(optionString);
        if (runnable != null) {
            runnable.run();
        } else {
            makeMenu(title, clear, options);
        }
    }

    protected void makeBackMenu() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Precione ENTER para voltar");
        at.addRule();
        println(at.render());
        getUserInput();
        this.mainMenu();
    }

    protected ConsoleSection getPreviousSection() {
        return previousSection;
    }

    public void setPreviousSection(ConsoleSection previousSection) {
        this.previousSection = previousSection;
    }

    public abstract void mainMenu();
}
