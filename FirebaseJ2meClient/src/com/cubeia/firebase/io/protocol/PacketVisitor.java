// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PacketVisitor.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.ProtocolObjectVisitor;

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

public interface PacketVisitor
    extends ProtocolObjectVisitor
{

    public abstract void visit(VersionPacket versionpacket);

    public abstract void visit(GameVersionPacket gameversionpacket);

    public abstract void visit(GoodPacket goodpacket);

    public abstract void visit(BadPacket badpacket);

    public abstract void visit(SystemMessagePacket systemmessagepacket);

    public abstract void visit(Param param);

    public abstract void visit(ParamFilter paramfilter);

    public abstract void visit(PingPacket pingpacket);

    public abstract void visit(Attribute attribute);

    public abstract void visit(LoginRequestPacket loginrequestpacket);

    public abstract void visit(LoginResponsePacket loginresponsepacket);

    public abstract void visit(LogoutPacket logoutpacket);

    public abstract void visit(PlayerInfoPacket playerinfopacket);

    public abstract void visit(ForcedLogoutPacket forcedlogoutpacket);

    public abstract void visit(SeatInfoPacket seatinfopacket);

    public abstract void visit(PlayerQueryRequestPacket playerqueryrequestpacket);

    public abstract void visit(PlayerQueryResponsePacket playerqueryresponsepacket);

    public abstract void visit(SystemInfoRequestPacket systeminforequestpacket);

    public abstract void visit(SystemInfoResponsePacket systeminforesponsepacket);

    public abstract void visit(JoinRequestPacket joinrequestpacket);

    public abstract void visit(JoinResponsePacket joinresponsepacket);

    public abstract void visit(WatchRequestPacket watchrequestpacket);

    public abstract void visit(WatchResponsePacket watchresponsepacket);

    public abstract void visit(UnwatchRequestPacket unwatchrequestpacket);

    public abstract void visit(UnwatchResponsePacket unwatchresponsepacket);

    public abstract void visit(LeaveRequestPacket leaverequestpacket);

    public abstract void visit(LeaveResponsePacket leaveresponsepacket);

    public abstract void visit(TableQueryRequestPacket tablequeryrequestpacket);

    public abstract void visit(TableQueryResponsePacket tablequeryresponsepacket);

    public abstract void visit(CreateTableRequestPacket createtablerequestpacket);

    public abstract void visit(CreateTableResponsePacket createtableresponsepacket);

    public abstract void visit(InvitePlayersRequestPacket inviteplayersrequestpacket);

    public abstract void visit(NotifyInvitedPacket notifyinvitedpacket);

    public abstract void visit(NotifyJoinPacket notifyjoinpacket);

    public abstract void visit(NotifyLeavePacket notifyleavepacket);

    public abstract void visit(NotifyRegisteredPacket notifyregisteredpacket);

    public abstract void visit(NotifyWatchingPacket notifywatchingpacket);

    public abstract void visit(KickPlayerPacket kickplayerpacket);

    public abstract void visit(TableChatPacket tablechatpacket);

    public abstract void visit(GameTransportPacket gametransportpacket);

    public abstract void visit(ServiceTransportPacket servicetransportpacket);

    public abstract void visit(LocalServiceTransportPacket localservicetransportpacket);

    public abstract void visit(MttTransportPacket mtttransportpacket);

    public abstract void visit(EncryptedTransportPacket encryptedtransportpacket);

    public abstract void visit(JoinChatChannelRequestPacket joinchatchannelrequestpacket);

    public abstract void visit(JoinChatChannelResponsePacket joinchatchannelresponsepacket);

    public abstract void visit(LeaveChatChannelPacket leavechatchannelpacket);

    public abstract void visit(NotifyChannelChatPacket notifychannelchatpacket);

    public abstract void visit(ChannelChatPacket channelchatpacket);

    public abstract void visit(LobbyQueryPacket lobbyquerypacket);

    public abstract void visit(TableSnapshotPacket tablesnapshotpacket);

    public abstract void visit(TableUpdatePacket tableupdatepacket);

    public abstract void visit(LobbySubscribePacket lobbysubscribepacket);

    public abstract void visit(LobbyUnsubscribePacket lobbyunsubscribepacket);

    public abstract void visit(TableRemovedPacket tableremovedpacket);

    public abstract void visit(TournamentSnapshotPacket tournamentsnapshotpacket);

    public abstract void visit(TournamentUpdatePacket tournamentupdatepacket);

    public abstract void visit(TournamentRemovedPacket tournamentremovedpacket);

    public abstract void visit(LobbyObjectSubscribePacket lobbyobjectsubscribepacket);

    public abstract void visit(LobbyObjectUnsubscribePacket lobbyobjectunsubscribepacket);

    public abstract void visit(TableSnapshotListPacket tablesnapshotlistpacket);

    public abstract void visit(TableUpdateListPacket tableupdatelistpacket);

    public abstract void visit(TournamentSnapshotListPacket tournamentsnapshotlistpacket);

    public abstract void visit(TournamentUpdateListPacket tournamentupdatelistpacket);

    public abstract void visit(FilteredJoinTableRequestPacket filteredjointablerequestpacket);

    public abstract void visit(FilteredJoinTableResponsePacket filteredjointableresponsepacket);

    public abstract void visit(FilteredJoinCancelRequestPacket filteredjoincancelrequestpacket);

    public abstract void visit(FilteredJoinCancelResponsePacket filteredjoincancelresponsepacket);

    public abstract void visit(FilteredJoinTableAvailablePacket filteredjointableavailablepacket);

    public abstract void visit(ProbeStamp probestamp);

    public abstract void visit(ProbePacket probepacket);

    public abstract void visit(MttRegisterRequestPacket mttregisterrequestpacket);

    public abstract void visit(MttRegisterResponsePacket mttregisterresponsepacket);

    public abstract void visit(MttUnregisterRequestPacket mttunregisterrequestpacket);

    public abstract void visit(MttUnregisterResponsePacket mttunregisterresponsepacket);

    public abstract void visit(MttSeatedPacket mttseatedpacket);

    public abstract void visit(MttPickedUpPacket mttpickeduppacket);

    public abstract void visit(NotifySeatedPacket notifyseatedpacket);
}