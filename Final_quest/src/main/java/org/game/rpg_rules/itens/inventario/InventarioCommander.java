package org.game.rpg_rules.itens.inventario;

import java.io.IOException;

public abstract class InventarioCommander {
    protected Inventario inventario;

    public InventarioCommander(Inventario inventario) throws IOException {
        this.inventario = inventario;
    }

    public abstract void execute() throws IOException;
}
