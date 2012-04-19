package hello;

import com.cubeia.firebase.clients.java.connector.PacketListener;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.protocol.LoginRequestPacket;
import com.cubeia.firebase.io.protocol.LoginResponsePacket;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import org.huy.firebase.clients.j2me.connector.SocketConnector;

/**
 * @author
 * Huy Thai
 */
public class HelloMidlet extends MIDlet implements CommandListener  {

	private Form loginForm;
	private TextField usernameTextField;
	private TextField passwordTextField;
	private Command cancel;
	private Command login;
	private Display display;
	
	private SocketConnector connector;

	public void startApp() {
		loginForm = new Form("Login");
		usernameTextField = new TextField("Username", "", 200, TextField.ANY);
		passwordTextField = new TextField("Password", "", 200, TextField.PASSWORD);
		cancel = new Command("Cancel", Command.CANCEL, 2);
		login = new Command("Login", Command.OK, 2);
		display = Display.getDisplay(this);
		loginForm.append(usernameTextField);
		loginForm.append(passwordTextField);
		loginForm.addCommand(cancel);
		loginForm.addCommand(login);
		loginForm.setCommandListener(this);
		display.setCurrent(loginForm);
		
		try {
			connector = new SocketConnector("localhost", 4123);
			TestLoginListener listener = new TestLoginListener();
			connector.addListener(listener);
			connector.connect();

		} catch (GeneralSecurityException ex) {
		} catch (IOException ex) {
		}
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
		connector.disconnect();
		notifyDestroyed();
	}

	public void commandAction(Command c, Displayable d) {
		String label = c.getLabel();
		if (label.equals("Cancel")) {
				destroyApp(true);
		} else if (label.equals("Login")) {
				login(usernameTextField.getString(), passwordTextField.getString());
		}
	}

	private void login(String username, String pass) {		
		LoginRequestPacket pak = new LoginRequestPacket();
		pak.user = username;
		pak.password = pass;
		pak.operatorid = 0;
		connector.send(pak);
	}
	
	private class TestLoginListener implements PacketListener {

		public void packetRecieved(ProtocolObject packet) {
			LoginResponsePacket re = (LoginResponsePacket) packet;
			Alert notice = new Alert("Welcome", "Welcom user: " + re.pid, null, AlertType.INFO);
			display.setCurrent(notice, loginForm);
		}
	}
}
