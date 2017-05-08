package monopoly.gui;



import monopoly.RailRoadCell;
import monopoly.PropertyCell;
import monopoly.CardCell;
import monopoly.UtilityCell;
import monopoly.FreeParkingCell;
import monopoly.GoToJailCell;
import monopoly.JailCell;
import monopoly.GoCell;
import monopoly.Cell;
import java.util.Hashtable;


public class InfoFormatter {
    static Hashtable cellInfoFormatters = null;
    
    static {
        if (cellInfoFormatters == null) {
            cellInfoFormatters = new Hashtable();
            addFormatters();
        }
    }
    
    private static void addFormatters() {
        cellInfoFormatters.put(
                PropertyCell.class, new PropertyCellInfoFormatter());
        cellInfoFormatters.put(
                GoCell.class, new GoCellInfoFormatter());
        cellInfoFormatters.put(
        		JailCell.class, new JailCellInfoFormatter());
        cellInfoFormatters.put(
        		GoToJailCell.class, new GotoJailCellInfoFormatter());
        cellInfoFormatters.put(
        		FreeParkingCell.class, new FreeParkingCellInfoFormatter());
        cellInfoFormatters.put(
                RailRoadCell.class, new RRCellInfoFormatter());
        cellInfoFormatters.put(
                UtilityCell.class, new UtilCellInfoFormatter());
        cellInfoFormatters.put(
                CardCell.class, new CCCellInfoFormatter());
    }

    public static String cellInfo(Cell cell) {
        CellInfoFormatter formatter =
                (CellInfoFormatter) cellInfoFormatters.get(cell.getClass());
        return formatter.format(cell);
    }

}
