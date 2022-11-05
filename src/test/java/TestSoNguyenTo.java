import com.mycompany.testsnt.Utils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class TestSoNguyenTo {
    @Test
    public void testSoLe(){
        int n = 5;
        boolean expected = true;
        boolean actual = Utils.ktNt(n);
        
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @Tag("Critical")
    @DisplayName("Kiem tra so nguyen to chan")
    public void testSoChan(){
        int n = 2;
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertTrue(actual);
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 7, 97, 103})
    public void testTrue(int n){
        Assertions.assertTrue(Utils.ktNt(n), "ABC");
    }
    //Test 1 tập giá trị khác nhau
    @ParameterizedTest
    @CsvSource({"1,false, chuoi TB1", "2,true, chuoi TB2", "4,false, chuoi TB3"})
    public void testAllValues(int n, boolean expected, String mess){
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertEquals(expected, actual, mess);
    }
    //Test 1 tập giá trị đọc từ file
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resource/data.csv", numLinesToSkip = 0)
    public void testFile(int n, boolean expected, String mess){
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertEquals(expected, actual, mess);
    }
    //Test Exception
    @Test
    public void testException(){
        int n = -3;
//        boolean actual;
//        actual = Utils.ktNt(n);
        Assertions.assertThrows(ArithmeticException.class, () -> {Utils.ktNt(n);});
    }
}
