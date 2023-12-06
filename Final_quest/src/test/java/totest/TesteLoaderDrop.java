package totest;

import org.game.rpg_elements.status.Drop;
import org.game.rpg_elements.status.LoaderDrop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TesteLoaderDrop {
    private int max;
    private int mim;
    private int size;
    private int xp;

    @BeforeEach
    public void Helper(){
        max = 10;
        mim = 2;
        size = 1;
        xp = 10;
    }

    @Test
    public void TesteLoaderDrop() throws IOException {
        Drop teste = new LoaderDrop().createDrop("slime");

        Assertions.assertEquals(max, teste.getMax_dinheiro());
        Assertions.assertEquals(mim, teste.getMim_dinheiro());
        Assertions.assertEquals(size, teste.getItens_droped().size());
        Assertions.assertEquals(xp, teste.getExperiencia());
    }
}
