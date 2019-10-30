package pl.poznan.put.utility;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.swing.table.TableModel;
import org.jumpmind.symmetric.csv.CsvWriter;

public final class TabularExporter {
  private TabularExporter() {
    super();
  }

  public static void export(final TableModel tableModel, final OutputStream stream)
      throws IOException {
    final CsvWriter csvWriter = new CsvWriter(stream, ',', StandardCharsets.UTF_8);

    for (int i = 0; i < tableModel.getColumnCount(); i++) {
      csvWriter.write(tableModel.getColumnName(i));
    }
    csvWriter.endRecord();

    for (int i = 0; i < tableModel.getRowCount(); i++) {
      for (int j = 0; j < tableModel.getColumnCount(); j++) {
        final Object value = tableModel.getValueAt(i, j);
        csvWriter.write((value != null) ? value.toString() : null);
      }
      csvWriter.endRecord();
    }

    csvWriter.close();
  }
}
