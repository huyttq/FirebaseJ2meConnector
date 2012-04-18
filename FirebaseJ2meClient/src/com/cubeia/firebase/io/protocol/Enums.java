// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 12:09:18 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Enums.java
package com.cubeia.firebase.io.protocol;

import javolution.lang.Enum;

public final class Enums {

	public static final class TournamentRegisterResponseStatus extends Enum {

		public static TournamentRegisterResponseStatus[] values() {
			return (TournamentRegisterResponseStatus[]) $VALUES.clone();
		}

		public static TournamentRegisterResponseStatus valueOf(String name) {
			return (TournamentRegisterResponseStatus) Enum.valueOf(TournamentRegisterResponseStatus.class, name);
		}
		public static final TournamentRegisterResponseStatus OK;
		public static final TournamentRegisterResponseStatus FAILED;
		public static final TournamentRegisterResponseStatus DENIED;
		public static final TournamentRegisterResponseStatus DENIED_LOW_FUNDS;
		public static final TournamentRegisterResponseStatus DENIED_MTT_FULL;
		public static final TournamentRegisterResponseStatus DENIED_NO_ACCESS;
		public static final TournamentRegisterResponseStatus DENIED_ALREADY_REGISTERED;
		public static final TournamentRegisterResponseStatus DENIED_TOURNAMENT_RUNNING;
		private static final TournamentRegisterResponseStatus $VALUES[];

		static {
			OK = new TournamentRegisterResponseStatus("OK", 0);
			FAILED = new TournamentRegisterResponseStatus("FAILED", 1);
			DENIED = new TournamentRegisterResponseStatus("DENIED", 2);
			DENIED_LOW_FUNDS = new TournamentRegisterResponseStatus("DENIED_LOW_FUNDS", 3);
			DENIED_MTT_FULL = new TournamentRegisterResponseStatus("DENIED_MTT_FULL", 4);
			DENIED_NO_ACCESS = new TournamentRegisterResponseStatus("DENIED_NO_ACCESS", 5);
			DENIED_ALREADY_REGISTERED = new TournamentRegisterResponseStatus("DENIED_ALREADY_REGISTERED", 6);
			DENIED_TOURNAMENT_RUNNING = new TournamentRegisterResponseStatus("DENIED_TOURNAMENT_RUNNING", 7);
			$VALUES = (new TournamentRegisterResponseStatus[]{
								OK, FAILED, DENIED, DENIED_LOW_FUNDS, DENIED_MTT_FULL, DENIED_NO_ACCESS, DENIED_ALREADY_REGISTERED, DENIED_TOURNAMENT_RUNNING
							});
		}

		private TournamentRegisterResponseStatus(String s, int i) {
			super(s, i);
		}
	}

	public static final class FilteredJoinResponseStatus extends Enum {

		public static FilteredJoinResponseStatus[] values() {
			return (FilteredJoinResponseStatus[]) $VALUES.clone();
		}

		public static FilteredJoinResponseStatus valueOf(String name) {
			return (FilteredJoinResponseStatus) Enum.valueOf(FilteredJoinResponseStatus.class, name);
		}
		public static final FilteredJoinResponseStatus OK;
		public static final FilteredJoinResponseStatus FAILED;
		public static final FilteredJoinResponseStatus DENIED;
		public static final FilteredJoinResponseStatus SEATING;
		public static final FilteredJoinResponseStatus WAIT_LIST;
		private static final FilteredJoinResponseStatus $VALUES[];

		static {
			OK = new FilteredJoinResponseStatus("OK", 0);
			FAILED = new FilteredJoinResponseStatus("FAILED", 1);
			DENIED = new FilteredJoinResponseStatus("DENIED", 2);
			SEATING = new FilteredJoinResponseStatus("SEATING", 3);
			WAIT_LIST = new FilteredJoinResponseStatus("WAIT_LIST", 4);
			$VALUES = (new FilteredJoinResponseStatus[]{
								OK, FAILED, DENIED, SEATING, WAIT_LIST
							});
		}

		private FilteredJoinResponseStatus(String s, int i) {
			super(s, i);
		}
	}

	public static final class WatchResponseStatus extends Enum {

		public static WatchResponseStatus[] values() {
			return (WatchResponseStatus[]) $VALUES.clone();
		}

		public static WatchResponseStatus valueOf(String name) {
			return (WatchResponseStatus) Enum.valueOf(WatchResponseStatus.class, name);
		}
		public static final WatchResponseStatus OK;
		public static final WatchResponseStatus FAILED;
		public static final WatchResponseStatus DENIED;
		public static final WatchResponseStatus DENIED_ALREADY_SEATED;
		private static final WatchResponseStatus $VALUES[];

