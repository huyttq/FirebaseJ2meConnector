package org.huy.firebase.clients.j2me.connector;

import com.cubeia.firebase.clients.java.connector.PacketListener;
import com.cubeia.firebase.io.ProtocolObject;

/**
 *
 * @author huy.thai
 */
public class LoginListener implements PacketListener {
  public ProtocolObject loginPacket;
  
  public void packetRecieved(ProtocolObject packet) {
    this.loginPacket = packet;
  }  
}
