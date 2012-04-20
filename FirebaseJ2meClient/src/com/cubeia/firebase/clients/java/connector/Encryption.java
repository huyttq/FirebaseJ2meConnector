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

public class Encryption {

	private int value;

	public Encryption(int val) {
		value = val;
	}
	/**
	 * No encryption.
	 */
	public static final Encryption NONE = new Encryption(0);

	/**
	 * Use ordinary SSL, normally configured via system
	 * properties.
	 */
	public static final Encryption SSL = new Encryption(1);
	
	/**
	 * Use naive SSL, accepting any server certificates.
	 */
	public static final Encryption NAIVE_SSL = new Encryption(2);
	
	/**
	 * Use Firebase native packet encryption.
	 */
	public static final Encryption FIREBASE_NATIVE = new Encryption(3);

}