		static {
			OK = new WatchResponseStatus("OK", 0);
			FAILED = new WatchResponseStatus("FAILED", 1);
			DENIED = new WatchResponseStatus("DENIED", 2);
			DENIED_ALREADY_SEATED = new WatchResponseStatus("DENIED_ALREADY_SEATED", 3);
			$VALUES = (new WatchResponseStatus[]{
								OK, FAILED, DENIED, DENIED_ALREADY_SEATED
							});
		}

		private WatchResponseStatus(String s, int i) {
			super(s, i);
		}
	}

	public static final class JoinResponseStatus extends Enum {

		public static JoinResponseStatus[] values() {
			return (JoinResponseStatus[]) $VALUES.clone();
		}

		public static JoinResponseStatus valueOf(String name) {
			return (JoinResponseStatus) Enum.valueOf(JoinResponseStatus.class, name);
		}
		public static final JoinResponseStatus OK;
		public static final JoinResponseStatus FAILED;
		public static final JoinResponseStatus DENIED;
		private static final JoinResponseStatus $VALUES[];

		static {
			OK = new JoinResponseStatus("OK", 0);
			FAILED = new JoinResponseStatus("FAILED", 1);
			DENIED = new JoinResponseStatus("DENIED", 2);
			$VALUES = (new JoinResponseStatus[]{
								OK, FAILED, DENIED
							});
		}

		private JoinResponseStatus(String s, int i) {
			super(s, i);
		}
	}

	public static final class ResponseStatus extends Enum {

		public static ResponseStatus[] values() {
			return (ResponseStatus[]) $VALUES.clone();
		}

		public static ResponseStatus valueOf(String name) {
			return (ResponseStatus) Enum.valueOf(ResponseStatus.class, name);
		}
		public static final ResponseStatus OK;
		public static final ResponseStatus FAILED;
		public static final ResponseStatus DENIED;
		private static final ResponseStatus $VALUES[];

		static {
			OK = new ResponseStatus("OK", 0);
			FAILED = new ResponseStatus("FAILED", 1);
			DENIED = new ResponseStatus("DENIED", 2);
			$VALUES = (new ResponseStatus[]{
								OK, FAILED, DENIED
							});
		}

		private ResponseStatus(String s, int i) {
			super(s, i);
		}
	}

	public static final class PlayerStatus extends Enum {

		public static PlayerStatus[] values() {
			return (PlayerStatus[]) $VALUES.clone();
		}

		public static PlayerStatus valueOf(String name) {
			return (PlayerStatus) Enum.valueOf(PlayerStatus.class, name);
		}
		public static final PlayerStatus CONNECTED;
		public static final PlayerStatus WAITING_REJOIN;
		public static final PlayerStatus DISCONNECTED;
		public static final PlayerStatus LEAVING;
		public static final PlayerStatus TABLE_LOCAL;
		public static final PlayerStatus RESERVATION;
		private static final PlayerStatus $VALUES[];

		static {
			CONNECTED = new PlayerStatus("CONNECTED", 0);
			WAITING_REJOIN = new PlayerStatus("WAITING_REJOIN", 1);
			DISCONNECTED = new PlayerStatus("DISCONNECTED", 2);
			LEAVING = new PlayerStatus("LEAVING", 3);
			TABLE_LOCAL = new PlayerStatus("TABLE_LOCAL", 4);
			RESERVATION = new PlayerStatus("RESERVATION", 5);
			$VALUES = (new PlayerStatus[]{
								CONNECTED, WAITING_REJOIN, DISCONNECTED, LEAVING, TABLE_LOCAL, RESERVATION
							});
		}

		private PlayerStatus(String s, int i) {
			super(s, i);
		}
	}

	public static final class ServiceIdentifier extends Enum {

		public static ServiceIdentifier[] values() {
			return (ServiceIdentifier[]) $VALUES.clone();
		}

		public static ServiceIdentifier valueOf(String name) {
			return (ServiceIdentifier) Enum.valueOf(ServiceIdentifier.class, name);
		}
		public static final ServiceIdentifier NAMESPACE;
		public static final ServiceIdentifier CONTRACT;
		private static final ServiceIdentifier $VALUES[];

		static {
			NAMESPACE = new ServiceIdentifier("NAMESPACE", 0);
			CONTRACT = new ServiceIdentifier("CONTRACT", 1);
			$VALUES = (new ServiceIdentifier[]{
								NAMESPACE, CONTRACT
							});
		}

		private ServiceIdentifier(String s, int i) {
			super(s, i);
		}
	}

	public static final class TournamentAttributes extends Enum {

		public static TournamentAttributes[] values() {
			return (TournamentAttributes[]) $VALUES.clone();
		}

