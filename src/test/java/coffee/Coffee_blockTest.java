package coffee;

import functional.Input;
import functional.Input_coffee_format;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static coffee.Coffee_block.createBlock;
import static coffee.Coffee_block_Volume.*;
import static functional.Input.getCoffeeLine;
import static functional.Input.getInt0_Limit;
import static org.junit.jupiter.api.Assertions.*;


class Coffee_blockTest {
    @Mock
    private Coffee coffee = new Coffee(1,1,1,1);
    @Mock
    private Coffee_block_Volume volume = SMALL_BLOCK;
    @InjectMocks
    private Coffee_block block;
    @BeforeEach
    public void  setUp(){
        block = new Coffee_block(volume, coffee);
    }
    @Test
    void setCoffee(){
        block.setCoffee(new Coffee(1,2,1,1));
        assertTrue(block.getCoffee().isEqual(new Coffee(1,2,1,1)));
    }

    @Test
    void isEqual_true() {
        var block2 = new Coffee_block(volume,coffee);
        assertEquals(block.getCoffee(),block2.getCoffee());
        assertEquals(block.getBlock_Volume(),block2.getBlock_Volume());
        assertTrue(block.isEqual(block2));
    }
    @Test
    void isEqual_false_coffee() {
        var coffee2=new Coffee(1,2,1,1);
        var block2 = new Coffee_block(Coffee_block_Volume.LARGE_BLOCK,coffee2);
        assertNotEquals(block.getCoffee(),block2.getCoffee());
        assertFalse(block.isEqual(block2));
    }
    @Test
    void isEqual_false_vol() {
        var block2 = new Coffee_block(Coffee_block_Volume.LARGE_BLOCK,coffee);
        assertEquals(block.getCoffee(),block2.getCoffee());
        assertNotEquals(block.getBlock_Volume(),block2.getBlock_Volume());
        assertFalse(block.isEqual(block2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void createBlock_1(int avail) {
        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class)) {
            input.when(Input::getCoffeeLine).thenReturn(new Input_coffee_format(1,1,1,1));
            var block1 = createBlock(avail);
            assertEquals(SMALL_BLOCK, block1.getBlock_Volume());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }
    @ParameterizedTest
    @ValueSource(ints = {2,3})
    void createBlock_2_1(int avail) {
        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class)) {
            input.when(Input::getCoffeeLine).thenReturn( new Input_coffee_format(1,1,1,1));
            input.when(() -> getInt0_Limit(avail+1)).thenReturn(1);
            var block1 = createBlock(avail);
            assertEquals(SMALL_BLOCK, block1.getBlock_Volume());

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}