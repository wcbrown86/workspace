/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customerrecords;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Patrick Keegan
 */
public class ProductListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Products) {
            Products p = (Products) value;
            setText(p.getProdType() + " " + p.getBrand() + " " + p.getModel());
        }
        return this;
    }
}