		public static TournamentAttributes valueOf(String name) {
			return (TournamentAttributes) Enum.valueOf(TournamentAttributes.class, name);
		}
		public static final TournamentAttributes NAME;
		public static final TournamentAttributes CAPACITY;
		public static final TournamentAttributes REGISTERED;
		public static final TournamentAttributes ACTIVE_PLAYERS;
		public static final TournamentAttributes STATUS;
		private static final TournamentAttributes $VALUES[];

		static {
			NAME = new TournamentAttributes("NAME", 0);
			CAPACITY = new TournamentAttributes("CAPACITY", 1);
			REGISTERED = new TournamentAttributes("REGISTERED", 2);
			ACTIVE_PLAYERS = new TournamentAttributes("ACTIVE_PLAYERS", 3);
			STATUS = new TournamentAttributes("STATUS", 4);
			$VALUES = (new TournamentAttributes[]{
								NAME, CAPACITY, REGISTERED, ACTIVE_PLAYERS, STATUS
							});
		}

		private TournamentAttributes(String s, int i) {
			super(s, i);
		}
	}

	public static final class LobbyType extends Enum {

		public static LobbyType[] values() {
			return (LobbyType[]) $VALUES.clone();
		}

		public static LobbyType valueOf(String name) {
			return (LobbyType) Enum.valueOf(LobbyType.class, name);
		}
		public static final LobbyType REGULAR;
		public static final LobbyType MTT;
		private static final LobbyType $VALUES[];

		static {
			REGULAR = new LobbyType("REGULAR", 0);
			MTT = new LobbyType("MTT", 1);
			$VALUES = (new LobbyType[]{
								REGULAR, MTT
							});
		}

		private LobbyType(String s, int i) {
			super(s, i);
		}
	}

	public static final class ParameterFilter extends Enum {

		public static ParameterFilter[] values() {
			return (ParameterFilter[]) $VALUES.clone();
		}

		public static ParameterFilter valueOf(String name) {
			return (ParameterFilter) Enum.valueOf(ParameterFilter.class, name);
		}
		public static final ParameterFilter EQUALS;
		public static final ParameterFilter GREATER_THAN;
		public static final ParameterFilter SMALLER_THAN;
		public static final ParameterFilter EQUALS_OR_GREATER_THAN;
		public static final ParameterFilter EQUALS_OR_SMALLER_THAN;
		private static final ParameterFilter $VALUES[];

		static {
			EQUALS = new ParameterFilter("EQUALS", 0);
			GREATER_THAN = new ParameterFilter("GREATER_THAN", 1);
			SMALLER_THAN = new ParameterFilter("SMALLER_THAN", 2);
			EQUALS_OR_GREATER_THAN = new ParameterFilter("EQUALS_OR_GREATER_THAN", 3);
			EQUALS_OR_SMALLER_THAN = new ParameterFilter("EQUALS_OR_SMALLER_THAN", 4);
			$VALUES = (new ParameterFilter[]{
								EQUALS, GREATER_THAN, SMALLER_THAN, EQUALS_OR_GREATER_THAN, EQUALS_OR_SMALLER_THAN
							});
		}

		private ParameterFilter(String s, int i) {
			super(s, i);
		}
	}

	public static final class ParameterType extends Enum {

		public static ParameterType[] values() {
			return (ParameterType[]) $VALUES.clone();
		}

		public static ParameterType valueOf(String name) {
			return (ParameterType) Enum.valueOf(ParameterType.class, name);
		}
		public static final ParameterType STRING;
		public static final ParameterType INT;
		public static final ParameterType DATE;
		private static final ParameterType $VALUES[];

		static {
			STRING = new ParameterType("STRING", 0);
			INT = new ParameterType("INT", 1);
			DATE = new ParameterType("DATE", 2);
			$VALUES = (new ParameterType[]{
								STRING, INT, DATE
							});
		}

		private ParameterType(String s, int i) {
			super(s, i);
		}
	}

	private Enums() {
	}

	public static ParameterType makeParameterType(int value) {
		switch (value) {
			case 0:
				return ParameterType.STRING;
			case 1:
				return ParameterType.INT;
			case 2:
				return ParameterType.DATE;
			default:
				throw new IllegalArgumentException("Invalid enum value for ParameterType: " + value);
		}
	}

	public static ParameterFilter makeParameterFilter(int value) {
		switch (value) {
			case 0:
				return ParameterFilter.EQUALS;
			case 1:
				return ParameterFilter.GREATER_THAN;
			case 2:
				return ParameterFilter.SMALLER_THAN;
			case 3:
				return ParameterFilter.EQUALS_OR_GREATER_THAN;
			case 4:
				return ParameterFilter.EQUALS_OR_SMALLER_THAN;
			default:
				throw new IllegalArgumentException("Invalid enum value for ParameterFilter: " + value);
		}
	}

