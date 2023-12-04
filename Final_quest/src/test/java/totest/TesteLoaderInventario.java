package totest;

import org.game.rpg_elements.itens.inventario.Inventario;
import org.game.rpg_elements.itens.inventario.LoaderInventario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteLoaderInventario {
    private Integer inventario_size;
    private Integer eq_quant;
    private Integer quant_item;
    private  Integer dinheiro;


    @BeforeEach
    public void Helper() throws IOException {
        inventario_size = 4;
        eq_quant = 3;
        quant_item = 1;
        dinheiro = 200;
    }

    @Test
    public void TesteLoaderInventario() throws IOException {
        Inventario teste = new LoaderInventario().createInventario();

        Assertions.assertEquals(inventario_size, teste.getInventario().size());
        Assertions.assertEquals(eq_quant, teste.getEquipamentos().size());
        Assertions.assertEquals(quant_item, teste.getConsumiveis().size());
        Assertions.assertEquals(dinheiro, teste.getDinheiro());
    }
}
