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
import java.math.BigInteger;

public class CryptoConstants {

	public static final byte ENCRYPTED_DATA = 0;
	public static final byte SESSION_KEY_REQUEST = 1;
	public static final byte SESSION_KEY_RESPONSE = 2;	
	public static final byte ILLEGAL_PACKET = -1;
	public static final byte ENCRYPTION_MANDATORY = -2;
	
	public static final int RSA_KEY_SIZE = 512;
	
	public static final BigInteger RSA_KEY_EXPONENT = new BigInteger("10001", 16);

	public static final long DEFAULT_KEY_ECHANGE_WAIT = 5000;
	
}
