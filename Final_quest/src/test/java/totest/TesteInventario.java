package totest;

import org.game.rpg_elements.itens.Item;
import org.game.rpg_elements.itens.inventario.Equipado;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public class TesteInventario {
    private Map<Item, Integer> inventario;
    private Map<Item, Integer> equipamentos;
    private Map<Item, Integer> consumiveis;
    private Equipado equipado;
    private Integer dinheiro;

    @BeforeEach
    public void Helper(){
        Map<Item, Integer> inv = new HashMap<>();



        this.inventario = inventario;
        this.equipamentos = equipamentos;
        this.consumiveis = consumiveis;
        this.equipado = equipado;
        this.dinheiro = dinheiro;
    }
}
