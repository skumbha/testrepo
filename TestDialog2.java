import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class TestDialog2 extends Dialog {

	private Image resizedImage;
	
	private Button testButton;
	private Button testButton1;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public TestDialog2(Shell parentShell) {
		super(parentShell);
		
		Image testImage = ImageDescriptor.createFromFile(TestDialog2.class, "testimage.png").createImage();
		resizedImage = ImageUtils.resize(testImage, 12, 12);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		testButton = new Button(container, SWT.PUSH);
		testButton.setText("Test Button");
		testButton.setEnabled(true);
		testButton.addListener(SWT.MouseDown, new Listener() {
		    public void handleEvent(Event event) {
		    	if (testButton.getImage() == null) {
		            testButton.setImage(resizedImage);
		            testButton.setText("");
		        } else {
		            testButton.setImage(null);
		            testButton.setText("Test Button1");
		        }
		    }
		});
		testButton1 = new Button(container, SWT.PUSH);
		testButton1.setText("Test Button 1");
		testButton1.setEnabled(true);
		testButton1.addListener(SWT.MouseDown, new Listener() {
		    public void handleEvent(Event event) {
		    	if (testButton1.getImage() == null) {
		            testButton1.setImage(resizedImage);
		            testButton1.setText("");
		        } else {
		            testButton1.setImage(null);
		            testButton1.setText("Test Button1");
		        }
		    }
		});
		
		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	public static void main(String[] args) {
		TestDialog2 testDialog = new TestDialog2(new Shell());
		testDialog.open();
	}

}
