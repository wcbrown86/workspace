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
public class CountryListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Countries) {
            Countries c = (Countries) value;
            setText(c.getCountry());
        }
        return this;
    }
}