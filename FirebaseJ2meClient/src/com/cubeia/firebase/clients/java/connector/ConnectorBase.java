/**
 * Copyright (C) 2011 Cubeia Ltd <info@cubeia.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.cubeia.firebase.clients.java.connector;

import com.cubeia.firebase.api.util.Arguments;
import j2me.util.ArrayList;
import j2me.util.List;
import j2me.util.logging.Logger;


public abstract class ConnectorBase implements Connector {

	protected final ExecutorService dispatcher = Executors.newSingleThreadExecutor();	
	protected final Logger log = Logger.getLogger("SocketConnector");
	
	protected final List listeners = new ArrayList();
	protected final boolean useHandshake;
	protected final int handshakeSignature;
	
	protected ConnectorBase(boolean useHandshake, int handshakeSignature) {
		this.useHandshake = useHandshake;
		this.handshakeSignature = handshakeSignature;
	}
	
	public void addListener(PacketListener handler) {
		Arguments.notNull(handler, "handler");
		listeners.add(handler);
		
	}

	public void removeListener(PacketListener handler) {
		Arguments.notNull(handler, "handler");
		listeners.add(handler);
	}
}
