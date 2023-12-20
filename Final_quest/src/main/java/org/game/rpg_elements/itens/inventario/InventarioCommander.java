package org.game.rpg_elements.itens.inventario;

import org.game.rpg_elements.status.Status;

import java.io.IOException;

public abstract class InventarioCommander {
    protected Inventario inventario;

    public InventarioCommander(Inventario inventario) throws IOException {
        this.inventario = inventario;
    }

    public abstract void execute() throws IOException;
}
