import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class SwtTest {

    public static void main(String[] args) {

        Display display = new Display();
        Shell shell = new Shell(display);

        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        shell.setLayout(rowLayout);

        Label label = new Label(shell,SWT.NONE );

        label.setText("Select language:");

        // Create a dropdown Combo
        Combo combo = new Combo(shell, SWT.DROP_DOWN);

        String[] items = new String[] { "English", "Vietnamese" };

        combo.setItems(items);

        shell.setText("SWT Combo (o7planning.org)");
        shell.setSize(400, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}