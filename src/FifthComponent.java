import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class FifthComponent {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        shell.setLayout(rowLayout);

        Text text = new Text(shell, SWT.CENTER);

        Button buttonOne = new Button(shell, SWT.PUSH);
        buttonOne.setText("Push 1 time");

        Button buttonTwo = new Button(shell, SWT.PUSH);
        buttonTwo.setText("Push 2 time");

        Button buttonThree = new Button(shell, SWT.PUSH);
        buttonThree.setText("Push 3 time");

        Table table = createTable(shell, SWT.MULTI | SWT.BORDER);

        TableItem item = new TableItem(table, SWT.NONE);

        table.getColumn(0).pack();
        table.getColumn(1).pack();

        buttonOne.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(0, text.getText());

                buttonTwo.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        item.setText(1, item.getText(0));
                        item.setText(0, "");

                        buttonThree.addSelectionListener(new SelectionAdapter() {
                            @Override
                            public void widgetSelected(SelectionEvent e) {
                                item.setText(0, item.getText(1));
                                item.setText(1, "");
                            }
                        });
                    }
                });
            }
        });


        table.setSize(table.computeSize(SWT.DEFAULT, 200));
        text.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    protected static Table createTable (Shell parent, int style) {
        Table table = new Table(parent, style);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        TableColumn columnOne = new TableColumn(table, SWT.NONE);
        columnOne.setText("First column");

        TableColumn columnTwo = new TableColumn(table, SWT.NONE);
        columnTwo.setText("Second column");
        return table;
    }
}
