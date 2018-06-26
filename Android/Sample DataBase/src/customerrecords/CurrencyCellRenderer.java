package customerrecords;

import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Table cell renderer for currency.
 *
 */
public class CurrencyCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Long) {
            value = NumberFormat.getCurrencyInstance().format((Long) value);
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
