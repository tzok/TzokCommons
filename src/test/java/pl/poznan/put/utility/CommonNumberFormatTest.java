package pl.poznan.put.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommonNumberFormatTest {
  @Test
  public final void formatDouble() {
    assertEquals("123", CommonNumberFormat.formatDouble(123.0));
    assertEquals("123.4", CommonNumberFormat.formatDouble(123.4));
    assertEquals("123.45", CommonNumberFormat.formatDouble(123.45));
    assertEquals("123.45", CommonNumberFormat.formatDouble(123.454));
    assertEquals("123.46", CommonNumberFormat.formatDouble(123.455));
  }
}
