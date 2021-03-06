// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.ProtocolObjectVisitor;

public interface PacketVisitor extends ProtocolObjectVisitor {
    public void visit(VersionPacket packet);
    public void visit(GameVersionPacket packet);
    public void visit(GoodPacket packet);
    public void visit(BadPacket packet);
    public void visit(SystemMessagePacket packet);
    public void visit(Param packet);
    public void visit(ParamFilter packet);
    public void visit(PingPacket packet);
    public void visit(Attribute packet);
    public void visit(LoginRequestPacket packet);
    public void visit(LoginResponsePacket packet);
    public void visit(LogoutPacket packet);
    public void visit(PlayerInfoPacket packet);
    public void visit(ForcedLogoutPacket packet);
    public void visit(SeatInfoPacket packet);
    public void visit(PlayerQueryRequestPacket packet);
    public void visit(PlayerQueryResponsePacket packet);
    public void visit(SystemInfoRequestPacket packet);
    public void visit(SystemInfoResponsePacket packet);
    public void visit(JoinRequestPacket packet);
    public void visit(JoinResponsePacket packet);
    public void visit(WatchRequestPacket packet);
    public void visit(WatchResponsePacket packet);
    public void visit(UnwatchRequestPacket packet);
    public void visit(UnwatchResponsePacket packet);
    public void visit(LeaveRequestPacket packet);
    public void visit(LeaveResponsePacket packet);
    public void visit(TableQueryRequestPacket packet);
    public void visit(TableQueryResponsePacket packet);
    public void visit(CreateTableRequestPacket packet);
    public void visit(CreateTableResponsePacket packet);
    public void visit(InvitePlayersRequestPacket packet);
    public void visit(NotifyInvitedPacket packet);
    public void visit(NotifyJoinPacket packet);
    public void visit(NotifyLeavePacket packet);
    public void visit(NotifyRegisteredPacket packet);
    public void visit(NotifyWatchingPacket packet);
    public void visit(KickPlayerPacket packet);
    public void visit(TableChatPacket packet);
    public void visit(GameTransportPacket packet);
    public void visit(ServiceTransportPacket packet);
    public void visit(LocalServiceTransportPacket packet);
    public void visit(MttTransportPacket packet);
    public void visit(EncryptedTransportPacket packet);
    public void visit(JoinChatChannelRequestPacket packet);
    public void visit(JoinChatChannelResponsePacket packet);
    public void visit(LeaveChatChannelPacket packet);
    public void visit(NotifyChannelChatPacket packet);
    public void visit(ChannelChatPacket packet);
    public void visit(LobbyQueryPacket packet);
    public void visit(TableSnapshotPacket packet);
    public void visit(TableUpdatePacket packet);
    public void visit(LobbySubscribePacket packet);
    public void visit(LobbyUnsubscribePacket packet);
    public void visit(TableRemovedPacket packet);
    public void visit(TournamentSnapshotPacket packet);
    public void visit(TournamentUpdatePacket packet);
    public void visit(TournamentRemovedPacket packet);
    public void visit(LobbyObjectSubscribePacket packet);
    public void visit(LobbyObjectUnsubscribePacket packet);
    public void visit(TableSnapshotListPacket packet);
    public void visit(TableUpdateListPacket packet);
    public void visit(TournamentSnapshotListPacket packet);
    public void visit(TournamentUpdateListPacket packet);
    public void visit(FilteredJoinTableRequestPacket packet);
    public void visit(FilteredJoinTableResponsePacket packet);
    public void visit(FilteredJoinCancelRequestPacket packet);
    public void visit(FilteredJoinCancelResponsePacket packet);
    public void visit(FilteredJoinTableAvailablePacket packet);
    public void visit(ProbeStamp packet);
    public void visit(ProbePacket packet);
    public void visit(MttRegisterRequestPacket packet);
    public void visit(MttRegisterResponsePacket packet);
    public void visit(MttUnregisterRequestPacket packet);
    public void visit(MttUnregisterResponsePacket packet);
    public void visit(MttSeatedPacket packet);
    public void visit(MttPickedUpPacket packet);
    public void visit(NotifySeatedPacket packet);
}