	public static LobbyType makeLobbyType(int value) {
		switch (value) {
			case 0:
				return LobbyType.REGULAR;
			case 1:
				return LobbyType.MTT;
			default:
				throw new IllegalArgumentException("Invalid enum value for LobbyType: " + value);
		}
	}

	public static TournamentAttributes makeTournamentAttributes(int value) {
		switch (value) {
			case 0:
				return TournamentAttributes.NAME;
			case 1:
				return TournamentAttributes.CAPACITY;
			case 2:
				return TournamentAttributes.REGISTERED;
			case 3:
				return TournamentAttributes.ACTIVE_PLAYERS;
			case 4:
				return TournamentAttributes.STATUS;
			default:
				throw new IllegalArgumentException("Invalid enum value for TournamentAttributes: " + value);
		}
	}

	public static ServiceIdentifier makeServiceIdentifier(int value) {
		switch (value) {
			case 0:
				return ServiceIdentifier.NAMESPACE;
			case 1:
				return ServiceIdentifier.CONTRACT;
			default:
				throw new IllegalArgumentException("Invalid enum value for ServiceIdentifier: " + value);
		}
	}

	public static PlayerStatus makePlayerStatus(int value) {
		switch (value) {
			case 0:
				return PlayerStatus.CONNECTED;
			case 1:
				return PlayerStatus.WAITING_REJOIN;
			case 2:
				return PlayerStatus.DISCONNECTED;
			case 3:
				return PlayerStatus.LEAVING;
			case 4:
				return PlayerStatus.TABLE_LOCAL;
			case 5:
				return PlayerStatus.RESERVATION;
			default:
				throw new IllegalArgumentException("Invalid enum value for PlayerStatus: " + value);
		}
	}

	public static ResponseStatus makeResponseStatus(int value) {
		switch (value) {
			case 0:
				return ResponseStatus.OK;
			case 1:
				return ResponseStatus.FAILED;
			case 2:
				return ResponseStatus.DENIED;
			default:
				throw new IllegalArgumentException("Invalid enum value for ResponseStatus: " + value);
		}
	}

	public static JoinResponseStatus makeJoinResponseStatus(int value) {
		switch (value) {
			case 0:
				return JoinResponseStatus.OK;
			case 1:
				return JoinResponseStatus.FAILED;
			case 2:
				return JoinResponseStatus.DENIED;
			default:
				throw new IllegalArgumentException("Invalid enum value for JoinResponseStatus: " + value);
		}
	}

	public static WatchResponseStatus makeWatchResponseStatus(int value) {
		switch (value) {
			case 0:
				return WatchResponseStatus.OK;
			case 1:
				return WatchResponseStatus.FAILED;
			case 2:
				return WatchResponseStatus.DENIED;
			case 3:
				return WatchResponseStatus.DENIED_ALREADY_SEATED;
			default:
				throw new IllegalArgumentException("Invalid enum value for WatchResponseStatus: " + value);
		}
	}

	public static FilteredJoinResponseStatus makeFilteredJoinResponseStatus(int value) {
		switch (value) {
			case 0:
				return FilteredJoinResponseStatus.OK;
			case 1:
				return FilteredJoinResponseStatus.FAILED;
			case 2:
				return FilteredJoinResponseStatus.DENIED;
			case 3:
				return FilteredJoinResponseStatus.SEATING;
			case 4:
				return FilteredJoinResponseStatus.WAIT_LIST;
			default:
				throw new IllegalArgumentException("Invalid enum value for FilteredJoinResponseStatus: " + value);
		}
	}

	public static TournamentRegisterResponseStatus makeTournamentRegisterResponseStatus(int value) {
		switch (value) {
			case 0:
				return TournamentRegisterResponseStatus.OK;
			case 1:
				return TournamentRegisterResponseStatus.FAILED;
			case 2:
				return TournamentRegisterResponseStatus.DENIED;
			case 3:
				return TournamentRegisterResponseStatus.DENIED_LOW_FUNDS;
			case 4:
				return TournamentRegisterResponseStatus.DENIED_MTT_FULL;
			case 5:
				return TournamentRegisterResponseStatus.DENIED_NO_ACCESS;
			case 6:
				return TournamentRegisterResponseStatus.DENIED_ALREADY_REGISTERED;
			case 7:
				return TournamentRegisterResponseStatus.DENIED_TOURNAMENT_RUNNING;
			default:
				throw new IllegalArgumentException("Invalid enum value for TournamentRegisterResponseStatus: " + value);
		}
	}
}