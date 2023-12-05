package org.game.model.menu;

import java.util.Arrays;
import java.util.List;

public class InteractionMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public InteractionMenu() {
        this.entries = Arrays.asList("Yes", "No");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }


    public boolean isSelectedYes() {
        return isSelected(0);
    }

    public boolean isSelectedNo() {
        return isSelected(1);
    }


    public int getNumberEntries() {
        return this.entries.size();
    }
}
