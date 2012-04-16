// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ProtocolObjectFactory.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.ObjectFactory;
import com.cubeia.firebase.io.ProtocolObject;
import j2me.lang.StringBuilder;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            VersionPacket, GameVersionPacket, GoodPacket, BadPacket, 
//            SystemMessagePacket, Param, ParamFilter, PingPacket, 
//            Attribute, LoginRequestPacket, LoginResponsePacket, LogoutPacket, 
//            PlayerInfoPacket, ForcedLogoutPacket, SeatInfoPacket, PlayerQueryRequestPacket, 
//            PlayerQueryResponsePacket, SystemInfoRequestPacket, SystemInfoResponsePacket, JoinRequestPacket, 
//            JoinResponsePacket, WatchRequestPacket, WatchResponsePacket, UnwatchRequestPacket, 
//            UnwatchResponsePacket, LeaveRequestPacket, LeaveResponsePacket, TableQueryRequestPacket, 
//            TableQueryResponsePacket, CreateTableRequestPacket, CreateTableResponsePacket, InvitePlayersRequestPacket, 
//            NotifyInvitedPacket, NotifyJoinPacket, NotifyLeavePacket, NotifyRegisteredPacket, 
//            NotifyWatchingPacket, KickPlayerPacket, TableChatPacket, GameTransportPacket, 
//            ServiceTransportPacket, LocalServiceTransportPacket, MttTransportPacket, EncryptedTransportPacket, 
//            JoinChatChannelRequestPacket, JoinChatChannelResponsePacket, LeaveChatChannelPacket, NotifyChannelChatPacket, 
//            ChannelChatPacket, LobbyQueryPacket, TableSnapshotPacket, TableUpdatePacket, 
//            LobbySubscribePacket, LobbyUnsubscribePacket, TableRemovedPacket, TournamentSnapshotPacket, 
//            TournamentUpdatePacket, TournamentRemovedPacket, LobbyObjectSubscribePacket, LobbyObjectUnsubscribePacket, 
//            TableSnapshotListPacket, TableUpdateListPacket, TournamentSnapshotListPacket, TournamentUpdateListPacket, 
//            FilteredJoinTableRequestPacket, FilteredJoinTableResponsePacket, FilteredJoinCancelRequestPacket, FilteredJoinCancelResponsePacket, 
//            FilteredJoinTableAvailablePacket, ProbeStamp, ProbePacket, MttRegisterRequestPacket, 
//            MttRegisterResponsePacket, MttUnregisterRequestPacket, MttUnregisterResponsePacket, MttSeatedPacket, 
//            MttPickedUpPacket, NotifySeatedPacket

