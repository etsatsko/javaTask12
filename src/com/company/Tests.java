package com.company;

import org.junit.Test;
import org.junit.Assert;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void test_empty_string(){
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void test_word_string(){
        Integer.decode("string");
    }

    @Test(expected = NullPointerException.class)
    public void test_null(){
        Integer.decode(null);
    }


    @Test(expected = NumberFormatException.class)
    public void test_sign_between_number(){
        Integer.decode("5-5");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_between_number(){
        Integer.decode("5 5");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_after_negative_sign(){
        Integer.decode("- 5");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_after_positive_sign(){
        Integer.decode("+ 5");
    }

    @Test(expected = NumberFormatException.class)
    public void test_double_1(){
        Integer.decode("-5.5");
    }

    @Test(expected = NumberFormatException.class)
    public void test_double_2(){
        Integer.decode("5,5");
    }

    @Test(expected = NumberFormatException.class)
    public void test_3(){
        Integer.decode("5.5");
    }

    @Test
    public void test_negative_number(){
        Assert.assertEquals(-20, (int)Integer.decode("-20"));
    }

    @Test
    public void test_positive_number_1(){
        Assert.assertEquals(20, (int)Integer.decode("+20"));
    }

    @Test
    public void test_positive_number_2(){
        Assert.assertEquals(20, (int)Integer.decode("20"));
    }

    @Test
    public void test_hexadecimal_1(){
        Assert.assertEquals(-255, (int)Integer.decode("-0xFF"));
    }

    @Test
    public void test_hexadecimal_2(){
        Assert.assertEquals(12, (int)Integer.decode("0Xc"));
    }

    @Test
    public void test_hexadecimal_3(){
        Assert.assertEquals(172, (int)Integer.decode("#AC"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_between_hexadecimal_1(){
        Integer.decode("-0x FF");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_between_hexadecimal_2(){
        Integer.decode("0X b");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_between_hexadecimal_3(){
        Integer.decode("# AC");
    }

    @Test
    public void test_octal_positive(){
        Assert.assertEquals(59, (int)Integer.decode("073"));
    }

    @Test
    public void test_octal_negative(){
        Assert.assertEquals(-59, (int)Integer.decode("-073"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_between_octal(){
        Integer.decode("0 77");
    }
}
