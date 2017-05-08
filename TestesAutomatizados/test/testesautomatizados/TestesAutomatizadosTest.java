
package testesautomatizados;

import org.junit.Assert;
import org.junit.Test;
import testesautomatizados.TestesAutomatizados;



public class TestesAutomatizadosTest {

    @Test
    public void contemLetra() {
        Assert.assertTrue(TestesAutomatizados.contem("paulo", 'p'));
    }

    @Test
    public void naoContemLetra() {
        Assert.assertFalse(TestesAutomatizados.contem("paulo", 'm'));
    }

    @Test
    public void stringVazia() {
        Assert.assertFalse(TestesAutomatizados.contem("", 'm'));
    }
    
    @Test
    public void stringNula() {
        Assert.assertFalse(TestesAutomatizados.contem(null, 'm'));  
    }
    
    @Test
    public void contemLetraComCaseDiferente() {
        Assert.assertFalse(TestesAutomatizados.contem("paulo", 'P'));
    }
    

}
