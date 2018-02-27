import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;


public class SwtTest {

    public static void main(String[] args) {

        Display display = new Display();
        Shell shell = new Shell(display);

        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        shell.setLayout(rowLayout);

        Group genderGroup = new Group(shell, SWT.NONE);
        genderGroup.setLayout(new RowLayout(SWT.HORIZONTAL));

        Label label = new Label(genderGroup, SWT.NONE);
        label.setText("Your gender: ");

        Button buttonMale = new Button(genderGroup, SWT.RADIO);
        buttonMale.setText("Male");

        Button buttonFemale = new Button(genderGroup, SWT.RADIO);
        buttonFemale.setText("Female");

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