import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;


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
/*Menu menuBar =createMenu (shell, SWT.BAR);

        MenuItem fileItem1  = new MenuItem(menuBar, SWT.NONE);
        fileItem1.setText("Component 1");

        fileItem1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                firstComponent(shell);
            }
        });

        MenuItem fileItem2  = new MenuItem(menuBar, SWT.NONE);
        fileItem2.setText("Component 2");

        fileItem1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                secondComponent();
            }
        });

        MenuItem fileItem3  = new MenuItem(menuBar, SWT.NONE);
        fileItem3.setText("Component 3");

        fileItem1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                thirdComponent();
            }
        });

        MenuItem fileItem4  = new MenuItem(menuBar, SWT.NONE);
        fileItem4.setText("Component 4");

        fileItem1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                fourthComponent();
            }
        });

        MenuItem fileItem5  = new MenuItem(menuBar, SWT.NONE);
        fileItem5.setText("Component 5");

        fileItem5.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                fifthComponent();
            }
        });*/


    /*protected static Menu createMenu (Shell parent, int style) {
        Menu menuBar = new Menu (parent, SWT.BAR);
        parent.setMenuBar (menuBar);

        for (int i=1; i<6; i++) {
            MenuItem fileItem  = new MenuItem(menuBar, SWT.NONE);
            fileItem.setText("Component " + i);
        }
        return menuBar;
    }*/