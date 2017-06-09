import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class TestDialog extends Dialog {

	
	
	private static final String TESTIMAGE_ID = "testimage";
	private static final int TEST_BUTTON_1 = 500;
	private static final int TEST_BUTTON_2 = 501;

	private ImageRegistry imageRegistry;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public TestDialog(Shell parentShell) {
		super(parentShell);
		
		imageRegistry = new ImageRegistry();
		Image testImage = ImageDescriptor.createFromFile(TestDialog.class, "testimage.png").createImage();
		Image resizedImage = ImageUtils.resize(testImage, 12, 12);
		imageRegistry.put(TESTIMAGE_ID, ImageDescriptor.createFromImage(resizedImage));
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));

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
		
		createButton(parent, TEST_BUTTON_1, "Test Button1", false);
		
		createButton(parent, TEST_BUTTON_2, "Test Button2", false);
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		
		if(TEST_BUTTON_1==buttonId){
			testButton1SelectionAction();
		}else if(TEST_BUTTON_2==buttonId){
			testButton2SelectionAction();
		}
		
		super.buttonPressed(buttonId);
	}

	private void testButton2SelectionAction() {
		Button testButton = getButton(TEST_BUTTON_2);
		if (testButton.getImage() == null) {
            testButton.setImage(imageRegistry.get(TESTIMAGE_ID));
            testButton.setText("");
        } else {
            testButton.setImage(null);
            testButton.setText("Test Button1");
        }
		
	}

	private void testButton1SelectionAction() {
		Button testButton = getButton(TEST_BUTTON_1);
		if (testButton.getImage() == null) {
            testButton.setImage(imageRegistry.get(TESTIMAGE_ID));
            testButton.setText("");
        } else {
            testButton.setImage(null);
            testButton.setText("Test Button2");
        }
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	public static void main(String[] args) {
		TestDialog testDialog = new TestDialog(new Shell());
		testDialog.open();
	}

}