public final class ProtocolObjectFactory
    implements ObjectFactory
{

    public ProtocolObjectFactory()
    {
    }

    public int version()
    {
        return 8450;
    }

    public ProtocolObject create(int classId)
    {
        switch(classId)
        {
        case 0: // '\0'
            return new VersionPacket();

        case 1: // '\001'
            return new GameVersionPacket();

        case 2: // '\002'
            return new GoodPacket();

        case 3: // '\003'
            return new BadPacket();

        case 4: // '\004'
            return new SystemMessagePacket();

        case 5: // '\005'
            return new Param();

        case 6: // '\006'
            return new ParamFilter();

        case 7: // '\007'
            return new PingPacket();

        case 8: // '\b'
            return new Attribute();

        case 10: // '\n'
            return new LoginRequestPacket();

        case 11: // '\013'
            return new LoginResponsePacket();

        case 12: // '\f'
            return new LogoutPacket();

        case 13: // '\r'
            return new PlayerInfoPacket();

        case 14: // '\016'
            return new ForcedLogoutPacket();

        case 15: // '\017'
            return new SeatInfoPacket();

        case 16: // '\020'
            return new PlayerQueryRequestPacket();

        case 17: // '\021'
            return new PlayerQueryResponsePacket();

        case 18: // '\022'
            return new SystemInfoRequestPacket();

        case 19: // '\023'
            return new SystemInfoResponsePacket();

        case 30: // '\036'
            return new JoinRequestPacket();

        case 31: // '\037'
            return new JoinResponsePacket();

        case 32: // ' '
            return new WatchRequestPacket();

        case 33: // '!'
            return new WatchResponsePacket();

        case 34: // '"'
            return new UnwatchRequestPacket();

        case 35: // '#'
            return new UnwatchResponsePacket();

        case 36: // '$'
            return new LeaveRequestPacket();

        case 37: // '%'
            return new LeaveResponsePacket();

        case 38: // '&'
            return new TableQueryRequestPacket();

        case 39: // '\''
            return new TableQueryResponsePacket();

        case 40: // '('
            return new CreateTableRequestPacket();

        case 41: // ')'
            return new CreateTableResponsePacket();

        case 42: // '*'
            return new InvitePlayersRequestPacket();

        case 43: // '+'
            return new NotifyInvitedPacket();

        case 60: // '<'
            return new NotifyJoinPacket();

        case 61: // '='
            return new NotifyLeavePacket();

        case 211: 
            return new NotifyRegisteredPacket();

        case 63: // '?'
            return new NotifyWatchingPacket();

        case 64: // '@'
            return new KickPlayerPacket();

        case 80: // 'P'
            return new TableChatPacket();

        case 100: // 'd'
            return new GameTransportPacket();

        case 101: // 'e'
            return new ServiceTransportPacket();

        case 103: // 'g'
            return new LocalServiceTransportPacket();

        case 104: // 'h'
            return new MttTransportPacket();

        case 105: // 'i'
            return new EncryptedTransportPacket();

        case 120: // 'x'
            return new JoinChatChannelRequestPacket();

        case 121: // 'y'
            return new JoinChatChannelResponsePacket();

        case 122: // 'z'
            return new LeaveChatChannelPacket();

        case 123: // '{'
            return new NotifyChannelChatPacket();

        case 124: // '|'
            return new ChannelChatPacket();

        case 142: 
            return new LobbyQueryPacket();

        case 143: 
            return new TableSnapshotPacket();

        case 144: 
            return new TableUpdatePacket();

        case 145: 
            return new LobbySubscribePacket();

        case 146: 
            return new LobbyUnsubscribePacket();

        case 147: 
            return new TableRemovedPacket();

        case 148: 
            return new TournamentSnapshotPacket();

        case 149: 
            return new TournamentUpdatePacket();

        case 150: 
            return new TournamentRemovedPacket();

        case 151: 
            return new LobbyObjectSubscribePacket();

        case 152: 
            return new LobbyObjectUnsubscribePacket();

        case 153: 
            return new TableSnapshotListPacket();

        case 154: 
            return new TableUpdateListPacket();

        case 155: 
            return new TournamentSnapshotListPacket();

        case 156: 
            return new TournamentUpdateListPacket();

        case 170: 
            return new FilteredJoinTableRequestPacket();

        case 171: 
            return new FilteredJoinTableResponsePacket();

        case 172: 
            return new FilteredJoinCancelRequestPacket();

        case 173: 
            return new FilteredJoinCancelResponsePacket();

        case 174: 
            return new FilteredJoinTableAvailablePacket();

        case 200: 
            return new ProbeStamp();

        case 201: 
            return new ProbePacket();

        case 205: 
            return new MttRegisterRequestPacket();

        case 206: 
            return new MttRegisterResponsePacket();

        case 207: 
            return new MttUnregisterRequestPacket();

        case 208: 
            return new MttUnregisterResponsePacket();

        case 209: 
            return new MttSeatedPacket();

        case 210: 
            return new MttPickedUpPacket();

        case 62: // '>'
            return new NotifySeatedPacket();

        case 9: // '\t'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 58: // ':'
        case 59: // ';'
        case 65: // 'A'
        case 66: // 'B'
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
        case 70: // 'F'
        case 71: // 'G'
        case 72: // 'H'
        case 73: // 'I'
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
        case 77: // 'M'
        case 78: // 'N'
        case 79: // 'O'
        case 81: // 'Q'
        case 82: // 'R'
        case 83: // 'S'
        case 84: // 'T'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 92: // '\\'
        case 93: // ']'
        case 94: // '^'
        case 95: // '_'
        case 96: // '`'
        case 97: // 'a'
        case 98: // 'b'
        case 99: // 'c'
        case 102: // 'f'
        case 106: // 'j'
        case 107: // 'k'
        case 108: // 'l'
        case 109: // 'm'
        case 110: // 'n'
        case 111: // 'o'
        case 112: // 'p'
        case 113: // 'q'
        case 114: // 'r'
        case 115: // 's'
        case 116: // 't'
        case 117: // 'u'
        case 118: // 'v'
        case 119: // 'w'
        case 125: // '}'
        case 126: // '~'
        case 127: // '\177'
        case 128: 
        case 129: 
        case 130: 
        case 131: 
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 138: 
        case 139: 
        case 140: 
        case 141: 
        case 157: 
        case 158: 
        case 159: 
        case 160: 
        case 161: 
        case 162: 
        case 163: 
        case 164: 
        case 165: 
        case 166: 
        case 167: 
        case 168: 
        case 169: 
        case 175: 
        case 176: 
        case 177: 
        case 178: 
        case 179: 
        case 180: 
        case 181: 
        case 182: 
        case 183: 
        case 184: 
        case 185: 
        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 191: 
        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
        case 197: 
        case 198: 
        case 199: 
        case 202: 
        case 203: 
        case 204: 
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown class id: ").append(classId).toString());
        }
    }
}