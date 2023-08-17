package org.example.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

  static RomanNumerals romanNumerals;

  @BeforeAll
  public static void beforeAll(){
    romanNumerals = new RomanNumerals();
  }

  @Test
  public void givenInt5ThenConvertReturnsV() {
    String expected = "V";
    String actual = romanNumerals.convertToNumeral(5);
    assertEquals(expected, actual);
  }
}
